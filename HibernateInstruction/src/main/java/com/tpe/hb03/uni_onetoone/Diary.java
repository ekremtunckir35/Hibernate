package com.tpe.hb03.uni_onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary {


    @Id
    private Integer Id;


    private String name;

    @OneToOne  //diary ile Student03 arasinda birebir iliski kurulmaini saglar
               //bunun icin diary ile FK ekler.default isim : student_id



    @JoinColumn(name="std_id",unique = true) //OPSIYONEL(isim degistirme,constraint ekleme vb..)
    private  Student03 student;// ONE //gunluk hangi ogrenciye ait onu gosterir.1 tane ogrenciye ait.



    //getter setter


    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //toString

    @Override
    public String toString() {
        return "Diary{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }
}
