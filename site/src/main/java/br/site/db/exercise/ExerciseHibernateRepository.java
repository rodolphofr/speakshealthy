package br.site.db.exercise;

import static org.hibernate.criterion.Restrictions.eq;
import static org.hibernate.criterion.Restrictions.idEq;
import static org.hibernate.criterion.Restrictions.in;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.site.db.phoneme.PhonemeRepository;
import br.site.model.exercise.Exercise;
import br.site.model.phoneme.Phoneme;

@Repository
public class ExerciseHibernateRepository implements ExerciseRepository{

	private SessionFactory sessionFactory;
	
	private PhonemeRepository phonemeRepository;
	
	
	@Autowired
	public ExerciseHibernateRepository(SessionFactory sessionFactory, 
									   PhonemeRepository phonemeRepository) {
		
		this.sessionFactory = sessionFactory;
		this.phonemeRepository = phonemeRepository;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Criteria createCriteria() {
		return getSession().createCriteria(Exercise.class);
	}
	
	@Override
	@Transactional
	public void save(Exercise exercise) {
		getSession().save(exercise);
	}
	
	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Exercise> byPhonemeOfAchiquirement(Integer id) {
		Criteria criteria = createCriteria();
		criteria.add(eq("phoneme.id", id))
				.add(eq("category", Exercise.Category.ACQUIREMENT));
		return criteria.list();
	}
	
	@Override
	@Transactional
	public Exercise by(Integer id) {
		Criteria criteria = createCriteria();
		criteria.add(idEq(id));
		return (Exercise) criteria.uniqueResult();
	}
	
	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Exercise> vowels() {
		List<Phoneme> phonemes = phonemeRepository.listVowel();
		Criteria criteria = createCriteria();
		criteria.add(in("phoneme", phonemes));
		return criteria.list();
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Exercise> list(Integer phonemeId, String category, Integer expertId) {
		StringBuilder builder = new StringBuilder();
		
		builder.append("select e.id as id, e.demo as demo, e.content as content")
			   .append(" from exercise e, expert_exercise ee, expert ex ")
			   .append(" where ee.exercise_id = e.id ")
			   .append(" and ee.expert_id = ex.id ")
			   .append(" and e.phoneme_id = :phonemeId ")
			   .append(" and e.category = :category ") 
			   .append(" and ex.id = :id ");
					 
		Query query = getQuery(phonemeId, category, builder).setParameter("id", expertId);
		
		List<Exercise> expertExercises = query.list();
		
		builder = new StringBuilder();
		
		builder.append("select e.id as id, e.demo as demo, e.content as content")
			   .append(" from exercise e left outer join expert_exercise ee ")
			   .append(" on(e.id = ee.exercise_id) ")
			   .append(" where e.phoneme_id = :phonemeId ")
			   .append(" and e.category = :category ")
			   .append(" and ee.exercise_id is null ");
		
		query = getQuery(phonemeId, category, builder);
		
		List<Exercise> exercises = query.list();
		
		if(expertExercises != null && !expertExercises.isEmpty()) {
			exercises.addAll(expertExercises);
		}
				
		return exercises;
	}

	private SQLQuery getQuery(Integer phonemeId, String category, StringBuilder builder) {
		SQLQuery query = getSession().createSQLQuery(builder.toString());
		query.setParameter("phonemeId", phonemeId)
			 .setParameter("category", category.toUpperCase());
		
		
		query.addScalar("id", StandardBasicTypes.INTEGER)
			 .addScalar("demo", StandardBasicTypes.STRING)
			 .addScalar("content", StandardBasicTypes.STRING);
		
		query.setResultTransformer(Transformers.aliasToBean(Exercise.class));
		return query;
	}


	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public boolean exists(String content) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("content", content));
		
		List<Exercise> list = criteria.list();
		
		return list != null && !list.isEmpty();
	}
	
}
