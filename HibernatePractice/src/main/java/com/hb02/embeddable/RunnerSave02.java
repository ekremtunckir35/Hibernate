package com.hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {

        Student02 student1 = new Student02();
        student1.setId(1001);
        student1.setName("Ahmet Uslu");
        student1.setGrade(90);



        Address address1 = new Address();
        address1.setStreet("Apple Street");
        address1.setCity("Newyork");
        address1.setCountry("USA");
        address1.setZipCode("06852");

        student1.setAddress(address1);

        Address address2 = new Address();
        address2.setStreet("Banana Street");
        address2.setCity("London");
        address2.setCountry("England");
        address2.setZipCode("03435");

        Student02 student2 = new Student02();
        student2.setId(1002);
        student2.setName("Beyza Keser");
        student2.setGrade(90);

        student2.setAddress(address2);



        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Student02.class);

        SessionFactory sf = cfg.buildSessionFactory();
         Session session =sf.openSession();

         Transaction tx =session.beginTransaction();


         session.save(student1);
         session.save(student2);


          tx.commit();


         session.close();
         sf.close();



    }
}
