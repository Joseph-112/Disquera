/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import model.DAOGenre;
import model.DAONationality;
import pojo.Genre;
import pojo.Nationality;

/**
 *
 * @author MontagutN
 */
@Named(value = "crearartistaController")
@RequestScoped
public class crearartistaController implements Serializable{
    
    private static List<SelectItem> genreList;
    private static List<SelectItem> countryList;
    private Nationality country;
    private Genre musicGenre;
    private String nombreartista;
    private Date fechanacimiento;
    private String fotoartista;
    private String nacionalidad;
    
    /**
     * Creates a new instance of crearartistaController
     */
    public crearartistaController() {
        country = new Nationality();
        musicGenre = new Genre();
    }

    public void enviardatos(){//recpcion y muestra de datos desde el boton por consola
        System.out.println("Entro"+ nombreartista+" "+ nacionalidad+" "+fechanacimiento+" "+fotoartista);
    }
    
    public List<SelectItem> countryList(){
        countryList = new ArrayList<SelectItem>();
        List<Nationality> countries;
        countries = new DAONationality().nationalityList();
        for (Nationality country : countries){
            SelectItem countryItem = new SelectItem (country.getId_nationality(),country.getCountry());
            countryList.add(countryItem);
        }
        return countryList;
    }
    
    public List<SelectItem> genreList(){
        genreList = new ArrayList<SelectItem>();
        List<Genre> genres;
        genres = new DAOGenre().genreList();
        for (Genre genre : genres){
            SelectItem countryItem = new SelectItem (genre.getId_genre(),genre.getGenre());
            genreList.add(countryItem);
        }
        return genreList;
    }

    public String getNombreartista() {
        return nombreartista;
    }

    public void setNombreartista(String nombreartista) {
        this.nombreartista = nombreartista;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getFotoartista() {
        return fotoartista;
    }

    public void setFotoartista(String fotoartista) {
        this.fotoartista = fotoartista;
    }

    public List<SelectItem> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<SelectItem> genreList) {
        this.genreList = genreList;
    }

    public List<SelectItem> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<SelectItem> countryList) {
        this.countryList = countryList;
    }

    public Nationality getCountry() {
        return country;
    }

    public void setCountry(Nationality country) {
        this.country = country;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Genre getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(Genre musicGenre) {
        this.musicGenre = musicGenre;
    }
    
    
}
