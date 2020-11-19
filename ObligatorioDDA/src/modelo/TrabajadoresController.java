package modelo;

import modelo.Trabajador;
import java.util.ArrayList;

public class TrabajadoresController
{   
    private ArrayList<Trabajador> trabajadores = new ArrayList();
    
    public Trabajador login(String ci,String contrasena )
    {
       for(Trabajador t: this.trabajadores)
       {            
            if(t.getCi().equals(ci) && t.getContrasena().equals(contrasena))
            {
                return t;
            }
        }
       return null;
    }  
    public Trabajador logout(Trabajador t)
    {
        return t; // para hacer
    }
    
    public ArrayList<Trabajador> getTrabajadores()
    {
        return trabajadores;
    }

    public Trabajador getTrabajador(String ci)
    {        
       for(Trabajador t: this.trabajadores)
       {            
            if(t.getCi().equals(ci))
            {
                return t;
            }
        }
       return null;
    }
    public void agregarTrabajador(Trabajador tnuevo)
    {
       trabajadores.add(tnuevo);
       
    }
    
}
