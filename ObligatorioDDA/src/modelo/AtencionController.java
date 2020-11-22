package modelo;

import Observador.Observable;
import Observador.Observador;
import java.util.ArrayList;
import modelo.Atencion;
import modelo.Cliente;
import modelo.Puesto;

public class AtencionController implements Observador
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
    
    public float calcularTiempoPromedioPuesto(Puesto p)
    {
        float total = this.sumarTiemposPuesto(p);        
        float promedio = total/this.cantAtencionesPuesto(p);        
    
        return promedio;
    }
    
    private float sumarTiemposPuesto(Puesto p)
    {
        float total = 0;
        for(Atencion a: this.atenciones)
        {
            if(a.getPuesto() != null)
            {
                if(a.getPuesto().equals(p))
                    total += a.obtenerTiempoAtencion();                
            }
        }         
        return total;
    }
    
    private float cantAtencionesPuesto(Puesto p)
    {
        float cont = 0;
        for(Atencion a: this.atenciones)
        {
            if(a.getPuesto() != null)
            {
                if(a.getPuesto().equals(p))
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
    
    public Atencion crearAtencionConPuesto(Cliente cliente, Sector s, Puesto p) {
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
        a.finalizarAtencion(d); // ya hace update atenciones set des='', hora=time where id = a.id //
    }
    public void asignarAtencion(Puesto p,Sector s){
        
        Atencion a= getAtencionPendiente(s);
        if(a!=null){
            //System.out.println(a);
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
    @Override
    public void actualizar(Observable origen, Object evento) {
        
    }

    public Puesto puestoLibre(Area a, Sector s) {
        Puesto p= a.buscarPuestoDisponible(s);
        
        return p;
    }

    
}
