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
 * @author julien giguere
 */
public class Patient implements Serializable {
    private int id;
    private String nom;
    private String prenom;
    private String codeAssuranceMaladie;
    private int numeroAssuranceMaladie;
    private Date dateNaissance;
    private String sexe;
    private String email;
    private boolean admin;
    private int medecin_id;
    private String password;

    public Patient() {
    }

    public Patient(int id) {
        this.id = id;
    }

    public Patient(String codeAssuranceMaladie) {
        this.codeAssuranceMaladie = codeAssuranceMaladie;
    }

    public Patient(int id, String nom, String prenom, String codeAssuranceMaladie, Date dateNaissance, String sexe, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.codeAssuranceMaladie = codeAssuranceMaladie;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.email = email;
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

    public String getCodeAssuranceMaladie() {
        return codeAssuranceMaladie;
    }

    public int getNumeroAssuranceMaladie() {
        return numeroAssuranceMaladie;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public String getEmail() {
        return email;
    }

    public boolean getAdmin() {
        return admin;
    }

    public int getMedecin_id() {
        return medecin_id;
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

    public void setCodeAssuranceMaladie(String codeAssuranceMaladie) {
        this.codeAssuranceMaladie = codeAssuranceMaladie;
    }

    public void setNumeroAssuranceMaladie(int numeroAssuranceMaladie) {
        this.numeroAssuranceMaladie = numeroAssuranceMaladie;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setMedecin_id(int medecin_id) {
        this.medecin_id = medecin_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
