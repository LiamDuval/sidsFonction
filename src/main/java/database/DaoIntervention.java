/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import static database.DaoPompier.requeteSql;
import static database.DaoPompier.resultatRequete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Caserne;
import model.Intervention;
import model.Pompier;

/**
 *
 * @author TS1SIO
 */
public class DaoIntervention {
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<Intervention> getLesInterventions(Connection cnx){
        
        ArrayList<Intervention> lesInterventions = new ArrayList<Intervention>();
        try{
            requeteSql = cnx.prepareStatement("select intervention.id as i_id, lieu as i_lieu, date as i_date, heure_appel as i_heure_appel, heure_arrivee as i_heure_arrivee, duree as i_duree " +
                         " from intervention ");
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                Intervention i = new Intervention();
                    i.setId(resultatRequete.getInt("i_id"));
                    i.setLieu(resultatRequete.getString("i_lieu"));
                    i.setDate(resultatRequete.getString("i_date"));
                    i.setHeure_appel(resultatRequete.getString("i_heure_appel"));
                    i.setHeure_arrivee(resultatRequete.getString("i_heure_arrivee"));
                    i.setDuree(resultatRequete.getString("i_duree"));


                lesInterventions.add(i);
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesPompiers e généré une erreur");
        }
        return lesInterventions;
    }
    
    public static Intervention getInterventionById(Connection cnx, int idIntervention){
        
        Intervention i = null ;
        try{
            requeteSql = cnx.prepareStatement("select intervention.id as i_id, lieu as i_lieu, date as i_date, heure_appel as i_heure_appel, heure_arrivee as i_heure_arrivee, duree as i_duree " +
                         " from intervention WHERE id = ? ");
            requeteSql.setInt(1, idIntervention);
            resultatRequete = requeteSql.executeQuery();
            
            if (resultatRequete.next()){
                
                
                    i = new Intervention();
                    i.setId(resultatRequete.getInt("i_id"));
                    i.setLieu(resultatRequete.getString("i_lieu"));
                    i.setDate(resultatRequete.getString("i_date"));
                    i.setHeure_appel(resultatRequete.getString("i_heure_appel"));
                    i.setHeure_arrivee(resultatRequete.getString("i_heure_arrivee"));
                    i.setDuree(resultatRequete.getString("i_duree"));
         
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getPompierById  a généré une erreur");
        }
        return i ;
    }
    
    
    public static Pompier addPompier(Connection connection, Pompier p){      
        int idGenere = -1;
        try
        {
            //preparation de la requete
            // id (clé primaire de la table client) est en auto_increment,donc on ne renseigne pas cette valeur
            // la paramètre RETURN_GENERATED_KEYS est ajouté à la requête afin de pouvoir récupérer l'id généré par la bdd (voir ci-dessous)
            // supprimer ce paramètre en cas de requête sans auto_increment.
            requeteSql=connection.prepareStatement("INSERT INTO pompier ( nom, prenom, caserne_id)\n" +
                    "VALUES (?,?,?)", requeteSql.RETURN_GENERATED_KEYS );
            requeteSql.setString(1, p.getNom());
            requeteSql.setString(2, p.getPrenom());
            requeteSql.setInt(3, p.getUneCaserne().getId());

           /* Exécution de la requête */
            requeteSql.executeUpdate();
            
             // Récupération de id auto-généré par la bdd dans la table client
            resultatRequete = requeteSql.getGeneratedKeys();
            while ( resultatRequete.next() ) {
                idGenere = resultatRequete.getInt( 1 );
                p.setId(idGenere);
                
                p = DaoPompier.getPompierById(connection, p.getId());
            }
            
         
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return p ;    
    }}
