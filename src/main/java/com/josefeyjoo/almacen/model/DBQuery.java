/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.josefeyjoo.almacen.model;

import com.josefeyjoo.almacen.model.entity.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jojo
 */
public class DBQuery {
    private DBConn con = new DBConn();
    
    //Metodo CREATE, crea el cliente en la base de datos
    public void crearCliente(Cliente cli) throws SQLException{
        String consulta = 
            """
            INSERT INTO clientes (codigo, nif, apellidos, nombre, domicilio, codigo_postal, localidad, telefono, movil, fax, email, total_ventas)
            VALUES (?,?,?,?,?,?,?,?,?,?,?,?)
            """;
        try (Connection conn = con.getConn()){
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, cli.getCodigo());
            stm.setString(2, cli.getNif());
            stm.setString(3, cli.getApellidos());
            stm.setString(4, cli.getNombre());
            stm.setString(5, cli.getDomicilio());
            stm.setString(6, cli.getCodigoPostal());
            stm.setString(7, cli.getLocalidad());
            stm.setString(8, cli.getTelefono());
            stm.setString(9, cli.getMovil());
            stm.setString(10, cli.getFax());
            stm.setString(11, cli.getEmail());
            stm.setFloat(12, cli.getTotalVentas());
            stm.execute();             
        }
    }
    
    //Método READ, devuelve el cliente en base al código
    public Cliente consultaClientePorCodigo(String codigo) throws SQLException{
        String consulta = """
                          SELECT codigo, nif, apellidos, nombre, domicilio, codigo_postal, localidad, telefono, movil, fax, email, total_ventas 
                          FROM clientes WHERE codigo = ?
                          """;
        try (Connection conn = con.getConn()){
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, codigo);
            
            return getCliente(stm.executeQuery());
        } 
    }
    
    //Método UPDATE, actualiza el cliente seleccionado, introduciendo el código del cliente
    public void updateCliente(Cliente cli, String codigo) throws SQLException{
        String consulta = """
                          UPDATE clientes SET codigo = ?, nif = ?, 
                          apellidos = ?, nombre = ?, domicilio = ?,
                          codigo_postal = ?, localidad = ?, telefono = ?,
                          movil = ?, fax = ?, email = ?, total_ventas = ?
                          WHERE codigo = ?
                          """;
        try (Connection conn = con.getConn()){
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, cli.getCodigo());
            stm.setString(2, cli.getNif());
            stm.setString(3, cli.getApellidos());
            stm.setString(4, cli.getNombre());
            stm.setString(5, cli.getDomicilio());
            stm.setString(6, cli.getCodigoPostal());
            stm.setString(7, cli.getLocalidad());
            stm.setString(8, cli.getTelefono());
            stm.setString(9, cli.getMovil());
            stm.setString(10, cli.getFax());
            stm.setString(11, cli.getEmail());
            stm.setFloat(12, cli.getTotalVentas());
            stm.setString(13, codigo);           
            stm.executeUpdate();
        }
    }
    
    //Método DELETE, borra el cliente en función del código
    public void deleteCliente(String codigo) throws SQLException {
        String consulta = 
            """
            DELETE FROM clientes WHERE codigo = ?
            """;
        try (Connection conn = con.getConn()){
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, codigo);
            stm.execute();
        } 
        
    }
    
    //Método privado, devuelve un cliente en base al ResultSet
    private Cliente getCliente(ResultSet rs) throws SQLException{
        Cliente cli = new Cliente();
        if (rs.next()){    
            cli.setCodigo(rs.getString("codigo"));
            cli.setNif(rs.getString("nif"));
            cli.setApellidos(rs.getString("apellidos"));
            cli.setNombre(rs.getString("nombre"));
            cli.setDomicilio(rs.getString("domicilio"));
            cli.setCodigoPostal(rs.getString("codigo_postal"));
            cli.setLocalidad(rs.getString("localidad"));
            cli.setTelefono(rs.getString("telefono"));
            cli.setMovil(rs.getString("movil"));
            cli.setFax(rs.getString("fax"));
            cli.setEmail(rs.getString("email"));
            cli.setTotalVentas(rs.getFloat("total_ventas"));
        } else {
            return null;
        }
        return cli;
    }
}
