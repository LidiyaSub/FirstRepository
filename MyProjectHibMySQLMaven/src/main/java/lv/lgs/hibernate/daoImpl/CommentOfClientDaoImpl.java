package lv.lgs.hibernate.daoImpl;

import java.util.List;

import lv.lgs.hibernate.domain.CommentOfClient;
import lv.lgs.hibernate.init.InitSessionFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CommentOfClientDaoImpl {

	SessionFactory sessionFactory = InitSessionFactory.getSessionFactory();

	public CommentOfClientDaoImpl() {
	}

	public void closeSessionFactory() {
		sessionFactory.close();
	}

	public void save(CommentOfClient comment) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(comment);
		session.getTransaction().commit();
		session.close();
	}

	public void update(CommentOfClient comment) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(comment);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(CommentOfClient comment) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(comment);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<CommentOfClient> getAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<CommentOfClient> comments;
		comments = session.createCriteria(CommentOfClient.class).list();
		session.getTransaction().commit();
		session.close();
		return comments;
	}
}
