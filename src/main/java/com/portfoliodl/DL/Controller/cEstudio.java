/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliodl.DL.Controller;

import com.portfoliodl.DL.Dto.dtoEstudios;
import com.portfoliodl.DL.Entity.Estudio;
import com.portfoliodl.DL.Security.Controller.Mensaje;
import com.portfoliodl.DL.Service.sEstudios;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 * @author Diego
 */
@RestController
@RequestMapping("/estudios")
@CrossOrigin (origins = "http://localhost:4200")
public class cEstudio {
    @Autowired
    sEstudios sEstudio;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Estudio>> list(){
        List<Estudio> list = sEstudio.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Estudio> detail(@PathVariable("id") int id){
        Estudio estudio = sEstudio.getOne(id).get();
        return new ResponseEntity(estudio, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEstudios dtoEstudios){
        if(StringUtils.isBlank(dtoEstudios.getNombreEs()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio."), HttpStatus.BAD_REQUEST);
        if(sEstudio.existByNombreEs(dtoEstudios.getNombreEs()))
            return new ResponseEntity(new Mensaje("El estudio que intenta agregar, ya existe."), HttpStatus.BAD_REQUEST);
        
        Estudio estudio = new Estudio(dtoEstudios.getNombreEs(), dtoEstudios.getDescripcionEs());
        sEstudio.save(estudio);
        return new ResponseEntity(new Mensaje("La experiencia se agregó correectamente..."), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody dtoEstudios dtoEstudios){
        if(!sEstudio.existsById(id))
            return new ResponseEntity(new Mensaje("Estudio no encontrado"), HttpStatus.OK);
        if(sEstudio.existByNombreEs(dtoEstudios.getNombreEs()) && sEstudio.getByNombreEs(dtoEstudios.getNombreEs()).get().getId() != id)
            return new ResponseEntity(new Mensaje("El estudio que intenta ingresar ya existe."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoEstudios.getNombreEs()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        
        Estudio estudio = sEstudio.getOne(id).get();
        estudio.setNombreEs(dtoEstudios.getNombreEs());
        estudio.setDescripcionEs(dtoEstudios.getDescripcionEs());
        sEstudio.save(estudio);
        
        return new ResponseEntity(new Mensaje("Estudio actualizado correctamente."), HttpStatus.OK);  
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEstudio.existsById(id))
            return new ResponseEntity(new Mensaje("Estudio no encontrado"), HttpStatus.BAD_REQUEST);
        sEstudio.delete(id);
        
        return new ResponseEntity(new Mensaje("Estudio eliminado"), HttpStatus.OK);
    }

}
