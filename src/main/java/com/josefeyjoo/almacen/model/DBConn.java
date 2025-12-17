/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.josefeyjoo.almacen.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jojo
 */
public class DBConn {
    final String URL = "jdbc:postgresql://localhost:5432/aprendizaje?currentSchema=almacen";
    final String USER = "alumno";
    final String PWD = "alumno";
    
    public Connection getConn() throws SQLException{
        return DriverManager.getConnection(URL, USER, PWD);
    }
}
