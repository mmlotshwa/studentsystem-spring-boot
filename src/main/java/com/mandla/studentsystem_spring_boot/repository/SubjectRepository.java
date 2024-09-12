/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.repository;

import com.mandla.studentsystem_spring_boot.model.Subject;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mlots
 */
public interface SubjectRepository extends JpaRepository<Subject, Integer>{
    
    List<Subject> findByDepartment(String department);
}
