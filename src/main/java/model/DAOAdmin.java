/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import pojo.User;

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
    /*public boolean validateAdmin(String username,String password){
        User user = new User();
        boolean exist = false;
        /*if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            exist = true;
        }
        return exist;*
    }*/
}
