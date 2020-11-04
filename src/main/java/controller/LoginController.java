/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import encapsulamiento.DAOAdmin;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Joseph
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    private String username;
    private String password;
    private DAOAdmin validar;
    /**
     * Obtains person's username to compare
     * @return 
     */
    public String getUsername() {
        return username;
    }

    /**
     * Assign the username
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtains the password to compare
     * @return 
     */
    public String getPassword() {
        return password;
    }

    /**
     * Assign the password
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method to validate data
     * @return 
     */
    public DAOAdmin getValidar() {
        return validar;
    }

    /**
     * Set DAOAdmin object
     * @param validar 
     */
    public void setValidar(DAOAdmin validar) {
        this.validar = validar;
    }
    
    public String validate(){
        String redirect = "";
        validar = new DAOAdmin();
        if (validar.validateAdmin(username, password) == true) {
            redirect="/addArtist";
        }else{
            redirect = "/Login";            
        }
        return redirect;
    }
    
}
