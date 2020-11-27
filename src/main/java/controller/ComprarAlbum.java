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
import model.DAOSale;
import org.primefaces.event.UnselectEvent;
import pojo.Album;
import pojo.Artist;
import pojo.Genre;

/**
 *
 * @author Joseph
 */
@Named(value = "comprarAlbum")
@RequestScoped
public class ComprarAlbum {

    private static List<SelectItem> artistList;
    private static List<SelectItem> albumList;
    private Album album;
    private Artist artist;

    /**
     * Creates a new instance of ComprarAlbum
     */
    public ComprarAlbum() {
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

    public List<SelectItem> albumList() {

        albumList = new ArrayList<SelectItem>();
        List<Album> albums;
        if (artist.getId_artist() == null) {
            albums = new DAOAlbum().albumList();
        } else {
            albums = new DAOAlbum().albumList(artist.getId_artist());
        }

        //albums = new DAOAlbum().albumList();
        for (Album album : albums) {
            SelectItem albumItem = new SelectItem(album.getId_album(), album.getName());

            albumList.add(albumItem);
        }
        return albumList;
    }

    public void onItemUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();

        FacesMessage msg = new FacesMessage();
        msg.setSummary("Item unselected: " + event.getObject().toString());
        msg.setSeverity(FacesMessage.SEVERITY_INFO);

        context.addMessage(null, msg);
    }

    public void sendData() {//recpcion y muestra de datos desde el boton por consola

        boolean success = new DAOSale().insertSale(artist.getId_artist(), album.getId_album());
        if (success == true) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Compra exitosa"));
            System.out.println("Registrado con éxito");
        } else {
            System.out.println("Chúpelo prro");
        }
    }

    public static List<SelectItem> getArtistList() {
        return artistList;
    }

    public static void setArtistList(List<SelectItem> artistList) {
        ComprarAlbum.artistList = artistList;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public static List<SelectItem> getAlbumList() {
        return albumList;
    }

    public static void setAlbumList(List<SelectItem> albumList) {
        ComprarAlbum.albumList = albumList;
    }

}
