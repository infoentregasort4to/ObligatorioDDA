
package controlador;

import java.util.ArrayList;
import modelo.Area;
import modelo.Cliente;
import modelo.Fachada;
import modelo.Sector;


public class ControladorPedirNumero {
    private Fachada ff= Fachada.getInstancia();
    private VistaPedirNumero vista;
    private Area a;
    
    public ControladorPedirNumero(VistaPedirNumero vista, Area a){
        this.vista=vista;
        this.a=a;
        ArrayList<Area> areas= ff.getAreas();
        vista.MostrarSectores(a.getSectores());
    }
    public void crearAtencion(String ci,Sector s){
        Cliente c= ff.getCliente(ci);
        ff.crearAtencion(c,this.a,s);
    }
    
}
