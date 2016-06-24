package com.vladimir.nextstep.server;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("serial")
public class HibernateUtil implements Serializable {

	  private static final SessionFactory sessionFactory;

	  static {
	    try {
	      
	      sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    } catch (Throwable ex) {
	     
	      System.err.println("Initial SessionFactory creation failed." + ex);
	      throw new ExceptionInInitializerError(ex);
	    }
	  }

	  public static SessionFactory getSessionFactory() {
	    return sessionFactory;
	  }
	}