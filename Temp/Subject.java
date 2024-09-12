/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mandla.studentsystem_spring_boot;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author mlots
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="subject")
public class Subject implements Comparable<Subject>{
    @Id
    @Column(name="subjectid")
    private Integer subjectid;
    
    @Column(name="title")
    private String title;
    
    @Column(name="department")
    private String department;

    @Override
    public String toString() {
        return String.format("[%04d] %-40s", getSubjectid(), getTitle());
    }

    @Override
    public int compareTo(Subject o) {
        return this.getTitle().compareTo(o.getTitle());
    }
}
