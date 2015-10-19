package br.site.db.crfa;

import static org.hibernate.criterion.Restrictions.eq;

import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.site.model.crfa.CRFa;

@Repository
public class CRFaHibernateRepository implements CRFaRepository {

	private SessionFactory sessionFactory;
	
	@Autowired
	public CRFaHibernateRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	private Criteria createCriteria() {
		return getSession().createCriteria(CRFa.class);
	}
	
	@Override
	@Transactional
	public CRFa by(Map<String, Integer> registry) {
		Criteria criteria = createCriteria();
		criteria.add(eq("registry", registry.get("registry")))
				.add(eq("region", registry.get("region")));
		return (CRFa) criteria.uniqueResult();
	}

}
