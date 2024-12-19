package com.tpe.hb13.entity_life_cycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave13 {

    public static void main(String[] args) {

        Student13 student1=new Student13("Jack",99);//Transient:DB DE KARSILIGI YOK ,KALICI DEGIL
        Student13 student2=new Student13("Harry",99);//ransient:DB DE KARSILIGI YOK ,KALICI DEGIL

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student13.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction transaction=session.beginTransaction();

        session.save(student1);//-->persisted/managed:DB de bir satira karsilik gelir:Kalici
        student1.setName("Sherlock");

        session.save(student2);//persisted
        student2.setGrade(111);

        session.evict(student2);//entityyi sessiondan detach eder

        student2.setName("Ali");

        session.update(student2);//persisted
        //uygulamada :student2:7,Ali,111
        //tabloda :7 ,Harry,99





        transaction.commit();
        session.close();


        student1.setName("Ahmet");//detached :DB de bir satira karsilik gelir,
                                  // Hibernate tarafindan yapilan degisikliler aktarilmaz


        Session session2=sf.openSession();
        Transaction transaction2=session2.beginTransaction();

        session2.update(student1);//entitynin yeniden sessiona baglanmasini saglar--Persisted,
                                  //DB deki karsiligini gunceller

        student1.setGrade(10); //3,Ahmet,10


        transaction2.commit();
        session2.close();

        sf.close();
    }
}
