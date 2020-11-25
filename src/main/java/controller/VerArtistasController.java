/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import model.DAOAlbum;
import model.DAOArtist;
import model.DAOSong;
import pojo.Album;
import pojo.Artist;
import pojo.Song;

/**
 *
 * @author Joseph
 */
@Named(value = "verArtistasController")
@ViewScoped
public class VerArtistasController implements Serializable {

    private static List<SelectItem> artistList;
    private static List<SelectItem> albumList;
    private static List<SelectItem> songList;
    private int itemAlbum;
    private int itemSong;
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
        System.out.println("\n\nId artista:"+artist.getId_artist());
        System.out.println("\n\nId artista:"+album.getId_album());
        System.out.println("\n\nId artista:"+song.getId_song());
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

    public List<SelectItem> songList() {

        songList = new ArrayList<SelectItem>();
        List<Song> songs;
        
        
        
        if (album.getId_album() == null) {
            songs = new DAOSong().songList();
        } else {
            songs = new DAOSong().songList(album.getId_album());
        }

        //albums = new DAOAlbum().albumList();
        for (Song cancion : songs) {
            SelectItem songItem = new SelectItem(cancion.getId_song(), cancion.getName());
            songList.add(songItem);
        }
        return songList;
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

    public int getItemAlbum() {
        return itemAlbum;
    }

    public void setItemAlbum(int itemAlbum) {
        this.itemAlbum = itemAlbum;
    }

    public int getItemSong() {
        return itemSong;
    }

    public void setItemSong(int itemSong) {
        this.itemSong = itemSong;
    }


    
    
}
