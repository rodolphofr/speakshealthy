package br.site.db.patient;

import static org.hibernate.criterion.Restrictions.idEq;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.site.model.expert.Expert;
import br.site.model.patient.Patient;

@Repository
public class PatientHibernateRepository implements PatientRepository {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public PatientHibernateRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Criteria createCriteria() {
		return getSession().createCriteria(Patient.class);
	}
			
	@Override
	@Transactional
	public Serializable save(Patient patient) {
		return getSession().save(patient);
	}
	
	@Override
	@Transactional
	public Patient byId(Integer id) {
		Criteria criteria = createCriteria()
				.add(idEq(id));
		return (Patient) criteria.uniqueResult();
	}
	
	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Patient> search(String term, Expert expert) {
		String sql = "select p.name as name, p.id as id, p.rg as rg, p.photo as photo from patient p, expert_patient ep, expert e "+
					 "where p.id = ep.patient_id and e.id = ep.expert_id "+ 
					 "and e.id = :id and (( p.name like :name ) or ( p.rg like :rg ))";
		
		SQLQuery query = getSession().createSQLQuery(sql);
		query.setParameter("id", expert.getId())
			 .setParameter("name", "%"+term+"%")
			 .setParameter("rg", "%"+term+"%");
		
		query.addScalar("name", StandardBasicTypes.STRING)
			 .addScalar("id", StandardBasicTypes.INTEGER)
			 .addScalar("rg", StandardBasicTypes.STRING)
			 .addScalar("photo", StandardBasicTypes.STRING);
		
		query.setResultTransformer(Transformers.aliasToBean(Patient.class));
		
		return query.list();
	}
}
