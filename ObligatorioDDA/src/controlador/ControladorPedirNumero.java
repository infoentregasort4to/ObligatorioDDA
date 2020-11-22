package controlador;

import java.util.ArrayList;
import modelo.Area;
import modelo.Atencion;
import modelo.AtencionException;
import modelo.Cliente;
import modelo.Fachada;
import modelo.Sector;

public class ControladorPedirNumero {

    private Fachada ff = Fachada.getInstancia();
    private VistaPedirNumero vista;
    private Area a;

    public ControladorPedirNumero(VistaPedirNumero vista, Area a) {
        this.vista = vista;
        this.a = a;
        ArrayList<Area> areas = ff.getAreas();
        vista.MostrarSectores(a.getSectores());
    }

    public void crearAtencion(String ci, Sector s) {
        try {
            if (!ff.atencionesPendientes().isEmpty()) {
                for (Atencion ate : ff.atencionesPendientes()) {
                    if (ate.getCliente().getCi().equals(ci)) {
                        vista.mostrarMensaje("Usted ya tiene una atención en espera.");
                    }
                }
            } else {
                Cliente c = ff.getCliente(ci);
                Atencion aa = ff.crearAtencion(c, this.a, s);
                if (aa.getPuesto() != null) {
                    vista.mostrarMensaje("Se le ha asignado el " + aa.getPuesto());
                } else {
                    vista.mostrarMensaje("Su atencion ha quedado en espera");
                }
            }
        } catch (AtencionException ae) {
            String msg = ae.getMessage();
            vista.mostrarMensaje(msg);
        }
    }

}
