/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliodl.DL.Controller;

import com.portfoliodl.DL.Dto.dtoHardysoftskill;
import com.portfoliodl.DL.Entity.Hardysoftskill;
import com.portfoliodl.DL.Security.Controller.Mensaje;
import com.portfoliodl.DL.Service.sHardysoftskill;
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
@RequestMapping("/hyss")
@CrossOrigin(origins = "http://localhost:4200")
public class cHardysoftskill {
    @Autowired
    sHardysoftskill sHardysoftskill;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Hardysoftskill>> list(){
        List<Hardysoftskill> list = sHardysoftskill.list();
        
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Hardysoftskill> detail(@PathVariable("id") int id){
        if(!sHardysoftskill.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        Hardysoftskill hyss = sHardysoftskill.getOne(id).get();
        
        return new ResponseEntity(hyss, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHardysoftskill dtoHyss){
        if(StringUtils.isBlank(dtoHyss.getNombre()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio..."), HttpStatus.BAD_REQUEST);
        if(sHardysoftskill.existsByNombre(dtoHyss.getNombre()))
            return new ResponseEntity(new Mensaje("Esta habilidad ya existe..."), HttpStatus.BAD_REQUEST);
        
        Hardysoftskill hyss = new Hardysoftskill(dtoHyss.getNombre(), dtoHyss.getPorcentaje(), dtoHyss.getImg());
        sHardysoftskill.save(hyss);
        
        return new ResponseEntity(new Mensaje("La experiencia se agregó exitosamente..."), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHardysoftskill dtoHyss){
        if(!sHardysoftskill.existsById(id))
            return new ResponseEntity(new Mensaje("La habilidad que intenta actualizar no existe..."), HttpStatus.BAD_REQUEST);  
        if(sHardysoftskill.existsByNombre(dtoHyss.getNombre()) && sHardysoftskill.getByNombre(dtoHyss.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("La habilidad que intenta ingresar ya existe..."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoHyss.getNombre()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio..."), HttpStatus.BAD_REQUEST);  
        
        Hardysoftskill hyss = sHardysoftskill.getOne(id).get();
        hyss.setNombre(dtoHyss.getNombre());
        hyss.setPorcentaje(dtoHyss.getPorcentaje());
        hyss.setImg(dtoHyss.getImg());
        sHardysoftskill.save(hyss);
        
        return new ResponseEntity(new Mensaje("Experiencia actualizada exitosamente..."), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sHardysoftskill.existsById(id))
            return new ResponseEntity(new Mensaje("La habilidad que intenta eliminar no existe..."), HttpStatus.BAD_REQUEST);
        sHardysoftskill.delete(id);
        
        return new ResponseEntity(new Mensaje("Habilidad eliminada exitosamente..."), HttpStatus.OK);
    }
}
