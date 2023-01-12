/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.miportfilio2023.joel.Interface;

import com.miportfilio2023.joel.Entity.Personita;
import java.util.List;

/**
 *
 * @author Joel Miguel Serrudo
 */
public interface InPersonaService {
    //traigo personita
    public List<Personita> getPersonita();
    //guardo el objeto de tipo persona
    public void savePersonita(Personita personita);
    //eliminar un objeto es decir ususario
    public void deletePersonita(Long id);
    //buscar una personita
    public Personita findPersonita(Long id);
}
