/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Joseph
 */
@Named(value = "loginSession")
@SessionScoped
public class LoginSession implements Serializable{

    private Integer key;

    public LoginSession() {
        System.out.println("Se ha creado");
        this.key =-1;
    }    
    
    /**
     * Obtains session's key
     * @return 
     */
    public Integer getKey() {
        return key;
    }

    /**
     * Set session's key
     * @param key 
     */
    public void setKey(Integer key) {
        this.key = key;
    }
    
    
    
}
