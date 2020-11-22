/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Observador.Observable;
import Observador.Observador;
import java.util.ArrayList;
import modelo.Area;
import modelo.Atencion;
import modelo.Fachada;
import modelo.Puesto;
import modelo.Sector;
import modelo.Trabajador;

/**
 *
 * @author sebaa
 */
public class ControladorTrabajadorAtencion implements Observador {
    
    private VistaTrabajadorAtencion vista;
    private Fachada ff= Fachada.getInstancia();
    
    private Sector sector;
    private Puesto p;
    private Area aa;
    private int cont; // de atenciones
    private float tiempoA;
    
    public ControladorTrabajadorAtencion(VistaTrabajadorAtencion vista,Puesto p,Trabajador t){
        this.vista=vista;
        this.p=p;
        ff.agregar(this);        
        this.sector=ff.obtenerSectorTrabajador(t);         
        this.aa = ff.obtenerAreaSector(this.sector);
        
        vista.mostrarAtencion(buscarAtencionPendiente());
        vista.mostrarTitulo(t.toString());
        vista.mostrarInfo(mostrarInfo());
        
    }
    
    public Atencion buscarAtencionPendiente(){
        Atencion a= ff.buscarAtencionPendiente(sector);
        if(a!=null){            
            ff.comenzarAtencion(a,p);
        }
        return a;
    }
    
    @Override
    public void actualizar(Observable origen, Object evento) {
       if(origen == ff) {
            if(evento.equals(Fachada.Eventos.ComienzoAtencion)) {
                Atencion a= ff.obtenerAtencionPuesto(this.p);
                vista.mostrarAtencion(a);                
                this.cont++;
                this.tiempoA = ff.calcularTiempoPromedioPuesto(this.p);
                vista.mostrarInfo(mostrarInfo());
            }        
        }
    }
    
    public void logout()
    {
        this.p.logout();
    }
    
    public String mostrarInfo()
    {   
        String info = this.p + "Area: " + this.aa + " Sector: " + this.sector + " Cant. Atenciones: " + this.cont + " Tiempo Promedio Atencion: " + this.tiempoA;        
        return info;
    }
    
}
