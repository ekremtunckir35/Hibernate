package com.tpe.hb08.manytomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    private  Integer id;
    private String name;

    @ManyToMany(mappedBy = "courseList")
    // JOIN TABLE : course_t_student08,jointable olusturmana gerek yok diger taraftan takip et,eslestir.
    
    private List<Student08> student08List=new ArrayList<>();


    //const


    public Course() {
    }

    public Course(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    //getter setter

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

    public List<Student08> getStudent08List() {
        return student08List;
    }

    public void setStudent08List(List<Student08> student08List) {
        this.student08List = student08List;
    }

    //toString()

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student08List=" + student08List +
                '}';
    }
}
