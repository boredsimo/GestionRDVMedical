/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.crosemont.priserdv.model.DAO;

import com.crosemont.priserdv.model.config.DAO.CliniqueImpDAO;
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
        testCreate_Utilisateur();
        testFindAll();
        //testExistsByEmailAndPassword();
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
    public static void testCreate_Utilisateur() {
        System.out.println("create");
         Scanner lectureClavier = new Scanner(System.in);
        Clinique clinique = null;
        CliniqueImpDAO instance = new CliniqueImpDAO();
        
           System.out.println("Entrez l'id de la clinique : ");
           int id = lectureClavier.nextInt();
          System.out.println("Entrez l'email de la clinique : ");
           String email = lectureClavier.next();
          
           System.out.println("Creer un mot de passe");
               
           String motdepasse  = lectureClavier.next();
      
           System.out.println("Entrez le nom de la Clinqiue : ");
           String nomClinique = lectureClavier.next();
            //  utilisateur.setNom(nom);
           System.out.println("Entrez l'adresse de de la clinique: ");
           String adresseRue = lectureClavier.next();
       
           System.out.println("Entrez le Zip code : ");
           String zip = lectureClavier.next();
    
           System.out.println("Entrez le pays de la clinqiue : ");
           String pays = lectureClavier.next();
           
           System.out.println("Entrez la ville de la clinqiue:  ");
           String ville = lectureClavier.next();
           
           System.out.println("Entrez la province de la  : ");
           String province = lectureClavier.next();
     
        clinique = new Clinique(id,email, motdepasse, nomClinique, adresseRue, zip, pays,ville,province);
        boolean expResult = false;
        boolean result = instance.create(clinique);
             if (result) {
                  System.out.println("Insertion reussite ");
             }else{
                  System.out.println("insertion echec ");
             }
      
    }
    
}
