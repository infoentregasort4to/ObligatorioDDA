package controlador;

import Observador.Observable;
import Observador.Observador;
import java.util.ArrayList;
import modelo.Area;
import modelo.Atencion;
import modelo.Cliente;
import modelo.Puesto;
import modelo.Sector;

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
    
    public Atencion getAtencionPendiente()
    {
        
        for(Atencion a: this.atenciones)
        {
            if(a.atencionPendiente())
                return a;
        }        
        return null;
    } 
    
    public Atencion crearAtencion(Cliente cliente, Area area, Sector sector)
    {
       Atencion aa = new Atencion(cliente,area,sector.getNumero());
       
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
    public void asignarAtencion(Puesto p){
        
        Atencion a= getAtencionPendiente();
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
}
