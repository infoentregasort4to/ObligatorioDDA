package controlador;

import java.util.ArrayList;
import modelo.Atencion;

public interface VistaMonitorCliente
{
    public void mostrarAtenciones(ArrayList<Atencion> a);
    public void mostrarTiempos(ArrayList<String> tiempos);
}
