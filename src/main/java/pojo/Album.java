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
public class Album {
    
    private Integer id_album;
    private String name;
    private Integer id_artist;
    private double price;

    /**
     * Obtains album's id
     * @return 
     */
    public Integer getId_album() {
        return id_album;
    }

    /**
     * Set album's id
     * @param id_album 
     */
    public void setId_album(Integer id_album) {
        this.id_album = id_album;
    }

    /**
     * Obtains album's name
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * Set album's name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtains artist's id
     * @return 
     */
    public Integer getId_artist() {
        return id_artist;
    }

    /**
     * Set id artist
     * @param id_artist 
     */
    public void setId_artist(Integer id_artist) {
        this.id_artist = id_artist;
    }

    /**
     * Obtains album's price
     * @return 
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set album's price
     * @param price 
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}
