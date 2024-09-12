/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.model;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description="Subject Code",example="500")
    @Id
    @Column(name="subjectid")
    private Integer subjectid;
    
    @Schema(description="Subject Name",example="First Language English")
    @Column(name="title", length = 40)
    private String title;
    
    @Schema(description="Subject belongs to the department",example="Languages")
    @Column(name="department", length=30)
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
