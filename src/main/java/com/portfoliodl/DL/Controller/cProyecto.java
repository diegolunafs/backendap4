/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliodl.DL.Controller;

import com.portfoliodl.DL.Dto.dtoProyecto;
import com.portfoliodl.DL.Entity.Proyecto;
import com.portfoliodl.DL.Security.Controller.Mensaje;
import com.portfoliodl.DL.Service.sProyecto;
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
 * @author Diego Luna
 */
@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = "http://localhost:4200")
public class cProyecto {
    @Autowired
    sProyecto sProyecto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = sProyecto.list();
        
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> detail(@PathVariable("id") int id){
        if(!sProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        Proyecto proyecto = sProyecto.getOne(id).get();
        
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoProyecto){
        if(StringUtils.isBlank(dtoProyecto.getNombre()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio..."), HttpStatus.BAD_REQUEST);
        if(sProyecto.existsByNombre(dtoProyecto.getNombre()))
            return new ResponseEntity(new Mensaje("Este proyecto ya existe..."), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = new Proyecto(dtoProyecto.getNombre(), dtoProyecto.getDescripcion(), dtoProyecto.getImg());
        sProyecto.save(proyecto);
        
        return new ResponseEntity(new Mensaje("El proyecto se agregó exitosamente..."), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoProyecto){
        if(!sProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("El proyecto que intenta actualizar no existe..."), HttpStatus.BAD_REQUEST);  
        if(sProyecto.existsByNombre(dtoProyecto.getNombre()) && sProyecto.getByNombre(dtoProyecto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("El proyecto que intenta ingresar ya existe..."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoProyecto.getNombre()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio..."), HttpStatus.BAD_REQUEST);  
        
        Proyecto proyecto = sProyecto.getOne(id).get();
        proyecto.setNombre(dtoProyecto.getNombre());
        proyecto.setDescripcion(dtoProyecto.getDescripcion());
        proyecto.setImg(dtoProyecto.getImg());
        sProyecto.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto actualizada exitosamente..."), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("El proyecto que intenta eliminar no existe..."), HttpStatus.BAD_REQUEST);
        sProyecto.delete(id);
        
        return new ResponseEntity(new Mensaje("Proyecto eliminado exitosamente..."), HttpStatus.OK);
    }
}
