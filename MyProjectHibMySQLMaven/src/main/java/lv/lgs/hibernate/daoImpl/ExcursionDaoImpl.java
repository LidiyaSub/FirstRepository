package lv.lgs.hibernate.daoImpl;

import java.util.List;

import lv.lgs.hibernate.domain.Excursion;
import lv.lgs.hibernate.init.InitSessionFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ExcursionDaoImpl {
	SessionFactory sessionFactory = InitSessionFactory.getSessionFactory();

	public ExcursionDaoImpl() {

	}

	public void closeSessionFactory() {
		sessionFactory.close();
	}

	public void save(Excursion excursion) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(excursion);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Excursion excursion) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(excursion);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Excursion excursion) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(excursion);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Excursion> getAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Excursion> excursions;
		excursions = session.createCriteria(Excursion.class).list();
		session.getTransaction().commit();
		session.close();
		return excursions;
	}

}
