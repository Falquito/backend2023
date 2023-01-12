/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miportfilio2023.joel.Service;

import com.miportfilio2023.joel.Entity.Personita;
import com.miportfilio2023.joel.Interface.InPersonaService;
import com.miportfilio2023.joel.repository.InPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/**
 *
 * @author Joel Miguel Serrudo
 */
public class ImplePersonaService implements InPersonaService{
    @Autowired InPersonaRepository ipersonaRepository;

    @Override   
    public List<Personita> getPersonita() {
        List<Personita> personita=ipersonaRepository.findAll();
        return personita;
    }

    @Override
    public void savePersonita(Personita personita) {
       ipersonaRepository.save(personita);
    }

    @Override
    public void deletePersonita(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Personita findPersonita(Long id) {
        Personita personita = ipersonaRepository.findById(id).orElse(null);
        return personita;
    }
    
}
