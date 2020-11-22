/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pojo.User;
import model.DBConnection;

/**
 *
 * @author Joseph
 */
public class DAOAdmin {

    User user = new User();
    Connection conn = null;
    Statement stm;
    ResultSet result;

    /**
     * Obtains user's data
     * @param username
     * @param password
     * @return
     * @throws ClassNotFoundException 
     */
    public User validateUser(String username, String password) throws ClassNotFoundException {

        
        User user = new User();
        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            result = stm.executeQuery("SELECT * FROM disquera.user WHERE password = '" + password + "' AND name = '" + username + "'");
            if (!result.next()) {
                System.out.println("No existe un usuario con esa contraseña");
                conn.close();
                return null;
                
            }else{
                user.setId(result.getInt("id_user"));
                user.setUsername(result.getString("name"));
                user.setRol(result.getString("rol"));
                System.out.println("Id: " + user.getId() + "\n Name: " + user.getUsername() + "\n Rol: " + user.getRol());
                result.close();
                stm.close();
                conn.close();
                return user;
            }
            
        } catch (SQLException ex) {
            ex.getStackTrace();
            return null;
        }        
    }
    
    public void insertArtist(String name , int genre ){
        
    }
}
