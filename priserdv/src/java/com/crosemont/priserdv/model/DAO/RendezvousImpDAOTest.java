/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crosemont.priserdv.model.DAO;

import com.crosemont.priserdv.model.entities.Rendezvous;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author julie
 */
public class RendezvousImpDAOTest {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        testCreate();
    }
    
public static void testCreate() {
        System.out.println("create");
         Scanner lectureClavier = new Scanner(System.in);
        Rendezvous rendezvous = null;
        RendezvousImpDAO instance = new RendezvousImpDAO();
        
           System.out.println("Entrez l'id du rende-vous : ");
           int id_rdv = lectureClavier.nextInt();
           
           Date uneDate = new Date();
           
           System.out.println("Entrez l'id du Medecin : ");
           int id_medecin = lectureClavier.nextInt();
          
     
        rendezvous = new Rendezvous();
        rendezvous.setId(id_rdv);
        rendezvous.setHeure(uneDate);
        rendezvous.setMedecin_id(id_medecin);
        boolean expResult = false;
        boolean result = instance.create(rendezvous);
             if (result) {
                  System.out.println("Insertion reussite ");
             }else{
                  System.out.println("insertion echec ");
             }
      
    }
}
