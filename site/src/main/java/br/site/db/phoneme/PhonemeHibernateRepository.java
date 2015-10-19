package br.site.db.phoneme;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.site.model.phoneme.Phoneme;

@Repository
public class PhonemeHibernateRepository implements PhonemeRepository {

	private SessionFactory sessionFactory;
	
	@Autowired
	public PhonemeHibernateRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Criteria createCriteria() {
		return getSession().createCriteria(Phoneme.class);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Phoneme> listVowel() {
		return listByClassification(Phoneme.Classification.VOWEL).list();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Phoneme> listConsonant() {
		return listByClassification(Phoneme.Classification.CONSONANT).list();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Phoneme> listArchiphoneme() {
		return listByClassification(Phoneme.Classification.ARCHIPHONEME).list();
	}
	
	private Criteria listByClassification(Phoneme.Classification classification) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("classification", classification));
		return criteria;
	}
	
	@Transactional
	public Serializable save(Phoneme phoneme) {
		return getSession().save(phoneme);
	}

	@Override
	@Transactional
	public Phoneme by(Integer id) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.idEq(id));
		return (Phoneme) criteria.uniqueResult();
	}
}
