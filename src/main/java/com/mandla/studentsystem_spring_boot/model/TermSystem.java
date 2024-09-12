/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mandla.studentsystem_spring_boot.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author mlots
 */

@Schema(description="TermSystem Model Information")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "termsystem")
public class TermSystem {
    @Schema(accessMode=Schema.AccessMode.READ_ONLY,description="Term ID",example="123")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="termid")
    private Integer termid;
    
    @Schema(description="Term",example="1")
    @Column(name = "term")
    private Integer term;
    
    @Schema(description="Term Start Month",example="5")
    @Column(name = "startmonth")
    private Integer startmonth;
}
