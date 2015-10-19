package br.site.db.recordingHistory;

import static org.hibernate.criterion.Restrictions.eq;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.site.model.exercise.Exercise;
import br.site.model.patient.Patient;
import br.site.model.recordingHistory.RecordingHistory;

@Repository
public class RecordingHistoryHibernateRepository implements RecordingHistoryRepository {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public RecordingHistoryHibernateRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Criteria createCriteria() {
		return getSession().createCriteria(RecordingHistory.class);
	}

	@Override
	@Transactional
	public Serializable save(RecordingHistory recordingHistory) {
		return getSession().save(recordingHistory);
	}
	
	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<RecordingHistory> recordingsBy(Patient patient, Integer exerciseId) {
		Criteria criteria = createCriteria();
		criteria.add(eq("patient.id", patient.getId()))
				.add(eq("exercise.id", exerciseId));
		return criteria.list();
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<RecordingHistory> byExercises(List<Exercise> exercises) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.in("exercise", exercises));
		return criteria.list();
	}
	
	
}
