package controlador;

import java.util.ArrayList;
import modelo.Atencion;

public interface IMonitorCliente
{
    public void mostrarAtenciones(ArrayList<Atencion> a);
    public void mostrarTiempos(ArrayList<String> tiempos);
}
