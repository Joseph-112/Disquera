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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import model.DAOAlbum;
import model.DAOArtist;
import model.DAOGenre;
import pojo.Album;
import pojo.Artist;
import pojo.Genre;

/**
 *
 * @author MontagutN
 */
@Named(value = "crearalbumController")
@RequestScoped
public class crearalbumController {

    private static List<SelectItem> artistList;
    private static List<SelectItem> genreList;
    
    private Album album;
    private Genre genre;
    private Artist artist;

    /**
     * Creates a new instance of crearalbumController
     */
    public crearalbumController() {
        album = new Album();
        artist = new Artist();
        genre = new Genre();
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

    public List<SelectItem> genreList() {
        genreList = new ArrayList<SelectItem>();
        List<Genre> genres;
        genres = new DAOGenre().genreList();
        for (Genre genre : genres) {
            SelectItem countryItem = new SelectItem(genre.getId_genre(), genre.getGenre());
            genreList.add(countryItem);
        }
        return genreList;
    }

    public void sendData() {//recpcion y muestra de datos desde el boton por consola

        System.out.println("Genero" + genre.getId_genre());
        DAOAlbum albumdata = new DAOAlbum();
        boolean success = new DAOAlbum().insertAlbum(album.getName(),artist.getId_artist(),album.getPrice(), genre.getId_genre());
        if (success==true) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Album registrado con éxito"));
            System.out.println("Registrado con éxito");
        }else{
            System.out.println("Chúpelo prro");
        }
        // boolean success = new DAOAlbum().insertAlbum(album.getName(), artist.getId_artist(),album.getPrice());
        /*if (albumdata.insertAlbum(album.getName(), artist.getId_artist(), album.getPrice(), genre.getId_genre()) == true) {
            System.out.println("Registrado con éxito");
        } else {
            System.out.println("Error");
        }*/
        System.out.println("Entro " + album.getName() + " " + artist.getId_artist() + " " + album.getPrice());
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

    public static List<SelectItem> getArtistList() {
        return artistList;
    }

    public static void setArtistList(List<SelectItem> artistList) {
        crearalbumController.artistList = artistList;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public static List<SelectItem> getGenreList() {
        return genreList;
    }

    public static void setGenreList(List<SelectItem> genreList) {
        crearalbumController.genreList = genreList;
    }



    
}
