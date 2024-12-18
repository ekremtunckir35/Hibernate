package com.hb04bi_onetoone;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student04 {
    @Id
    private Integer id; //private Integer id..wrapper class kullaniriz,default null dir.
                        //int kullanirsak default 0 dir.

    @Column(name="std_name")
    private String name;

    private int grade;
    @OneToOne(mappedBy = "student")//sadece Diary tablosunda OneToOne iliski icin yeni bir kolon olusmasini sagliyor.
    private Diary04 diary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Diary04 getDiary() {
        return diary;
    }

    public void setDiary(Diary04 diary) {
        this.diary = diary;
    }


    //method ciktisinda sonsuz donguye girilmesin diye diary objesi eklenmedi.
    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +

                '}';
    }
}
