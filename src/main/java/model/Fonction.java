/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
/**
 *
 * @author TS1SIO
 */
public class Fonction {
    private int id;
    private String libelle;
    private ArrayList<Fonction> lesFonctions;
    
    public Fonction(){
        
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public ArrayList<Fonction> getLesFonctions() {
        return lesFonctions;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setLesFonctions(ArrayList<Fonction> lesFonctions) {
        this.lesFonctions = lesFonctions;
    }
    
    
    
}

