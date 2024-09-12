/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mandla.studentsystem_spring_boot;

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
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="teacherid")
    private Integer teacherid;
    
    @Column(name="title")
    private String title;
    
    @Column(name="firstname")
    private String firstName;
    
    @Column(name="surname")
    private String surname;
    
    @Column(name="gender")
    private String gender;
    
    @Column(name="email")
    private String email;
    
    @Column(name="department")
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
