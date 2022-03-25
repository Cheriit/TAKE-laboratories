/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.take.PrimeFaces.view.backing;

import com.take.PrimeFaces.models.Student;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author cherit
 */
@Named(value = "tableBean")
@RequestScoped
public class TableBean {

    private List<Student> students;
    /**
     * Creates a new instance of TableBean
     */
    public TableBean() {
        students = new ArrayList<>();
        students.add(new Student("Filip", "Szóstak", 4.85));
        students.add(new Student("Grzegorz", "Brzęczyszczykiewicz", 4.25));
        students.add(new Student("Cecil", "Palmer", 3.45));
    }

    /**
     * @return the students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
}
