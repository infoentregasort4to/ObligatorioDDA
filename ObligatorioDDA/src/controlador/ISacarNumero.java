package controlador;

import java.util.ArrayList;
import modelo.Sector;

public interface ISacarNumero
{
    public void mostrarMensaje(String msg);
    public void MostrarSectores(ArrayList<Sector> sectores);
    public void LimpiarValores();
}