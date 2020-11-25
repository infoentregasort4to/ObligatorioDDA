package controlador;

import Observador.Observable;
import Observador.Observador;
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
    
    public ControladorTrabajadorAtencion(VistaTrabajadorAtencion vista,Puesto p,Trabajador t)
    {
        this.vista=vista;
        this.p=p;
        ff.agregar(this);        
        this.sector=ff.obtenerSectorTrabajador(t);         
        this.aa = ff.obtenerAreaSector(this.sector);
        vista.mostrarAtencion(buscarAtencionPendiente());
        vista.mostrarTitulo(t.toString());        
    }

    public Atencion getAtencionEnCurso()
    {
        return atencion;
    }

    public void setAtencion(Atencion atencion)
    {
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
    public void actualizar(Observable origen, Object evento)
    {
       if(origen == ff)
       {
            if(evento.equals(Fachada.Eventos.ComienzoAtencion))
            {
                
                this.atencion = ff.obtenerAtencionPuesto(this.p);
                vista.mostrarAtencion(this.atencion);                 
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
            vista.mostrarMensaje("No es posible finalizar su sesion!");            
        }
    }
    
    public void actualizarInfo()
    {
        cont++;
        this.tiempoA = ff.calcularTiempoPromedioPuesto(this.p);
        vista.actualizarInfo(Long.toString(this.tiempoA),Integer.toString(cont));
    }
    public void guardarYSeguir(String descripcion)
    {         
        try
        {
            
            float importe = ff.finalizarAtencion(this.atencion, descripcion);
            vista.finYSiguiente();
            vista.mostrarAtencion(buscarAtencionPendiente());            
            actualizarInfo();
            
            vista.mostrarMensaje("El costo de la atencion es de: " + importe);
            
        }
        catch (AtencionException ae)
        {
            String msg = ae.getMessage();
            vista.mostrarMensaje(msg);
        }
    }
}
