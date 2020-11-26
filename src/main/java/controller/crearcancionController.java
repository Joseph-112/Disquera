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
import model.DAOGenre;
import model.DAOSong;
import pojo.Album;
import pojo.Artist;
import pojo.Genre;
import pojo.Song;

/**
 *
 * @author MontagutN
 */
@Named(value = "crearcancion")
@RequestScoped
public class crearcancionController {

    private static List<SelectItem> genreList;
    private static List<SelectItem> artistList;
    private static List<SelectItem> albumList;
    private Artist artist;
    private Genre musicGenre;
    private Album album;
    private Song song;

    /**
     * Creates a new instance of crearcancion
     */
    public crearcancionController() {
        artist = new Artist();
        musicGenre = new Genre();
        song = new Song();
        album = new Album();
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

    public void sendData() {//recpcion y muestra de datos desde el boton por consola

        boolean success = new DAOSong().insertSong( this.artist.getId_artist() ,this.album.getId_album(), this.musicGenre.getId_genre(), this.song.getPrice(), this.song.getName());
        if (success == true) {
            System.out.println("Registrado con éxito");
        } else {
            System.out.println("Error");
        }
        System.out.println("Entro: " + this.song.getName() + " Id género: " + this.musicGenre.getId_genre() + " Id album: " + this.album.getId_album() + " Id artista: " + this.artist.getId_artist() + " Precio: "+ this.song.getPrice());
    }

    public static List<SelectItem> getGenreList() {
        return genreList;
    }

    public static void setGenreList(List<SelectItem> genreList) {
        crearcancionController.genreList = genreList;
    }

    public static List<SelectItem> getArtistList() {
        return artistList;
    }

    public static void setArtistList(List<SelectItem> artistList) {
        crearcancionController.artistList = artistList;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Genre getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(Genre musicGenre) {
        this.musicGenre = musicGenre;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public static List<SelectItem> getAlbumList() {
        return albumList;
    }

    public static void setAlbumList(List<SelectItem> albumList) {
        crearcancionController.albumList = albumList;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

}
