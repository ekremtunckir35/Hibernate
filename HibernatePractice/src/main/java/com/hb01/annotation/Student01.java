package com.hb01.annotation;


import javax.persistence.*;

@Entity //@Entity annonationu koydugumuz sinifi veritabaninda yani DB de tabloya karsilik gelir.
@Table(name="t_student01")//DB'de tablo isimi im "t_student01"olrak degisti
public class Student01 { //DB de "student01" isimnde tablo olusturur.  t_student

    @Id   //primary-key olusmasini saglar
    //@Column(name="std_id")
    private int id;

    //@Column zorunlu degil,ancak herhangi bir degisiklik yapmak istiyorsaniz yani costumize edebilmek icin gerekli.
    @Column(name="student_name",length = 100,nullable = false,unique = false)
    private String name;

    //@Transient // DB de tabloda "grade" adinda bir kolon olusmasini engeller
    private int grade;

    //@Lob //-->large object ile buyuk boyutlu datalar tutulabilir.
    //private  byte[] image;


    //getter-setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }



    //toString() #######################

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
