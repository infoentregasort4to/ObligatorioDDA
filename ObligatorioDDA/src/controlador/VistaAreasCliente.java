/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Area;

/**
 *
 * @author sebaa
 */
public interface VistaAreasCliente {
    
    public void MostrarAreas(ArrayList<Area> a);
    public void Siguiente(Object a);
}
