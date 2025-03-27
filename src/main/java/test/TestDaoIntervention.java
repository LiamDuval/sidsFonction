package test;


import database.ConnexionBdd;
import database.DaoIntervention;
import database.DaoPompier;
import java.sql.Connection;
import java.util.ArrayList;
import model.Caserne;
import model.Intervention;
import model.Pompier;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TS1SIO
 */
public class TestDaoIntervention {
    public static void main (String args[]){
        
        Connection cnx = ConnexionBdd.ouvrirConnexion();
        System.out.println ("nombre d'intervention=" + DaoIntervention.getLesInterventions(cnx).size());
        
        
        
        
        ArrayList<Intervention> lesInterventions = DaoIntervention.getLesInterventions(cnx);
        System.out.println("Nombre d'éléments retournés = " + lesInterventions.size());
        for (Intervention i : lesInterventions) {
            System.out.println(". " + i.getLieu());
        }
        
        
        /*
        Intervention i = new Intervention();
                    i.setLieu("Paris");
                    i.setDate("2023-06-12");
                    i.setHeure_appel("16h45");
                    i.setHeure_arrivee("17h00");
                    i.setDuree("45min");
        
        i = DaoIntervention.addIntervention(cnx, i);
        System.out.println("le nouveau pompier a reçu l id = " + p.getId());
        */
        
    }
}
