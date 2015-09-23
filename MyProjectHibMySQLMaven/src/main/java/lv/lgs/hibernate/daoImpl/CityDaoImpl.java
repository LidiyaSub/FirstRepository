package lv.lgs.hibernate.daoImpl;

import java.util.List;

import lv.lgs.hibernate.domain.City;
import lv.lgs.hibernate.init.InitSessionFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CityDaoImpl {

	SessionFactory sessionFactory = InitSessionFactory.getSessionFactory();

	public CityDaoImpl() {
	}

	public void closeSessionFactory() {
		sessionFactory.close();
	}

	public void save(City city) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(city);
		session.getTransaction().commit();
		session.close();
	}

	public void update(City city) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(city);
		session.getTransaction().commit();
		session.close();

	}

	public void delete(City city) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(city);
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	public List<City> getAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<City> cities;
		cities = session.createCriteria(City.class).list();
		session.getTransaction().commit();
		session.close();
		return cities;

	}

}
