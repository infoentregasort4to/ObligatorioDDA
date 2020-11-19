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
import vista.VistaAtencion;


public class ControladorPuestos implements Observador {
    
    private Fachada ff=Fachada.getInstancia();
    private VistaPuestos vista;
    private Sector sector;
    private Puesto puesto;
    private Trabajador trabajador;

    public ControladorPuestos(VistaPuestos vista, Trabajador t){
        ff.agregar(this);
        this.vista=vista;
        this.trabajador=t;
        this.sector = ff.obtenerSector(trabajador);
        ArrayList<Puesto> puestos=sector.getPuestos();
        vista.mostrarPuestos(puestos);
    }
    public void asignarPuesto(Puesto p){
        
        ff.asignarPuesto(trabajador, p);
        JDialog atencion = new VistaAtencion(null, false,p);
        
        atencion.setVisible(true);       
        atencion.setLocationRelativeTo(null);
        vista.puestoAsignado(p);
    }
    
    
    
    @Override
    public void actualizar(Observable origen, Object evento) {
        if(evento.equals(Fachada.Eventos.PuestoDisponible)){//ACA ESTA IMPLEMENTADO POR EL PUESTO, ACCEDO AL ENUM POR LA CLASE PUESTO
                                //SI LO ESTOY HACIENDO POR FACHADA SERIA FACHADA.EVENTOS.PUESTODISPONIBLE
           
           ff.asignarAtencion(puesto);
        }
    }
    
}
