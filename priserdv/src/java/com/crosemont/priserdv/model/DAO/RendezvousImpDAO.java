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
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julien
 */
public class RendezvousImpDAO implements RendezvousDAO{

    private static final String SQL_INSERT_RENDEZVOUS= "insert into rendezvous(id,heure,raison,precision,patient_id,medecin_id) value(?,?,?,?,?,?)";
    
    @Override
    public List<Rendezvous> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public List<Rendezvous> findByMedecinIdAndAujourdhui(int numero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rendezvous> findByMedecinIdAndSemaine(int numero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(Rendezvous rendezvous) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT_RENDEZVOUS);
            //   Insérer les données dans la table rendezvous
            ps.setInt(1, rendezvous.getId());
            Date sqlDate = new java.sql.Date(rendezvous.getHeure().getTime());
            ps.setDate(2, sqlDate );
            ps.setNull(3, java.sql.Types.NULL);
            ps.setNull(4, java.sql.Types.NULL);
            ps.setNull(5, java.sql.Types.NULL);
            ps.setInt(6, rendezvous.getMedecin_id());

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
