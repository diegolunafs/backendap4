/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfoliodl.DL.Repository;

import com.portfoliodl.DL.Entity.Hardysoftskill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diego Luna
 */
@Repository
public interface iHardysoftskillRepository extends JpaRepository<Hardysoftskill, Integer>{
    public Optional<Hardysoftskill> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
