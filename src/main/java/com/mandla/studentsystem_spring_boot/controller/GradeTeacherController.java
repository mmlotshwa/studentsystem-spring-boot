/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.controller;

import com.mandla.studentsystem_spring_boot.service.GradeTeacherService;
import com.mandla.studentsystem_spring_boot.repository.GradeTeacherRepository;
import com.mandla.studentsystem_spring_boot.model.GradeTeacher;
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
@Tag(name="Grade Teacher", description="Grade Teacher Management APIs")
@RestController
@RequestMapping("/api/gradeteachers")
public class GradeTeacherController {
    @Autowired
    private GradeTeacherService teacherService;
    
    @Autowired
    private GradeTeacherRepository teacherRepository;
    
    @Operation(
            summary="Create a Grade Teacher record",
            description="A body is requested to have a gradeteacher object. The reponse is the gradeteacher you created."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GradeTeacher.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The teacher record could not be created", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @PostMapping
    public GradeTeacher createGradeTeacher(@RequestBody GradeTeacher teacher){
        return teacherService.createGradeTeacher(teacher);
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
    public List<GradeTeacher> getAllGradeTeachers(){
        return teacherService.getAllGradeTeachers();
    }
    
    @Operation(
            summary="Retrive a GradeTeacher by id",
            description="Get a GradeTeacher object for a specified id. The response is a GradeTeacher object with all the GradeTeacher properties."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Teacher.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The Teacher with the given id was not found!", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/{id}")
    public GradeTeacher getGradeTeacherById(@PathVariable Integer id){
        return teacherService.getGradeTeacherById(id);
    }
    
    @Operation(
            summary="Retrive gradeteachers by given year and term",
            description="Get all teachers in the specified year and term. The response is a List of teachers with each gradeteacher details."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = List.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "There are no active gradeteachers in this year and term", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/byyearterm/{tyear}/{term}")
    public List<GradeTeacher> getGradeTeachersByTyearAndTerm(@PathVariable Integer tyear, @PathVariable Integer term){
        return teacherRepository.findByTyearAndTerm(tyear,term);
    }
    
    @Operation(
            summary="Retrive a gradeteacher by given grade, year and term",
            description="Get all teachers in the specified grade, year and term. The response is a GradeTeacher with details."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GradeTeacher.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "There are no gradeteacher for this grade, year and term", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/bygradeyearterm/{grade}/{tyear}/{term}")
    public GradeTeacher getGradeTeachersByGradeAndTyearAndTerm(@PathVariable String grade, @PathVariable Integer tyear, @PathVariable Integer term){
        return teacherRepository.findByGradeAndTyearAndTerm(grade, tyear, term);
    }
    
    @Operation(
            summary="Retrive a gradeteacher by given teacherid, year and term",
            description="Get all teachers in the specified teacherid, year and term. The response is a List of teachers with each gradeteacher details."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GradeTeacher.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "There is no gradeteacher this teacherid, year and term", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/byteacheridyearterm/{grade}/{tyear}/{term}")
    public GradeTeacher getGradeTeachersByTeacheridAndTyearAndTerm(@PathVariable Integer teacherid, @PathVariable Integer tyear, @PathVariable Integer term){
        return teacherRepository.findByTeacheridAndTyearAndTerm(teacherid, tyear, term);
    }
    
    @Operation(
            summary="Retrive a gradeteacher by given teacher and year",
            description="Get all teachers in the specified teacherid and year. The response is a List of gradeteachers with each gradeteacher details."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = List.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "This teacher has is not a gradeteacher this year", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/byteacheridyear/{teacherid}/{tyear}")
    public List<GradeTeacher> getGradeTeachersByTeacheridAndTyear(@PathVariable Integer teacherid, @PathVariable Integer tyear){
        return teacherRepository.findByTeacheridAndTyear(teacherid, tyear);
    }
    
    @Operation(
            summary="Update GradeTeacher for the given id",
            description="Update the GradeTeacher object for a specified id. The response is a GradeTeacher object with all the GradeTeacher properties."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GradeTeacher.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The GradeTeacher with the given id was not found!", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @PutMapping("/{id}")
    public GradeTeacher updateGradeTeacher(@PathVariable Integer id, @RequestBody GradeTeacher teacher){
        return teacherService.updateGradeTeacher(id, teacher);
    }
    
    @Operation(
            summary="Delete a GradeTeacher with the given id",
            description="Delete the GradeTeacher object for a specified id."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = GradeTeacher.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The GradeTeacher with the given id was not found!", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @DeleteMapping("/{id}")
    public void deleteGradeTeacher(@PathVariable Integer id){
        teacherService.deleteGradeTeacher(id);
    }
}
