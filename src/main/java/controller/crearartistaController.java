/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import model.DAOAdmin;
import model.DAOGenre;
import model.DAONationality;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import pojo.Genre;
import pojo.Nationality;

/**
 *
 * @author MontagutN
 */
@Named(value = "crearartistaController")
@RequestScoped
public class crearartistaController implements Serializable {

    private static List<SelectItem> genreList;
    private static List<SelectItem> countryList;
    private Nationality country;
    private Genre musicGenre;
    private String nombreartista;
    private Date fechanacimiento;
    private String ruta = "C://Users//josep//Desktop//Personal//Universidad//Línea de profundización 1//Trabajos//ProyectoDisquera//Web Pages//artistPhotos";
    private String ruta_temporal = "..//artistPhotos";
    private String nacionalidad;

    /**
     * Creates a new instance of crearartistaController
     */
    public crearartistaController() {
        country = new Nationality();
        musicGenre = new Genre();
        
    }
    
    public void handleFileUpload(FileUploadEvent event) throws IOException {
        UploadedFile uploadedFile = event.getFile();
        String fileName = uploadedFile.getFileName();
        byte[] contents = uploadedFile.getContent();
        try {
            this.ruta += fileName.replace(" ", "");
            this.ruta_temporal += fileName.replace(" ", "");
            FileOutputStream fos = new FileOutputStream(ruta);
            fos.write(contents);
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(crearartistaController.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public void sendData() {//recpcion y muestra de datos desde el boton por consola

        boolean success = new DAOAdmin().insertArtist(getNombreartista(), musicGenre.getId_genre(),country.getId_nationality(),getRuta_temporal(),  getFechanacimiento());
        if (success==true) {
            System.out.println("Registrado con éxito");
        }else{
            System.out.println("Chúpelo prro");
        }
        System.out.println("Entro" + nombreartista + " " + nacionalidad + " " + fechanacimiento + " " + ruta_temporal);
    }

    public List<SelectItem> countryList() {
        countryList = new ArrayList<SelectItem>();
        List<Nationality> countries;
        countries = new DAONationality().nationalityList();
        for (Nationality country : countries) {
            SelectItem countryItem = new SelectItem(country.getId_nationality(), country.getCountry());
            countryList.add(countryItem);
        }
        return countryList;
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

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getRuta_temporal() {
        return ruta_temporal;
    }

    public void setRuta_temporal(String ruta_temporal) {
        this.ruta_temporal = ruta_temporal;
    }

    

}
