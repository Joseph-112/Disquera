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
@Named(value = "crearalbumController")
@RequestScoped
public class crearalbumController {
    private String albumname;
    private int valoralbum;
    /**
     * Creates a new instance of crearalbumController
     */
    public crearalbumController() {
    }
    public void enviardatos(){
        //System.out.println("entro: "+""+""); //imprime por consola
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public int getValoralbum() {
        return valoralbum;
    }

    public void setValoralbum(int valoralbum) {
        this.valoralbum = valoralbum;
    }
    
}
