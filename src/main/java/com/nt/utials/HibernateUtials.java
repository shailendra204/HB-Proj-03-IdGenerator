package com.nt.utials;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtials {
	private static SessionFactory factory;
	static {
		Configuration cfg = null;
		StandardServiceRegistry registary = null;
		StandardServiceRegistryBuilder builder = null;
		// bootstrap of hibernate
		cfg = new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml");
		// create service registry builder
		builder = new StandardServiceRegistryBuilder();
		registary = builder.applySettings(cfg.getProperties()).build();
		// build HB SessionDFactory
		factory = cfg.buildSessionFactory();
	}

	public static Session getSession() {
		Session ses = null;
		if (factory != null) {
			ses = factory.openSession();
		}
		return ses;

	}// close get Session

	public static void closeSessionFactory() {
		if (factory != null) {
			factory.close();
		}
	}

	public static void closeSession(Session ses) {
		if (ses != null) {
			ses.close();
		}
	}
}
