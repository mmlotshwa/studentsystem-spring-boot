/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.service;

import com.mandla.studentsystem_spring_boot.repository.StudentRepository;
import com.mandla.studentsystem_spring_boot.model.Student;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mlots
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    
    public Student createStudent(Student student){
        return studentRepository.save(student);
    }
    
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    
    public Student getStudentById(Integer studentid){
        return studentRepository.findById(studentid).orElse(null);
    }
    
    public Student updateStudent(Integer studentid, Student student){
        student.setStudentid(studentid);
        return studentRepository.save(student);
    }
    
    public void deleteStudent(Integer studentid){
        studentRepository.deleteById(studentid);
    }
}
