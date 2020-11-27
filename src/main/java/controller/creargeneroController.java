/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.DAOGenre;
import pojo.Genre;

/**
 *
 * @author MontagutN
 */
@Named(value = "creargeneroController")
@RequestScoped
public class creargeneroController {

    private Genre genre;

    /**
     * Creates a new instance of creargeneroController
     */
    public creargeneroController() {
        genre = new Genre();
    }

    public void enviardatos() {

        boolean success = new DAOGenre().insertGenre(genre.getGenre());
        if (success == true) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Género musical registrado con éxito"));
            System.out.println("Registrado con éxito");
        } else {
            System.out.println("Error");
        }
        System.out.println("Entro " + genre.getGenre());

    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    

    
}
