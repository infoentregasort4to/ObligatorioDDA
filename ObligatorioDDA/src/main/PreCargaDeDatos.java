package main;

import modelo.Fachada;
import java.util.ArrayList;
import modelo.Area;
import modelo.Cliente;
import modelo.ClienteConCosto;
import modelo.Puesto;
import modelo.Sector;
import modelo.TipoCliente;
import modelo.Trabajador;

public class PreCargaDeDatos
{
    public void Cargar()
    {
        Fachada f = Fachada.getInstancia();
        
        Trabajador mit1 = new Trabajador("1237","Seba","1234");
        Trabajador mit2 = new Trabajador("1231","Tincho","1234");
        Trabajador mit3 = new Trabajador("1232","Seba2","1234");
        Trabajador mit4 = new Trabajador("1234","John","1234");
        Trabajador mit5 = new Trabajador("1994","Luciano","1994");
        
           
        TipoCliente tc1 = new TipoCliente("ClienteConCosto");
        TipoCliente tc2 = new TipoCliente("ClienteExonerado");
        TipoCliente tc3 = new TipoCliente("ClienteGestor");    
        //cambiar nombre a agregarCliente
        f.setTipoCliente(tc1);
        f.setTipoCliente(tc2);
        f.setTipoCliente(tc3);  
        
        Cliente c1 = new ClienteConCosto(tc1,"1237"," Seba","mail1@mail.com");
        Cliente c2 = new ClienteConCosto(tc2,"1237","Tincho","mail2@mail.com");
        Cliente c3 = new ClienteConCosto(tc3,"1237"," Seba2","mail3@mail.com");
        Cliente c4 = new ClienteConCosto(tc2,"1237"," John","mail4@mail.com");        
        //cambiar a agregarCliente
        f.setCliente(c1);
        f.setCliente(c2);
        f.setCliente(c3);
        f.setCliente(c4);
        
        Area a1 = new Area("Caja");
        Area a2 = new Area("Ventas");
        Area a3 = new Area("Atencion al Cliente");
        Area a4 = new Area("RMA");
        
        f.agregarArea(a1);
        f.agregarArea(a2);
        f.agregarArea(a3);
        f.agregarArea(a4);
        
        Puesto p1 = new Puesto("Puesto 1");
        Puesto p2 = new Puesto("Puesto 2");
        Puesto p3 = new Puesto("Puesto 3");
        Puesto p4 = new Puesto("Puesto 4");
        Puesto p5 = new Puesto("Puesto 5");
        Puesto p6 = new Puesto("Puesto 6");
        Puesto p7 = new Puesto("Puesto 7");
        Puesto p8 = new Puesto("Puesto 8");
        Puesto p9 = new Puesto("Puesto 9");
        Puesto p10 = new Puesto("Puesto 10");
        Puesto p11 = new Puesto("Puesto 11");
        Puesto p12 = new Puesto("Puesto 12");
        Puesto p13 = new Puesto("Puesto 13");
        Puesto p14 = new Puesto("Puesto 14");
        Puesto p15 = new Puesto("Puesto 15");
        
        Sector s1 = new Sector("Piso 1");
        Sector s2 = new Sector("Piso 2");
        Sector s3 = new Sector("Piso 3"); 
        
        f.agregarTrabajador(s1,mit1);
        f.agregarTrabajador(s2,mit2);
        f.agregarTrabajador(s3,mit3);
        f.agregarTrabajador(s3,mit4);   
        f.agregarTrabajador(s2,mit5); 
        
        a2.setSector(s1);
        a3.setSector(s2);
        a2.setSector(s3);
        //cambiar a agregarPuesto
        s1.setPuesto(p1);
        s1.setPuesto(p2);
        s1.setPuesto(p3);
        s1.setPuesto(p4);
        s1.setPuesto(p5);
        
        s2.setPuesto(p6);
        s2.setPuesto(p7);
        s2.setPuesto(p8);
        s2.setPuesto(p9);
        s2.setPuesto(p10);
        
        s3.setPuesto(p11);
        s3.setPuesto(p12);
        s3.setPuesto(p13);
        s3.setPuesto(p14);
        s3.setPuesto(p15);
        
      
        
        ArrayList<Trabajador> mivar = f.getTrabajadores();
    }
}
