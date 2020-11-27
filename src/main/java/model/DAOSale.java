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
import pojo.Artist;
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
                stm.execute("INSERT INTO disquera.sale (id_album, id_artist, price,id_genre)" + "	VALUES ( " + album.getId_album() + ", " + album.getId_artist() + ", " + album.getPrice() + " , " + album.getId_genre() + " );");
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
                stm.execute("INSERT INTO disquera.sale (id_song, price,id_artist,id_genre)" + "	VALUES ( " + song.getId_song() + ", " + song.getPrice() + " ," + song.getId_artist() + ", " + song.getId_genre() + " );");
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

    public List<Sale> saleListSong() {
        //ResultSet result_album;
        //ResultSet result_artist;
        //Saves genre's data
        List<Sale> saleList = new ArrayList<Sale>();

        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            result = stm.executeQuery("SELECT * FROM disquera.sale "
                    + "join disquera.song on sale.id_song=song.id_song "
                    + "join disquera.artist on song.id_artist=artist.id_artist "
                    + "join disquera.album on song.id_album=album.id_album");
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
                newSale.setArtistName(result.getString(14));
                newSale.setAlbumName(result.getString(20));

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

    public List<Sale> saleListAlbum() {
        ResultSet result_album;
        //ResultSet result_artist;
        //Saves genre's data
        List<Sale> saleList = new ArrayList<Sale>();

        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            //result = stm.executeQuery("SELECT * FROM disquera.sale join disquera.song on sale.id_song=song.id_song");
            result_album = stm.executeQuery("SELECT * FROM disquera.sale join disquera.album on sale.id_album=album.id_album join disquera.artist on album.id_artist=artist.id_artist");
            //result_artist=stm.executeQuery("SELECT * FROM disquera.sale join disquera.artist on sale.id_artist=artist.id_artist");
            while (result_album.next()) {
                Sale newSale = new Sale();
                newSale.setId_sale(result_album.getInt(1));
                newSale.setPrice(result_album.getDouble(3));
                newSale.setId_album(result_album.getInt(4));
                newSale.setId_user(result_album.getInt(5));
                newSale.setId_genre(result_album.getInt(6));
                //newSale.setSongName(result.getString(10));
                newSale.setAlbumName(result_album.getString(8));
                newSale.setArtistName(result_album.getString(13));

                System.out.println("\n\n Received data: \n Id: " + newSale.getId_sale() + "\nPrecio: " + newSale.getPrice());
                saleList.add(newSale);
                /*
                System.out.println("No existe un usuario con esa contraseña");
                conn.close();
                return null;
                 */
            }
            result_album.close();
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

    public List<Sale> saleListSongCount() {
        //ResultSet result_album;
        //ResultSet result_artist;
        //Saves genre's data
        List<Sale> saleList = new ArrayList<Sale>();

        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            result = stm.executeQuery("SELECT name,\n"
                    + "COUNT (*) \n"
                    + "FROM disquera.song JOIN disquera.sale ON song.id_song = sale.id_song\n"
                    + "GROUP BY song.name ORDER BY song.name");
            //result_album = stm.executeQuery("SELECT * FROM disquera.sale join disquera.album on sale.id_album=album.id_album");
            //result_artist=stm.executeQuery("SELECT * FROM disquera.sale join disquera.artist on sale.id_artist=artist.id_artist");
            while (result.next()) {
                Sale newSale = new Sale();

                newSale.setSongName(result.getString(1));
                newSale.setCount(result.getInt(2));
                //System.out.println("\n\n Received data: \n Id: " + newSale.getId_sale() + "\nPrecio: " + newSale.getPrice());
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

    public List<Sale> saleLisAlbumCount() {
        //ResultSet result_album;
        //ResultSet result_artist;
        //Saves genre's data
        List<Sale> saleList = new ArrayList<Sale>();

        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            result = stm.executeQuery("SELECT name,\n"
                    + "COUNT (*) \n"
                    + "FROM disquera.album JOIN disquera.sale ON album.id_album = sale.id_album\n"
                    + "GROUP BY album.name ORDER BY album.name");
            //result_album = stm.executeQuery("SELECT * FROM disquera.sale join disquera.album on sale.id_album=album.id_album");
            //result_artist=stm.executeQuery("SELECT * FROM disquera.sale join disquera.artist on sale.id_artist=artist.id_artist");
            while (result.next()) {
                Sale newSale = new Sale();

                newSale.setAlbumName(result.getString(1));
                newSale.setCount(result.getInt(2));
                //System.out.println("\n\n Received data: \n Id: " + newSale.getId_sale() + "\nPrecio: " + newSale.getPrice());
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

    public List<Sale> saleListArtistCount() {
        //ResultSet result_album;
        //ResultSet result_artist;
        //Saves genre's data
        List<Sale> saleList = new ArrayList<Sale>();

        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            result = stm.executeQuery("SELECT name,\n"
                    + "COUNT (*) \n"
                    + "FROM disquera.artist JOIN disquera.sale ON artist.id_artist = sale.id_artist\n"
                    + "GROUP BY artist.name ORDER BY artist.name");
            //result_album = stm.executeQuery("SELECT * FROM disquera.sale join disquera.album on sale.id_album=album.id_album");
            //result_artist=stm.executeQuery("SELECT * FROM disquera.sale join disquera.artist on sale.id_artist=artist.id_artist");
            while (result.next()) {
                Sale newSale = new Sale();

                newSale.setArtistName(result.getString(1));
                newSale.setCount(result.getInt(2));
                //System.out.println("\n\n Received data: \n Id: " + newSale.getId_sale() + "\nPrecio: " + newSale.getPrice());
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

    public List<Sale> saleListArtist() {

        ResultSet result_album;
        //ResultSet result_artist;
        //Saves genre's data
        List<Sale> saleList = new ArrayList<Sale>();

        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            //result = stm.executeQuery("SELECT * FROM disquera.sale join disquera.song on sale.id_song=song.id_song");
            result_album = stm.executeQuery("SELECT * FROM disquera.sale join disquera.artist on sale.id_artist=artist.id_artist");
            //result_artist=stm.executeQuery("SELECT * FROM disquera.sale join disquera.artist on sale.id_artist=artist.id_artist");
            while (result_album.next()) {
                Sale newSale = new Sale();
                newSale.setId_sale(result_album.getInt(1));
                newSale.setId_album(result_album.getInt(4));
                newSale.setId_user(result_album.getInt(5));
                newSale.setId_genre(result_album.getInt(6));
                //newSale.setSongName(result.getString(10));
                //newSale.setAlbumName(result_album.getString(8));
                newSale.setArtistName(result_album.getString(8));
                newSale.setImage(result_album.getString(9));

                System.out.println("\n\n Received data: \n Id: " + newSale.getId_sale() + "\nPrecio: " + newSale.getPrice());
                saleList.add(newSale);
                /*
                System.out.println("No existe un usuario con esa contraseña");
                conn.close();
                return null;
                 */
            }
            result_album.close();
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

    public List<Sale> saleListGenre() {
        //ResultSet result_album;
        //ResultSet result_artist;
        //Saves genre's data
        List<Sale> saleList = new ArrayList<Sale>();

        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            result = stm.executeQuery("SELECT * FROM disquera.sale \n"
                    + "join disquera.genre on sale.id_genre=genre.id_genre");
            //result_album = stm.executeQuery("SELECT * FROM disquera.sale join disquera.artist on sale.id_artist=artist.id_artist");
            //result_artist=stm.executeQuery("SELECT * FROM disquera.sale join disquera.artist on sale.id_artist=artist.id_artist");
            while (result.next()) {
                Sale newSale = new Sale();
                newSale.setId_sale(result.getInt(1));
                newSale.setId_album(result.getInt(4));
                newSale.setId_user(result.getInt(5));
                newSale.setId_genre(result.getInt(6));
                //newSale.setSongName(result.getString(10));
                //newSale.setAlbumName(result_album.getString(8));
                newSale.setGenre(result.getString(8));

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

    public List<Sale> saleListGenreCount() {
        //ResultSet result_album;
        //ResultSet result_artist;
        //Saves genre's data
        List<Sale> saleList = new ArrayList<Sale>();

        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            result = stm.executeQuery("SELECT musical_genre, COUNT (*) FROM disquera.genre \n"
                    + "JOIN disquera.sale ON genre.id_genre = sale.id_genre \n"
                    + "GROUP BY genre.musical_genre ORDER BY genre.musical_genre");
            //result_album = stm.executeQuery("SELECT * FROM disquera.sale join disquera.album on sale.id_album=album.id_album");
            //result_artist=stm.executeQuery("SELECT * FROM disquera.sale join disquera.artist on sale.id_artist=artist.id_artist");
            while (result.next()) {
                Sale newSale = new Sale();

                newSale.setGenre(result.getString(1));
                newSale.setCount(result.getInt(2));
                //System.out.println("\n\n Received data: \n Id: " + newSale.getId_sale() + "\nPrecio: " + newSale.getPrice());
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
