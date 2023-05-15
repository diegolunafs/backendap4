/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliodl.DL.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Diego Luna
 */
public class dtoExperienciaLaboral {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    
     // Constructores

    public dtoExperienciaLaboral() {
    }

    public dtoExperienciaLaboral(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }
    
    // Get & Set

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
    
}
