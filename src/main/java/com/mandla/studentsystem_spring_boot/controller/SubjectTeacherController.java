/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.controller;

import com.mandla.studentsystem_spring_boot.service.SubjectTeacherService;
import com.mandla.studentsystem_spring_boot.repository.SubjectTeacherRepository;
import com.mandla.studentsystem_spring_boot.model.SubjectTeacher;
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
@Tag(name="Subject Teacher", description="Subject Teacher Management APIs")
@RestController
@RequestMapping("/api/subjectteachers")
public class SubjectTeacherController {
    @Autowired
    private SubjectTeacherService teacherService;
    
    @Autowired
    private SubjectTeacherRepository teacherRepository;
    
    @Operation(
            summary="Create a Subject Teacher record",
            description="A body is requested to have a subjectteacher object. The reponse is the subjectteacher you created."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = SubjectTeacher.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The teacher record could not be created", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @PostMapping
    public SubjectTeacher createSubjectTeacher(@RequestBody SubjectTeacher teacher){
        return teacherService.createSubjectTeacher(teacher);
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
    public List<SubjectTeacher> getAllSubjectTeachers(){
        return teacherService.getAllSubjectTeachers();
    }
    
    @Operation(
            summary="Retrive a SubjectTeacher by id",
            description="Get a SubjectTeacher object for a specified id. The response is a SubjectTeacher object with all the SubjectTeacher properties."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Teacher.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The Teacher with the given id was not found!", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/{id}")
    public SubjectTeacher getSubjectTeacherById(@PathVariable Integer id){
        return teacherService.getSubjectTeacherById(id);
    }
    
    @Operation(
            summary="Retrive subjectteachers by given year and term",
            description="Get all teachers in the specified year and term. The response is a List of teachers with each subjectteacher details."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = List.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "There are no active subjectteachers in this year and term", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/byyearterm/{tyear}/{term}")
    public List<SubjectTeacher> getSubjectTeachersByTyearAndTerm(@PathVariable Integer tyear, @PathVariable Integer term){
        return teacherRepository.findByTyearAndTerm(tyear,term);
    }
    
    @Operation(
            summary="Retrive a subjectteacher by given grade, year and term",
            description="Get all teachers in the specified grade, year and term. The response is a SubjectTeacher with details."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = List.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "There are no subjectteacher for this grade, year and term", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/bygradeyearterm/{grade}/{tyear}/{term}")
    public List<SubjectTeacher> getSubjectTeachersByGradeAndTyearAndTerm(@PathVariable String grade, @PathVariable Integer tyear, @PathVariable Integer term){
        return teacherRepository.findByGradeAndTyearAndTerm(grade, tyear, term);
    }
    
    @Operation(
            summary="Retrive a subjectteacher by given teacherid, year and term",
            description="Get all teachers in the specified teacherid, year and term. The response is a List of teachers with each subjectteacher details."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = List.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "There is no subjectteacher this teacherid, year and term", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/byteacheridyearterm/{teacherid}/{tyear}/{term}")
    public List<SubjectTeacher> getSubjectTeachersByTeacheridAndTyearAndTerm(@PathVariable Integer teacherid, @PathVariable Integer tyear, @PathVariable Integer term){
        return teacherRepository.findByTeacheridAndTyearAndTerm(teacherid, tyear, term);
    }
    
    @Operation(
            summary="Retrive a subjectteacher by given teacher and year",
            description="Get all teachers in the specified teacherid and year. The response is a List of subjectteachers with each subjectteacher details."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = List.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "This teacher has is not a subjectteacher this year", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/byteacheridyear/{teacherid}/{tyear}")
    public List<SubjectTeacher> getSubjectTeachersByTeacheridAndTyear(@PathVariable Integer teacherid, @PathVariable Integer tyear){
        return teacherRepository.findByTeacheridAndTyear(teacherid, tyear);
    }
    
    @Operation(
            summary="Update SubjectTeacher for the given id",
            description="Update the SubjectTeacher object for a specified id. The response is a SubjectTeacher object with all the SubjectTeacher properties."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = SubjectTeacher.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The SubjectTeacher with the given id was not found!", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @PutMapping("/{id}")
    public SubjectTeacher updateSubjectTeacher(@PathVariable Integer id, @RequestBody SubjectTeacher teacher){
        return teacherService.updateSubjectTeacher(id, teacher);
    }
    
    @Operation(
            summary="Delete a SubjectTeacher with the given id",
            description="Delete the SubjectTeacher object for a specified id."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = SubjectTeacher.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The SubjectTeacher with the given id was not found!", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @DeleteMapping("/{id}")
    public void deleteSubjectTeacher(@PathVariable Integer id){
        teacherService.deleteSubjectTeacher(id);
    }
}
