/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crosemont.priserdv.model.config;

/**
 *
 * @author Giguere julien
 */
public interface ConfigBD {
    public final static String URL = "jdbc:mysql://127.0.0.1:3306/priserdv?serverTimezone=UTC&allowPublickeyRetrieval=true&useSSL=false";
    //utilisateur de la bd
    public final static String USER = "mfatene";
    public final static String PASSWORD = "root";
    //le driver mysql
    public final static String DRIVER ="com.mysql.cj.jdbc.Driver";
}
