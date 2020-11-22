/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Observador.Observable;
import Observador.Observador;
import java.util.ArrayList;
import javax.swing.JDialog;
import modelo.Fachada;
import modelo.Puesto;
import modelo.Sector;
import modelo.Trabajador;
import vista.TrabajadorAtencion;


public class ControladorPuestos {
    
    private Fachada ff=Fachada.getInstancia();
    private VistaPuestos vista;
    private Sector sector;
    private Puesto puesto;
    private Trabajador trabajador;

    public ControladorPuestos(VistaPuestos vista, Trabajador t){
        //ff.agregar(this);
        this.vista=vista;
        this.trabajador=t;
        this.sector = ff.obtenerSectorTrabajador(trabajador);
        vista.mostrarTitulo(sector.toString());
        vista.mostrarPuestos(sector.getPuestosLibres());
    }
    public void asignarPuesto(Puesto p){
        
        ff.asignarPuesto(trabajador, p);
        vista.puestoAsignado(p,trabajador);
        
    }

    
    
    
}
