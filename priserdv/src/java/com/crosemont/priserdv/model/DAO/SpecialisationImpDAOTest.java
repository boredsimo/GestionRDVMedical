/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crosemont.priserdv.model.DAO;

import com.crosemont.priserdv.model.entities.Specialisation;
import java.util.List;

/**
 *
 * @author Giguere Julien
 */
public class SpecialisationImpDAOTest {

    
    public static void main(String[] args) {
        // TODO code application logic here

        testFindAll();
        //testCreate();

    }

    public static void testFindAll() {
        System.out.println("findAll");
        SpecialisationImpDAO instance = new SpecialisationImpDAO();
        // List<Utilisateur> expResult = null;
        List<Specialisation> result = instance.findAll();
        // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println(result.get(0).afficherTitreDesColonnes());
        for (Specialisation specialisation : result) {
            System.out.println(specialisation.toString());
        }
    }
}
