package modelo;
import Observador.Observable;

public class Puesto extends Observable {//ESTA ES LA OPCION QUE VENIAMOS APLICANDO QUE ME PARECE TAMBIEN VALIDA, 
                                        //CAPAZ QUE AL FINAL POR REQUERIMIENTOS NECESITAMOS QUE LA FACHADA TAMBIEN SEA OBSERVABLE
    
    private String nombre;
    private Trabajador trabajador;

    public enum Eventos{PuestoDisponible,PuestoOcupado;}//EN ESTE CASO EL PUESTO MANDA LOS EVENTOS

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
    
    public boolean puestoLibre()
    {
        return trabajador == null;
    }
    
    @Override
    public String toString()
    {
        return this.getNombre();
    }
    public void setTrabajador(Trabajador t){
        avisar(Eventos.PuestoDisponible);//AVISO A QUIEN ME ESTE VIENDO
        this.trabajador= t;
        
    }
    
}
