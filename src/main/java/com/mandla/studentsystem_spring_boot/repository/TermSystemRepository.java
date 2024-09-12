/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.repository;

import com.mandla.studentsystem_spring_boot.model.TermSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author mlots
 */
public interface TermSystemRepository extends JpaRepository<TermSystem, Integer>{
    
    @Query("SELECT t FROM TermSystem t WHERE t.startmonth = ?1")
    TermSystem findByStartMonth(Integer startmonth);
}
