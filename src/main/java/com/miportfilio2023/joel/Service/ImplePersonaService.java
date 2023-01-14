/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miportfilio2023.joel.Service;

import com.miportfilio2023.joel.Entity.Personita;
import com.miportfilio2023.joel.repository.InPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
/**
 *
 * @author Joel Miguel Serrudo
 */
public class ImplePersonaService{
    @Autowired
    InPersonaRepository ipersonaRepository;
    
    public List<Personita> list(){
        return ipersonaRepository.findAll();
    }
    
    public Optional<Personita> getOne(int id){
        return ipersonaRepository.findById(id);
    }
    
    
    public Optional<Personita> getByNombre(String nombre){
        return ipersonaRepository.findByNombre(nombre);
    }
    
    public void save(Personita personita){
        ipersonaRepository.save(personita);
    }
    
    public void delete(int id){
        ipersonaRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return ipersonaRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return ipersonaRepository.existsByNombre(nombre);
    }
}
