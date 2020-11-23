/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Observador.Observable;
import Observador.Observador;
import java.util.ArrayList;
import modelo.Atencion;
import modelo.Fachada;

/**
 *
 * @author sebaa
 */
public class ControladorMonitorCliente implements Observador {
    private Fachada ff= Fachada.getInstancia();
    private VistaMonitor vista;
    
    public ControladorMonitorCliente(VistaMonitor vista){
        ff.agregar(this);
        this.vista=vista;
        vista.mostrarAtenciones(ff.atencionesEnCurso());
    }
    
    @Override
    public void actualizar(Observable origen, Object evento) {
        if(origen == ff) {
            if(evento.equals(Fachada.Eventos.FinAtencion)||evento.equals(Fachada.Eventos.ComienzoAtencion)) {
                ArrayList<Atencion> a = ff.atencionesEnCurso();
                vista.mostrarAtenciones(a);
            }
        } 
    }
}
