/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.inject.Named;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import pojo.User;
import services.LoginService;

/**
 *
 * @author Joseph
 */
@Named(value = "loginController")
@RequestScoped
public class LoginController implements Serializable {

    private String username;
    private String password;
    private User user;

    @Inject
    private LoginSession loginSession;

    public LoginController() {
    }

    /**
     * Method to validate user's data
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void Login() throws IOException, ClassNotFoundException {
        //System.out.println("Entro " + name + " " + password);
        LoginService service = new LoginService();
        FacesContext context = FacesContext.getCurrentInstance();
        user = service.login(username, password);
        context.addMessage(null, new FacesMessage("Éxito", "Bienvenido " + username));
        context.getExternalContext().getSessionMap().put(user.getId() + "", user);

        if (user != null) {
            loginSession.setKey(user.getId());
            context.addMessage(null, new FacesMessage("Éxito", "Bienvenido " + user.getUsername()));
            context.getExternalContext().redirect("addArtist.xhtml");
        } else {
            loginSession.setKey(-1);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario y Contraseña incorrecto"));

        }

        if (user.getRol().equalsIgnoreCase("Administrador")) {
            context.getExternalContext().redirect("addArtist.xhtml");
        } else {
            context.getExternalContext().redirect("addArtist.xhtml");
        }

        /*if(usuario != null) {            
            loginSession.setKey(usuario.getId());
            context.addMessage(null, new FacesMessage("Éxito",  "Bienvenido " + usuario.getUsername()));
            context.getExternalContext().redirect("addArtist.xhtml");
        } else {        
            loginSession.setKey(-1);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "Usuario y Contraseña incorrecto") );
        }*/
    }

    /*public void cerrarSesion() {
        loginSession.setKey(-1);
        FacesContext context = FacesContext.getCurrentInstance();        
        context.getExternalContext().invalidateSession();        
    }*/
    /**
     * Obtains person's username to compare
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Assign the username
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtains the password to compare
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Assign the password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
