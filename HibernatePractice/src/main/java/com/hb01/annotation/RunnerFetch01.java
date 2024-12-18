package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunnerFetch01 {

    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);


        SessionFactory sf = con.buildSessionFactory();
        Session session =sf.openSession();

        Transaction tx = session.beginTransaction();

        //DB den bir bilgiyi almak icin
        //1-get() methodu
        //2- SQL ile
        //3- HQL ile java classlarini sql komutlariyla birlestirip  DB ye gondermenin adi
        //   HQL de tablo isimin degil class in ismi yazilir,header ismi degil class daki field ismi yazilir.


        //1.yol :##################################################################
//         Student01 student01 =session.get(Student01.class,1001);
//         Student01 student2 =session.get(Student01.class,1002);
//         Student01 student3 =session.get(Student01.class,1003);
//
//        System.out.println(student01);
//        System.out.println(student2);
//        System.out.println(student3);


     //2.yol : SQL   ######################################################

        String sqlQuery ="SELECT * FROM t_student01";
        List <Object[]>resultList = session.createSQLQuery(sqlQuery).getResultList();
        for(Object[]object:resultList){
            System.out.println(Arrays.toString(object));
        }

    //3.yol HQL ##################################################
        //Trick bilgi -->HQL  sorgusunda FROM dan sonra class ismi kullanilmali

        String hqlQuery ="FROM Student01";//burada class isimini kullandik

        List<Student01>resultList2  = session.createQuery(hqlQuery,Student01.class).getResultList();
        for (Student01 student01 : resultList2) {
            System.out.println(student01 );
        }

      /// unigueResult()with SQL######################################################
        //Donecek akydin Unique yani tek bir tame oldugundan emin iseniz "uniqueResult()" methodu kullanilabilir.

        String sqlQuery2 ="SELECT * FROM t_student01 WHERE student_name = 'Tarik Akan' ";
        Object[]uniqueResult1= (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
        System.out.println(Arrays.toString(uniqueResult1));

        //yukarida 1 obje gelecek ama icinde kolonlar oldugu icin array turunde obje geldi.


        System.out.println(uniqueResult1[0]+" "+uniqueResult1[1]+" "+uniqueResult1[2]);

        /// unigueResult()with HQL######################################################


        String hqlQuery2 ="FROM Student01 WHERE name = 'Tarik Akan' ";
        Student01 uniqueResult2= (Student01) session.createQuery(hqlQuery2).uniqueResult();
        System.out.println(uniqueResult2);

      //######################################################################

        //Yukaridaki sorguyu HQL ile Alias ile yazalim yani s ile

        String hqlQuery3 ="FROM Student01 std WHERE std.name = 'Tarik Akan'";
        Student01 uniqueResult3= (Student01) session.createQuery(hqlQuery3,Student01.class).uniqueResult();
        System.out.println(uniqueResult3);
  //######################################################

        //grade degeri 90 olan ogrenciyi getirelim

        String hqlQuery4 ="SELECT  s.id,s.name FROM Student01 s WHERE s.grade = 90";
        List<Object[]>resulList4= session.createQuery(hqlQuery4).getResultList();

        //createQuery metoduna tek parametre girildigi icin Student01 clasi ile mapleme yapilmadi.
        //Bu yuzden object olrak aldik.
        for(Object[]object:resulList4) {
            System.out.println(Arrays.toString(object));
        }

        tx.commit();
        session.close();
        sf.close();
    }
}
