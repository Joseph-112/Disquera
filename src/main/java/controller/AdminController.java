/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author MontagutN
 */
@Named(value = "adminController")
@RequestScoped
public class AdminController implements Serializable {

    /**
     * Creates a new instance of AdminController
     */
    public AdminController() {

    }

    public void crearArtista() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../faces/crearartista.xhtml");
    }
    public void crearAlbum() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../faces/crearalbum.xhtml");
    }
    public void crearCancion() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../faces/crearcancion.xhtml");
    }
    public void crearGenero() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../faces/creargenero.xhtml");
    }
    public void estadisticasAlbum() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../faces/Admin.xhtml");
    }
    //-----------------
    public void pedidos() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../faces/pedidos.xhtml");
    }
    public void estadisticasCancion() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("../faces/estadisticascancion.xhtml");
    }
    public void estadisticasArtistas() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("../faces/estadisticasartistas.xhtml");
    }
    public void estadisticasGenero() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("../faces/estadisticasgenero.xhtml");
    }
    //-----------------
    public void cerrarSesion() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../faces/login.xhtml");
    }
    
}   
