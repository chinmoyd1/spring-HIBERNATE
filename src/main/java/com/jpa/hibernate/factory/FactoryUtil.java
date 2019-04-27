package com.jpa.hibernate.factory;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryUtil {
    private static final org.hibernate.SessionFactory sessionFactory;
    static {
        try {
            //XML based
            //sessionFactory = new Configuration().configure().buildSessionFactory();
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial FactoryUtil creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return  sessionFactory;
    }
}
