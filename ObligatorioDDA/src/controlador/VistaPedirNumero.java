/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Sector;

/**
 *
 * @author sebaa
 */
public interface VistaPedirNumero {
    public void mostrarMensaje(String msg);
    public void MostrarSectores(ArrayList<Sector> sectores);
}
