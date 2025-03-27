/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import static database.DaoFonction.requeteSql;
import static database.DaoFonction.resultatRequete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Fonction;


/**
 *
 * @author TS1SIO
 */
public class DaoFonction {
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<Fonction> getLesFonctions(Connection cnx){
        
        ArrayList<Fonction> lesFonctions = new ArrayList<Fonction>();
        try{
            requeteSql = cnx.prepareStatement("select fonction.id as f_id, libelle as f_libelle" +
                         " from fonction ");
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                Fonction i = new Fonction();
                    i.setId(resultatRequete.getInt("f_id"));
                    i.setLibelle(resultatRequete.getString("f_libelle"));

                lesFonctions.add(i);
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesFonction a généré une erreur");
        }
        return lesFonctions;
    }
    
    public static Fonction getFonctionById(Connection cnx, int idFonction){
        
        Fonction i = null ;
        try{
            requeteSql = cnx.prepareStatement("select fonction.id as f_id, libelle as f_libelle" +
                         " from fonction WHERE id = ? ");
            requeteSql.setInt(1, idFonction);
            resultatRequete = requeteSql.executeQuery();
            
            if (resultatRequete.next()){
                
                
                    i = new Fonction();
                    i.setId(resultatRequete.getInt("f_id"));
                    i.setLibelle(resultatRequete.getString("f_libelle"));
         
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getFonctionById  a généré une erreur");
        }
        return i ;
    }
}
