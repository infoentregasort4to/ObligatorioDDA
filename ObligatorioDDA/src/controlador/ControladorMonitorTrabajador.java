package controlador;

import Observador.Observable;
import Observador.Observador;
import java.util.ArrayList;
import modelo.Atencion;
import modelo.Fachada;

public class ControladorMonitorTrabajador implements Observador
{
    private Fachada ff= Fachada.getInstancia();
    private IMonitor vista;
    
    public ControladorMonitorTrabajador(IMonitor vista)
    {
        ff.agregar(this);
        this.vista=vista;
        vista.mostrarAtenciones(ff.atencionesPendientes());
    }
    
    @Override
    public void actualizar(Observable origen, Object evento)
    {
        if(origen == ff)
        {
            if(evento.equals(Fachada.Eventos.NuevaAtencion)||evento.equals(Fachada.Eventos.ComienzoAtencion))
            {
                ArrayList<Atencion> a = ff.atencionesPendientes();
                vista.mostrarAtenciones(a);
            }
        }   
    }    
}
