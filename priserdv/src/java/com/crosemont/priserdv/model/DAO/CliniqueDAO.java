/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crosemont.priserdv.model.config.DAO;

import com.crosemont.priserdv.model.entities.Clinique;
import java.util.List;

/**
 *
 * @author mfate
 */
public interface CliniqueDAO {
    List<Clinique> findAll();
    Clinique findById(int id);
    Clinique findByName(String nom);
    Clinique findByEmail(String email);
    Clinique findByaddresseRue(String addresseRue);
    //List<Role> findAllRole();
    Clinique existsByEmailAndPassword(String email, String motDePasse);
    boolean delete(int id);
    boolean create(Clinique clinique);
    //boolean create(Clinique clinique, String nomRole);
    boolean update(Clinique clinique);
    
}
