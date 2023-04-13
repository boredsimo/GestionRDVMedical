/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crosemont.priserdv.model.config.DAO;

import static com.crosemont.priserdv.model.config.DAO.CliniqueIMPdaotest.testCreate_Utilisateur;
import com.crosemont.priserdv.model.entities.Clinique;
import com.crosemont.priserdv.model.entities.Medecin;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mfate
 */
public class MedecinImpDAOTest {
    public static void main(String[] args) {
        // TODO code application logic here
        testFindAll();
        //testFindById();
        //testFindByName();
        //testFindByNumMedecin();
        // testExistsByEmailAndPassword();
        testCreate_Medecin();
    }
    public static void testFindAll() {
        System.out.println("findAll");
        MedecinImpDAO instance = new MedecinImpDAO();
        // List<Utilisateur> expResult = null;
        List<Medecin> result = instance.findAll();
        // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println(result.get(0).afficherTitreDesColonnes());
        for (Medecin medecin : result) {
            System.out.println(medecin.toString());
        }
    }
    public static void testFindById() {
        System.out.println("findById");
        int id = 0;
        MedecinImpDAO instance = new MedecinImpDAO();
        System.out.println("Entrez l'ide du medecin : ");
        Scanner lectureClavier = new Scanner(System.in);
        id = lectureClavier.nextInt();
        Medecin result = instance.findById(id);
        System.out.println(result.toString());

    }
    public static void testFindByName() {
        System.out.println("findByName");
        String nom = "";
        MedecinImpDAO instance = new MedecinImpDAO();
        System.out.println("Entrez le nom de l'utilisateur : ");
        Scanner lectureClavier = new Scanner(System.in);
        nom = lectureClavier.next();
        Medecin result = instance.findByName(nom);
        System.out.println(result.toString());

    }
    public static void testFindByNumMedecin() {
        System.out.println("findById");
        int id = 0;
        MedecinImpDAO instance = new MedecinImpDAO();
        System.out.println("Entrez le num du medecin : ");
        Scanner lectureClavier = new Scanner(System.in);
        id = lectureClavier.nextInt();
        Medecin result = instance.findByNumeroMedecin(id);
        System.out.println(result.toString());

    }
    public static void testExistsByEmailAndPassword() {
        System.out.println("existsByEmailAndPassword");
        String email = "";
        String motDePasse = "";
        MedecinImpDAO instance = new MedecinImpDAO();
        System.out.println("Entrez l'email de l'utilisateur : ");
        Scanner lectureClavier = new Scanner(System.in);
        email = lectureClavier.next();
        System.out.println("Entrez le mot depase de l'utilisateur : ");

        motDePasse = lectureClavier.next();
        Medecin result = instance.existsByEmailAndPassword(email, motDePasse);
        System.out.println(result.toString());

    }
    public static void testCreate_Medecin() {
        System.out.println("create");
         Scanner lectureClavier = new Scanner(System.in);
        Medecin medecin = null;
        MedecinImpDAO instance = new MedecinImpDAO();
        
           System.out.println("Entrez l'id du medecin : ");
           int id = lectureClavier.nextInt();
          System.out.println("Entrez le nom du medecin : ");
           String nom = lectureClavier.next();
           
           System.out.println("Entrez le prenom du medecin : ");
           String prenom = lectureClavier.next();
          
           System.out.println("Creer Le numero Medecin ");
               
           int numeroMedecin  = lectureClavier.nextInt();
      
           System.out.println("Entrez le email du medecin : ");
           String email = lectureClavier.next();
            //  utilisateur.setNom(nom);
           System.out.println("Entrez l'e motdepasse de de la clinique: ");
           String motdepasse = lectureClavier.next();
       
           System.out.println("Entrez le prixx : ");
           float appointmentPrice = lectureClavier.nextFloat();
    
           System.out.println("Disponibilité Lundi : ");
           boolean estDisponibleLundi = lectureClavier.nextBoolean();
           
           System.out.println("Disponibilité Mardi : ");
           boolean estDisponibleMardi = lectureClavier.nextBoolean();
           
           System.out.println("Disponibilité Mercredi : ");
           boolean estDisponibleMercredi = lectureClavier.nextBoolean();
           System.out.println("Disponibilité Jeudi :");
           boolean estDisponibleJeudi = lectureClavier.nextBoolean();
           System.out.println("Disponibilité Vendredi :");
           boolean estDisponibleVendredi = lectureClavier.nextBoolean();
           System.out.println("Disponibilité Samedi :");
           boolean estDisponibleSamedi = lectureClavier.nextBoolean();
           System.out.println("Disponibilité Dimanche : ");
           boolean estDisponibleDimanche = lectureClavier.nextBoolean();
           
           System.out.println("Entrez l id de la specialisation  ");
           int specialisation_id = lectureClavier.nextInt();
           
           System.out.println("Entrez l id du clinique id ");
           int clinique_id = lectureClavier.nextInt();
     
        medecin= new Medecin(id, nom, prenom, numeroMedecin, email, motdepasse, appointmentPrice, estDisponibleLundi, estDisponibleMardi, estDisponibleMercredi, estDisponibleJeudi, estDisponibleVendredi, estDisponibleSamedi, estDisponibleDimanche, specialisation_id, clinique_id);
        boolean expResult = false;
        boolean result = instance.create(medecin);
             if (result) {
                  System.out.println("Insertion reussite ");
             }else{
                  System.out.println("insertion echec ");
             }
      
    }
}
