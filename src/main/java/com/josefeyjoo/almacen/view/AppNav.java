/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.josefeyjoo.almacen.view;

import com.josefeyjoo.almacen.view.ui.ClienteFormulario;
import com.josefeyjoo.almacen.view.ui.Home;
import com.josefeyjoo.almacen.model.Repository;
import com.josefeyjoo.almacen.viewmodel.ViewModel;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import javax.swing.JFrame;

/**
 *
 * @author jojo
 */
public class AppNav {
    //HashMap con Identificador, Supplier
    private static final Map<String, Supplier<JFrame>> routes = new HashMap<>();
    public static final ViewModel vm = new ViewModel(new Repository());
    
    //Creación de las rutas
    static {
        routes.put("HOME", () -> new Home(vm));
        routes.put("CLIENTES", () -> new ClienteFormulario(vm));
    }
    
    //This will be executed once, at the start of the Progra
    public static void start(){
        Supplier<JFrame> frame = routes.get("HOME");
        JFrame next = frame.get();
        next.setLocationRelativeTo(null);
        next.setVisible(true);
    }
    
    public static void navigate(JFrame currentFrame, JFrame nextFrame){
        nextFrame.setLocationRelativeTo(null);
        nextFrame.setVisible(true);
        currentFrame.dispose();
    }
    
    public static void navigate(JFrame current, String identifier){
        Supplier<JFrame> frameSupplier = routes.get(identifier);
        JFrame next = frameSupplier.get();
        next.setLocationRelativeTo(null);
        next.setVisible(true);
        current.dispose();
    }
}
