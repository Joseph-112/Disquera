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
    public void comprarCanciones() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../faces/comprarcancion.xhtml");
    }
    public void comprarAlbum() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../faces/veralbum.xhtml");
    }
    public void inicioUser() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../faces/User.xhtml");
    }
}
