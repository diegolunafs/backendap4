/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliodl.DL.Controller;

import com.portfoliodl.DL.Dto.dtoExperienciaLaboral;
import com.portfoliodl.DL.Entity.ExperienciaLaboral;
import com.portfoliodl.DL.Security.Controller.Mensaje;
import com.portfoliodl.DL.Service.sExperienciaLaboral;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author Diego Luna
 */

@RestController
@RequestMapping("/explab")
@CrossOrigin(origins = "http://localhost:4200")
public class cExperienciaLaboral {
    @Autowired
    sExperienciaLaboral sExperienciaL;
    
    @GetMapping("/lista")
    public ResponseEntity<List<ExperienciaLaboral>> list(){
        List<ExperienciaLaboral> list = sExperienciaL.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<ExperienciaLaboral> detail(@PathVariable("id") int id){
        if(!sExperienciaL.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        ExperienciaLaboral experienciaLaboral = sExperienciaL.getOne(id).get();
        return new ResponseEntity(experienciaLaboral, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperienciaLaboral dtoExpLab){
        if(StringUtils.isBlank(dtoExpLab.getNombreE()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio..."), HttpStatus.BAD_REQUEST);
        if(sExperienciaL.existsByNombreE(dtoExpLab.getNombreE()))
            return new ResponseEntity(new Mensaje("La experiencia que intenta agregar ya existe..."), HttpStatus.BAD_REQUEST);
        
        ExperienciaLaboral experienciaLaboral = new ExperienciaLaboral(dtoExpLab.getNombreE(), dtoExpLab.getDescripcionE());
        sExperienciaL.save(experienciaLaboral);
        
        return new ResponseEntity(new Mensaje("La experiencia se agregó exitosamente..."), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperienciaLaboral dtoExpLab){
        if(!sExperienciaL.existsById(id))
            return new ResponseEntity(new Mensaje("La experiencia que intenta actualizar no existe..."), HttpStatus.BAD_REQUEST);
        
        if(sExperienciaL.existsByNombreE(dtoExpLab.getNombreE()) && sExperienciaL.getByNombreE(dtoExpLab.getNombreE()).get().getId() != id)
            return new ResponseEntity(new Mensaje("La experiencia que intenta ingresar ya existe..."), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoExpLab.getNombreE()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio..."), HttpStatus.BAD_REQUEST);
        
        ExperienciaLaboral experienciaLaboral = sExperienciaL.getOne(id).get();
        experienciaLaboral.setNombreEL(dtoExpLab.getNombreE());
        experienciaLaboral.setDescripcionEL(dtoExpLab.getDescripcionE());
        sExperienciaL.save(experienciaLaboral);
        
        return new ResponseEntity(new Mensaje("Experiencia actualizada exitosamente..."), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sExperienciaL.existsById(id))
            return new ResponseEntity(new Mensaje("La experiencia que intenta eliminar no existe..."), HttpStatus.BAD_REQUEST);
        sExperienciaL.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada exitosamente..."), HttpStatus.OK);
    }
    
    
}


