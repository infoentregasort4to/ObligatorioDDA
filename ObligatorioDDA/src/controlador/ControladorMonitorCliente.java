package controlador;

import Observador.Observable;
import Observador.Observador;
import java.util.ArrayList;
import modelo.Atencion;
import modelo.Fachada;

public class ControladorMonitorCliente implements Observador
{
    private Fachada ff= Fachada.getInstancia();
    private VistaMonitorCliente vista;
    
    public ControladorMonitorCliente(VistaMonitorCliente vista)
    {
        ff.agregar(this);
        this.vista = vista;
        vista.mostrarAtenciones(ff.atencionesEnCurso());
    }
    
    @Override
    public void actualizar(Observable origen, Object evento)
    {
        if(origen == ff)
        {
            if(evento.equals(Fachada.Eventos.FinAtencion)||evento.equals(Fachada.Eventos.ComienzoAtencion))
            {
                ArrayList<Atencion> a = ff.atencionesEnCurso();
                vista.mostrarAtenciones(a);
                vista.mostrarTiempos(ff.tiemposPromediosAtenciones(a));
            }
        } 
    }
}
