package controlador;

import modelo.Fachada;

public class ControladorSeleccionArea
{
    private ISeleccionArea vista;
    private Fachada ff= Fachada.getInstancia();
    
    public ControladorSeleccionArea(ISeleccionArea vista)
    {
        this.vista=vista;
        vista.MostrarAreas(ff.getAreas());
    }
}
