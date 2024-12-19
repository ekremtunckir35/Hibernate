package com.tpe.hb13.entity_life_cycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Runner13 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student13.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction transaction=session.beginTransaction();


        Student13 student = session.get(Student13.class, 1);//persisted
        student.setName("Mehmet");//id:1, isim Mehmet,grade:99
        //persisted modda bir degisiklik yapildiginde bu degisiklik dogrudan aktarilir.

        //remote mod

        session.delete(student);//persisted durumda ogrenciyi remote moda getirir.
                                // DB de bir karsiligi yoktur.DB de gorulmez

        transaction.commit();
        session.close();
        sf.close();
    }
}
