package com.hb05.manytoone;

import com.hb04bi_onetoone.Diary04;
import com.hb04bi_onetoone.Student04;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {
    public static void main(String[] args) {

              Student05 student01 = new Student05();
              student01.setId(1001);
              student01.setName("Atilgan Sahin");
              student01.setGrade(70);

              Student05 student02 = new Student05();
              student02.setId(1002);
              student02.setName("Errany");
              student02.setGrade(70);

              Student05 student03 = new Student05();
              student03.setId(1003);
              student03.setName("Kemal");
              student03.setGrade(70);

              University university = new University();
              university.setId(1);
              university.setName("TPE Unv");

              student01.setUniversity(university);
              student02.setUniversity(university);
              student03.setUniversity(university);







        Configuration cfg = new Configuration().
                configure("hibernate.cfg.xml").addAnnotatedClass(University.class).
                addAnnotatedClass(Student05.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx = session.beginTransaction();

                   session.save(university);
                   session.save(student01);
                   session.save(student02);
                   session.save(student03);






        tx.commit();
        session.close();
        sf.close();
    }
}
