package com.hb04bi_onetoone;

import com.hb03.uni_onetoone.Diary;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {
    public static void main(String[] args) {


        Student04 student01 = new Student04();
        student01.setId(1001);
        student01.setName("Samet Guler");
        student01.setGrade(90);

        Student04 student02 = new Student04();
        student02.setId(1002);
        student02.setName("Fatih Arzu");
        student02.setGrade(85);

        Student04 student03 = new Student04();
        student03.setId(1003);
        student03.setName("Ridvan A ");
        student03.setGrade(85);


        Diary04 diary01 = new Diary04();
        diary01.setId(101);
        diary01.setName("A diary");
        diary01.setStudent(student01);

        Diary04 diary02 = new Diary04();
        diary02.setId(102);
        diary02.setName("B diary");
        diary02.setStudent(student02);//iliski sahibi diary oldugu icin setStudent metodunu burada kullaniyoruz.



        Configuration cfg = new Configuration().
                configure("hibernate.cfg.xml").addAnnotatedClass(Student04.class).
                addAnnotatedClass(Diary04.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx = session.beginTransaction();


        session.save(student01);
        session.save(student02);
        session.save(student03);

        session.save(diary01);
        session.save(diary02);




        tx.commit();
        session.close();
        sf.close();


    }
}
