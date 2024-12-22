package com.hb06.uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch06 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).addAnnotatedClass(Book06.class);


        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //!! get methodu
        // get methodu ile veritabanindan veri cekme islemi yapilir.
    Student06 student =session.get(Student06.class, 1001);
    System.out.println(student);

//         //!!!!HQL ile id si 1001 olan kitabi getirelim
//        //HQL ile veritabanindan veri cekme islemi yapilir.
//         String hqlQuery1 = "from Book06  b where b.id=101";
//         Book06 book1 = session.createQuery(hqlQuery1, Book06.class).uniqueResult();
//        System.out.println(book1);

//        //!! bir ogrencinin kitaplarini ogrenci id ye gore getirelim
//        String hqlQurey2 =
//                "SELECT b.id,b.name FROM  Student06 s INNER JOIN s.bookList b WHERE s.id=1001";
//        List<Object[]>resultList1 = session.createQuery(hqlQurey2).getResultList();
//        resultList1.forEach(oa-> System.out.println(Arrays.toString(oa)));


        //!!  get() ile bir ogrencinin kitaplarini ogrenci  id ye gore getirelim
        session.get(Student06.class,1001);
        System.out.println(student.getBookList());

        tx.commit();
        session.close();
        sf.close();

    }
}
