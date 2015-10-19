package br.site.db.expert;

import static org.hibernate.criterion.Restrictions.eq;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.site.model.crfa.CRFa;
import br.site.model.expert.Expert;

@Repository
public class ExpertHibernateRepository implements ExpertRepository{

	private SessionFactory sessionFactory;
	
	@Autowired
	public ExpertHibernateRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Criteria createCriteria() {
		return getSession().createCriteria(Expert.class);
	}
	
	@Override
	@Transactional
	public Expert by(CRFa crfa) {
		Criteria criteria = createCriteria();
		criteria.add(eq("crfa", crfa))
				.add(eq("activated", true));
		return (Expert) criteria.uniqueResult();
	}

	@Override
	@Transactional
	public void save(Expert expert) {
		getSession().save(expert);
	}
	
	@Override
	@Transactional
	public void update(Expert expert) {
		getSession().update(expert);
	}

}
