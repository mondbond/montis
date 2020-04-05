package com.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralEntityManager<T> {

	@Autowired
	SessionFactory sessionFactory;

	public boolean save(T entity) {
		Transaction transaction = sessionFactory.getCurrentSession().getTransaction();
		transaction.begin();
		sessionFactory.getCurrentSession().save(entity);
		transaction.commit();
		sessionFactory.getCurrentSession().close();

		return true;
	}

	public boolean saveAll(List<T> entities) {
		Transaction transaction = sessionFactory.getCurrentSession().getTransaction();
		transaction.begin();

		for (T entity : entities) {
			sessionFactory.getCurrentSession().save(entity);
		}

		transaction.commit();
		sessionFactory.getCurrentSession().close();

		return true;
	}
}
