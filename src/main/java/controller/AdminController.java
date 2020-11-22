/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author MontagutN
 */

@Named(value = "adminController")
@RequestScoped
public class AdminController implements Serializable{
    
    /**
     * Creates a new instance of AdminController
     */
    public AdminController() {
    }
   
    
}
