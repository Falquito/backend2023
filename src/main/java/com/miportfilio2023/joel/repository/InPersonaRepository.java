/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.miportfilio2023.joel.repository;

import com.miportfilio2023.joel.Entity.Personita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Joel Miguel Serrudo
 */
@Repository
public interface InPersonaRepository extends JpaRepository<Personita,Long>{
    
}
