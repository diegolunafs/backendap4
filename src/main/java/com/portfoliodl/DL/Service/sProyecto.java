/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliodl.DL.Service;

import com.portfoliodl.DL.Entity.Proyecto;
import com.portfoliodl.DL.Repository.iProyectosRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego Luna
 */
@Service
@Transactional
public class sProyecto {
    @Autowired
    iProyectosRepository rProyectos;

    public List<Proyecto> list(){
        return rProyectos.findAll();
    }
    
    public Optional<Proyecto> getOne(int id){
        return rProyectos.findById(id);
    }
    
    public Optional<Proyecto> getByNombre(String nombre){
        return rProyectos.findByNombre(nombre);
    }
    
    public void save(Proyecto proyecto){
        rProyectos.save(proyecto);
    }
    
    public void delete(int id){
        rProyectos.deleteById(id);
    }
   
    public boolean existsById(int id){
        return rProyectos.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rProyectos.existsByNombre(nombre);
    }
}
