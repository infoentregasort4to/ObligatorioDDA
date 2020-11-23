package modelo;
import Observador.Observable;

public class Puesto extends Observable
{    
    private String nombre;
    private Trabajador trabajador;
    private boolean disponible;

    public enum Eventos{PuestoDisponible,PuestoOcupado;}

    public Puesto(String nombre) 
    {
        this.nombre = nombre;       
    }   
    
    public String getNombre()
    {
        return this.nombre;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public void setPuestoDisponible(boolean b)
    {
        this.disponible=b;
    }
    
    public boolean puestoDisponible()
    {
        return this.disponible;
    }
    
    public boolean puestoLibre()
    {
        return trabajador == null;
    }
    
    @Override
    public String toString()
    {
        return this.getNombre();
    }
    
    public void setTrabajador(Trabajador t)
    {
        avisar(Eventos.PuestoDisponible);
        this.trabajador= t;
        this.disponible=true;        
    }
    
    public Trabajador getTrabajador()
    {
        return this.trabajador;
    }
    
    public void logout()
    {
        this.trabajador=null;
    }   
}
