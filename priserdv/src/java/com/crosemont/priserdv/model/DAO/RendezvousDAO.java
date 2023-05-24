/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crosemont.priserdv.model.DAO;

import com.crosemont.priserdv.model.entities.Rendezvous;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Giguere julien
 */
public interface RendezvousDAO {
    List<Rendezvous> findAll();
    Rendezvous findById(int id);
    Rendezvous findByHeure(Date date);
    List<Rendezvous> findByMedecinId(int numero);
    List<Rendezvous> findByMedecinIdAndDate(int numero, Date date);
    List<Rendezvous> findByMedecinIdAndSemaine(int numero);
    boolean delete(int id);
    boolean create(Rendezvous rendezvous);
    boolean update(Rendezvous rendezvous);
    boolean updatePatientID(int rdv_id, int patient_id);
}
