/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author MontagutN
 */
@Named(value = "crearartistaController")
@RequestScoped
public class crearartistaController {
    private String nombreartista;
    private String nacionalidad;
    private Date fechanacimiento;
    private String fotoartista;
    
    /**
     * Creates a new instance of crearartistaController
     */
    public crearartistaController() {
        //no se que va acá :(
    }

    public void enviardatos(){//recpcion y muestra de datos desde el boton por consola
        System.out.println("Entro"+ nombreartista+" "+ nacionalidad+" "+fechanacimiento+" "+fotoartista);
    }
    public String getUsername() {
        return nombreartista;
    }

    public void setUsername(String username) {
        this.nombreartista = username;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNombreartista() {
        return nombreartista;
    }

    public void setNombreartista(String nombreartista) {
        this.nombreartista = nombreartista;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getFotoartista() {
        return fotoartista;
    }

    public void setFotoartista(String fotoartista) {
        this.fotoartista = fotoartista;
    }
    
}
