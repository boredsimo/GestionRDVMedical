/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crosemont.priserdv.model.DAO;

import com.crosemont.priserdv.model.entities.Rendezvous;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Giguere julien
 */
public class RendezvousImpDAOTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long Localdate;
        // TODO code application logic here

        //testFindAll();
        //testCreate();
        //testFindAll();
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0); // same for minutes and seconds
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        //System.out.println(Calendar.YEAR);
        
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
            LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        testFindfindByMedecinIdAndDate(4, new Date(localDate.toEpochDay()));
    }

    public static void testFindAll() {
        System.out.println("findAll");
        RendezvousImpDAO instance = new RendezvousImpDAO();
        // List<Utilisateur> expResult = null;
        List<Rendezvous> result = instance.findAll();
        // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println(result.get(0).afficherTitreDesColonnes());
        for (Rendezvous rendezvous : result) {
            System.out.println(rendezvous.toString());
        }
    }

    public static void testCreate() {
        System.out.println("create");
        Scanner lectureClavier = new Scanner(System.in);
        Rendezvous rendezvous = null;
        RendezvousImpDAO instance = new RendezvousImpDAO();

        System.out.println("Entrez l'id patient : ");
        int id_patient = lectureClavier.nextInt();

        Date uneDate = new Date();

        System.out.println("Entrez l'id du Medecin : ");
        int id_medecin = lectureClavier.nextInt();

        rendezvous = new Rendezvous();
        Timestamp ts = new Timestamp(new Date().getTime());
        rendezvous.setHeure(uneDate);
        rendezvous.setMedecin_id(id_medecin);
        rendezvous.setPatient_id(id_patient);
        boolean expResult = false;
        boolean result = instance.create(rendezvous);
        if (result) {
            System.out.println("Insertion reussite ");
        } else {
            System.out.println("insertion echec ");
        }
    }

    private static void testFindfindByMedecinIdAndDate(int numero, Date date) {
        System.out.println("FindfindByMedecinIdAndDate");
        RendezvousImpDAO instance = new RendezvousImpDAO();
        // List<Utilisateur> expResult = null;
        List<Rendezvous> result = instance.findByMedecinIdAndDate(numero, new java.sql.Date(date.getTime()));
        // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println(result.get(0).afficherTitreDesColonnes());
        for (Rendezvous rendezvous : result) {
            System.out.println(rendezvous.toString());
        }
    }
}
