package controlador;

import modelo.Fachada;
import modelo.Puesto;
import modelo.Sector;
import modelo.Trabajador;


public class ControladorSeleccionPuesto
{    
    private Fachada ff=Fachada.getInstancia();
    private VistaSeleccionPuesto vista;
    private Sector sector;
    private Trabajador trabajador;

    public ControladorSeleccionPuesto(VistaSeleccionPuesto vista, Trabajador t)
    {
        this.vista=vista;
        this.trabajador=t;
        this.sector = ff.obtenerSectorTrabajador(trabajador);
        vista.mostrarTitulo(sector.toString());
        vista.mostrarPuestos(sector.getPuestosLibres());
    }
    
    public void asignarPuesto(Puesto p)
    {        
        ff.asignarPuesto(trabajador, p);
        vista.puestoAsignado(p,trabajador);        
    }    
}
