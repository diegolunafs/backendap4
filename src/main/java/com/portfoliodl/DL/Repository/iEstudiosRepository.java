/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfoliodl.DL.Repository;
import com.portfoliodl.DL.Entity.Estudio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diego Luna
 */
@Repository
public interface iEstudiosRepository extends JpaRepository<Estudio, Integer> {
    public Optional<Estudio> findByNombreEs(String nombreEs);
    public boolean existsByNombreEs(String nombreEs);
}




