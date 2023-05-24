/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crosemont.priserdv.model.DAO;

import com.crosemont.priserdv.model.entities.Specialisation;
import java.util.List;

/**
 *
 * @author Giguere Julien
 */
public interface SpecialisationDAO {
    List<Specialisation> findAll();
    Specialisation findById(int id);
    Specialisation findByName(String nom);
    
    boolean delete(int id);
    boolean create(Specialisation specialisation);
    boolean update(Specialisation specialisation);
}
