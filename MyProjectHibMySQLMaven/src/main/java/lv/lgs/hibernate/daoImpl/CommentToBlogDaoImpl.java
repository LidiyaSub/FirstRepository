package lv.lgs.hibernate.daoImpl;

import java.util.List;

import lv.lgs.hibernate.domain.CommentToBlog;
import lv.lgs.hibernate.init.InitSessionFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CommentToBlogDaoImpl {

	SessionFactory sessionFactory = InitSessionFactory.getSessionFactory();

	public CommentToBlogDaoImpl() {
	}

	public void closeSessionFactory() {
		sessionFactory.close();
	}

	public void save(CommentToBlog comment) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(comment);
		session.getTransaction().commit();
		session.close();
	}

	public void update(CommentToBlog comment) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(comment);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(CommentToBlog comment) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(comment);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<CommentToBlog> getAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<CommentToBlog> comments;
		comments = session.createCriteria(CommentToBlog.class).list();
		session.getTransaction().commit();
		session.close();
		return comments;
	}
}
