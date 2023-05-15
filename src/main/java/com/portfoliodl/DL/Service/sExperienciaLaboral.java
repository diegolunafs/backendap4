/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliodl.DL.Service;

import com.portfoliodl.DL.Entity.ExperienciaLaboral;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfoliodl.DL.Repository.iExperienciaLaboralRepository;

/**
 *
 * @author Diego Luna
 */

@Service
@Transactional
public class sExperienciaLaboral {
    @Autowired
    iExperienciaLaboralRepository rExperienciaLaboral;

    public List<ExperienciaLaboral> list(){
        return rExperienciaLaboral.findAll();
    }
    
    public Optional<ExperienciaLaboral> getOne(int id){
        return rExperienciaLaboral.findById(id);
    }
    
    public Optional<ExperienciaLaboral> getByNombreE(String nombreE){
        return rExperienciaLaboral.findByNombreE(nombreE);
    }
    
    public void save(ExperienciaLaboral experiencia){
        rExperienciaLaboral.save(experiencia);
    }
    
    public void delete(int id){
        rExperienciaLaboral.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rExperienciaLaboral.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return rExperienciaLaboral.existsByNombreE(nombreE);
    }
     
}
