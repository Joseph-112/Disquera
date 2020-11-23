/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author MontagutN
 */
@Named(value = "creargeneroController")
@Dependent
public class creargeneroController {
    private String genero;
    /**
     * Creates a new instance of creargeneroController
     */
    public creargeneroController() {
    }
    public void enviardatos(){
        System.out.println("entro: "+genero); //imprime por consola
    }
}
