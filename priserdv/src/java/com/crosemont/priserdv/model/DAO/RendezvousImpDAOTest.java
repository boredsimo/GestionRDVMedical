/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crosemont.priserdv.model.DAO;

import com.crosemont.priserdv.model.entities.Rendezvous;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        //testCreateSpecificDate();
        
        //testFindfindByMedecinIdAndDate();
        //testDeleteRendezvousParID();
        testUpdateRendezvousPatientID();
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
        //Timestamp ts = new Timestamp(new Date().getTime());
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
    
    
        public static void testCreateSpecificDate() {
        //try {
            System.out.println("create");
            Scanner lectureClavier = new Scanner(System.in);
            Rendezvous rendezvous = null;
            RendezvousImpDAO instance = new RendezvousImpDAO();
            
            /*
            String chaineDate = request.getParameter("dateHeure");
            Date date1=new SimpleDateFormat("yyyy-MM-dd-H-mm").parse(chaineDate);
            HttpSession session = request.getSession(true);
            
            unRendezvous.setHeure(date1);
            unRendezvous.setMedecin_id((int)session.getAttribute("id"));
            unRendezvous.setPatient_id(1);
            */
            
            String chaineDateHeure = "2023-05-22-06-00";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
            LocalDate dateTime = LocalDate.parse(chaineDateHeure, formatter);
            ZoneId defaultZoneId = ZoneId.systemDefault();
            
            Date date1 = Date.from(dateTime.atStartOfDay(defaultZoneId).toInstant());
            //HttpSession session = request.getSession(true);
            
            rendezvous = new Rendezvous();
            rendezvous.setHeure(date1);
            rendezvous.setMedecin_id(2);
            rendezvous.setPatient_id(2);
            //boolean expResult = false;
            boolean result = instance.create(rendezvous);
            if (result) {
                System.out.println("Insertion reussite ");
            } else {
                System.out.println("insertion echec ");
            }
       // } catch (ParseException ex) {
         //   Logger.getLogger(RendezvousImpDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        //}
    }

    private static void testFindfindByMedecinIdAndDate() {
        System.out.println("FindfindByMedecinIdAndDate");
        RendezvousImpDAO instance = new RendezvousImpDAO();
        
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0); // same for minutes and seconds
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.DAY_OF_MONTH, 30);
        //System.out.println(Calendar.YEAR);
        
        System.out.println(today.toString());
        
        List<Rendezvous> result = instance.findByMedecinIdAndDate(1, new java.sql.Date(today.getTimeInMillis()));
        // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println(result.get(0).afficherTitreDesColonnes());
        for (Rendezvous rendezvous : result) {
            System.out.println(rendezvous.toString());
        }
    }
    
    private static void testDeleteRendezvousParID() {
        System.out.println("FindfindByMedecinIdAndDate");
        RendezvousImpDAO instance = new RendezvousImpDAO();

        boolean result = instance.delete(2);
        // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result) {
            System.out.println("reussi");
        } else {
            System.out.println("echec");
        }
    }
    
    private static void testUpdateRendezvousPatientID() {
        System.out.println("FindfindByMedecinIdAndDate");
        RendezvousImpDAO instance = new RendezvousImpDAO();

        boolean result = instance.updatePatientID(356, 2);
        // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result) {
            System.out.println("reussi");
        } else {
            System.out.println("echec");
        }
    }
}
