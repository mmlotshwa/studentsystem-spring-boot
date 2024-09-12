/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.repository;

import com.mandla.studentsystem_spring_boot.model.SubjectTeacher;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mlots
 */
public interface SubjectTeacherRepository extends JpaRepository<SubjectTeacher, Integer>{
    
    List<SubjectTeacher> findByTyearAndTerm(int tyear, int term);
    List<SubjectTeacher> findByGradeAndTyearAndTerm(String grade, int tyear, int term);
    List<SubjectTeacher> findByTeacheridAndTyearAndTerm(int teacherid, int tyear, int term);
    List<SubjectTeacher> findByTeacheridAndTyear(int teacherid, int tyear);
    
}
