/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author MontagutN
 */
@Named(value = "userController")
@RequestScoped
public class UserController {

    /**
     * Creates a new instance of UserController
     */
    public UserController() {
    }
    
    public void verArtista() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../faces/verartistas.xhtml");
    }
    public void verAlbum() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../faces/User.xhtml");//no se que se hizo el xhtml de este
    }
    public void verCancion() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../faces/User.xhtml");//no se que se hizo el xhtml de este
    }
    /*public void crearGenero() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../faces/crearalbum.xhtml");
    }*/
    public void pedidos() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../faces/Admin.xhtml");// este no lo cree porque no sabia que ponerle
    }
    
}
