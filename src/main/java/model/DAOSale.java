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
import pojo.Sale;
import pojo.Song;

/**
 *
 * @author Joseph
 */
public class DAOSale {

    Connection conn = null;
    Statement stm;
    ResultSet result;

    public Album searchPrice(Integer id_album) {

        Album album = new Album();
        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            result = stm.executeQuery("SELECT * FROM disquera.album WHERE id_album = " + id_album);

            if (result.next()) {

                album.setId_album(result.getInt(1));
                album.setName(result.getString(2));
                album.setId_artist(result.getInt(3));
                album.setPrice(result.getDouble(4));
                album.setId_genre(result.getInt(5));
                System.out.println("\n\n Received data: \n Id: " + album.getId_album() + "\n Genre: " + album.getId_genre());

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
        return album;
    }

    public boolean insertSale(Integer id_artist, Integer id_album) {
        Album album = searchPrice(id_album);
        boolean success = false;
        if (album == null) {
            System.out.println("\nError en la consulta");
        } else {

            try {
                conn = DBConnection.getConnection();
                stm = conn.createStatement();
                stm.execute("INSERT INTO disquera.sale (id_album, id_artist, price,id_genre)" + "	VALUES ( " + album.getId_album() + ", " + album.getId_artist() + ", " + album.getPrice() + " , "+album.getId_genre()+" );");
                success = true;
                //result.close();
                stm.close();
                conn.close();

            } catch (SQLException ex) {
                ex.getStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DAOAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return success;
    }

    public boolean insertSaleSong(Integer id_artist, int id_song) {
        Song song = searchPriceSong(id_song);
        boolean success = false;
        if (song == null) {
            System.out.println("\nError en la consulta");
        } else {

            try {
                conn = DBConnection.getConnection();
                stm = conn.createStatement();
                stm.execute("INSERT INTO disquera.sale (id_song, price,id_artist,id_genre)" + "	VALUES ( " + song.getId_song()+ ", " + song.getPrice()+ " ," + song.getId_artist() + ", "+song.getId_genre()+" );");
                success = true;
                //result.close();
                stm.close();
                conn.close();

            } catch (SQLException ex) {
                ex.getStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DAOAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return success;
    }

    private Song searchPriceSong(int id_song) {
        Song song = new Song();
        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            result = stm.executeQuery("SELECT * FROM disquera.song WHERE id_song = " + id_song);

            if (result.next()) {

                song.setId_song(result.getInt(1));
                song.setId_album(result.getInt(2));
                song.setId_artist(result.getInt(3));
                song.setName(result.getString(4));
                song.setPrice(result.getDouble(5));
                song.setId_genre(result.getInt(6));
                //System.out.println("\n\n Received data: \n Id: " + album.getId_album() + "\n Genre: " + album.getId_genre());

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
        return song;
    }

    public List<Sale> saleList() {
        ResultSet result_album;
        ResultSet result_artist;
        //Saves genre's data
        List<Sale> saleList = new ArrayList<Sale>();

        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            result = stm.executeQuery("SELECT * FROM disquera.sale join disquera.song on sale.id_song=song.id_song");
            //result_album = stm.executeQuery("SELECT * FROM disquera.sale join disquera.album on sale.id_album=album.id_album");
            //result_artist=stm.executeQuery("SELECT * FROM disquera.sale join disquera.artist on sale.id_artist=artist.id_artist");
            while (result.next()) {
                Sale newSale = new Sale();
                newSale.setId_sale(result.getInt(1));
                newSale.setId_song(result.getInt(2));
                newSale.setPrice(result.getDouble(3));
                newSale.setId_album(result.getInt(4));
                newSale.setId_user(result.getInt(5));
                newSale.setId_genre(result.getInt(6));
                newSale.setSongName(result.getString(10));
                //newSale.setAlbumName(result_album.getString(8));
                //newSale.setArtistName(result_artist.getString(8));
                
                System.out.println("\n\n Received data: \n Id: " + newSale.getId_sale() + "\nPrecio: " + newSale.getPrice());
                saleList.add(newSale);
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
        return saleList;
    }

}
