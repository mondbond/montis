package com.dao;

import com.sun.javafx.util.Utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class GeneralEntityManager<T> {

	@Autowired
	SessionFactory sessionFactory;

	public boolean save(T entity) {

		final Session session = sessionFactory.openSession();
		try {
			final Transaction transaction = session.beginTransaction();
			try {
				session.saveOrUpdate(entity);
				System.out.println("Persisted: " + entity.toString());
				transaction.commit();
			} catch (Exception ex) {
				transaction.rollback();
				throw ex;
			}
		} finally
		{
			session.close();
		}
		return true;
	}

	public boolean saveAll(List<T> entities) {
		final Session session = sessionFactory.openSession();
		try {
			final Transaction transaction = session.beginTransaction();
			try {
				for (T entity : entities) {
					session.save(entity);
					System.out.println("Persisted: " + entity.toString());
//					session.clear();
				}
				transaction.commit();
			} catch (Exception ex) {
				transaction.rollback();
				throw ex;
			}
		} finally {
			session.close();
		}

		return true;
	}

	public boolean exist(Class entity, String key) {
		final Session session = sessionFactory.openSession();
		T result = null;
		try {
			final Transaction transaction = session.beginTransaction();
			try {
				result = (T) session.get(entity, key);
				transaction.commit();
			} catch (Exception ex) {
				transaction.rollback();
				throw ex;
			}
		} finally {
			session.close();
		}

		return result != null;
	}


	public T getById(Class className, String key) {
		final Session session = sessionFactory.openSession();
		T result = null;
		try {
			final Transaction transaction = session.beginTransaction();
			try {
				result = (T) session.get(className, key);
				transaction.commit();
			} catch (Exception ex) {
				transaction.rollback();
				throw ex;
			}
		} finally {
			session.close();
		}

		return result;
	}
}
