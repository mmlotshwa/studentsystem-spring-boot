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
    @Schema(description="SubjectTeacher grade",example="1 East")
    @Column(name="grade", length = 20)
    private String grade;
    
    @Schema(description="SubjectTeacher Teacher ID",example="123")
    @Column(name="teacherid")
    private Integer teacherid;
    
    @Schema(description="SubjectTeacher Fetched Teacher Record",example="Mlotshwa,  M")
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="teacherid", insertable=false, updatable=false)
    private Teacher teacher;
    
    @Schema(description="SubjectTeacher Subject ID",example="500")
    @Column(name="subjectid")
    private Integer subjectid;
    
    @Schema(description="SubjectTeacher Fetched Subject Record",example="[0500] First Language English")
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="subjectid", insertable=false, updatable=false)
    private Subject subject;
    
    @Schema(description="SubjectTeacher Year",example="2024")
    @Column(name="tyear")
    private Integer tyear;
    
    @Schema(description="SubjectTeacher Term",example="1")
    @Column(name="term")
    private Integer term;
    
    @Schema(accessMode=Schema.AccessMode.READ_ONLY,description="Grade Teacher ID",example="123")
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
