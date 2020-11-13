/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.faces.context.FacesContext;
import pojo.User;

/**
 *
 * @author Joseph
 */
public class LoginService {
    
    public User login(String name, String password) {
        if(name.equals("Nicolas") && password.equals("1234")) {
            FacesContext context = FacesContext.getCurrentInstance();
            User user = new User(1070, "Johans", "González", "Administrador");
            context.getExternalContext().getSessionMap().put(user.getId()+ "", user);
            return user;
        } else if(name.equals("jairo") && password.equals("1234")) {
            FacesContext context = FacesContext.getCurrentInstance();
            User user = new User(10701, "jairo", "peñuela", "Estudiante");
            context.getExternalContext().getSessionMap().put(user.getId() + "", user);
            return user;    
        } else {
            return null;
        }
    }
    
}
