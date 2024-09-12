/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.controller;

import com.mandla.studentsystem_spring_boot.service.TermSystemService;
import com.mandla.studentsystem_spring_boot.repository.TermSystemRepository;
import com.mandla.studentsystem_spring_boot.model.TermSystem;
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
@Tag(name="Term System", description="Term System Management APIs")
@RestController
@RequestMapping("/api/terms")
public class TermSystemController {
    @Autowired
    private TermSystemService termService;
    
    @Autowired
    private TermSystemRepository termRepository;
    
    @Operation(
            summary="Create a term record",
            description="A body is requested to have a term object. The reponse is the term you created."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TermSystem.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The term record could not be created", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @PostMapping
    public TermSystem createTermSystem(@RequestBody TermSystem term){
        return termService.createTermSystem(term);
    }
    
    @Operation(
            summary="Retrive all terms",
            description="Get all terms from the database. The response is a List of terms with each term's details"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = List.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "There are no terms in the database", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping
    public List<TermSystem> getAllTermSystems(){
        return termService.getAllTermSystems();
    }
    
    @Operation(
            summary="Retrive a TermSystem by id",
            description="Get a TermSystem object for a specified id. The response is a TermSystem object with all the TermSystem properties."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TermSystem.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The TermSystem with the given id was not found!", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/{id}")
    public TermSystem getTermSystemById(@PathVariable Integer id){
        return termService.getTermSystemById(id);
    }
    
    @Operation(
            summary="Retrive term with given start month",
            description="Get the term with the specified start month. The response is a term with the term's properties."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TermSystem.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "There are no active terms in this grade", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/bystartmonth/{startMonth}")
    public TermSystem getTermSystemsByStartMonth(@PathVariable Integer startmonth){
        return termRepository.findByStartMonth(startmonth);
    }
    
    @Operation(
            summary="Update TermSystem for the given id",
            description="Update the TermSystem object for a specified id. The response is a TermSystem object with all the TermSystem properties."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TermSystem.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The TermSystem with the given id was not found!", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @PutMapping("/{id}")
    public TermSystem updateTermSystem(@PathVariable Integer id, @RequestBody TermSystem term){
        return termService.updateTermSystem(id, term);
    }
    
    @Operation(
            summary="Delete a TermSystem with the given id",
            description="Delete the TermSystem object for a specified id."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TermSystem.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "The TermSystem with the given id was not found!", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error!", content = { @Content(schema = @Schema()) })
    })
    @DeleteMapping("/{id}")
    public void deleteTermSystem(@PathVariable Integer id){
        termService.deleteTermSystem(id);
    }
}
