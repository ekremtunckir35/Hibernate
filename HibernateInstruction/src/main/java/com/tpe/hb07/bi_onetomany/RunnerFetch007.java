package com.tpe.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.CascadeType;

public class RunnerFetch007 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();

        //db de değişikliklerin kalıcı olması için transaction gereklidir
        Transaction t =session.beginTransaction();


        //id:1002 olan öğrenciyi silelim

        Student07 student =session.get(Student07.class, 1002);
        session.delete(student);


        //burada calistirisak hata verir.Cunku id 1002 olan iki tabloda da var.
        //Parent(student) child(books) iliskisi var.
        // !!! Kitab bilgisi olan bir ogrenciyi silmek istersek
        // 1.yol ) once Book tablosunda iliskili oldugu booklar silinir daha sonra istenen student objesi silinebilir

        //  // 2.yol ) CascadeType.REMOVE / orphanRemoval
        //CascadeType.REMOVE
        // parent tablodan(student) satır silmek istediğimizde önce ilişkili olduğu
        //satırları(bookList) diğer tablodan(book) siler, ardından parenttan silme işlemi yapar.
        //yani aşamalı(kademeli) silme işlemini otomatik yapar.









        t.commit();
        session.close();
        sf.close();
    }
}
