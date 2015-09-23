package lv.lgs.hibernate.daoImpl;

import java.util.List;

import lv.lgs.hibernate.domain.Question;
import lv.lgs.hibernate.init.InitSessionFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class QuestionDaoImpl {

	SessionFactory sessionFactory = InitSessionFactory.getSessionFactory();

	public QuestionDaoImpl() {

	}

	public void closeSessionFactory() {
		sessionFactory.close();
	}

	public void save(Question question) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(question);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Question question) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(question);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Question question) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(question);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Question> getAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Question> questions;
		questions = session.createCriteria(Question.class).list();
		session.getTransaction().commit();
		session.close();
		return questions;
	}
}
