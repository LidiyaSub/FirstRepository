package lv.lgs.hibernate.daoImpl;

import java.util.List;

import lv.lgs.hibernate.domain.Client;
import lv.lgs.hibernate.init.InitSessionFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ClientDaoImpl {

	SessionFactory sessionFactory = InitSessionFactory.getSessionFactory();

	public ClientDaoImpl() {
	}

	public void closeSessionFactory() {
		sessionFactory.close();
	}

	public void save(Client client) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(client);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Client client) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(client);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Client client) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(client);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Client> getAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Client> clients;
		clients = session.createCriteria(Client.class).list();
		session.getTransaction().commit();
		session.close();
		return clients;
	}
}
