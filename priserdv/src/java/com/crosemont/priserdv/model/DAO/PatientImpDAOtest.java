/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crosemont.priserdv.model.DAO;

import com.crosemont.priserdv.model.entities.Patient;
import java.util.List;

/**
 *
 * @author Giguere julien
 */
public class PatientImpDAOtest {
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //testFindAllByRendezvousAndMedecinID();
        testFindByID();
    }

    public static void testFindAllByRendezvousAndMedecinID() {
        System.out.println("findAll");
        PatientImpDAO instance = new PatientImpDAO();
        // List<Utilisateur> expResult = null;
        List<Patient> result = instance.findAllByRendezvousAndMedecinID(1);
        // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println(result.get(0).afficherTitreDesColonnes());
        for (Patient rendezvous : result) {
            System.out.println(rendezvous.toString());
        }
    }
    
    public static void testFindByID() {
        System.out.println("findAll");
        PatientImpDAO instance = new PatientImpDAO();
        // List<Utilisateur> expResult = null;
        Patient result = instance.findById(1);
        // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println(result.afficherTitreDesColonnes());
        System.out.println(result.toString());
    }
}
