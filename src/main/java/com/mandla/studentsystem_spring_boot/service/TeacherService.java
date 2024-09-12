/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.service;

import com.mandla.studentsystem_spring_boot.repository.TeacherRepository;
import com.mandla.studentsystem_spring_boot.model.Teacher;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mlots
 */
@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    
    public Teacher createTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }
    
    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }
    
    public Teacher getTeacherById(Integer teacherid){
        return teacherRepository.findById(teacherid).orElse(null);
    }
    
    public Teacher updateTeacher(Integer teacherid, Teacher teacher){
        teacher.setTeacherid(teacherid);
        return teacherRepository.save(teacher);
    }
    
    public void deleteTeacher(Integer teacherid){
        teacherRepository.deleteById(teacherid);
    }
}
