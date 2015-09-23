package lv.lgs.hibernate.daoImpl;

import java.util.List;

import lv.lgs.hibernate.domain.Blog;
import lv.lgs.hibernate.init.InitSessionFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BlogDaoImpl {

	SessionFactory sessionFactory = InitSessionFactory.getSessionFactory();

	public BlogDaoImpl() {

	}

	public void closeSessionFactory() {
		sessionFactory.close();
	}

	public void save(Blog blog) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(blog);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Blog blog) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(blog);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Blog blog) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(blog);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Blog> getAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Blog> blogs;
		blogs = session.createCriteria(Blog.class).list();
		session.getTransaction().commit();
		session.close();
		return blogs;
	}

}
