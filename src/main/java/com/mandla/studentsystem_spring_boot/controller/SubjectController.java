/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.controller;

import com.mandla.studentsystem_spring_boot.service.SubjectService;
import com.mandla.studentsystem_spring_boot.repository.SubjectRepository;
import com.mandla.studentsystem_spring_boot.model.Subject;
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
@Tag(name="Subject", description="Subject Management APIs")
@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    
    @Autowired
    private SubjectRepository subjectRepository;
    
    @Operation(
            summary="Create a subject record",
            description="A body is requested to have a subject object. The reponse is the subject you created."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Subject.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The subject record could not be created", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @PostMapping
    public Subject createSubject(@RequestBody Subject subject){
        return subjectService.createSubject(subject);
    }
    
    @Operation(
            summary="Retrive all subjects",
            description="Get all subjects from the database. The response is a List of subjects with each subject's details"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = List.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "There are no subjects in the database", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }
    
    @Operation(
            summary="Retrive a Subject by id",
            description="Get a Subject object for a specified id. The response is a Subject object with all the Subject properties."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Subject.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The Subject with the given id was not found!", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable Integer id){
        return subjectService.getSubjectById(id);
    }
    
    @Operation(
            summary="Retrive subjects by given grade",
            description="Get all subjects in the specified grade. The response is a List of subjects with each subject's properties."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = List.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "There are no active subjects in this grade", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/bydept/{department}")
    public List<Subject> getSubjectsByDepartment(@PathVariable String department){
        return subjectRepository.findByDepartment(department);
    }
    
    @Operation(
            summary="Update Subject for the given id",
            description="Update the Subject object for a specified id. The response is a Subject object with all the Subject properties."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Subject.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The Subject with the given id was not found!", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @PutMapping("/{id}")
    public Subject updateSubject(@PathVariable Integer id, @RequestBody Subject subject){
        return subjectService.updateSubject(id, subject);
    }
    
    @Operation(
            summary="Delete a Subject with the given id",
            description="Delete the Subject object for a specified id."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Subject.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The Subject with the given id was not found!", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable Integer id){
        subjectService.deleteSubject(id);
    }
}
