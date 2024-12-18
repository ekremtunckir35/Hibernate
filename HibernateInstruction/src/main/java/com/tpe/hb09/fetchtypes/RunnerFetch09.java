package com.tpe.hb09.fetchtypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {
    public static void main(String[] args) {


        Configuration config = new Configuration().configure().
                addAnnotatedClass(Student09.class).addAnnotatedClass(Book09.class);
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();


        //student getirelim :LAZY(onetomany)
        //lazy sadece ilgili olan entity getirir

        Student09 student = session.get(Student09.class, 1001);
        System.out.println(student.getBookList());

        //book getirelim : EAGER(manytomany)
        session.get(Book09.class, 33);
        //System.out.println(student.getBookList());

        session.close();
        sf.close();

        //System.out.println(student.getBookList());
    }
}
