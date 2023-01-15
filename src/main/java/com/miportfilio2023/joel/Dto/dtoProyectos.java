/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miportfilio2023.joel.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Joel Miguel Serrudo
 */
public class dtoProyectos {
    @NotBlank
    private String urlP;
    @NotBlank
    private String nombreP;
    @NotBlank
    private String descripcionP;

    public dtoProyectos() {
    }

    public dtoProyectos(String urlP, String nombreP, String descripcionP) {
        this.urlP = urlP;
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
    }

    public String getUrlP() {
        return urlP;
    }

    public void setUrlP(String urlP) {
        this.urlP = urlP;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }
    
    
}
