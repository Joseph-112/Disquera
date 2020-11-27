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
import static jdk.internal.joptsimple.internal.Messages.message;
import model.DAOArtist;
import model.DAOSale;
import model.DAOSong;
import org.primefaces.event.UnselectEvent;
import pojo.Artist;
import pojo.Song;

/**
 *
 * @author Joseph
 */
@Named(value = "comprarCancionController")
@RequestScoped
public class ComprarCancionController {

    private static List<SelectItem> artistList;
    private static List<SelectItem> songList;
    private Artist artist;
    private Song song;

    /**
     * Creates a new instance of ComprarCancionController
     */
    public ComprarCancionController() {
        artist = new Artist();
        song = new Song();
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

    public List<SelectItem> songList() {

        songList = new ArrayList<SelectItem>();
        List<Song> songs;

        if (artist.getId_artist() == null) {
            songs = new DAOSong().songList();
        } else {
            songs = new DAOSong().songListArtist(artist.getId_artist());
        }

        //albums = new DAOAlbum().albumList();
        for (Song cancion : songs) {
            SelectItem songItem = new SelectItem(cancion.getId_song(), cancion.getName());
            songList.add(songItem);
        }
        return songList;
    }

    public void sendData() {//recpcion y muestra de datos desde el boton por consola

        boolean success = new DAOSale().insertSaleSong(artist.getId_artist(), song.getId_song());
        if (success == true) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Compra exitosa"));
            System.out.println("Registrado con éxito");
        } else {

            System.out.println("Error");
        }
    }

    public void onItemUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();

        FacesMessage msg = new FacesMessage();
        msg.setSummary("Item unselected: " + event.getObject().toString());
        msg.setSeverity(FacesMessage.SEVERITY_INFO);

        context.addMessage(null, msg);
    }

    public static List<SelectItem> getArtistList() {
        return artistList;
    }

    public static void setArtistList(List<SelectItem> artistList) {
        ComprarCancionController.artistList = artistList;
    }

    public static List<SelectItem> getSongList() {
        return songList;
    }

    public static void setSongList(List<SelectItem> songList) {
        ComprarCancionController.songList = songList;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

}
