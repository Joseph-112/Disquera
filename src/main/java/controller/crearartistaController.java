/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author MontagutN
 */
@Named(value = "crearartistaController")
@RequestScoped
public class crearartistaController {
private String username;
private String nacionalidad;
    /**
     * Creates a new instance of crearartistaController
     */
    public crearartistaController() {
    }

    public void enviardatos(){//recpcion y muestra de datos desde el boton por consola
        System.out.println("Entro"+ username+" "+ nacionalidad);
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
}
