/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 * 
 * @author Joseph Trejos / Nicolás Montagut
 */
@Named(value = "admin")
@SessionScoped
public class Admin implements Serializable {

    private String username = "Leo";
    private String password = "123";

    /**
     * Obtains user's username
     * @return 
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set username
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtains user's password 
     * @return 
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password account
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
