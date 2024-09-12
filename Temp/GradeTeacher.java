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
import java.sql.Date;
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
@Table(name="gradeteacher")
public class GradeTeacher {
    @Column(name="grade")
    private String grade;
    
    @Column(name="teacherid")
    private Integer teacherid;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="teacherid", insertable=false, updatable=false)
    private Teacher teacher;
    
    @Column(name="tyear")
    private Integer tyear;
    
    @Column(name="term")
    private Integer term;
    
    @Column(name="termbegins")
    private Date termbegins;
    
    @Column(name="termends")
    private Date termends;
    
    @Column(name="numofdays")
    private Integer numofdays;
    
    @Column(name="nexttermbegins")
    private Date nexttermbegins;
    
    @Column(name="nexttermends")
    private Date nexttermends;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="gradeteacherid")
    private Integer gradeteacherid;

    @Override
    public String toString() {
        return String.format("%-20s%-40s", getGrade(),getTeacher().getSurname() + ", " + getTeacher().getFirstName());
    }
}
