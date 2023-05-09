/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crosemont.priserdv.model.entities;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Giguere julien
 */
public class Rendezvous implements Serializable  {
    private int id;
    private Date heure;
    private String raison;
    private String precision;
    private int patient_id;
    private int medecin_id;

    public Rendezvous() {
    }

    public int getId() {
        return id;
    }

    public Date getHeure() {
        return heure;
    }

    public String getRaison() {
        return raison;
    }

    public String getPrecision() {
        return precision;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public int getMedecin_id() {
        return medecin_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHeure(Date heure) {
        this.heure = heure;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public void setMedecin_id(int medecin_id) {
        this.medecin_id = medecin_id;
    }

    public String afficherTitreDesColonnes() {
        String message = "";
        message = String.format(" %-10s  %30s %45s %100s %10s %10s ", "Id", "heure", "raison", "precision", "patient_id",
                "medecin_id");
       message+="\n -------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
       return message;
    }
  
    @Override
       public String toString() {
         String message = "";
       message = String.format(" %-10s  %30s %45s %100s %10s %10s ",this.id,this.heure, this.raison,this.precision,this.patient_id,
                    this.medecin_id); 
       return message;
    }
    
    
}
