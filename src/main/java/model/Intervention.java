/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author TS1SIO
 */
public class Intervention {
    private int id;
    private String lieu;
    private String date;
    private String heure_appel;
    private String heure_arrivee;
    private String duree;
    private ArrayList<Intervention> lesInterventions;

    public Intervention() {
    }

    public Intervention(int id) {
        this.id = id;
    }

    public Intervention(int id, String lieu, String date, String heure_appel, String heure_arrivee, String duree) {
        this.id = id;
        this.lieu = lieu;
        this.date = date;
        this.heure_appel = heure_appel;
        this.heure_arrivee = heure_arrivee;
        this.duree = duree;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getHeure_appel() {
        return heure_appel;
    }

    public void setHeure_appel(String heure_appel) {
        this.heure_appel = heure_appel;
    }

    public String getHeure_arrivee() {
        return heure_arrivee;
    }

    public void setHeure_arrivee(String heure_arrivee) {
        this.heure_arrivee = heure_arrivee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public ArrayList<Intervention> getLesInterventions() {
        return lesInterventions;
    }

    public void setLesInterventions(ArrayList<Intervention> lesInterventions) {
        this.lesInterventions = lesInterventions;
    }
    
    
}
