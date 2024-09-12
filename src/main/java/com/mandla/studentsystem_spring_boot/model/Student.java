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
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author mlots
 */

@Schema(description="Student Model Information")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student implements Comparable<Student>{
    @Schema(accessMode=Schema.AccessMode.READ_ONLY,description="Student ID",example="123")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="studentid")
    private Integer studentid;
    
    @Schema(description="Student's Name",example="Mandla")
    @Column(name = "firstname", length = 50)
    private String firstname;
    
    @Schema(description="Student's Surname",example="Mlotshwa")
    @Column(name = "surname", length = 30)
    private String surname;
    
    @Schema(description="Student's Gender",example="F for Female, M for Male")
    @Column(name = "gender", length = 10)
    private String gender;
    
    @Schema(description="Student's Grade",example="1 East")
    @Column(name = "grade", length = 20)
    private String grade;
    
    @Schema(description="Student's Status",example="A - Active, G - Graduated, T - Transferred")
    @Column(name = "rstatus", length = 10)
    private String rstatus;
    
    @Schema(description="Student's Email Address",example="youraddess@domain.com")
    @Column(name = "email", length = 50)
    private String email;
    
    @Schema(description="Student's Date of Birth",example="05/09/2024")
    @Column(name = "dob")
    private Date dob;

    @Override
    public String toString() {
        return String.format("%-60s", "[" + getGrade() + "] " + getSurname() + ", " + getFirstname());
    }

    @Override
    public int compareTo(Student o) {
        if(this.getSurname().compareTo(o.getSurname()) == 0)
            return this.getFirstname().compareTo(o.getFirstname());
        return this.getSurname().compareTo(o.getSurname());
    }
    
    
}
