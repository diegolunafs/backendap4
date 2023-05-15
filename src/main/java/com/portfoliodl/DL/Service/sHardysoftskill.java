/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliodl.DL.Service;

import com.portfoliodl.DL.Entity.Hardysoftskill;
import com.portfoliodl.DL.Repository.iHardysoftskillRepository;
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
public class sHardysoftskill {
    @Autowired
    iHardysoftskillRepository rHardysoftskill;

    public List<Hardysoftskill> list(){
        return rHardysoftskill.findAll();
    }
    
    public Optional<Hardysoftskill> getOne(int id){
        return rHardysoftskill.findById(id);
    }
    
    public Optional<Hardysoftskill> getByNombre(String nombre){
        return rHardysoftskill.findByNombre(nombre);
    }
    
    public void save(Hardysoftskill hyss){
        rHardysoftskill.save(hyss);
    }
    
    public void delete(int id){
        rHardysoftskill.deleteById(id);
    }
   
    public boolean existsById(int id){
        return rHardysoftskill.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rHardysoftskill.existsByNombre(nombre);
    }
     
}
