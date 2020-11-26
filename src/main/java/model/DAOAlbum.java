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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Album;

/**
 *
 * @author Joseph
 */
public class DAOAlbum {

    Connection conn = null;
    Statement stm;
    ResultSet result;

    public boolean insertAlbum(String name, int id_artist, double price, int id_genre) {
        //Timestamp date = new Timestamp(birthday.get)
        boolean success = false;
        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            stm.executeUpdate("INSERT INTO disquera.album (name, id_artist, price, id_genre) VALUES ( '" + name + "', '" + id_artist + "', '" + price + "','" + id_genre + "');");
            success = true;

        } catch (SQLException ex) {
            ex.getStackTrace();
            System.err.println("SQL error" + ex);
        } catch (ClassNotFoundException ex) {
            System.err.println("Otro error" + ex);
            Logger.getLogger(DAOAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    public List<Album> albumList() {

        //Saves genre's data
        List<Album> albumList = new ArrayList<Album>();

        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            result = stm.executeQuery("SELECT * FROM disquera.album ORDER BY id_album");
            while (result.next()) {
                Album newAlbum = new Album();
                newAlbum.setId_album(result.getInt(1));
                newAlbum.setName(result.getString(2));
                System.out.println("\n\n Received data: \n Id: " + newAlbum.getId_album() + "\n Nombre album: " + newAlbum.getName());
                albumList.add(newAlbum);
                /*
                System.out.println("No existe un usuario con esa contraseña");
                conn.close();
                return null;
                 */
            }
            result.close();
            stm.close();
            conn.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOGenre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return albumList;
    }

    public List<Album> albumList(Integer id_artist) {

        List<Album> albumList = new ArrayList<Album>();

        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            result = stm.executeQuery("SELECT * FROM disquera.album WHERE id_artist = " + id_artist + " ORDER BY id_album");
            while (result.next()) {
                Album newAlbum = new Album();
                newAlbum.setId_album(result.getInt(1));
                newAlbum.setName(result.getString(2));
                System.out.println("\n\n Received data: \n Id: " + newAlbum.getId_album() + "\n Nombre album: " + newAlbum.getName());
                albumList.add(newAlbum);
                /*
                System.out.println("No existe un usuario con esa contraseña");
                conn.close();
                return null;
                 */
            }
            result.close();
            stm.close();
            conn.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOGenre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return albumList;
    }
}
