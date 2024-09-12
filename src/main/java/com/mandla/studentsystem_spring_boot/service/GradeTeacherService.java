/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.service;

import com.mandla.studentsystem_spring_boot.repository.GradeTeacherRepository;
import com.mandla.studentsystem_spring_boot.model.GradeTeacher;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mlots
 */
@Service
public class GradeTeacherService {
    @Autowired
    private GradeTeacherRepository teacherRepository;
    
    public GradeTeacher createGradeTeacher(GradeTeacher teacher){
        return teacherRepository.save(teacher);
    }
    
    public List<GradeTeacher> getAllGradeTeachers(){
        return teacherRepository.findAll();
    }
    
    public GradeTeacher getGradeTeacherById(Integer gradeteacherid){
        return teacherRepository.findById(gradeteacherid).orElse(null);
    }
    
    public GradeTeacher updateGradeTeacher(Integer gradeteacherid, GradeTeacher gradeTeacher){
        gradeTeacher.setGradeteacherid(gradeteacherid);
        return teacherRepository.save(gradeTeacher);
    }
    
    public void deleteGradeTeacher(Integer gradeteacherid){
        teacherRepository.deleteById(gradeteacherid);
    }
}
