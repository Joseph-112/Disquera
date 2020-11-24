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
import pojo.Album;
import pojo.Artist;
import pojo.Genre;
import pojo.Song;

/**
 *
 * @author Joseph
 */
@Named(value = "verArtistasController")
@RequestScoped
public class VerArtistasController {

    private static List<SelectItem> artistList;
    private static List<SelectItem> albumList;
    private static List<SelectItem> songList;
    private static List<SelectItem> genreList;
    private Artist artist;
    private Album album;
    private Song song;
    
    /**
     * Creates a new instance of VerArtistasController
     */
    public VerArtistasController() {
        artist = new Artist();
        album = new Album();
        song = new Song();
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
        albums = new DAOAlbum().albumList();
        for (Album album : albums) {
            SelectItem albumItem = new SelectItem(album.getId_album(), album.getName());
            albumList.add(albumItem);
        }
        return albumList;
    }    

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public static List<SelectItem> getArtistList() {
        return artistList;
    }

    public static void setArtistList(List<SelectItem> artistList) {
        VerArtistasController.artistList = artistList;
    }

    public static List<SelectItem> getAlbumList() {
        return albumList;
    }

    public static void setAlbumList(List<SelectItem> albumList) {
        VerArtistasController.albumList = albumList;
    }

    public static List<SelectItem> getSongList() {
        return songList;
    }

    public static void setSongList(List<SelectItem> songList) {
        VerArtistasController.songList = songList;
    }

    public static List<SelectItem> getGenreList() {
        return genreList;
    }

    public static void setGenreList(List<SelectItem> genreList) {
        VerArtistasController.genreList = genreList;
    }
    
    
}
