package controlador;

import modelo.Area;
import modelo.Atencion;
import modelo.AtencionException;
import modelo.Cliente;
import modelo.Fachada;
import modelo.Sector;

public class ControladorSacarNumero
{
    private Fachada ff = Fachada.getInstancia();
    private ISacarNumero vista;
    private Area a;

    public ControladorSacarNumero(ISacarNumero vista, Area a)
    {
        this.vista = vista;
        this.a = a;
        vista.MostrarSectores(a.getSectores());
    }

    public void crearAtencion(String ci, Sector s)
    {
        try
        {
            if (ff.atencionesPendientes().isEmpty())
            {
                altaAtencion(ci, s);
                vista.LimpiarValores();
            } 
            else if (clienteEnEspera(ci))
            {
                vista.mostrarMensaje("Usted ya tiene una atención en espera.");
            }
            else
            {
                altaAtencion(ci, s);
            }
        }
        catch (AtencionException ae)
        {
            String msg = ae.getMessage();
            vista.mostrarMensaje(msg);
        }
    }

    public void altaAtencion(String ci, Sector s) throws AtencionException
    {
        Cliente c = ff.getCliente(ci);
        Atencion aa = ff.crearAtencion(c, this.a, s);
        if (aa.getPuesto() != null)
        {
            vista.mostrarMensaje("Se le ha asignado el " + aa.getPuesto());
        }
        else
        {
            vista.mostrarMensaje("Su atencion ha quedado en espera");
        }
    }

    private boolean clienteEnEspera(String ci)
    {
        for (Atencion ate : ff.atencionesPendientes())
        {
            if (ate.getCliente().getCi().equals(ci))
            {
                return true;
            }
        }
        return false;
    }
}
