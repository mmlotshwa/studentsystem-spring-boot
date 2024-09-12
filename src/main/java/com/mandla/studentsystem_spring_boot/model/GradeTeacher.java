/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.model;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description="GradeTeacher Grade",example="1 East")
    @Column(name="grade", length = 20)
    private String grade;
    
    @Schema(description="GradeTeacher Teacher ID",example="123")
    @Column(name="teacherid")
    private Integer teacherid;
    
    @Schema(description="GradeTeacher Fetched Teacher Record",example="Mlotshwa,  M")
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="teacherid", insertable=false, updatable=false)
    private Teacher teacher;
    
    @Schema(description="GradeTeacher Year",example="2024")
    @Column(name="tyear")
    private Integer tyear;
    
    @Schema(description="GradeTeacher Term",example="1")
    @Column(name="term")
    private Integer term;
    
    @Schema(description="GradeTeacher Term Begins Date",example="15-09-2024")
    @Column(name="termbegins")
    private Date termbegins;
    
    @Schema(description="GradeTeacher Term Ends Date",example="03-12-2024")
    @Column(name="termends")
    private Date termends;
    
    @Schema(description="GradeTeacher Number of Days in Term",example="63")
    @Column(name="numofdays")
    private Integer numofdays;
    
    @Schema(description="GradeTeacher Next Term Begins Date",example="09-01-2025")
    @Column(name="nexttermbegins")
    private Date nexttermbegins;
    
    @Schema(description="GradeTeacher Next Term Ends Date",example="04-04-2025")
    @Column(name="nexttermends")
    private Date nexttermends;
    
    @Schema(accessMode=Schema.AccessMode.READ_ONLY,description="Grade Teacher ID",example="123")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="gradeteacherid")
    private Integer gradeteacherid;

    @Override
    public String toString() {
        return String.format("%-20s%-40s", getGrade(),getTeacher().getSurname() + ", " + getTeacher().getFirstName());
    }
}
