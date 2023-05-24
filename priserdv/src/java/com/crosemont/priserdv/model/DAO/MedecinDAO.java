/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.crosemont.priserdv.model.DAO;

import com.crosemont.priserdv.model.entities.Clinique;
import com.crosemont.priserdv.model.entities.Medecin;
import java.util.List;

/**
 *
 * @author mfate
 */
public interface MedecinDAO {
    List<Medecin> findAll();
    Medecin findById(int id);
    Medecin findByName(String nom);
    Medecin findByNumeroMedecin(int numero);Medecin findByaddresseRue(String addresseRue);
    Medecin existsByEmailAndPassword(String email, String motDePasse);
    boolean delete(int id);
    boolean create(Medecin medecin);
    boolean update(Medecin medecin);
    boolean updatePrix(int medecinID, float prix);
}
