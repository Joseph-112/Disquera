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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.User;
import model.DBConnection;
import org.primefaces.model.file.UploadedFile;

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
     *
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

            } else {
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

    public boolean insertArtist(String name, int genre, int nationality, String photo, Date birthday) {
        //Timestamp date = new Timestamp(birthday.get)
        boolean success = false; 
        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            stm.execute("INSERT INTO disquera.artist (name, photo, id_genre, id_nationality, birthday)" + "	VALUES ( '" + name + "', '" + photo + "', " + genre + " , " + nationality + " , '" + birthday + "');");
            success = true;
            //result.close();
            stm.close();
            conn.close();

        } catch (SQLException ex) {
            ex.getStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
}
