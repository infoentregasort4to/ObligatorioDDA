package controlador;

import Observador.Observable;
import Observador.Observador;
import java.util.ArrayList;
import modelo.Atencion;
import modelo.Fachada;

public class ControladorMonitorTrabajador implements Observador
{
    private Fachada ff= Fachada.getInstancia();
    private IMonitorTrabajador vista;
    
    public ControladorMonitorTrabajador(IMonitorTrabajador vista)
    {
        ff.agregar(this);
        this.vista=vista;
        ArrayList<Atencion> a = ff.atencionesPendientes();
        vista.mostrarAtenciones(a);
        vista.mostrarTiempos(this.mostrarTiempos(a));
    }
    
    public ArrayList<String> mostrarTiempos( ArrayList<Atencion> atenciones)
    {
        ArrayList<String> aux = new ArrayList();
        
        for(Atencion aa: atenciones)
        {
            long tiempo = ff.calcularTiempoPromedioPuesto(aa.getPuesto());            
            aux.add(Long.toString(tiempo));
        }
        
        return aux; 
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
                vista.mostrarTiempos(this.mostrarTiempos(a));
            }
        }   
    }    
}
