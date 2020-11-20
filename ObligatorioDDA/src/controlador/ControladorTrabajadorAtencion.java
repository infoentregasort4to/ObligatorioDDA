/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Atencion;
import modelo.Fachada;
import modelo.Puesto;
import modelo.Sector;
import modelo.Trabajador;

/**
 *
 * @author sebaa
 */
public class ControladorTrabajadorAtencion {
    
    private VistaTrabajadorAtencion vista;
    private Fachada ff= Fachada.getInstancia();
    private Sector sector;
    private Puesto p;
    
    public ControladorTrabajadorAtencion(VistaTrabajadorAtencion vista,Puesto p,Trabajador t){
        this.vista=vista;
        this.p=p;
        this.sector=ff.obtenerSector(t);
        vista.mostrarAtencion(buscarAtencionPendiente());
    }
    public Atencion buscarAtencionPendiente(){
    
        Atencion a= ff.buscarAtencionPendiente(sector);
        return a;
    
    }
    
    
    
}
