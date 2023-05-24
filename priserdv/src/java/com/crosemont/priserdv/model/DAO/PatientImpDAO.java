/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crosemont.priserdv.model.DAO;

import com.crosemont.priserdv.model.entities.Patient;
import com.crosemont.priserdv.model.singleton.ConnexionBD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giguere julien
 */
public class PatientImpDAO implements PatientDAO {
    
    public List<Patient> findAll() {
        String SQL_SELECT = "select * from patient";
        List<Patient> listePatient = null;
        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT);
            ResultSet result = ps.executeQuery();
            listePatient = new ArrayList<>();

            while (result.next()) {
                Patient patient = new Patient();
                patient.setId(result.getInt("id"));
                patient.setNom(result.getString("nom"));
                patient.setPrenom(result.getString("prenom"));
                patient.setCodeAssuranceMaladie(result.getString("codeAssuranceMaladie"));
                patient.setNumeroAssuranceMaladie(result.getInt("numeroAssuranceMaladie"));
                patient.setDateNaissance(result.getDate("dateNaissance"));
                patient.setSexe(result.getString("sexe"));
                patient.setEmail(result.getString("email"));
                patient.setPassword(result.getString("motdepasse"));
                patient.setAdmin(result.getBoolean("admin"));
                patient.setMedecin_id(result.getInt("medecin_id"));
                listePatient.add(patient);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PatientImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listePatient;
    };

    public List<Patient> findAllByDoctor(int id) {
        String SQL_SELECT_BY_DOCTOR = "select * from patient where medecin_id = ?";
        List<Patient> listePatient = null;
        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_DOCTOR);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            listePatient = new ArrayList<>();

            while (result.next()) {
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(PatientImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listePatient;
    };

    public Patient findById(int id) {
        Patient patient = null;
        try {
            String SQL_SELECT_PAR_ID = "select * from patient where id = ?";
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_ID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                patient = new Patient();
                patient.setId(result.getInt("id"));
                patient.setNom(result.getString("nom"));
                patient.setPrenom(result.getString("prenom"));
                patient.setCodeAssuranceMaladie(result.getString("codeAssuranceMaladie"));
                patient.setNumeroAssuranceMaladie(result.getInt("numeroAssuranceMaladie"));
                patient.setDateNaissance(result.getDate("dateNaissance"));
                patient.setSexe(result.getString("sexe"));
                patient.setEmail(result.getString("email"));
                patient.setPassword(result.getString("motdepasse"));
                patient.setAdmin(result.getBoolean("admin"));
                patient.setMedecin_id(result.getInt("medecin_id"));
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(PatientImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return patient;
    };

    public boolean create(Patient patient){
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            String SQL_INSERT = "insert into patient(nom,prenom,codeAssuranceMaladie,numeroAssuranceMaladie,dateNaissance,sexe,email,motdepasse,admin,medecin_id) value(?,?,?,?,?,?,?,?,?,?)";
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT);

            ps.setString(1, patient.getNom());
            ps.setString(2, patient.getPrenom());
            ps.setString(3, patient.getCodeAssuranceMaladie());
            ps.setInt(4, patient.getNumeroAssuranceMaladie());
            ps.setDate(5, (Date) patient.getDateNaissance());
            ps.setString(6, patient.getSexe());
            ps.setString(7, patient.getEmail());
            ps.setString(8, patient.getPassword());
            ps.setBoolean(9, patient.getAdmin());
            if (patient.getMedecin_id() != 0 ) {
                ps.setInt(10, patient.getMedecin_id());
            } else {
                ps.setNull(10, java.sql.Types.NULL);
            }


            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(PatientImpDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    };

    public boolean delete(int id){
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            String SQL_DELETE = "delete from patient where id = ?";
            ps = ConnexionBD.getConnection().prepareStatement(SQL_DELETE);
            ps.setInt(1, id);

            nbLigne = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    };

    public boolean update(Patient patient){
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            String SQL_UPDATE = "update patient set nom =?, prenom =?, codeAssuranceMaladie = ?,numeroAssuranceMaladie =?, dateNaissance = ?,sexe =? ,email =?,motdepasse = ?, doctor_id = ? where id = ?";
            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE);

		ps.setString(1, patient.getNom());
            ps.setString(2, patient.getPrenom());
            ps.setString(3, patient.getCodeAssuranceMaladie());
            ps.setInt(4, patient.getNumeroAssuranceMaladie());
            ps.setDate(5, (Date) patient.getDateNaissance());
            ps.setString(6, patient.getSexe());
            ps.setString(7, patient.getEmail());
            ps.setString(8, patient.getPassword());
            ps.setInt(10, patient.getMedecin_id());
		ps.setInt(10, patient.getId());

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(PatientImpDAO.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    };

    public Patient isExist(String email, String motDePasse){
        Patient patient = null;

        try {
            String SQL_CONNEXION_PAR_EMAIL_AND_PASSWORD = "select * from patient where email=? and motdepasse=?";
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_CONNEXION_PAR_EMAIL_AND_PASSWORD);
            ps.setString(1, email);
            ps.setString(2, motDePasse);
            //On execute la requête et on récupère les résultats dans la requête
            // dans ResultSet
            ResultSet result = ps.executeQuery();
            //on parcours ligne par ligne les resultats retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                patient = new Patient();
                patient.setId(result.getInt("id"));
                patient.setNom(result.getString("nom"));
                patient.setPrenom(result.getString("prenom"));
                patient.setCodeAssuranceMaladie(result.getString("codeAssuranceMaladie"));
                patient.setNumeroAssuranceMaladie(result.getInt("numeroAssuranceMaladie"));
                patient.setDateNaissance(result.getDate("dateNaissance"));
                patient.setSexe(result.getString("sexe"));
                patient.setEmail(result.getString("email"));
                patient.setPassword(result.getString("motdepasse"));
                patient.setAdmin(result.getBoolean("admin"));
                patient.setMedecin_id(result.getInt("medecin_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionBD.closeConnection();
        return patient;
    };

    //@Override
    public boolean isEmailExist(String email) {
        boolean isExist = false;

        try {
            String SQL_CONNEXION_PAR_EMAIL = "select * from patient where email=?";
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_CONNEXION_PAR_EMAIL);
            ps.setString(1, email);
            //On execute la requête et on récupère les résultats dans la requête
            // dans ResultSet
            ResultSet result = ps.executeQuery();
            //on parcours ligne par ligne les resultats retournés
            while (result.next()) {
                isExist = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PatientImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionBD.closeConnection();
        return isExist;
    }

    //@Override
    public boolean isNAMxist(String nam) {
        boolean isExist = false;

        try {
            String SQL_CONNEXION_PAR_NAM = "select * from patient where codeAssuranceMaladie=?";
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_CONNEXION_PAR_NAM);
            ps.setString(1, nam);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                isExist = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PatientImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionBD.closeConnection();
        return isExist;
    }

    @Override
    public boolean isNumExist(String num) {
        boolean isExist = false;

        try {
            String SQL_CONNEXION_PAR_CODE = "select * from patient where codeAssuranceMaladie=?";
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_CONNEXION_PAR_CODE);
            ps.setString(1, num);
            //On execute la requête et on récupère les résultats dans la requête
            // dans ResultSet
            ResultSet result = ps.executeQuery();
            //on parcours ligne par ligne les resultats retournés
            while (result.next()) {
                isExist = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PatientImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionBD.closeConnection();
        return isExist;
    }

}
