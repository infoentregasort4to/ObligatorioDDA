package controlador;

import modelo.Fachada;

public class ControladorSeleccionArea
{
    private VistaSeleccionArea vista;
    private Fachada ff= Fachada.getInstancia();
    
    public ControladorSeleccionArea(VistaSeleccionArea vista)
    {
        this.vista=vista;
        vista.MostrarAreas(ff.getAreas());
    }
}
