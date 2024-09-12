/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name="teacher")
public class Teacher implements Comparable<Teacher>{
    @Schema(accessMode=Schema.AccessMode.READ_ONLY,description="Teacher ID",example="123")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="teacherid")
    private Integer teacherid;
    
    @Schema(description="Teacher's Title",example="Dr or Mr or Ms or Mrs")
    @Column(name="title", length=10)
    private String title;
    
    @Schema(description="Teacher's Firstname",example="Mandla")
    @Column(name="firstname", length=40)
    private String firstName;
    
    @Schema(description="Teacher's Surname",example="Mlotshwa")
    @Column(name="surname",length=30)
    private String surname;
    
    @Schema(description="Teacher's Gender",example="F - Female or M - Male or O - Other")
    @Column(name="gender",length=10)
    private String gender;
    
    @Schema(description="Teacher's Email Address",example="yourname@domain.com")
    @Column(name="email",length=50)
    private String email;
    
    @Schema(description="Teacher's Department",example="Sciences")
    @Column(name="department",length=30)
    private String department;

    @Override
    public String toString() {
        return String.format("%-50s",  getSurname() + ", " + getFirstName());
    }

    @Override
    public int compareTo(Teacher o) {
        if(this.getSurname().compareTo(o.getSurname()) == 0)
            return this.getFirstName().compareTo(o.getFirstName());
        return this.getSurname().compareTo(o.getSurname());
    }
}
