/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mandla.studentsystem_spring_boot;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="subjectteacher")
public class SubjectTeacher {
    @Column(name="grade")
    private String grade;
    
    @Column(name="teacherid")
    private Integer teacherid;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="teacherid", insertable=false, updatable=false)
    private Teacher teacher;
    
    @Column(name="subjectid")
    private Integer subjectid;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="subjectid", insertable=false, updatable=false)
    private Subject subject;
    
    @Column(name="tyear")
    private Integer tyear;
    
    @Column(name="term")
    private Integer term;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="subjectteacherid")
    private Integer subjectteacherid;

    @Override
    public String toString() {
        return String.format("%-70s",getSubject().toString().trim() + " (" + getTeacher().getSurname().trim() + ", " + getTeacher().getFirstName().trim() + 
                ")" + " - [{" + getGrade().trim() + "}]");
    }
}
