/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliodl.DL.Dto;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Diego Luna
 */
public class dtoHardysoftskill {
    @NotNull
    private String nombre; 
    @NotNull
    private int porcentaje;
    @NotNull
    private String img;    
    
    //Constructores

    public dtoHardysoftskill() {
    }

    public dtoHardysoftskill(String nombre, int porcentaje, String img) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.img = img;
    }
    
    // Get & Set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje(){
        return this.porcentaje;
    }
    
    public void setPorcentaje(int porcentaje){
        this.porcentaje = porcentaje;
    }
    
    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
