/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.repository;

import com.mandla.studentsystem_spring_boot.model.Registration;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mlots
 */
public interface RegistrationRepository extends JpaRepository<Registration, Integer>{
    
    List<Registration> findByTyearAndTerm(int tyear, int term);
    List<Registration> findByGradeAndTyearAndTerm(String grade, int tyear, int term);
    List<Registration> findByStudentidAndTyearAndTerm(int studentid, int tyear, int term);
    List<Registration> findBySubjectidAndTyearAndTerm(int subjectid, int tyear, int term);
    List<Registration> findByGradeAndSubjectidAndTyearAndTerm(String grade, int subjectid, int tyear, int term);
    List<Registration> findByStudentidAndTyear(int studentid, int tyear);
    
}
