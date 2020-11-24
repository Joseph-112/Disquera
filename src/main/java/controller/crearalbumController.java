/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import model.DAOAlbum;
import model.DAOArtist;
import pojo.Album;
import pojo.Artist;

/**
 *
 * @author MontagutN
 */
@Named(value = "crearalbumController")
@RequestScoped
public class crearalbumController {

    private static List<SelectItem> artistList;
    private String albumname;
    private double price;
    private Album album;
    private Artist artist;

    /**
     * Creates a new instance of crearalbumController
     */
    public crearalbumController() {
        album = new Album();
        artist = new Artist();
    }

    public List<SelectItem> artistList() {
        artistList = new ArrayList<SelectItem>();
        List<Artist> artists;
        artists = new DAOArtist().artistList();
        for (Artist artist : artists) {
            SelectItem artistItem = new SelectItem(artist.getId_artist(), artist.getName());
            artistList.add(artistItem);
        }
        return artistList;
    }

    public void sendData() {//recpcion y muestra de datos desde el boton por consola

        boolean success = new DAOAlbum().insertAlbum(album.getName(), artist.getId_artist(),album.getPrice());
        if (success==true) {
            System.out.println("Registrado con éxito");
        }else{
            System.out.println("Chúpelo prro");
        }
        System.out.println("Entro " + album.getName() + " " + artist.getId_artist() + " " + album.getPrice());
    }

    /**
     * Obtains album's name from database
     *
     * @return
     */
    public String getAlbumname() {
        return albumname;
    }

    /**
     * Set album name
     *
     * @param albumname
     */
    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    /**
     * Obtains album's price
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set album's price
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Obtains object from Album class
     *
     * @return
     */
    public Album getAlbum() {
        return album;
    }

    /**
     * Set Album object's attributes
     *
     * @param album
     */
    public void setAlbum(Album album) {
        this.album = album;
    }

    /**
     * Obtains object from Artist class
     *
     * @return
     */
    public Artist getArtist() {
        return artist;
    }

    /**
     * Set Artist object's attributes
     *
     * @param artist
     */
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

}
