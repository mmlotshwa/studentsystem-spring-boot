/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.controller;

import com.mandla.studentsystem_spring_boot.service.RegistrationService;
import com.mandla.studentsystem_spring_boot.repository.RegistrationRepository;
import com.mandla.studentsystem_spring_boot.model.Teacher;
import com.mandla.studentsystem_spring_boot.model.Registration;
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
@Tag(name="Registration", description="Registration Management APIs")
@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;
    
    @Autowired
    private RegistrationRepository registrationRepository;
    
    @Operation(
            summary="Create a Subject Teacher record",
            description="A body is requested to have a registration object. The reponse is the registration you created."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Registration.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The teacher record could not be created", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @PostMapping
    public Registration createRegistration(@RequestBody Registration teacher){
        return registrationService.createRegistration(teacher);
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
    public List<Registration> getAllRegistrations(){
        return registrationService.getAllRegistrations();
    }
    
    @Operation(
            summary="Retrive a Registration by id",
            description="Get a Registration object for a specified id. The response is a Registration object with all the Registration properties."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Teacher.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The Teacher with the given id was not found!", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/{id}")
    public Registration getRegistrationById(@PathVariable Integer id){
        return registrationService.getRegistrationById(id);
    }
    
    @Operation(
            summary="Retrive registrations by given year and term",
            description="Get all teachers in the specified year and term. The response is a List of teachers with each registration details."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = List.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "There are no active registrations in this year and term", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/byyearterm/{tyear}/{term}")
    public List<Registration> getRegistrationsByTyearAndTerm(@PathVariable Integer tyear, @PathVariable Integer term){
        return registrationRepository.findByTyearAndTerm(tyear,term);
    }
    
    @Operation(
            summary="Retrive a registration for given grade, year and term",
            description="Get all teachers in the specified grade, year and term. The response is a Registration with details."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = List.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "There are no registration for this grade, year and term", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/bygradeyearterm/{grade}/{tyear}/{term}")
    public List<Registration> getRegistrationsByGradeAndTyearAndTerm(@PathVariable String grade, @PathVariable Integer tyear, @PathVariable Integer term){
        return registrationRepository.findByGradeAndTyearAndTerm(grade, tyear, term);
    }
    
    @Operation(
            summary="Retrive a registration for given studentid, year and term",
            description="Get all registrations with the specified studentid, year and term. The response is a List of registrations with each registration details."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = List.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "There is no registration this studentid, year and term", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/bystudentidyearterm/{studentid}/{tyear}/{term}")
    public List<Registration> getRegistrationsByStudentAndTyearAndTerm(@PathVariable Integer studentid, @PathVariable Integer tyear, @PathVariable Integer term){
        return registrationRepository.findByStudentidAndTyearAndTerm(studentid, tyear, term);
    }
    
    @Operation(
            summary="Retrive a registration for given student and year",
            description="Get all teachers in the specified teacherid and year. The response is a List of registrations with each registration details."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = List.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "This teacher has is not a registration this year", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/bystudentyear/{studentid}/{tyear}")
    public List<Registration> getRegistrationsByStudentAndTyear(@PathVariable Integer studentid, @PathVariable Integer tyear){
        return registrationRepository.findByStudentidAndTyear(studentid, tyear);
    }
    
    @Operation(
            summary="Retrive a registration by given teacher and year",
            description="Get all teachers in the specified teacherid and year. The response is a List of registrations with each registration details."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = List.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "This teacher has is not a registration this year", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/bysubjectyearterm/{subjectid}/{tyear}/{term}")
    public List<Registration> getRegistrationsBySubjectAndTyearAndTerm(@PathVariable Integer subjectid, @PathVariable Integer tyear, @PathVariable Integer term){
        return registrationRepository.findBySubjectidAndTyearAndTerm(subjectid, tyear,term);
    }
    
    @Operation(
            summary="Retrive a registration by given teacher and year",
            description="Get all teachers in the specified teacherid and year. The response is a List of registrations with each registration details."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = List.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "This teacher has is not a registration this year", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/bygradesubjectyearterm/{grade}/{subjectid}/{tyear}/{term}")
    public List<Registration> getRegistrationsByGradeSubjectAndTyearAndTerm(@PathVariable String grade, @PathVariable Integer subjectid, @PathVariable Integer tyear, @PathVariable Integer term){
        return registrationRepository.findByGradeAndSubjectidAndTyearAndTerm(grade,subjectid, tyear,term);
    }
    
    @Operation(
            summary="Update Registration for the given id",
            description="Update the Registration object for a specified id. The response is a Registration object with all the Registration properties."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Registration.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The Registration with the given id was not found!", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @PutMapping("/{id}")
    public Registration updateRegistration(@PathVariable Integer id, @RequestBody Registration teacher){
        return registrationService.updateRegistration(id, teacher);
    }
    
    @Operation(
            summary="Delete a Registration with the given id",
            description="Delete the Registration object for a specified id."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Registration.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The Registration with the given id was not found!", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @DeleteMapping("/{id}")
    public void deleteRegistration(@PathVariable Integer id){
        registrationService.deleteRegistration(id);
    }
}
