/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.service;

import com.mandla.studentsystem_spring_boot.repository.SubjectTeacherRepository;
import com.mandla.studentsystem_spring_boot.model.SubjectTeacher;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mlots
 */
@Service
public class SubjectTeacherService {
    @Autowired
    private SubjectTeacherRepository teacherRepository;
    
    public SubjectTeacher createSubjectTeacher(SubjectTeacher teacher){
        return teacherRepository.save(teacher);
    }
    
    public List<SubjectTeacher> getAllSubjectTeachers(){
        return teacherRepository.findAll();
    }
    
    public SubjectTeacher getSubjectTeacherById(Integer subjectteacherid){
        return teacherRepository.findById(subjectteacherid).orElse(null);
    }
    
    public SubjectTeacher updateSubjectTeacher(Integer subjectteacherid, SubjectTeacher subjectTeacher){
        subjectTeacher.setSubjectteacherid(subjectteacherid);
        return teacherRepository.save(subjectTeacher);
    }
    
    public void deleteSubjectTeacher(Integer subjectteacherid){
        teacherRepository.deleteById(subjectteacherid);
    }
}
