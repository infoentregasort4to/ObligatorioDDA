package modelo;

import java.util.ArrayList;
import modelo.Area;
import modelo.Sector;
import modelo.Trabajador;

public class AreasController
{
    private ArrayList<Area> areas = new ArrayList();
    
    public void agregarArea(Area a)
    {
        this.areas.add(a);
    }
    
    public ArrayList<Area> getAreas()
    {
        return this.areas;
    }
    
    public Sector obtenerSector(Trabajador t)
    {
        for (Area a : areas)
        {
            Sector s = a.obtenerSector(t);
            if (s != null)
                return s;            
        }
        return null;
    }
   
    public Trabajador login(String ci,String contrasena ) throws AtencionException
    {
       for(Area a: areas){
          Trabajador t=a.obtenerTrabajador(ci,contrasena);
          if(t!= null){
              return t;
          }
       }
       throw new AtencionException("El usuario no existe.");
    }
    
    public void agregarTrabajador(Sector s,Trabajador tnuevo)
    {
       s.agregarTrabajador(tnuevo);
    }
}




