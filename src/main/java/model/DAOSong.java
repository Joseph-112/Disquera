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
import pojo.Song;

/**
 *
 * @author Joseph
 */
public class DAOSong {

    Connection conn = null;
    Statement stm;
    ResultSet result;

    public List<Song> songList() {

        //Saves genre's data
        List<Song> songList = new ArrayList<Song>();

        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            result = stm.executeQuery("SELECT * FROM disquera.song ORDER BY id_song");
            while (result.next()) {
                Song newSong = new Song();
                newSong.setId_song(result.getInt(1));
                newSong.setId_album(result.getInt(2));
                newSong.setId_artist(result.getInt(3));
                newSong.setName(result.getString(4));
                newSong.setPrice(result.getDouble(5));
                newSong.setId_genre(result.getInt(6));

                System.out.println("\n\n Received data: \n Id album: " + newSong.getId_album() + "\n Id artist: " + newSong.getId_artist());
                songList.add(newSong);
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
        return songList;
    }

    public boolean insertSong(int id_artist, int id_album, int id_genre, double price, String name) {
        //Timestamp date = new Timestamp(birthday.get)
        boolean success = false;
        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            stm.execute("INSERT INTO disquera.song (id_album, id_artist, name, price, id_genre) VALUES ( " + id_album + " , " + id_artist + ", '" + name + "', " + price + "," + id_genre + " )");
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

    public List<Song> songList(Integer id_album) {
        //Saves genre's data
        List<Song> songList = new ArrayList<Song>();

        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            result = stm.executeQuery("SELECT * FROM disquera.song WHERE id_album = "+id_album+" ORDER BY id_song");
            while (result.next()) {
                Song newSong = new Song();
                newSong.setId_song(result.getInt(1));
                newSong.setId_album(result.getInt(2));
                newSong.setId_artist(result.getInt(3));
                newSong.setName(result.getString(4));
                newSong.setPrice(result.getDouble(5));
                newSong.setId_genre(result.getInt(6));

                System.out.println("\n\n Received data: \n Id album: " + newSong.getId_album() + "\n Id artist: " + newSong.getId_artist());
                songList.add(newSong);
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
        return songList;
    }

    public List<Song> songListArtist(Integer id_artist) {
        List<Song> songList = new ArrayList<Song>();

        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            result = stm.executeQuery("SELECT * FROM disquera.song WHERE id_artist = "+id_artist+" ORDER BY id_song");
            while (result.next()) {
                Song newSong = new Song();
                newSong.setId_song(result.getInt(1));
                newSong.setId_album(result.getInt(2));
                newSong.setId_artist(result.getInt(3));
                newSong.setName(result.getString(4));
                newSong.setPrice(result.getDouble(5));
                newSong.setId_genre(result.getInt(6));

                System.out.println("\n\n Received data: \n Id album: " + newSong.getId_album() + "\n Id artist: " + newSong.getId_artist());
                songList.add(newSong);
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
        return songList;
    }
}
