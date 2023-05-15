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
public class dtoEstudios {
    @NotBlank
    private String nombreEs;
    @NotBlank
    private String descripcionEs;
    
    // constructores

    public dtoEstudios() {}
    
    public dtoEstudios(String nombreEs, String descripcionEs) {
        this.nombreEs = nombreEs;
        this.descripcionEs = descripcionEs;
    }
    
    //Get & set

    public String getNombreEs() {
        return nombreEs;
    }

    public void setNombreEs(String nombreEs) {
        this.nombreEs = nombreEs;
    }

    public String getDescripcionEs() {
        return descripcionEs;
    }

    public void setDescripcionEs(String descripcionEs) {
        this.descripcionEs = descripcionEs;
    }
    
    
    
    
    
}
