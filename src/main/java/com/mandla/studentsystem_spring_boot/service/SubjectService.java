/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.service;

import com.mandla.studentsystem_spring_boot.repository.SubjectRepository;
import com.mandla.studentsystem_spring_boot.model.Subject;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mlots
 */
@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    
    public Subject createSubject(Subject subject){
        return subjectRepository.save(subject);
    }
    
    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }
    
    public Subject getSubjectById(Integer subjectid){
        return subjectRepository.findById(subjectid).orElse(null);
    }
    
    public Subject updateSubject(Integer subjectid, Subject subject){
        subject.setSubjectid(subjectid);
        return subjectRepository.save(subject);
    }
    
    public void deleteSubject(Integer subjectid){
        subjectRepository.deleteById(subjectid);
    }
}
