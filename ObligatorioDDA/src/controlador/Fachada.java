package controlador;

import Observador.Observable;
import java.util.ArrayList;
import modelo.Area;
import modelo.Atencion;
import modelo.Cliente;
import modelo.Puesto;
import modelo.Sector;
import modelo.TipoCliente;
import modelo.Trabajador;

public class Fachada extends Observable//UNA OPCION ES QUE LA FACHADA SEA OBSERVABLE Y QUE PASE TODO POR LA FACHADA
{
    private ClienteController clientesC = new ClienteController();
    private TrabajadoresController trabajadoresC = new TrabajadoresController();
    private AreasController areaC = new AreasController();
    private AtencionController atencionC = new AtencionController();
    
    public enum Eventos {PuestoDisponible,NuevaAtencion,ComienzoAtencion,FinAtencion};//EN ESTE CASO LA FACHADA TENDRIA TODOS LOS EVENTOS
    
    private static Fachada cg = new Fachada();

    public static Fachada getInstancia() {
        return cg;
    }
 
    private Fachada()
    {
    }
    //CLIENTES 
    public void agregarTipoCliente(TipoCliente tc)
    {
        clientesC.setTipoCliente(tc);
    } 
    public void agregarCliente(Cliente c)
    {
        clientesC.setCliente(c);
    }
    
    public Cliente getCliente(String ci)
    {
        return clientesC.getCliente(ci);
    }
    //FIN CLIENTES
    
    //TRABAJADORES 
    public void asignarPuesto(Trabajador t,Puesto p){//SI PASO POR FACHADA PARA ASIGNAR EL PUESTO TAMBIEN AVISO POR FACHADA
        avisar(Eventos.PuestoDisponible);
        p.setTrabajador(t);
    }
    public ArrayList<Trabajador> getTrabajadores()
    {
        return trabajadoresC.getTrabajadores();
    }
    
    public Trabajador getTrabajador(String ci)
    {        
       return trabajadoresC.getTrabajador(ci);
    }

    public void agregarTrabajador(Sector s,Trabajador tnuevo)
    {
        
        areaC.agregarTrabajador(s,tnuevo);
    } 
    
    public Trabajador login(String ci, String pwd)
    {
        return areaC.login(ci, pwd);
    }

    public void logout(Trabajador t)
    {
        trabajadoresC.logout(t);
    }
    
    //FIN DE TRABAJADORES
    
    
    //Puestos       
    //FIN PUESTOS
    
    
    // Areas  
    public void agregarArea(Area a)
    {
        areaC.agregarArea(a);
    }
    
    public ArrayList<Area> getAreas()
    {
        return areaC.getAreas();
    }
    
    public Sector obtenerSector(Trabajador t)
    {
        return areaC.obtenerSector(t);
    }
    //FIN AREAS
    
    // ATENCION
   /* public void agregarObservador(Observador obs)
    {
        atencionC.agregar(obs);
    }*/
    
    public ArrayList<Atencion> atencionesPendientes()
    {
        return atencionC.atencionesPendientes();
    }
    
    public void asignarAtencion(Puesto p){
        atencionC.asignarAtencion(p);
    }
    public Atencion obtenerAtencionPuesto(Puesto p){
        return atencionC.obtenerAtencionPuesto(p);
    }
    public Atencion crearAtencion(Cliente cliente, Area area,Sector sector)
    {
       Atencion a= atencionC.crearAtencion(cliente,area,sector);
       avisar(Eventos.NuevaAtencion);
       return a;
    }
    
    public void comenzarAtencion(Atencion a, Puesto p)
    {
        avisar(Eventos.ComienzoAtencion);
        atencionC.comenzarAtencion(a, p);  
        
    }
    
    public void finalizarAtencion(Atencion a, String d)
    {
        avisar(Eventos.FinAtencion);
        atencionC.finalizarAtencion(a, d); 
    }
    
    //FIN ATENCIOn
}
