/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.controller;

import com.mandla.studentsystem_spring_boot.service.TeacherService;
import com.mandla.studentsystem_spring_boot.repository.TeacherRepository;
import com.mandla.studentsystem_spring_boot.model.Teacher;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@Tag(name="Teacher", description="Teacher Management APIs")
@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    
    @Autowired
    private TeacherRepository teacherRepository;
    
    @Operation(
            summary="Create a teacher record",
            description="A body is requested to have a teacher object. The reponse is the teacher you created."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Teacher.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The teacher record could not be created", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher){
        return teacherService.createTeacher(teacher);
    }
    
    @Operation(
            summary="Retrive all teachers",
            description="Get all teachers from the database. The response is a List of teachers with each teacher's details"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = List.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "There are no teachers in the database", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }
    
    @Operation(
            summary="Retrive a Teacher by id",
            description="Get a Teacher object for a specified id. The response is a Teacher object with all the Teacher properties."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Teacher.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The Teacher with the given id was not found!", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Integer id){
        return teacherService.getTeacherById(id);
    }
    
    @Operation(
            summary="Retrive teachers by given grade",
            description="Get all teachers in the specified grade. The response is a List of teachers with each teacher's properties."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = List.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "There are no active teachers in this grade", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/bydept/{department}")
    public List<Teacher> getTeachersByDepartment(@PathVariable String department){
        return teacherRepository.findByDepartment(department);
    }
    
    @Operation(
            summary="Update Teacher for the given id",
            description="Update the Teacher object for a specified id. The response is a Teacher object with all the Teacher properties."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Teacher.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The Teacher with the given id was not found!", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable Integer id, @RequestBody Teacher teacher){
        return teacherService.updateTeacher(id, teacher);
    }
    
    @Operation(
            summary="Delete a Teacher with the given id",
            description="Delete the Teacher object for a specified id."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Teacher.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The Teacher with the given id was not found!", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
    }
}
