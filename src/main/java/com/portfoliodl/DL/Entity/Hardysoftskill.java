/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliodl.DL.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Diego Luna
 */
@Entity
public class Hardysoftskill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String nombre;
    
    @NotNull
    private String img;
    
    @NotNull
    private int porcentaje;
    
    //Constructores

    public Hardysoftskill() {
    }

    public Hardysoftskill(String nombre, int porcentaje, String img) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.img = img;
    }
    
    // Get & Set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
