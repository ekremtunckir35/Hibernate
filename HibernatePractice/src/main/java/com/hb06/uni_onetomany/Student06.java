package com.hb06.uni_onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student06 {
     @Id
    private int id;
    @Column(name = "student_name", nullable = false)
    private String name;

    private int grade;

    @OneToMany
    @JoinColumn
    private List<Book06> bookList = new ArrayList<>();

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

    public List<Book06> getBookList() {
        return bookList;
    }

    public void setBook06List(List<Book06> book06List) {
        this.bookList = book06List;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    //toString


    @Override
    public String toString() {
        return "Student06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }


}
