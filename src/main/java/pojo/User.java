/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Joseph Trejos / Nicolás Montagut
 */
@Named(value = "admin")
@SessionScoped
public class User implements Serializable {

    private String username;
    private String name;
    private Integer id;
    private String rol;

    public User() {
    }

    public User(Integer id, String username, String name, String rol) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.rol = rol;
    }

    /**
     * Obtains user's username
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set username
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtains id from user
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the user's id
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtains rol from the person (administrator, user, artist)
     *
     * @return
     */
    public String getRol() {
        return rol;
    }

    /**
     * Set the user's rol
     *
     * @param rol
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

}
