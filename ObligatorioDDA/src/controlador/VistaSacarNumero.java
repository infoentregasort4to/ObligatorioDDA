package controlador;

import java.util.ArrayList;
import modelo.Sector;

public interface VistaSacarNumero
{
    public void mostrarMensaje(String msg);
    public void mostrarSectores(ArrayList<Sector> sectores);
    public void limpiarValores();
    public void mostrarTiempos(ArrayList<String> t);
}