package lv.lgs.hibernate.daoImpl;

import java.util.List;

import lv.lgs.hibernate.domain.Language;
import lv.lgs.hibernate.init.InitSessionFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LanguageDaoImpl {

	SessionFactory sessionFactory = InitSessionFactory.getSessionFactory();

	public LanguageDaoImpl() {

	}

	public void closeSessionFactory() {
		sessionFactory.close();
	}

	public void save(Language language) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(language);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Language language) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(language);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Language language) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(language);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Language> getAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Language> languages;
		languages = session.createCriteria(Language.class).list();
		session.getTransaction().commit();
		session.close();
		return languages;
	}

}
