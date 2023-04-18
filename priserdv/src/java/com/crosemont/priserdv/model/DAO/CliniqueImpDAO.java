/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crosemont.priserdv.model.DAO;

import com.crosemont.priserdv.model.entities.Clinique;
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
public class CliniqueImpDAO implements CliniqueDAO{
    
    private static final String SQL_SELECT_CLINIQUE = "select * from clinique";
    private static final String SQL_SELECT_CLINIQUE_PAR_ID = "select * from clinique where id = ?";
    private static final String SQL_SELECT_CLINIQUE_PAR_NOM = "select * from clinique where nomClinique = ?";
    private static final String SQL_SELECT_CLINIQUE_PAR_EMAIL = "select * from clinique where email = ?";
    private static final String SQL_SELECT_CLINIQUE_PAR_ADDRESSERUE = "select * from clinique where adresseRue = ?";
    private static final String SQL_CONNEXION_PAR_EMAIL_AND_PASSWORD = "select nomClinique, adresseRue from clinique where email=? and motdepasse=?";
    private static final String SQL_INSERT_CLINIQUE="insert into clinique(id,email,motdepasse,nomClinique,adresseRue,zip,pays,ville,province) value(?,?,?,?,?,?,?,?,?)";
    @Override
    public List<Clinique> findAll() {
        
        List<Clinique> list = null;
        

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            
        try {
            PreparedStatement ps;
            ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_CLINIQUE);
            
            System.out.println(" result : " + ps.toString());
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
               
            list = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                Clinique clinique = new Clinique();
                 System.out.println(" result : " + result.getString("email"));
                clinique.setId(result.getInt("id"));
                clinique.setEmail(result.getString("email"));
                clinique.setMotdepasse(result.getString("motdepasse"));
                clinique.setNomClinique(result.getString("nomClinique"));
                clinique.setAddresseRue(result.getString("adresseRue"));
                clinique.setZip(result.getString("zip"));
                clinique.setPays(result.getString("pays"));
                clinique.setVille(result.getString("ville"));
                clinique.setProvince(result.getString("province"));
                list.add(clinique);
            };
        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return list;
    }

    @Override
    public Clinique findById(int id) {
        Clinique clinique = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_CLINIQUE_PAR_ID);
            // on initialise la propriété id du bean avec sa valeur
            ps.setInt(1, id);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                clinique = new Clinique();
                 System.out.println(" result : " + result.getString("email"));
                clinique.setId(result.getInt("id"));
                clinique.setEmail(result.getString("email"));
                clinique.setMotdepasse(result.getString("motdepasse"));
                clinique.setNomClinique(result.getString("nomClinique"));
                clinique.setAddresseRue(result.getString("adresseRue"));
                clinique.setZip(result.getString("zip"));
                clinique.setPays(result.getString("pays"));
                clinique.setVille(result.getString("ville"));
                clinique.setProvince(result.getString("province"));
                

            };
        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return clinique;
    }

    @Override
    public Clinique findByName(String nom) {
        Clinique clinique = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_CLINIQUE_PAR_NOM);
            // on initialise la propriété nom du bean avec sa premiere valeur
            ps.setString(1, nom);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                clinique = new Clinique();
                 System.out.println(" result : " + result.getString("email"));
                clinique.setId(result.getInt("id"));
                clinique.setEmail(result.getString("email"));
                clinique.setMotdepasse(result.getString("motdepasse"));
                clinique.setNomClinique(result.getString("nomClinique"));
                clinique.setAddresseRue(result.getString("adresseRue"));
                clinique.setZip(result.getString("zip"));
                clinique.setPays(result.getString("pays"));
                clinique.setVille(result.getString("ville"));
                clinique.setProvince(result.getString("province"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return clinique;
    }

    @Override
    public Clinique findByEmail(String email) {
        Clinique clinique = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_CLINIQUE_PAR_EMAIL);
            // on initialise la propriété email du bean avec sa premiere valeur
            ps.setString(1, email);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                clinique = new Clinique();
                 System.out.println(" result : " + result.getString("email"));
                clinique.setId(result.getInt("id"));
                clinique.setEmail(result.getString("email"));
                clinique.setMotdepasse(result.getString("motdepasse"));
                clinique.setNomClinique(result.getString("nomClinique"));
                clinique.setAddresseRue(result.getString("adresseRue"));
                clinique.setZip(result.getString("zip"));
                clinique.setPays(result.getString("pays"));
                clinique.setVille(result.getString("ville"));
                clinique.setProvince(result.getString("province"));

            };
        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return clinique;
    }

    @Override
    public Clinique findByaddresseRue(String addresseRue) {
        Clinique clinique = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_CLINIQUE_PAR_ADDRESSERUE);
            // on initialise la propriété email du bean avec sa premiere valeur
            ps.setString(1, addresseRue);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                clinique = new Clinique();
                 System.out.println(" result : " + result.getString("email"));
                clinique.setId(result.getInt("id"));
                clinique.setEmail(result.getString("email"));
                clinique.setMotdepasse(result.getString("motdepasse"));
                clinique.setNomClinique(result.getString("nomClinique"));
                clinique.setAddresseRue(result.getString("adresseRue"));
                clinique.setZip(result.getString("zip"));
                clinique.setPays(result.getString("pays"));
                clinique.setVille(result.getString("ville"));
                clinique.setProvince(result.getString("province"));

            };
        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return clinique;
    }

    @Override
    public Clinique existsByEmailAndPassword(String email, String motDePasse) {
        Clinique clinique = null;
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
                clinique = new Clinique();
                
                clinique.setNomClinique(result.getString("nomClinique"));
                clinique.setAddresseRue(result.getString("adresseRue"));
                
            };
        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return clinique;
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(Clinique clinique) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT_CLINIQUE);
            //   Insérer les données dans la table parente, utilisateurs
            ps.setInt(1, clinique.getId());
            ps.setString(2, clinique.getEmail());
            ps.setString(3, clinique.getMotdepasse());
            ps.setString(4, clinique.getNomClinique());
            ps.setString(5, clinique.getAddresseRue());

            ps.setString(6, clinique.getZip());
            ps.setString(7, clinique.getPays());
            ps.setString(8, clinique.getVille());
            ps.setString(9, clinique.getProvince());
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
    public boolean update(Clinique clinique) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
