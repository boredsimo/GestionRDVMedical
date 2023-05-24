/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crosemont.priserdv.model.entities;

/**
 *
 * @author Giguere Julien
 */
public class Specialisation {
    private int id;
    private String titre;

    public Specialisation() {
    }
    
    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    public String afficherTitreDesColonnes() {
        String message = "";
        message = String.format(" %-10s  %30s ", "Id", "titre");
       message+="\n -------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
       return message;
    }
  
    @Override
       public String toString() {
            String message = "";
       message = String.format(" %-10s  %30s",this.id, this.titre); 
       return message;
    }
    
}
