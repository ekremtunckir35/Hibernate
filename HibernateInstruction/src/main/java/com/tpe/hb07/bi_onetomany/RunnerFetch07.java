package com.tpe.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class RunnerFetch07 {

    public static void main(String[] args) {

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();

        //id:101 olan kitabı getirelim

//        Book07 book =session.get(Book07.class,101);
//        System.out.println(book);
//
//        //bu kitabin sahibi olan ogrenciyi gorelim
//        System.out.println(book.getStudent());
//
//        //id:1002 olan öğrencinin kitaplarını getirelim
//
//        Student07 student =session.get(Student07.class,1002);
//        System.out.println(student.getBookList());

        //DB de degisikliklerin kalici olmasi icin Transaction gereklidir.
        // //book07 tablosunda tüm kayıtları silelim

        Transaction t =session.beginTransaction();

//        String hql = "DELETE FROM Book07";
//        int deletedBooks= session.createQuery(hql).executeUpdate();
//        System.out.println("silinen kitap sayisi " + deletedBooks);


         //student07 tablosunda tüm kayıtları silelim
//        String hql2 = "DELETE  FROM Student07";
//        int deletedStudents= session.createQuery(hql2).executeUpdate();
//        System.out.println("silinen ogrenci  sayisi " + deletedStudents);

       //Ismi Sefiller olan kitabi HQL ile silelim

//        String hql3="DELETE FROM Book07 b  WHERE b.name ='Sefiller' ";
//        int deleted= session.createQuery(hql3).executeUpdate();
//        System.out.println("silinen kayisi sayisi " + deleted);

        //id:1001 olan öğrencinin kitap listesinden ilkini silelim

        Student07 student02 =session.get(Student07.class,1001);
        student02.getBookList().remove(0);//1001 : 101,102 ---> 102
        student02.getBookList().set(0,null);//

        //collectiondan  bir eleman silinir veya null yapilirsa
        //referansi olmayan bu nesneyi tablodan da siler.

     //std-book --->std kitabi iade etti--> listeden kaldirdik-->tablodan silmemeliyiz.orphanRemoval: false olmali

     //2-musteri siparis ---> siparis listesi (1,2,3 )
     //                 ---->siparis iptali (1) siparis listesi(2,3)
     //musterinin olusturdugu  siparisi tabloda tutmaya gerek var mi ---> orphanRemovel:true

        t.commit();
        session.close();
        sf.close();
    }
}
