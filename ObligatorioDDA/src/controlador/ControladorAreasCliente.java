/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Fachada;



/**
 *
 * @author sebaa
 */
public class ControladorAreasCliente  {

    private VistaAreasCliente vista;
    private Fachada ff= Fachada.getInstancia();
    
    public ControladorAreasCliente(VistaAreasCliente vista){
        this.vista=vista;
        vista.MostrarAreas(ff.getAreas());
    }
    
    
    
}
