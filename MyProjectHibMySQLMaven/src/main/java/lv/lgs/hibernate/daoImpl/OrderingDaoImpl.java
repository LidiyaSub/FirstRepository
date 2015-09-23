package lv.lgs.hibernate.daoImpl;

import java.util.List;

import lv.lgs.hibernate.domain.Ordering;
import lv.lgs.hibernate.init.InitSessionFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OrderingDaoImpl {

	SessionFactory sessionFactory = InitSessionFactory.getSessionFactory();

	public OrderingDaoImpl() {

	}

	public void closeSessionFactory() {
		sessionFactory.close();
	}

	public void save(Ordering order) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(order);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Ordering order) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(order);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Ordering order) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(order);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Ordering> getAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Ordering> orderings;
		orderings = session.createCriteria(Ordering.class).list();
		session.getTransaction().commit();
		session.close();
		return orderings;
	}
}
