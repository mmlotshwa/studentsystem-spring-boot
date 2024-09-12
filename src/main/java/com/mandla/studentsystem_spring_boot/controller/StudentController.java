/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.controller;

import com.mandla.studentsystem_spring_boot.service.StudentService;
import com.mandla.studentsystem_spring_boot.repository.StudentRepository;
import com.mandla.studentsystem_spring_boot.model.Student;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mlots
 */

@CrossOrigin(origins = "http://localhost:3000")
@Tag(name="Student", description="Student Management APIs")
@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Operation(
            summary="Create a student record",
            description="A body is requested to have a student object. The reponse is the student you created."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Student.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The student record could not be created", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
    
    @Operation(
            summary="Retrive all students",
            description="Get all students from the database. The response is a List of students with each student's details"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = List.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "There are no students in the database", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    
    @Operation(
            summary="Retrive a Student by id",
            description="Get a Student object for a specified id. The response is a Student object with all the Student properties."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Student.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The Student with the given id was not found!", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }
    
    @Operation(
            summary="Retrive students by given grade",
            description="Get all students in the specified grade. The response is a List of students with each student's properties."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = List.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "There are no active students in this grade", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/bygrade/{grade}")
    public List<Student> getStudentsByGrade(@PathVariable String grade){
        return studentRepository.findByGrade(grade);
    }
    
    @Operation(
            summary="Update Student for the given id",
            description="Update the Student object for a specified id. The response is a Student object with all the Student properties."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Student.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The Student with the given id was not found!", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }
    
    @Operation(
            summary="Delete a Student with the given id",
            description="Delete the Student object for a specified id."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Student.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The Student with the given id was not found!", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
    }
}
