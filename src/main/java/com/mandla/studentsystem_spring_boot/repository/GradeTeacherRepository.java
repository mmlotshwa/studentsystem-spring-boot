/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.repository;

import com.mandla.studentsystem_spring_boot.model.GradeTeacher;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mlots
 */
public interface GradeTeacherRepository extends JpaRepository<GradeTeacher, Integer>{
    
    List<GradeTeacher> findByTyearAndTerm(int tyear, int term);
    GradeTeacher findByGradeAndTyearAndTerm(String grade, int tyear, int term);
    GradeTeacher findByTeacheridAndTyearAndTerm(int teacherid, int tyear, int term);
    List<GradeTeacher> findByTeacheridAndTyear(int teacherid, int tyear);
    
}
