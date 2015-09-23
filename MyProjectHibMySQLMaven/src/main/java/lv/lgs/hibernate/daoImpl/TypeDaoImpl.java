package lv.lgs.hibernate.daoImpl;

import java.util.List;

import lv.lgs.hibernate.domain.Type;
import lv.lgs.hibernate.init.InitSessionFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class TypeDaoImpl {

	SessionFactory sessionFactory = InitSessionFactory.getSessionFactory();

	public TypeDaoImpl() {
		
	}

	public void closeSessionFactory() {
		sessionFactory.close();
	}

	public void save(Type type) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(type);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Type type) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(type);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Type type) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(type);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Type> getAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Type> types;
		types = session.createCriteria(Type.class).list();
		session.getTransaction().commit();
		session.close();
		return types;
	}
}
