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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Artist;

/**
 *
 * @author Joseph
 */
public class DAOArtist {

    Connection conn = null;
    Statement stm;
    ResultSet result;

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
    
    public List<Artist>artistList() {

        //Saves genre's data
        List<Artist> artistList = new ArrayList<Artist>();

        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            result = stm.executeQuery("SELECT * FROM disquera.artist ORDER BY id_artist");
            while (result.next()) {
                Artist newArtist = new Artist();
                newArtist.setId_artist(result.getInt(1));
                newArtist.setName(result.getString(2));
                System.out.println("\n\n Received data: \n Id: " + newArtist.getId_artist() + "\n Nombre: " + newArtist.getName() );
                artistList.add(newArtist);
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
        return artistList;
    }
}
