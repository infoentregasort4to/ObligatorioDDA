/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Puesto;
import modelo.Trabajador;

/**
 *
 * @author sebaa
 */
public interface VistaPuestos {
    public void mostrarPuestos(ArrayList<Puesto> p);
    public void puestoAsignado(Puesto p,Trabajador t);
    public void mostrarTitulo(String s);
    public void mostrarError(String msg);
}
