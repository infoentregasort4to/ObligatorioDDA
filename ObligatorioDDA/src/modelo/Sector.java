package modelo;

import java.util.ArrayList;

public class Sector
{    
    private String nombre;
    private int num;
    private ArrayList<Puesto> puestos = new ArrayList();
    private ArrayList<Trabajador> trabajadores = new ArrayList();

    public Sector(String nombre)
    {
        this.nombre = nombre;

    }
    
    public int cantTrabajadores()
    {           
        int cant=0;
        for(Puesto p : puestos)
        {
            if(!p.puestoLibre())
            {
                cant++;
            }      
        }
        return cant;
    }   
    
    public String getNombre()
    {
        return nombre;
    }
    
    public int getNum()
    {
        return num++;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public ArrayList<Puesto> getPuestos()
    {
        return puestos;
    }

    public void agregarPuesto(Puesto pnuevo)
    {
        this.puestos.add(pnuevo);
    }
    
    public ArrayList<Puesto> getPuestosLibres()
    {
        ArrayList<Puesto> losLibres = new ArrayList();

        for(Puesto p: this.getPuestos())
        {
             if(p.puestoLibre())
                 losLibres.add(p);
        }        
        return losLibres;
    }
    
    public void agregarTrabajador(Trabajador t)
    {        
        trabajadores.add(t);
    }
    
    public ArrayList<Trabajador> getTrabajadores()
    {
        return trabajadores;
    }
    
    public Trabajador obtenerTrabajador(String ci, String contrasena) throws AtencionException
    {
        for(Trabajador t: trabajadores)
        {            
            if(t.getCi().equals(ci) && t.getContrasena().equals(contrasena))
            {
                return t;
            }        
        }
        return null;    
    }
    
    public Trabajador tieneTrabajador(Trabajador t)
    {
        for(Trabajador trabajador: trabajadores)
        {        
            if(trabajador.equals(t))
            {
                return t;
            }
        }        
        return null;
    }
    
    public void ocuparPuesto(String p,Trabajador t)
    {
        for(Puesto pp : puestos)
        {
            if(pp.getNombre() == p)
            {
                pp.setTrabajador(t);
            }
        }
    }
    
    @Override
    public String toString()
    {
        return this.nombre;
    }

    public Puesto buscarPuestoDisponible()
    {
        Puesto pp= null;
        for(Puesto p : puestos )
        {
            if(p.puestoDisponible())
            {
                pp=p;
            }
        }
        return pp;
    }    
}
