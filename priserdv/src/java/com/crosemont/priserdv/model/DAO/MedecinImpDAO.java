/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crosemont.priserdv.model.config.DAO;

import com.crosemont.priserdv.model.entities.Clinique;
import com.crosemont.priserdv.model.entities.Medecin;
import com.crosemont.priserdv.model.singleton.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mfate
 */
public class MedecinImpDAO implements MedecinDAO {
    private static final String SQL_SELECT_MEDECIN = "select * from medecin";
    private static final String SQL_SELECT_MEDECIN_PAR_ID = "select * from medecin where id = ?";
    private static final String SQL_SELECT_MEDECIN_PAR_NOM= "select * from medecin where nom = ?";
    private static final String SQL_SELECT_MEDECIN_PAR_NUMEROMED= "select * from medecin where numeroMedecin = ?";
    private static final String SQL_CONNEXION_PAR_EMAIL_AND_PASSWORD = "select nom, prenom from medecin where email=? and motdepasse=?";
    private static final String SQL_INSERT_MEDECIN= "insert into medecin(id,nom,prenom,numeroMedecin,email,motdepasse,appointmentPrice,estDisponibleLundi,"
            + "estDisponibleMardi,estDisponibleMercredi,estDisponibleJeudi,estDisponibleVendredi,estDisponibleSamedi,estDisponibleDimanche,specialisation_id,clinique_id) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public List<Medecin> findAll() {
        List<Medecin> list = null;
        

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            
        try {
            PreparedStatement ps;
            ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_MEDECIN);
            
            System.out.println(" result : " + ps.toString());
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
               
            list = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                Medecin medecin = new Medecin();
                 System.out.println(" result : " + result.getString("email"));
                medecin.setId(result.getInt("id"));
                medecin.setNom(result.getString("nom"));
                medecin.setPrenom(result.getString("prenom"));
                medecin.setNumeroMedecin(result.getInt("numeroMedecin"));
                medecin.setEmail(result.getString("email"));
                medecin.setMotdepasse(result.getString("motdepasse"));
                medecin.setAppointmentPrice(result.getInt("appointmentPrice"));
                medecin.setEstDisponibleLundi(result.getBoolean("estDisponibleLundi"));
                medecin.setEstDisponibleMardi(result.getBoolean("estDisponibleMardi"));
                medecin.setEstDisponibleMercredi(result.getBoolean("estDisponibleMercredi"));
                medecin.setEstDisponibleJeudi(result.getBoolean("estDisponibleJeudi"));
                medecin.setEstDisponibleVendredi(result.getBoolean("estDisponibleVendredi"));
                medecin.setEstDisponibleSamedi(result.getBoolean("estDisponibleSamedi"));
                medecin.setEstDisponibleDimanche(result.getBoolean("estDisponibleDimanche"));
                medecin.setSpecialisation_id(result.getInt("specialisation_id"));
                medecin.setClinique_id(result.getInt("clinique_id"));
                list.add(medecin);
            };
        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return list;
    }

    @Override
    public Medecin findById(int id) {
        Medecin medecin=null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_MEDECIN_PAR_ID);
            // on initialise la propriété id du bean avec sa valeur
            ps.setInt(1, id);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                medecin = new Medecin();
                 System.out.println(" result : " + result.getString("email"));
                medecin.setId(result.getInt("id"));
                medecin.setNom(result.getString("nom"));
                medecin.setPrenom(result.getString("prenom"));
                medecin.setNumeroMedecin(result.getInt("numeroMedecin"));
                medecin.setEmail(result.getString("email"));
                medecin.setMotdepasse(result.getString("motdepasse"));
                medecin.setAppointmentPrice(result.getInt("appointmentPrice"));
                medecin.setEstDisponibleLundi(result.getBoolean("estDisponibleLundi"));
                medecin.setEstDisponibleMardi(result.getBoolean("estDisponibleMardi"));
                medecin.setEstDisponibleMercredi(result.getBoolean("estDisponibleMercredi"));
                medecin.setEstDisponibleJeudi(result.getBoolean("estDisponibleJeudi"));
                medecin.setEstDisponibleVendredi(result.getBoolean("estDisponibleVendredi"));
                medecin.setEstDisponibleSamedi(result.getBoolean("estDisponibleSamedi"));
                medecin.setEstDisponibleDimanche(result.getBoolean("estDisponibleDimanche"));
                medecin.setSpecialisation_id(result.getInt("specialisation_id"));
                medecin.setClinique_id(result.getInt("clinique_id"));
                
                

            };
        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return medecin;
    }

    @Override
    public Medecin findByName(String nom) {
        Medecin medecin = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_MEDECIN_PAR_NOM);
            // on initialise la propriété nom du bean avec sa premiere valeur
            ps.setString(1, nom);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                medecin = new Medecin();
                 System.out.println(" result : " + result.getString("email"));
                medecin.setId(result.getInt("id"));
                medecin.setNom(result.getString("nom"));
                medecin.setPrenom(result.getString("prenom"));
                medecin.setNumeroMedecin(result.getInt("numeroMedecin"));
                medecin.setEmail(result.getString("email"));
                medecin.setMotdepasse(result.getString("motdepasse"));
                medecin.setAppointmentPrice(result.getInt("appointmentPrice"));
                medecin.setEstDisponibleLundi(result.getBoolean("estDisponibleLundi"));
                medecin.setEstDisponibleMardi(result.getBoolean("estDisponibleMardi"));
                medecin.setEstDisponibleMercredi(result.getBoolean("estDisponibleMercredi"));
                medecin.setEstDisponibleJeudi(result.getBoolean("estDisponibleJeudi"));
                medecin.setEstDisponibleVendredi(result.getBoolean("estDisponibleVendredi"));
                medecin.setEstDisponibleSamedi(result.getBoolean("estDisponibleSamedi"));
                medecin.setEstDisponibleDimanche(result.getBoolean("estDisponibleDimanche"));
                medecin.setSpecialisation_id(result.getInt("specialisation_id"));
                medecin.setClinique_id(result.getInt("clinique_id"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return medecin;
    }

    @Override
    public Medecin findByNumeroMedecin(int numero) {
        Medecin medecin=null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_MEDECIN_PAR_NUMEROMED);
            // on initialise la propriété id du bean avec sa valeur
            ps.setInt(1, numero);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                medecin = new Medecin();
                 System.out.println(" result : " + result.getString("email"));
                medecin.setId(result.getInt("id"));
                medecin.setNom(result.getString("nom"));
                medecin.setPrenom(result.getString("prenom"));
                medecin.setNumeroMedecin(result.getInt("numeroMedecin"));
                medecin.setEmail(result.getString("email"));
                medecin.setMotdepasse(result.getString("motdepasse"));
                medecin.setAppointmentPrice(result.getInt("appointmentPrice"));
                medecin.setEstDisponibleLundi(result.getBoolean("estDisponibleLundi"));
                medecin.setEstDisponibleMardi(result.getBoolean("estDisponibleMardi"));
                medecin.setEstDisponibleMercredi(result.getBoolean("estDisponibleMercredi"));
                medecin.setEstDisponibleJeudi(result.getBoolean("estDisponibleJeudi"));
                medecin.setEstDisponibleVendredi(result.getBoolean("estDisponibleVendredi"));
                medecin.setEstDisponibleSamedi(result.getBoolean("estDisponibleSamedi"));
                medecin.setEstDisponibleDimanche(result.getBoolean("estDisponibleDimanche"));
                medecin.setSpecialisation_id(result.getInt("specialisation_id"));
                medecin.setClinique_id(result.getInt("clinique_id"));
                
                

            };
        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return medecin;
    }

    @Override
    public Medecin findByaddresseRue(String addresseRue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Medecin existsByEmailAndPassword(String email, String motDePasse) {
        Medecin medecin = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_CONNEXION_PAR_EMAIL_AND_PASSWORD);
            // on initialise la propriété email du bean avec sa premiere valeur
            ps.setString(1, email);
            ps.setString(2, motDePasse);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                medecin = new Medecin();
                
                medecin.setNom(result.getString("nom"));
                medecin.setPrenom(result.getString("prenom"));
                
            };
        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return medecin;
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(Medecin medecin) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT_MEDECIN);
            //   Insérer les données dans la table parente, utilisateurs
            ps.setInt(1, medecin.getId());
            ps.setString(2, medecin.getNom());
            ps.setString(3, medecin.getPrenom());
            ps.setInt(4, medecin.getNumeroMedecin());
            ps.setString(5, medecin.getEmail());

            ps.setString(6, medecin.getMotdepasse());
            ps.setInt(7, (int) medecin.getAppointmentPrice());
            ps.setBoolean(8, medecin.isEstDisponibleLundi());
            ps.setBoolean(9, medecin.isEstDisponibleMardi());
            ps.setBoolean(10, medecin.isEstDisponibleMercredi());
            ps.setBoolean(11, medecin.isEstDisponibleJeudi());
            ps.setBoolean(12, medecin.isEstDisponibleVendredi());
            ps.setBoolean(13, medecin.isEstDisponibleSamedi());
            ps.setBoolean(14, medecin.isEstDisponibleDimanche());
            
            ps.setInt(15, medecin.getSpecialisation_id());
            ps.setInt(16, medecin.getClinique_id());
            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(CliniqueImpDAO.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean update(Medecin medecin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
