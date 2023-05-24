/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crosemont.priserdv.model.DAO;

import com.crosemont.priserdv.model.entities.Rendezvous;
import com.crosemont.priserdv.model.singleton.ConnexionBD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Giguere julien
 */
public class RendezvousImpDAO implements RendezvousDAO{

    private static final String SQL_SELECT_RENDEZVOUS = "select * from rendezvous";
    private static final String SQL_DELETE_RENDEZVOUS_PAR_ID= "delete from rendezvous where id = ?";
    private static final String SQL_INSERT_RENDEZVOUS= "insert into rendezvous(heure,raison,patient_id,medecin_id) value(?,?,?,?)";
    private static final String SQL_SELECT_RENDEZVOUS_PAR_MEDECINID_AND_DATE= "select * from rendezvous where medecin_id = ? and heure BETWEEN ? AND ?"; //and heure < ?
   
    @Override
    public List<Rendezvous> findAll() {
         List<Rendezvous> list = null;
        

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            
        try {
            PreparedStatement ps;
            ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_RENDEZVOUS);
            
            System.out.println(" result : " + ps.toString());
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
               
            list = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                Rendezvous rendezvous = new Rendezvous();
                 System.out.println(" result : " + result.getInt("id"));
                rendezvous.setId(result.getInt("id"));
                Date date=new Date(result.getTimestamp("heure").getTime()); 
                rendezvous.setHeure(date);
                rendezvous.setRaison(result.getString("raison"));
                rendezvous.setPrecision(result.getString("precision"));
                rendezvous.setPatient_id(result.getInt("patient_id"));
                rendezvous.setMedecin_id(result.getInt("medecin_id"));

                list.add(rendezvous);
            };
        } catch (SQLException ex) {
            Logger.getLogger(RendezvousImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return list;
    }


    @Override
    public Rendezvous findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rendezvous findByHeure(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rendezvous> findByMedecinId(int numero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rendezvous> findByMedecinIdAndDate(int numero, Date date) {
         List<Rendezvous> list = null;
        

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            
        try {
            PreparedStatement ps;
            ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_RENDEZVOUS_PAR_MEDECINID_AND_DATE);
            
            String pattern = "yyyy-MM-dd"; // HH:mm:ss
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            ps.setInt(1, numero);
           
            ps.setString(2, simpleDateFormat.format(date) + " 00:00:00");
            ps.setString(3, simpleDateFormat.format(date) + " 23:59:59");

            
            //On execute la requête et on récupère les résultats dans la requête 
            ResultSet result = ps.executeQuery();
               
            list = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                Rendezvous rendezvous = new Rendezvous();
                 System.out.println(" result : " + result.getInt("id"));
                rendezvous.setId(result.getInt("id"));
                Date uneDate=new Date(result.getTimestamp("heure").getTime()); 
                rendezvous.setHeure(uneDate);
                rendezvous.setRaison(result.getString("raison"));
                rendezvous.setPrecision(result.getString("precision"));
                rendezvous.setPatient_id(result.getInt("patient_id"));
                rendezvous.setMedecin_id(result.getInt("medecin_id"));

                list.add(rendezvous);
            };
        } catch (SQLException ex) {
            Logger.getLogger(RendezvousImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return list;
    }

    @Override
    public List<Rendezvous> findByMedecinIdAndSemaine(int numero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_DELETE_RENDEZVOUS_PAR_ID);
            
            ps.setInt(1, id);
            nbLigne = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RendezvousImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean create(Rendezvous rendezvous) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT_RENDEZVOUS);
            //   Insérer les données dans la table rendezvous
            //ps.setInt(1, 2);
            //Date sqlDate = new java.sql.Date(rendezvous.getHeure().getTime());
            Timestamp ts=new Timestamp(rendezvous.getHeure().getTime());  
            ps.setTimestamp(1, ts );
            ps.setString(2, "");
            //ps.setString(3, "null");
            ps.setInt(3, rendezvous.getPatient_id());
            ps.setInt(4, rendezvous.getMedecin_id());

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(RendezvousImpDAO.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean update(Rendezvous rendezvous) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
