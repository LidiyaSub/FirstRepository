package lv.lgs.hibernate.daoImpl;

import java.util.List;

import lv.lgs.hibernate.domain.Comment;
import lv.lgs.hibernate.init.InitSessionFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CommentDaoImpl {
	SessionFactory sessionFactory = InitSessionFactory.getSessionFactory();

	public CommentDaoImpl() {
	}

	public void closeSessionFactory() {
		sessionFactory.close();
	}

	public void save(Comment comment) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(comment);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Comment comment) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(comment);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Comment comment) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(comment);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Comment> getAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Comment> comments;
		comments = session.createCriteria(Comment.class).list();
		session.getTransaction().commit();
		session.close();
		return comments;
	}
}
