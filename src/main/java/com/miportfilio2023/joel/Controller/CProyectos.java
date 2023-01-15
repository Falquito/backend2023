/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miportfilio2023.joel.Controller;

import com.miportfilio2023.joel.Dto.dtoProyectos;
import com.miportfilio2023.joel.Entity.Proyectos;
import com.miportfilio2023.joel.Security.Controller.Mensaje;
import com.miportfilio2023.joel.Service.Sproyectos;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins="https://portfolio-frontend-7d3b4.web.app/")
/**
 *
 * @author Joel Miguel Serrudo
 */
public class CProyectos {
    @Autowired
    Sproyectos sProyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id")int id){
        if(!sProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe el ID"),HttpStatus.BAD_REQUEST);
        }
        
        Proyectos proyecto = sProyectos.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!sProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe el id"),HttpStatus.NOT_FOUND);
        }
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto Eliminado"),HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproyecto){
        if(StringUtils.isBlank(dtoproyecto.getNombreP())){
            return new ResponseEntity(new Mensaje("En el nombre lo tenes que poner papa"),HttpStatus.BAD_REQUEST);
        }
        if(sProyectos.existsByNombreP(dtoproyecto.getNombreP())){
            return new ResponseEntity(new Mensaje("ese nombre ya existe"),HttpStatus.BAD_REQUEST);
        }
        
        Proyectos proyecto = new Proyectos(dtoproyecto.getNombreP(),dtoproyecto.getDescripcionP(),dtoproyecto.getUrlP());
        sProyectos.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto creado"),HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody dtoProyectos dtoproyectos){
        if(!sProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe el ID"),HttpStatus.NOT_FOUND);
        }
        if(sProyectos.existsByNombreP(dtoproyectos.getNombreP()) && sProyectos.getByNombreP(dtoproyectos.getNombreP()).get().getId() !=id){
            return new ResponseEntity(new Mensaje("ese nombre ya existe"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoproyectos.getNombreP())){
            return new ResponseEntity(new Mensaje("este campo no puede estar vacio"),HttpStatus.BAD_REQUEST);
        }
        
        Proyectos proyecto = sProyectos.getOne(id).get();
        proyecto.setNombreP(dtoproyectos.getNombreP());
        proyecto.setDescripcionP(dtoproyectos.getDescripcionP());
        proyecto.setUrlP(dtoproyectos.getUrlP());
        
        sProyectos.save(proyecto);
        
        return new ResponseEntity(new Mensaje("proyecto actualizado"),HttpStatus.OK);
    }
}
