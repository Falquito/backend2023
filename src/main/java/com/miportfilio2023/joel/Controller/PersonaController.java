/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miportfilio2023.joel.Controller;

import com.miportfilio2023.joel.Dto.dtoPersonita;
import com.miportfilio2023.joel.Entity.Personita;
import com.miportfilio2023.joel.Security.Controller.Mensaje;
import com.miportfilio2023.joel.Service.ImplePersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins ="https://portfolio-frontend-7d3b4.web.app")
/**
 *
 * @author Joel Miguel Serrudo
 */
public class PersonaController {
    @Autowired
    ImplePersonaService personaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Personita>> list(){
        List<Personita> list = personaService.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Personita> getById(@PathVariable("id")int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("no esta este id"),HttpStatus.BAD_REQUEST);
        }
        Personita persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    /*@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"),HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion Borrada"),HttpStatus.OK);
    }*/
    /*
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
        if(StringUtils.isBlank(dtoeducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if(sEducacion.existsByNombreE(dtoeducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("el nombre este ya existe"),HttpStatus.BAD_REQUEST);
            
        }
        Educacion educacion = new Educacion(dtoeducacion.getNombreE(),dtoeducacion.getDescripcionE());
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("la educacion fue creada"),HttpStatus.OK);
    }*/
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody dtoPersonita dtopersona){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("no hay id"),HttpStatus.NOT_FOUND);
        }
        if(personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId()!=id){
            return new ResponseEntity(new Mensaje("el nombre que pusiste ya existe"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("el campo no tiene que estar vacio"),HttpStatus.BAD_REQUEST);
        }
        Personita persona = personaService.getOne(id).get();
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setDescripcion(dtopersona.getDescripcion());
        persona.setImg(dtopersona.getImg());
        
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("persona Actualizada"),HttpStatus.OK);
    }
}
