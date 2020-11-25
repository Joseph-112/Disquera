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
import pojo.Genre;

/**
 *
 * @author Joseph
 */
public class DAOGenre {

    Connection conn = null;
    Statement stm;
    ResultSet result;

    public List<Genre> genreList() {

        //Saves genre's data
        List<Genre> genreList = new ArrayList<Genre>();

        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            result = stm.executeQuery("SELECT * FROM disquera.genre ORDER BY id_genre");
            while (result.next()) {
                Genre newGenre = new Genre();
                newGenre.setId_genre(result.getInt(1));
                newGenre.setGenre(result.getString(2));
                System.out.println("\n\n Received data: \n Id: " + newGenre.getId_genre() + "\n Genre: " + newGenre.getGenre());
                genreList.add(newGenre);
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
        return genreList;
    }

    public Genre selectGenre(int id_genre) {

        Genre genre = new Genre();
        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            result = stm.executeQuery("SELECT * FROM disquera.genre WHERE genre.id_genre = " + id_genre);

            if (!result.next()) {

                genre.setId_genre(result.getInt(1));
                genre.setGenre(result.getString(2));
                System.out.println("\n\n Received data: \n Id: " + genre.getId_genre() + "\n Genre: " + genre.getGenre());

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
        return genre;
    }

    public boolean insertGenre(String genreName) {
        //Timestamp date = new Timestamp(birthday.get)
        boolean success = false;
        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            stm.execute("INSERT INTO disquera.genre (musical_genre) VALUES ( '" + genreName + "') ");
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
