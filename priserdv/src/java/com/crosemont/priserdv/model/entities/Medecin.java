/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crosemont.priserdv.model.entities;

import java.io.Serializable;

/**
 *
 * @author julien giguere
 */
public class Medecin implements Serializable{
    private int id;
    private String nom;
    private String prenom;
    private int numeroMedecin;
    private String email;
    private String motdepasse;
    private float appointmentPrice;
    private boolean estDisponibleLundi;
    private boolean estDisponibleMardi;
    private boolean estDisponibleMercredi;
    private boolean estDisponibleJeudi;
    private boolean estDisponibleVendredi;
    private boolean estDisponibleSamedi;
    private boolean estDisponibleDimanche;
    private int specialisation_id;
    private int clinique_id;

    public Medecin() {
    }

    public Medecin(int id) {
        this.id = id;
    }

    public Medecin(String nom, String prenom, int numeroMedecin) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroMedecin = numeroMedecin;
    }

    public Medecin(int id, String nom, String prenom, int numeroMedecin, String email, String motdepasse, float appointmentPrice, boolean estDisponibleLundi, boolean estDisponibleMardi, boolean estDisponibleMercredi, boolean estDisponibleJeudi, boolean estDisponibleVendredi, boolean estDisponibleSamedi, boolean estDisponibleDimanche, int specialisation_id, int clinique_id) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numeroMedecin = numeroMedecin;
        this.email = email;
        this.motdepasse = motdepasse;
        this.appointmentPrice = appointmentPrice;
        this.estDisponibleLundi = estDisponibleLundi;
        this.estDisponibleMardi = estDisponibleMardi;
        this.estDisponibleMercredi = estDisponibleMercredi;
        this.estDisponibleJeudi = estDisponibleJeudi;
        this.estDisponibleVendredi = estDisponibleVendredi;
        this.estDisponibleSamedi = estDisponibleSamedi;
        this.estDisponibleDimanche = estDisponibleDimanche;
        this.specialisation_id = specialisation_id;
        this.clinique_id = clinique_id;
    }

    public Medecin(int id, String nom, String prenom, int numeroMedecin, String email, String motdepasse, float appointmentPrice, int specialisation_id, int clinique_id) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numeroMedecin = numeroMedecin;
        this.email = email;
        this.motdepasse = motdepasse;
        this.appointmentPrice = appointmentPrice;
        this.specialisation_id = specialisation_id;
        this.clinique_id = clinique_id;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getNumeroMedecin() {
        return numeroMedecin;
    }

    public String getEmail() {
        return email;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public float getAppointmentPrice() {
        return appointmentPrice;
    }

    public boolean isEstDisponibleLundi() {
        return estDisponibleLundi;
    }

    public boolean isEstDisponibleMardi() {
        return estDisponibleMardi;
    }

    public boolean isEstDisponibleMercredi() {
        return estDisponibleMercredi;
    }

    public boolean isEstDisponibleJeudi() {
        return estDisponibleJeudi;
    }

    public boolean isEstDisponibleVendredi() {
        return estDisponibleVendredi;
    }

    public boolean isEstDisponibleSamedi() {
        return estDisponibleSamedi;
    }

    public boolean isEstDisponibleDimanche() {
        return estDisponibleDimanche;
    }

    public int getSpecialisation_id() {
        return specialisation_id;
    }

    public int getClinique_id() {
        return clinique_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNumeroMedecin(int numeroMedecin) {
        this.numeroMedecin = numeroMedecin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public void setAppointmentPrice(float appointmentPrice) {
        this.appointmentPrice = appointmentPrice;
    }

    public void setEstDisponibleLundi(boolean estDisponibleLundi) {
        this.estDisponibleLundi = estDisponibleLundi;
    }

    public void setEstDisponibleMardi(boolean estDisponibleMardi) {
        this.estDisponibleMardi = estDisponibleMardi;
    }

    public void setEstDisponibleMercredi(boolean estDisponibleMercredi) {
        this.estDisponibleMercredi = estDisponibleMercredi;
    }

    public void setEstDisponibleJeudi(boolean estDisponibleJeudi) {
        this.estDisponibleJeudi = estDisponibleJeudi;
    }

    public void setEstDisponibleVendredi(boolean estDisponibleVendredi) {
        this.estDisponibleVendredi = estDisponibleVendredi;
    }

    public void setEstDisponibleSamedi(boolean estDisponibleSamedi) {
        this.estDisponibleSamedi = estDisponibleSamedi;
    }

    public void setEstDisponibleDimanche(boolean estDisponibleDimanche) {
        this.estDisponibleDimanche = estDisponibleDimanche;
    }

    public void setSpecialisation_id(int specialisation_id) {
        this.specialisation_id = specialisation_id;
    }

    public void setClinique_id(int clinique_id) {
        this.clinique_id = clinique_id;
    }
    
    public void setDisponibiliteSemaine(boolean estDisponible) {
        this.estDisponibleLundi = estDisponible;
        this.estDisponibleMardi = estDisponible;
        this.estDisponibleMercredi = estDisponible;
        this.estDisponibleJeudi = estDisponible;
        this.estDisponibleVendredi = estDisponible;
    }
    
    public void setDisponibiliteFinDeSemaine (boolean estDisponible) {
        this.estDisponibleSamedi = estDisponible;
        this.estDisponibleDimanche = estDisponible;
    }
    
    public String afficherTitreDesColonnes() {
        String message = "";
        message = String.format(" %-10s  %30s %15s %15s %15s %15s %15s %15s %15s %15s %15s %15s %15s %15s %15s %25s", "Id", "nom", "prenom", "numeromedecin", "email",
                "motdepasse", "appointmentPrice","esdispoLundi","estdispomardi","estdispomerc","estdispojeu","estdispoven","estdisposam","estdispodim","specialisation","cliniqueid");
       message+="\n -------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
       return message;
    }
  
    @Override
       public String toString() {
         String message = "";
       message = String.format(" %-10d  %30s %15b %15s %15s %15s %15s %15s %15s %15s %15s %15s %15s %15s %15s %25s ",this.id,this.nom, this.prenom,this.numeroMedecin,this.email,
                    this.motdepasse, this.appointmentPrice,this.estDisponibleLundi,this.estDisponibleMardi,this.estDisponibleMercredi,this.estDisponibleJeudi,this.estDisponibleVendredi,this.estDisponibleSamedi,this.estDisponibleDimanche,
                    this.specialisation_id,this.clinique_id); 
       return message;
    }
    
}
