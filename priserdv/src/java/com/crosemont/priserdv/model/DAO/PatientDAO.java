/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crosemont.priserdv.model.DAO;

import com.crosemont.priserdv.model.entities.Patient;
import java.util.List;

/**
 *
 * @author Giguere julien
 */
public interface PatientDAO {
    List<Patient> findAll();

    Patient findById(int id);

    boolean create(Patient patient);

    List<Patient> findAllByDoctor(int id);

    boolean delete(int id);

    boolean update(Patient patient);

    Patient isExist(String email, String motDePasse);

    boolean isEmailExist(String email);

    boolean isNAMxist(String nam);
    
    boolean isNumExist(String num);
    public List<Patient> findAllByRendezvousAndMedecinID(int id);
}
