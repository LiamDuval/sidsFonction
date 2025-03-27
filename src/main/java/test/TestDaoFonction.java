package test;


import database.ConnexionBdd;
import database.DaoFonction;
import database.DaoPompier;
import java.sql.Connection;
import java.util.ArrayList;
import model.Caserne;
import model.Fonction;
import model.Pompier;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TS1SIO
 */
public class TestDaoFonction {
    public static void main (String args[]){
        
        Connection cnx = ConnexionBdd.ouvrirConnexion();
        System.out.println ("nombre d'intervention=" + DaoFonction.getLesFonctions(cnx).size());
        
        
        
        
        ArrayList<Fonction> lesFonctions = DaoFonction.getLesFonctions(cnx);
        System.out.println("Nombre d'éléments retournés = " + lesFonctions.size());
        for (Fonction f : lesFonctions) {
            System.out.println(". " + f.getLibelle());
        }
        
        
        /*
        Fonction i = new Fonction();
                    i.setLieu("Paris");
                    i.setDate("2023-06-12");
                    i.setHeure_appel("16h45");
                    i.setHeure_arrivee("17h00");
                    i.setDuree("45min");
        
        i = DaoFonction.addFonction(cnx, i);
        System.out.println("le nouveau pompier a reçu l id = " + p.getId());
        */
        
    }
}
