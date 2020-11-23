package modelo;

import Observador.Observable;
import Observador.Observador;
import java.util.ArrayList;
import modelo.Atencion;
import modelo.Cliente;
import modelo.Puesto;

public class AtencionController
{
    private ArrayList<Atencion> atenciones = new ArrayList();

    public AtencionController() {
        
    }
    public ArrayList<Atencion> atencionesPendientes()
    {
        ArrayList<Atencion> atenciones= new ArrayList();
        for(Atencion a: this.atenciones)
        {
            if(a.atencionPendiente())
                atenciones.add(a);
        }        
        return atenciones;
    } 
    
    public long calcularTiempoPromedioPuesto(Puesto p)
    {
        long total = this.sumarTiemposPuesto(p);
        
        long promedio = total/this.cantAtencionesPuesto(p);
        
        return promedio;
    }
    
    private long sumarTiemposPuesto(Puesto p)
    {
        long total = 0;
        for(Atencion a: this.atenciones)
        {
            if(a.getPuesto() != null)
            {
                if(a.getPuesto().equals(p) && a.getFechaHoraFin() != null)
                {
                    total += a.obtenerTiempoAtencion();
                }                                    
            }
        }         
        return total;
    }
    
    private long cantAtencionesPuesto(Puesto p)
    {
        long cont = 1;
        for(Atencion a: this.atenciones)
        {
            if(a.getPuesto() != null)
            {
                if(a.getPuesto().equals(p) && a.getFechaHoraFin() != null)
                    cont++;
            }
        }        
        return cont;
    }  
    
    public Atencion getAtencionPendiente(Sector s)
    { 
        for(Atencion a: this.atenciones)
        {
            if(a.getSector().equals(s) && a.atencionPendiente())
                return a;
        }        
        return null;
    }         
    
    
    public Atencion crearAtencionPendiente(Cliente cliente,Sector s)
    {
       int numero = s.getNum();       
       
       Atencion aa = new Atencion(numero,cliente,s);
       
       this.atenciones.add(aa);     
 
       return aa;
    }
    
    public Atencion crearAtencionConPuesto(Cliente cliente, Sector s, Puesto p)
    {       
       int numero = s.getNum();       
       
       p.setPuestoDisponible(false);
       
       Atencion aa = new Atencion(numero,cliente,s,p);
       
       this.atenciones.add(aa);     
 
       return aa;
    }
    
    public void comenzarAtencion(Atencion a, Puesto p)
    {
        a.comenzarAtencion(p);     
    }
    
    public void finalizarAtencion(Atencion a, String d)
    {
        a.finalizarAtencion(d);
    }
    
    public void asignarAtencion(Puesto p,Sector s)
    {        
        Atencion a= getAtencionPendiente(s);
        if(a!=null)
        {            
            a.comenzarAtencion(p);
        }
    }
    
    public Atencion obtenerAtencionPuesto(Puesto p){
    
        for(Atencion a : atenciones){
            if(a.getPuesto().equals(p)){
                return a;
            }
        }
        return null;
    }   

    public Puesto puestoLibre(Area a, Sector s)
    {
        Puesto p= a.buscarPuestoDisponible(s);        
        return p;
    }    
}
