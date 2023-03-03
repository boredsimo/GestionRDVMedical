/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crosemont.priserdv.model.entities;

import java.io.Serializable;

/**
 *
 * @author julie giguere
 */
public class Clinique implements Serializable {
    private int id;
    private String email;
    private String motdepasse;
    private String nomClinique;
    private String addresseRue;
    private String zip;
    private String pays;
    private String ville;
    private String province;

    public Clinique() {
    }

    public Clinique(int id) {
        this.id = id;
    }

    public Clinique(String nomClinique) {
        this.nomClinique = nomClinique;
    }

    public Clinique(int id, String email, String motdepasse, String nomClinique, String addresseRue, String zip, String pays, String ville, String province) {
        this.id = id;
        this.email = email;
        this.motdepasse = motdepasse;
        this.nomClinique = nomClinique;
        this.addresseRue = addresseRue;
        this.zip = zip;
        this.pays = pays;
        this.ville = ville;
        this.province = province;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public String getNomClinique() {
        return nomClinique;
    }

    public String getAddresseRue() {
        return addresseRue;
    }

    public String getZip() {
        return zip;
    }

    public String getPays() {
        return pays;
    }

    public String getVille() {
        return ville;
    }

    public String getProvince() {
        return province;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public void setNomClinique(String nomClinique) {
        this.nomClinique = nomClinique;
    }

    public void setAddresseRue(String addresseRue) {
        this.addresseRue = addresseRue;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    public String afficherTitreDesColonnes() {
        String message = "";
        message = String.format(" %-10s  %30s %15s %15s %15s %15s %15s %15s %25s", "Id", "Email", "motdepasse", "nomClinique", "addresseRue",
                "zip", "pays","ville","province");
       message+="\n -------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
       return message;
    }
  
    @Override
       public String toString() {
         String message = "";
       message = String.format(" %-10d  %30s %15b %15s %15s %15s %15s %15s %25s ",this.id,this.email, this.motdepasse,this.nomClinique,this.addresseRue,
                    this.zip, this.pays,this.ville,this.province); 
       return message;
    }


     
    
}
