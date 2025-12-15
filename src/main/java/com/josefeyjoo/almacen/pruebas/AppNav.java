/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.josefeyjoo.almacen.pruebas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import javax.swing.JFrame;

/**
 *
 * @author jojo
 */
public class AppNav {
    private static final Map<String, Supplier<JFrame>> routes = new HashMap<>();
    
    static {
        routes.put("VEN1", () -> new Ventana1());
        routes.put("VEN2", Ventana2::new);
    }
    
    public static void start(){
        Supplier<JFrame> frame = routes.get("VEN1");
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
