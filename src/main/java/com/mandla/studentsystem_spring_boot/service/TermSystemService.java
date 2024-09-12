/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.service;

import com.mandla.studentsystem_spring_boot.repository.TermSystemRepository;
import com.mandla.studentsystem_spring_boot.model.TermSystem;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mlots
 */
@Service
public class TermSystemService {
    @Autowired
    private TermSystemRepository termRepository;
    
    public TermSystem createTermSystem(TermSystem term){
        return termRepository.save(term);
    }
    
    public List<TermSystem> getAllTermSystems(){
        return termRepository.findAll();
    }
    
    public TermSystem getTermSystemById(Integer termid){
        return termRepository.findById(termid).orElse(null);
    }
    
    public TermSystem updateTermSystem(Integer termid, TermSystem term){
        term.setTermid(termid);
        return termRepository.save(term);
    }
    
    public void deleteTermSystem(Integer termid){
        termRepository.deleteById(termid);
    }
}
