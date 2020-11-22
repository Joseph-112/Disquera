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
public class Nationality {
    
    //Stores nationality's id from database
    private Integer id_nationality;
    //Stores country from database
    private String country;

    /**
     * Obtains id's nationality from database
     * @return 
     */
    public Integer getId_nationality() {
        return id_nationality;
    }

    /**
     * Set id_ nationality
     * @param id_nationality 
     */
    public void setId_nationality(Integer id_nationality) {
        this.id_nationality = id_nationality;
    }

    /**
     * Obtains contry from database
     * @return 
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set country
     * @param country 
     */
    public void setCountry(String country) {
        this.country = country;
    }
    
    
    
}
