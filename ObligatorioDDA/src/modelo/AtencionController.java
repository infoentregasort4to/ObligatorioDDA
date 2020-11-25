package modelo;

import java.util.ArrayList;

public class AtencionController
{
    private ArrayList<Atencion> atenciones = new ArrayList();
    
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
    
    public long calcularPromedioSector(Sector s)
    {        
        long totalPuestos=0;
        
        for(Atencion a: atenciones)
        {
            if(a.getSector().equals(s) && a.getFechaHoraFin()!=null)
            {
              totalPuestos +=  calcularTiempoPromedioPuesto(a.getPuesto());
            }
        }
        int cant = s.cantTrabajadores();
        if(cant>0)
        {
            return totalPuestos/cant;
        }
        return 0;
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
    
    public float finalizarAtencion(Atencion a, String d)
    {     
        float importe = a.finalizarAtencion(d);
        a.getPuesto().setPuestoDisponible(true);
        return importe;
    }
    
    public void asignarAtencion(Puesto p,Sector s)
    {        
        Atencion a= getAtencionPendiente(s);
        if(a!=null)
        {            
            a.comenzarAtencion(p);
        }
    }
     public int cantNumerosEspera(Sector s)
     {
        int cant=0;
        for(Atencion a : atenciones)
        {
            if(a.getSector().equals(s) && a.getPuesto()==null)
            {
                cant++;
            }
         }
        return cant;
    }
    
    public long sumaPromedios(Sector s){
        long suma= 0;
        for(Puesto p : s.getPuestos()){
            
           suma += calcularTiempoPromedioPuesto(p);
        }
        return suma;
    }
    
    public long tiempoPromedioAtencionSector(Sector s)
    {        
        long res =0;
        if(s.cantPuestos()>0)
        {
            res=sumaPromedios(s)/s.cantPuestos();
        }
        return res;
    }
    
    public long esperaEstimadaSector(Sector s)
    {
        long res=0;
        
        if(s.cantTrabajadores()>0)
        {
            long tpas = tiempoPromedioAtencionSector(s);
            long cantNrosE = cantNumerosEspera(s);
            long cantT = s.cantTrabajadores();
            res =(tpas*cantNrosE)/cantT;
        }
        return res;
    }
    
    public ArrayList<String> tiemposPromediosAtencion(Area a)
    {            
        ArrayList<String> esperas= new ArrayList();
        
        for(Sector s : a.getSectores())
        {
            String e= Long.toString(this.tiempoPromedioAtencionSector(s));
            esperas.add(e);
        }
        return esperas;
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

    public ArrayList<String> tiemposPromediosAtenciones(ArrayList<Atencion> atenciones)
    {
        ArrayList<String> aa = new ArrayList();
        
        for(Atencion att: atenciones)
        {
           String e= Long.toString(this.tiempoPromedioAtencionSector(att.getSector()));
           aa.add(e);
        }        
        
        return aa;
    } 
}