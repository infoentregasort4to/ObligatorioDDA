package modelo;

import java.util.ArrayList;

public class Area
{
    private String nombre;
    private ArrayList<Sector> sectores = new ArrayList();

    public Area(String nombre)
    {
        this.nombre = nombre;
    }
    
    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public ArrayList<Sector> getSectores()
    {
        return sectores;
    }

    public void agregarSector(Sector sector)
    {
        this.sectores.add(sector);
    }
    
    public Sector obtenerSector(Trabajador t)
    {
        for(Sector s: sectores)
        {
            if(s.tieneTrabajador(t)!= null)
            {
                return s;
            }
        }
        return null;
    }
    
    public Trabajador obtenerTrabajador(String ci, String contrasena) throws AtencionException
    {
        for(Sector s : sectores)
        {
            Trabajador t=s.obtenerTrabajador(ci,contrasena);
            if(t!=null)
            {
                return t;
            }
        }
        return null;
    }

    public Puesto buscarPuestoDisponible(Sector s)
    {
        Puesto p= s.buscarPuestoDisponible();
        return p;
    }

    public boolean obtenerAreaSector(Sector s)
    {
        for(Sector sec: sectores)
        {
            if(sec.equals(s))
            {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString()
    {
        return this.nombre;
    }
}
