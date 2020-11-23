package controlador;

import Observador.Observable;
import Observador.Observador;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import modelo.Area;
import modelo.Atencion;
import modelo.AtencionException;
import modelo.Fachada;
import modelo.Puesto;
import modelo.Sector;
import modelo.Trabajador;

public class ControladorTrabajadorAtencion implements Observador {
    
    private VistaTrabajadorAtencion vista;
    private Fachada ff= Fachada.getInstancia();
    private Sector sector;
    private Puesto p;
    private Area aa;
    private int cont;
    private long tiempoA;
    private Atencion atencion;
    
    public ControladorTrabajadorAtencion(VistaTrabajadorAtencion vista,Puesto p,Trabajador t){
        this.vista=vista;
        this.p=p;
        ff.agregar(this);        
        this.sector=ff.obtenerSectorTrabajador(t);         
        this.aa = ff.obtenerAreaSector(this.sector);
        vista.mostrarAtencion(buscarAtencionPendiente());
        vista.mostrarTitulo(t.toString());
        vista.mostrarInfo(mostrarInfo());
    }

    public Atencion getAtencionEnCurso() {
        return atencion;
    }

    public void setAtencion(Atencion atencion) {
        this.atencion = atencion;
    }
    
    public Atencion buscarAtencionPendiente()
    {       
        this.atencion = null;
        Atencion a = ff.buscarAtencionPendiente(sector);
        if(a!=null){            
            ff.comenzarAtencion(a,p);
        }
        return a;
    }
    
    @Override
    public void actualizar(Observable origen, Object evento) {
       if(origen == ff) {
            if(evento.equals(Fachada.Eventos.ComienzoAtencion)) {
                Atencion a= ff.obtenerAtencionPuesto(this.p);
                this.atencion = a;
                vista.mostrarAtencion(a);                
                this.cont++;                
                vista.mostrarInfo(mostrarInfo());
            }        
        }
    }
    
    public void logout()
    {        
        if(this.atencion == null)
        {
            this.p.logout();
            vista.Salir();
        }
        else
        {
            vista.mostrarError("No es posible finalizar su sesion!");            
        }
    }
    
    public String mostrarInfo()
    {   
        this.tiempoA = ff.calcularTiempoPromedioPuesto(this.p);
        String info = this.p + " " + "Area: " + this.aa + " Sector: " + this.sector + " Cant. Atenciones: " + this.cont + " Tiempo Promedio Atencion: " + this.tiempoA;        
        return info;
    }

    public void guardarYSeguir(String descripcion)
    {         
        try{
            ff.finalizarAtencion(this.atencion, descripcion);
            vista.mostrarAtencion(buscarAtencionPendiente());
            vista.mostrarInfo(mostrarInfo());
        } catch (AtencionException ae) {
            String msg = ae.getMessage();
            vista.mostrarError(msg);
        }
    }
}
