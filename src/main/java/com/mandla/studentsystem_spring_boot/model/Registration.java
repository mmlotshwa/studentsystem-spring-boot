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
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
    @Schema(description="Registion Grade",example="1 East")
    @Column(name="grade", length=20)
    private String grade;
    
    @Schema(description="Registered Subject ID",example="500")
    @Column(name="subjectid")
    private Integer subjectid;
    
    @Schema(description="Registration Fetched Subject Record",example="[0500] First Language English")
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="subjectid", insertable=false, updatable=false)
    private Subject subject;
    
    @Schema(description="Registered Student ID",example="123")
    @Column(name="studentid")
    private Integer studentid;
    
    @Schema(description="Registration Fetched Student Record",example="Mlotshwa, Mandlenkosi")
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="studentid", insertable=false, updatable=false)
    private Student student;
    
    @Schema(description="Grade Subject Average Term Mark",example="77")
    @Column(name="tavemark")
    private Integer tavemark;
   
    @Schema(description="Student Subject Exam Mark",example="90")
    @Column(name="exammark")
    private Integer exammark;
    
    @Transient
    private String symbol;
    
    @PostLoad
    private void postLoad(){
        if (this.getExammark() == null){
            this.setSymbol(null);
        }else if(this.getSubject().getTitle().contains("(core)") && this.getExammark() >= 58){
            this.setSymbol("C");
        }else{
            if(this.getExammark() >= 90)
                this.setSymbol("A*");
            else if(this.getExammark() >= 80)
                this.setSymbol("A");
            else if(this.getExammark() >= 70)
                this.setSymbol("B");
            else if(this.getExammark() >= 58)
                this.setSymbol("C");
            else if(this.getExammark() >= 50)
                this.setSymbol("D");
            else if(this.getExammark() >= 40)
                this.setSymbol("E");
            else if(this.getExammark() >= 30)
                this.setSymbol("F");
            else if(this.getExammark() >= 20)
                this.setSymbol("G");
            else if(this.getExammark() >= 0)
                this.setSymbol("U");
        }
    }
    
    @Schema(description="Subject Teacher Comments",example="An excellent performance")
    @Column(name="comments")
    private String comments;
    
    @Schema(description="Registration Year",example="2024")
    @Column(name="tyear")
    private Integer tyear;
    
    @Schema(description="Registration Term",example="1")
    @Column(name="term")
    private Integer term;
    
    @Schema(accessMode=Schema.AccessMode.READ_ONLY,description="Registration ID",example="123")
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
