package controlador;

import java.util.ArrayList;
import modelo.Puesto;
import modelo.Trabajador;

public interface ISeleccionPuesto
{
    public void mostrarPuestos(ArrayList<Puesto> p);
    public void puestoAsignado(Puesto p,Trabajador t);
    public void mostrarTitulo(String s);
    public void mostrarError(String msg);
}