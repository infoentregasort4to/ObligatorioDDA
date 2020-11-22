package modelo;

import Observador.Observable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    private AreasController areaC = new AreasController();
    private AtencionController atencionC = new AtencionController();

    public enum Eventos {
        PuestoDisponible, NuevaAtencion, ComienzoAtencion, FinAtencion
    };//EN ESTE CASO LA FACHADA TENDRIA TODOS LOS EVENTOS

    private static Fachada cg = new Fachada();

    public static Fachada getInstancia() {
        return cg;
    }

    private Fachada() {
    }

    //CLIENTES 
    public void setTipoCliente(TipoCliente tc) {
        clientesC.setTipoCliente(tc);
    }

    public void agregarCliente(Cliente c) {
        clientesC.agregarCliente(c);
    }

    public Cliente getCliente(String ci) throws AtencionException {
        return clientesC.getCliente(ci);
    }
    //FIN CLIENTES

    //TRABAJADORES 
    public void asignarPuesto(Trabajador t, Puesto p) {//SI PASO POR FACHADA PARA ASIGNAR EL PUESTO TAMBIEN AVISO POR FACHADA

        avisar(Eventos.PuestoDisponible);
        p.setTrabajador(t);
    }

    public Atencion buscarAtencionPendiente(Sector s) {

        return atencionC.getAtencionPendiente(s);

    }

    public void agregarTrabajador(Sector s, Trabajador tnuevo) {

        areaC.agregarTrabajador(s, tnuevo);
    }

    public Trabajador login(String ci, String pwd) throws AtencionException {
        return areaC.login(ci, pwd);
    }

    // Areas  
    public void agregarArea(Area a) {
        areaC.agregarArea(a);
    }

    public ArrayList<Area> getAreas() {
        return areaC.getAreas();
    }

    public Sector obtenerSectorTrabajador(Trabajador t) {
        return areaC.obtenerSector(t);
    }
    //FIN AREAS  

    public ArrayList<Atencion> atencionesPendientes() {
        return atencionC.atencionesPendientes();
    }

    public void asignarAtencion(Puesto p, Sector s) {
        atencionC.asignarAtencion(p, s);
    }

    public Atencion obtenerAtencionPuesto(Puesto p) {
        return atencionC.obtenerAtencionPuesto(p);
    }

    public Atencion crearAtencion(Cliente cliente, Area a, Sector s) {
        Puesto p = atencionC.puestoLibre(a, s);
        if (p != null) {
            Atencion aa = atencionC.crearAtencionConPuesto(cliente, s, p);
            Calendar cal = Calendar.getInstance();

            cal.setTime(new Date());

//            Date tiempoActual = cal.getTime();
//            
//            cal.add(Calendar.MINUTE, 10);
//            cal.add(Calendar.HOUR, 1); 
//            
//            Date tiempoFuturo = cal.getTime();
//            
//            long tiempoTranscurrido = tiempoFuturo.getTime() - tiempoActual.getTime();
//            long minutosTranscurridos = tiempoTranscurrido/(1000*60);
            aa.setFechaHora(cal.getTime());
            avisar(Eventos.ComienzoAtencion);
            return aa;
        }
        Atencion aa = atencionC.crearAtencionPendiente(cliente, s);
        avisar(Eventos.NuevaAtencion);
        return aa;
    }

    public void comenzarAtencion(Atencion a, Puesto p) {
        atencionC.comenzarAtencion(a, p);
        avisar(Eventos.ComienzoAtencion);
    }

    public void finalizarAtencion(Atencion a, String d) {
        atencionC.finalizarAtencion(a, d);
        avisar(Eventos.FinAtencion);
    }

    public Area obtenerAreaSector(Sector s) {
        return areaC.obtenerAreaSector(s);
    }

    public float calcularTiempoPromedioPuesto(Puesto p) {
        return atencionC.calcularTiempoPromedioPuesto(p);
    }

}
