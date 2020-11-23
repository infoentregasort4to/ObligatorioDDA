package modelo;

import java.util.ArrayList;

public class AtencionController
{
    private ArrayList<Atencion> atenciones = new ArrayList();

    public AtencionController()
    {
        
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
    
    public ArrayList<Atencion> atencionesEnCurso()
    {
        ArrayList<Atencion> atenciones= new ArrayList();
        for(Atencion a: this.atenciones)
        {
            if(a.atencionEnCurso())
                atenciones.add(a);
        }        
        return atenciones;
    } 
    
    public long calcularPromedioSector(Sector s){
        
        long totalPuestos=0;
        
        
        for(Atencion a: atenciones){
            if(a.getSector().equals(s) && a.getFechaHoraFin()!=null){
              totalPuestos +=  calcularTiempoPromedioPuesto(a.getPuesto());
            }
        }
        long promedio = totalPuestos/s.cantTrabajadores();
        return totalPuestos;
    }
    
    public long calcularTiempoPromedioPuesto(Puesto p)
    {
        long total = this.sumarTiemposPuesto(p);
        long cantidad=this.cantAtencionesPuesto(p);
        if(cantidad>0){
            long promedio = total/cantidad;
            return promedio;
        }
        return 0;
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
        long cont = 0;
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
        a.getPuesto().setPuestoDisponible(true);
    }
    
    public void asignarAtencion(Puesto p,Sector s)
    {        
        Atencion a= getAtencionPendiente(s);
        if(a!=null)
        {            
            a.comenzarAtencion(p);
        }
    }
    
    public Atencion obtenerAtencionPuesto(Puesto p)
    {    
        for(Atencion a : atenciones)
        {
            if(a.getPuesto().equals(p) && a.getFechaHoraFin()==null)
            {
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