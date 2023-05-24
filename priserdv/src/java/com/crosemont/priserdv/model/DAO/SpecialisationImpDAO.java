/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crosemont.priserdv.model.DAO;

import com.crosemont.priserdv.model.entities.Specialisation;
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
 * @author Giguere
 */
public class SpecialisationImpDAO implements SpecialisationDAO{

    
    private static final String SQL_SELECT_SPECIALISATION = "select * from specialisation";
    
    @Override
    public List<Specialisation> findAll() {
        List<Specialisation> list = null;
            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
        try {
            PreparedStatement ps;
            ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_SPECIALISATION);
            
            System.out.println(" result : " + ps.toString());
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
               
            list = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                Specialisation specialisation = new Specialisation();
                 System.out.println(" result : " + result.getInt("id"));
                specialisation.setId(result.getInt("id"));
                specialisation.setTitre(result.getString("titreSpecialisation"));

                list.add(specialisation);
            };
        } catch (SQLException ex) {
            Logger.getLogger(RendezvousImpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return list;
    }

    @Override
    public Specialisation findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Specialisation findByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(Specialisation specialisation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Specialisation specialisation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
