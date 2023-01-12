/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.miportfilio2023.joel.Security.Repository;

import com.miportfilio2023.joel.Security.Entity.Rol;
import com.miportfilio2023.joel.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/**
 *
 * @author Joel Miguel Serrudo
 */
public interface IRolRepository extends JpaRepository<Rol,Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
