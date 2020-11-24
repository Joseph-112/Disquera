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
public class Artist {
    
    private Integer id_artist;
    private String name;
    private String photo;

    
    /**
     * Obtains artist's id from database
     * @return 
     */
    public Integer getId_artist() {
        return id_artist;
    }

    /**
     * Set id
     * @param id_artist 
     */
    public void setId_artist(Integer id_artist) {
        this.id_artist = id_artist;
    }

    /**
     * Obtains artist's name from database
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * Set artist's name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtains artist's photo from database
     * @return 
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Set photo
     * @param photo 
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    
    
}
