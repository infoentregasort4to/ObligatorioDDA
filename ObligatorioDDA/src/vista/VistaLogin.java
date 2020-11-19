/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorLogin;
import java.awt.Frame;
import modelo.Fachada;
import modelo.Trabajador;


public class VistaLogin extends Login {
    
    private Fachada ff = modelo.Fachada.getInstancia();
    private ControladorLogin controlador;
    
    
    public VistaLogin(Frame parent, boolean modal) {
        super(parent, modal);
        controlador= new ControladorLogin(this);
    }

    @Override
    public void Ingresar(Object t) {
        dispose();
        new Puestos(null, false,(Trabajador)t).setVisible(true);
    }

    @Override
    public String generarTitulo() {
        return "Login";
    }

    @Override
    public void llamarLogin(String nom, String pass) {
        controlador.login(nom,pass);
    }

    
}
