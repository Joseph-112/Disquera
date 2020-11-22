/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Genre;
import pojo.Nationality;

/**
 *
 * @author Joseph
 */
public class DAONationality {

    Connection conn = null;
    Statement stm;
    ResultSet result;

    public List<Nationality> nationalityList() {

        //Saves genre's data
        List<Nationality> countryList = new ArrayList<Nationality>();

        try {
            conn = DBConnection.getConnection();
            stm = conn.createStatement();
            result = stm.executeQuery("SELECT * FROM disquera.nationality ORDER BY id_nationality");
            while (result.next()) {
                Nationality newCountry = new Nationality();
                newCountry.setId_nationality(result.getInt(1));
                newCountry.setCountry(result.getString(2));
                System.out.println("\n\n Received data: \n Id: " + newCountry.getId_nationality()+ "\n Country: " + newCountry.getCountry());
                countryList.add(newCountry);
                /*
                System.out.println("No existe un usuario con esa contraseña");
                conn.close();
                return null;
                 */
            }
            result.close();
            stm.close();
            conn.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOGenre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return countryList;
    }
}
