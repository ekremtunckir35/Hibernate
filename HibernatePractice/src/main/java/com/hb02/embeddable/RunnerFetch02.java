package com.hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {
    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Student02.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session =sf.openSession();

        Transaction tx =session.beginTransaction();

          Student02 student02 =session.get(Student02.class,1001);
          System.out.println(student02);
          System.out.println(student02.getAddress());


        tx.commit();
        session.close();
        sf.close();



    }
}
