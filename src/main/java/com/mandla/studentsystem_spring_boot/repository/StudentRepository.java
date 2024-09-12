/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.repository;

import com.mandla.studentsystem_spring_boot.model.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author mlots
 */
public interface StudentRepository extends JpaRepository<Student, Integer>{
    
    List<Student> findByRstatus(String rstatus);
    
    @Query("SELECT s FROM Student s WHERE s.grade = ?1 AND s.rstatus = \"A\"")
    List<Student> findByGrade(String grade);
    
}
