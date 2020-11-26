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
public class Genre {
    
    //Take id_genre from the database
    private Integer id_genre;
    //Take genre description from the database
    private String genre;

    /**
     * Obtains id_genre from database
     * @return 
     */
    public Integer getId_genre() {
        return id_genre;
    }

    /**
     * Set id_genre
     * @param id_genre 
     */
    public void setId_genre(Integer id_genre) {
        this.id_genre = id_genre;
    }

    /**
     * Obtains music's genre description
     * @return 
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Set music's genre
     * @param genre 
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    
    
}
