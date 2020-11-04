/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encapsulamiento;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import persistencia.Admin;

/**
 *
 * @author Joseph
 */
@Named(value = "dAOAdmin")
@RequestScoped
public class DAOAdmin {
    
    /**
     * Validate user's data
     * @param username
     * @param password
     * @return 
     */
    public boolean validateAdmin(String username,String password){
        Admin administrator = new Admin();
        boolean exist = false;
        if (administrator.getUsername().equals(username) && administrator.getPassword().equals(password)) {
            exist = true;
        }
        return exist;
    }
}
