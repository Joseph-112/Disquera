/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Joseph
 */
public class Song {
    
    private int id_song,id_album,id_artist,id_genre;
    private String name;
    private double price;

    public int getId_song() {
        return id_song;
    }

    public void setId_song(int id_song) {
        this.id_song = id_song;
    }

    public int getId_album() {
        return id_album;
    }

    public void setId_album(int id_album) {
        this.id_album = id_album;
    }

    public int getId_artist() {
        return id_artist;
    }

    public void setId_artist(int id_artist) {
        this.id_artist = id_artist;
    }

    public int getId_genre() {
        return id_genre;
    }

    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}
