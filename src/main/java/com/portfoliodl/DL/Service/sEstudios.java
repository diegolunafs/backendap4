/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliodl.DL.Service;

import com.portfoliodl.DL.Entity.Estudio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfoliodl.DL.Repository.iEstudiosRepository;

/**
 *
 * @author Diego Luna
 */
@Service
@Transactional
public class sEstudios {
    @Autowired
    iEstudiosRepository rEstudios;
    
    public List<Estudio> list(){
        return rEstudios.findAll();
    }
    
    public Optional<Estudio> getOne(int id){
        return rEstudios.findById(id);
    }
    
    public Optional<Estudio> getByNombreEs(String nombreEs){
        return rEstudios.findByNombreEs(nombreEs);
    }
    
    public void save(Estudio estudio){
        rEstudios.save(estudio);
    }
    
    public void delete(int id){
        rEstudios.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rEstudios.existsById(id);
    }
    
    public boolean existByNombreEs(String nombreEs){
        return rEstudios.existsByNombreEs(nombreEs);
    }
}
