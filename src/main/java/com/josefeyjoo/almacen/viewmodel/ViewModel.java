/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.josefeyjoo.almacen.viewmodel;

import com.josefeyjoo.almacen.model.DBQuery;
import com.josefeyjoo.almacen.model.Repository;
import com.josefeyjoo.almacen.model.entity.Articulo;
import com.josefeyjoo.almacen.model.entity.Cliente;
import com.josefeyjoo.almacen.model.entity.Proveedores;
import java.sql.SQLException;

/**
 *
 * @author jojo
 */
public class ViewModel {
    private Cliente uiCliente;
    private Proveedores uiProveedores;
    private Articulo uiArticulo;
    private String codigo;
    private Repository repo;

    public ViewModel(Repository repo) {
        this.repo = repo;
    }

    public Cliente getUiCliente() {
        return uiCliente;
    }

    public void setUiCliente(Cliente uiCliente) {
        this.uiCliente = uiCliente;
    }

    public Proveedores getUiProveedores() {
        return uiProveedores;
    }

    public void setUiProveedores(Proveedores uiProveedores) {
        this.uiProveedores = uiProveedores;
    }

    public Articulo getUiArticulo() {
        return uiArticulo;
    }

    public void setUiArticulo(Articulo uiArticulo) {
        this.uiArticulo = uiArticulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Repository getRepo() {
        return repo;
    }

    public void setRepo(Repository repo) {
        this.repo = repo;
    }
    
    public Cliente consultaCliente() throws SQLException{
        return repo.getDbquery().consultaClientePorCodigo(codigo);
    
    }
    
    public void updateCliente() throws SQLException{
        repo.getDbquery().updateCliente(uiCliente);
    }
    
    
    
    
}
