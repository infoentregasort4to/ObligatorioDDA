package controlador;

import java.util.ArrayList;
import modelo.Sector;

public interface VistaPedirNumero
{
    public void mostrarMensaje(String msg);
    public void mostrarSectores(ArrayList<Sector> sectores);
    public void mostrarTiempos(ArrayList<String> t);
    public void CerrarVentana();
}