package com.tpe.hb03.uni_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {


        Student03 student1 = new Student03(1001,"Ali",99);
        Student03 student2 = new Student03(1002,"Ayse",98);
        Student03 student3 = new Student03(1003,"Fatma",99);

        Diary diary1=new Diary();
        diary1.setId(11);
        diary1.setName("X");

        Diary diary2=new Diary();
        diary2.setId(22);
        diary2.setName("Y");

        Diary diary3=new Diary();
        diary3.setId(33);
        diary3.setName("Z");

        //-------------------------------------

        diary1.setStudent(student1);//diary1 ile student1 iliskilendirdik.
        diary2.setStudent(student2);
        diary3.setStudent(student3);
       //yani FK sutununa studentlarin id lerini ekledik.DIKKAT :unique(tekrarsiz)


        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();


       Transaction transaction =session.beginTransaction();

       session.save(diary1);
       session.save(diary2);
       session.save(diary3);

       session.save(student1);
       session.save(student2);
       session.save(student3);

       transaction.commit();
       session.close();
       sf.close();




    }
}
