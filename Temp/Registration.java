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
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
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
@Table(name="registration")
public class Registration {
    @Column(name="grade")
    private String grade;
    
    @Column(name="subjectid")
    private Integer subjectid;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="subjectid", insertable=false, updatable=false)
    private Subject subject;
    
    @Column(name="studentid")
    private Integer studentid;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="studentid", insertable=false, updatable=false)
    private Student student;
   
    @Column(name="exammark")
    private Integer exammark;
    
     @Column(name="tavemark")
    private Integer tavemark;
    
    @Column(name="comments")
    private String comments;
    
    @Column(name="tyear")
    private Integer tyear;
    
    @Column(name="term")
    private Integer term;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="registrationid")
    private Integer registrationid;

    @Override
    public String toString() {
        return String.format("%-60s", "(" + getGrade() + ") - " + getSubject().toString().trim() + " {" +
                getStudentid() + "}");
    }
}
