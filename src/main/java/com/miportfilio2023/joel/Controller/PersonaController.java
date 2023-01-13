/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miportfilio2023.joel.Controller;

import com.miportfilio2023.joel.Entity.Personita;
import com.miportfilio2023.joel.Interface.InPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"https://portfolio-frontend-7d3b4.web.app","https://localhost:4200"})
/**
 *
 * @author Joel Miguel Serrudo
 */
public class PersonaController {
    @Autowired InPersonaService ipersonaService;
    @GetMapping("/personovich/traer")
    public List<Personita> getPersonita(){
        return (List<Personita>)this.ipersonaService.getPersonita();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personovich/crear")
    public String createPersonita(@RequestBody final Personita personita){
        this.ipersonaService.savePersonita(personita);
        return "la personovich se creo de forma nazi";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personovich/borrar/{id}")
    public String deletePersonita(@PathVariable final Long id){
        this.ipersonaService.deletePersonita(id);
        return "La persona fue eliminada correctamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personovich/editar/{id}")
    public Personita editPersonita(@PathVariable final Long id,@RequestParam("nombre")final String nuevoNombre,@RequestParam("apellido")final String nuevoApellido,@RequestParam("img")final String nuevoImg){
        final Personita persona=this.ipersonaService.findPersonita(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        this.ipersonaService.savePersonita(persona);
        return persona;
    }
    @GetMapping("/personovich/traer/perfil")
    public Personita findPersonita(){
        return this.ipersonaService.findPersonita(Long.valueOf(1L));
    }
}
