/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.crosemont.priserdv.model.config.DAO;

import com.crosemont.priserdv.model.entities.Clinique;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mfate
 */
public class CliniqueIMPdaotest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //testFindById();
        //testFindByName();
        //testFindByEmail();
        //testFindByAddresseRue();
        testFindAll();
        testExistsByEmailAndPassword();
    }
    public static void testFindAll() {
        System.out.println("findAll");
        CliniqueImpDAO instance = new CliniqueImpDAO();
        // List<Utilisateur> expResult = null;
        List<Clinique> result = instance.findAll();
        // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println(result.get(0).afficherTitreDesColonnes());
        for (Clinique utilisateur : result) {
            System.out.println(utilisateur.toString());
        }
    }
    public static void testFindById() {
        System.out.println("findById");
        int id = 0;
        CliniqueImpDAO instance = new CliniqueImpDAO();
        System.out.println("Entrez l'ide l'utilisateur : ");
        Scanner lectureClavier = new Scanner(System.in);
        id = lectureClavier.nextInt();
        Clinique result = instance.findById(id);
        System.out.println(result.toString());

    }
    public static void testFindByName() {
        System.out.println("findByName");
        String nom = "";
        CliniqueImpDAO instance = new CliniqueImpDAO();
        System.out.println("Entrez le nom de l'utilisateur : ");
        Scanner lectureClavier = new Scanner(System.in);
        nom = lectureClavier.next();
        Clinique result = instance.findByName(nom);
        System.out.println(result.toString());

    }
    
    public static void testFindByEmail() {
        System.out.println("findByEmail");
        String email = "";
        CliniqueImpDAO instance = new CliniqueImpDAO();
        System.out.println("Entrez le nom de l'utilisateur : ");
        Scanner lectureClavier = new Scanner(System.in);
        email = lectureClavier.next();
        Clinique result = instance.findByEmail(email);
        System.out.println(result.toString());
    }
    public static void testFindByAddresseRue() {
        System.out.println("findByEmail");
        String addresseRue = "";
        CliniqueImpDAO instance = new CliniqueImpDAO();
        System.out.println("Entrez le l'address du Clinique : ");
        Scanner lectureClavier = new Scanner(System.in);
        addresseRue = lectureClavier.next();
        Clinique result = instance.findByaddresseRue(addresseRue);
        System.out.println(result.toString());
    }
    
    public static void testExistsByEmailAndPassword() {
        System.out.println("existsByEmailAndPassword");
        String email = "";
        String motDePasse = "";
        CliniqueImpDAO instance = new CliniqueImpDAO();
        System.out.println("Entrez l'email de l'utilisateur : ");
        Scanner lectureClavier = new Scanner(System.in);
        email = lectureClavier.next();
        System.out.println("Entrez le mot depase de l'utilisateur : ");

        motDePasse = lectureClavier.next();
        Clinique result = instance.existsByEmailAndPassword(email, motDePasse);
        System.out.println(result.toString());

    }
    
}
