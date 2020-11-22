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
        
        ////////////////////////////////////////////
        
        //CREAR TIPOCLIENTES
        TipoCliente tc1 = new TipoCliente("ClienteConCosto");
        TipoCliente tc2 = new TipoCliente("ClienteExonerado");
        TipoCliente tc3 = new TipoCliente("ClienteGestor");    
        //cambiar nombre a agregarTipoCliente
        f.setTipoCliente(tc1);
        f.setTipoCliente(tc2);
        f.setTipoCliente(tc3);  
        ///////////////////////////////////////////////
        //CREAR CLIENTES
        Cliente c1 = new ClienteConCosto(tc1,"1236"," Seba","mail1@mail.com");
        Cliente c2 = new ClienteConCosto(tc2,"1237","Tincho","mail2@mail.com");
        Cliente c3 = new ClienteConCosto(tc3,"1238"," Seba2","mail3@mail.com");
        Cliente c4 = new ClienteConCosto(tc2,"1239"," John","mail4@mail.com");        
        
        f.agregarCliente(c1);
        f.agregarCliente(c2);
        f.agregarCliente(c3);
        f.agregarCliente(c4);
        //////////////////////////////////////////////
        
        //CREAR SECTORES
        Sector s1 = new Sector("Caja 1");
        Sector s2 = new Sector("Caja 2");
        Sector s3 = new Sector("Caja 3"); 
        
        Sector s4 = new Sector("Venta autos");
        Sector s5 = new Sector("Venta Calefones");
        Sector s6 = new Sector("Venta Celulares");
        
        Sector s7 = new Sector("Atencion a indeseables");
        Sector s8 = new Sector("Atencion a capacidades diferentes");
        Sector s9 = new Sector("Atencion a buena onda");
        
        Sector s10 = new Sector("RMA1");
        Sector s11 = new Sector("RMA2");
        Sector s12 = new Sector("RMA3");
        ////////////////////////////////////
        //AREAS
        Area a1 = new Area("Caja");
        Area a2 = new Area("Ventas");
        Area a3 = new Area("Atencion al Cliente");
        Area a4 = new Area("RMA");
        //////////////////////////////////
        //AGREGAR SECTORES A AREAS
        //CAJA
        a1.agregarSector(s1);
        a1.agregarSector(s2);
        a1.agregarSector(s3);
        //VENTAS
        a2.agregarSector(s4);
        a2.agregarSector(s5);
        a2.agregarSector(s6);
        //ATENCION
        a3.agregarSector(s7);
        a3.agregarSector(s8);
        a3.agregarSector(s9);
        //RMA
        a4.agregarSector(s10);
        a4.agregarSector(s11);
        a4.agregarSector(s12);
        ////////////////////////////////
        
        f.agregarArea(a1);
        f.agregarArea(a2);
        f.agregarArea(a3);
        f.agregarArea(a4);
        
         
        
        //CREAR PUESTOS
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
        Puesto p16 = new Puesto("Puesto 16");
        Puesto p17 = new Puesto("Puesto 17");
        Puesto p18 = new Puesto("Puesto 18");
        Puesto p19 = new Puesto("Puesto 19");
        Puesto p20 = new Puesto("Puesto 20");
        Puesto p21 = new Puesto("Puesto 21");
        Puesto p22 = new Puesto("Puesto 22");
        Puesto p23 = new Puesto("Puesto 23");
        Puesto p24 = new Puesto("Puesto 24");
        Puesto p25 = new Puesto("Puesto 25");
        Puesto p26 = new Puesto("Puesto 26");
        Puesto p27 = new Puesto("Puesto 27");
        Puesto p28 = new Puesto("Puesto 28");
        Puesto p29 = new Puesto("Puesto 29");
        Puesto p30 = new Puesto("Puesto 30");
        Puesto p31 = new Puesto("Puesto 31");
        Puesto p32 = new Puesto("Puesto 32");
        Puesto p33 = new Puesto("Puesto 33");
        Puesto p34 = new Puesto("Puesto 34");
        Puesto p35 = new Puesto("Puesto 35");
        Puesto p36 = new Puesto("Puesto 36");
        Puesto p37 = new Puesto("Puesto 37");
        Puesto p38 = new Puesto("Puesto 38");
        Puesto p39 = new Puesto("Puesto 39");
        Puesto p40 = new Puesto("Puesto 40");
        Puesto p41 = new Puesto("Puesto 41");
        Puesto p42 = new Puesto("Puesto 42");
        Puesto p43 = new Puesto("Puesto 43");
        Puesto p44 = new Puesto("Puesto 44");
        Puesto p45 = new Puesto("Puesto 45");
        Puesto p46 = new Puesto("Puesto 46");
        Puesto p47 = new Puesto("Puesto 47");
        Puesto p48 = new Puesto("Puesto 48");
        Puesto p49 = new Puesto("Puesto 49");
        Puesto p50 = new Puesto("Puesto 50");
        Puesto p51 = new Puesto("Puesto 51");
        Puesto p52 = new Puesto("Puesto 52");
        Puesto p53 = new Puesto("Puesto 53");
        Puesto p54 = new Puesto("Puesto 54");
        Puesto p55 = new Puesto("Puesto 55");
        Puesto p56 = new Puesto("Puesto 56");
        Puesto p57 = new Puesto("Puesto 57");
        Puesto p58 = new Puesto("Puesto 58");
        Puesto p59 = new Puesto("Puesto 59");
        Puesto p60 = new Puesto("Puesto 60");
        Puesto p61 = new Puesto("Puesto 61");
        Puesto p62 = new Puesto("Puesto 62");
        Puesto p63 = new Puesto("Puesto 63");
        Puesto p64 = new Puesto("Puesto 64");
        Puesto p65 = new Puesto("Puesto 65");
        Puesto p66 = new Puesto("Puesto 66");
        Puesto p67 = new Puesto("Puesto 67");
        Puesto p68 = new Puesto("Puesto 68");
        Puesto p69 = new Puesto("Puesto 69");
        Puesto p70 = new Puesto("Puesto 70");
        Puesto p71 = new Puesto("Puesto 71");
        Puesto p72 = new Puesto("Puesto 72");
        Puesto p73 = new Puesto("Puesto 73");
        Puesto p74 = new Puesto("Puesto 74");
        Puesto p75 = new Puesto("Puesto 75");
        Puesto p76 = new Puesto("Puesto 76");
        Puesto p77 = new Puesto("Puesto 77");
        Puesto p78 = new Puesto("Puesto 78");
        Puesto p79 = new Puesto("Puesto 79");
        Puesto p80 = new Puesto("Puesto 80");
        Puesto p81 = new Puesto("Puesto 81");
        Puesto p82 = new Puesto("Puesto 82");
        Puesto p83 = new Puesto("Puesto 83");
        Puesto p84 = new Puesto("Puesto 84");
        Puesto p85 = new Puesto("Puesto 85");
        Puesto p86 = new Puesto("Puesto 86");
        Puesto p87 = new Puesto("Puesto 87");
        Puesto p88 = new Puesto("Puesto 88");
        Puesto p89 = new Puesto("Puesto 89");
        Puesto p90 = new Puesto("Puesto 90");
        
        ///////////////////////////////////
       
        //AGREGAR PUESTOS A SECTORES
        
        //CAJA 1
        s1.agregarPuesto(p1);
        s1.agregarPuesto(p2);
        s1.agregarPuesto(p3);
        s1.agregarPuesto(p4);
        s1.agregarPuesto(p5);
        //CAJA2
        s2.agregarPuesto(p6);
        s2.agregarPuesto(p7);
        s2.agregarPuesto(p8);
        s2.agregarPuesto(p9);
        s2.agregarPuesto(p10);
        //CAJA3
        s3.agregarPuesto(p11);
        s3.agregarPuesto(p12);
        s3.agregarPuesto(p13);
        s3.agregarPuesto(p14);
        s3.agregarPuesto(p15);
        //VENTA AUTOS
        s4.agregarPuesto(p16);
        s4.agregarPuesto(p17);
        s4.agregarPuesto(p18);
        s4.agregarPuesto(p19);
        s4.agregarPuesto(p20);
        //VENTA CALEFONES
        s5.agregarPuesto(p21);
        s5.agregarPuesto(p22);
        s5.agregarPuesto(p23);
        s5.agregarPuesto(p24);
        s5.agregarPuesto(p25);
        //VENTA CELULARES
        s6.agregarPuesto(p26);
        s6.agregarPuesto(p27);
        s6.agregarPuesto(p28);
        s6.agregarPuesto(p29);
        s6.agregarPuesto(p30);
        //ATENCION A INDESEABLES
        s7.agregarPuesto(p31);
        s7.agregarPuesto(p32);
        s7.agregarPuesto(p33);
        s7.agregarPuesto(p34);
        s7.agregarPuesto(p35);
        //ATENCION A CAPACIDADES DIFERENTES
        s8.agregarPuesto(p36);
        s8.agregarPuesto(p37);
        s8.agregarPuesto(p38);
        s8.agregarPuesto(p39);
        s8.agregarPuesto(p40);
        //ATENCION A BUENA ONDA
        s9.agregarPuesto(p41);
        s9.agregarPuesto(p42);
        s9.agregarPuesto(p43);
        s9.agregarPuesto(p44);
        s9.agregarPuesto(p45);
        //RMA1
        s10.agregarPuesto(p46);
        s10.agregarPuesto(p47);
        s10.agregarPuesto(p48);
        s10.agregarPuesto(p49);
        s10.agregarPuesto(p50);
        //RMA2
        s11.agregarPuesto(p61);
        s11.agregarPuesto(p62);
        s11.agregarPuesto(p63);
        s11.agregarPuesto(p64);
        s11.agregarPuesto(p65);
        //RMA3
        s12.agregarPuesto(p66);
        s12.agregarPuesto(p67);
        s12.agregarPuesto(p68);
        s12.agregarPuesto(p69);
        s12.agregarPuesto(p70);
        
        //////////////////////////
      //CREAR TRABAJADORES
        //CAJA1
        Trabajador mit1 = new Trabajador("0001","Seba","1234");
        Trabajador mit2 = new Trabajador("0002","Tincho","1234");
        //CAJA2
        Trabajador mit3 = new Trabajador("0003","Seba2","1234");
        Trabajador mit4 = new Trabajador("0004","John","1234");
        //CAJA3
        Trabajador mit5 = new Trabajador("0005","Luciano","1234");
        Trabajador mit6 = new Trabajador("0006","Luciano","1234");
        //VENTA AUTOS
        Trabajador mit7 = new Trabajador("1001","Luciano","1234");
        Trabajador mit8 = new Trabajador("1002","Luciano","1234");
        //VENTA CALEFONES
        Trabajador mit9 = new Trabajador("1003","Luciano","1234");
        Trabajador mit10 = new Trabajador("1004","Luciano","1234");
        //VENTA CELULARES
        Trabajador mit11 = new Trabajador("1005","Luciano","1234");
        Trabajador mit12 = new Trabajador("1006","Luciano","1234");
        //ATENCION A INDESEABLES
        Trabajador mit13 = new Trabajador("2001","Luciano","1234");
        Trabajador mit14 = new Trabajador("2002","Luciano","1234");
        //ATENCION A CAPACIDADES ESPECIALES
        Trabajador mit15 = new Trabajador("2003","Luciano","1234");
        Trabajador mit16 = new Trabajador("2004","Luciano","1234");
        //ATENCION A BUENA ONDA
        Trabajador mit17 = new Trabajador("2005","Luciano","1234");
        Trabajador mit18 = new Trabajador("2006","Luciano","1234");
        //RMA1
        Trabajador mit19 = new Trabajador("3001","Luciano","1234");
        Trabajador mit20 = new Trabajador("3002","Luciano","1234");
        //RMA2
        Trabajador mit21 = new Trabajador("3003","Luciano","1234");
        Trabajador mit22 = new Trabajador("3004","Luciano","1234");
        //RMA3
        Trabajador mit23 = new Trabajador("3005","Luciano","1234");
        Trabajador mit24 = new Trabajador("3006","Luciano","1234");
        
        //AGREGAR TRABAJADORES A SECTORES
        
        f.agregarTrabajador(s1,mit1);
        f.agregarTrabajador(s1,mit2);
        
        f.agregarTrabajador(s2,mit3);
        f.agregarTrabajador(s2,mit4);
        
        f.agregarTrabajador(s3,mit5);
        f.agregarTrabajador(s3,mit6);
        f.agregarTrabajador(s4,mit7);
        f.agregarTrabajador(s4,mit8);
        f.agregarTrabajador(s5,mit9);   
        f.agregarTrabajador(s5,mit10);
        f.agregarTrabajador(s6,mit11);
        f.agregarTrabajador(s6,mit12);
        f.agregarTrabajador(s7,mit13);
        f.agregarTrabajador(s7,mit14);   
        f.agregarTrabajador(s8,mit15);
        f.agregarTrabajador(s8,mit16);
        f.agregarTrabajador(s9,mit17);
        f.agregarTrabajador(s9,mit18);
        f.agregarTrabajador(s10,mit19);   
        f.agregarTrabajador(s10,mit20);
        f.agregarTrabajador(s11,mit21);
        f.agregarTrabajador(s11,mit22);
        f.agregarTrabajador(s12,mit23);
        f.agregarTrabajador(s12,mit24);   
        
        
        ArrayList<Trabajador> mivar = f.getTrabajadores();
    }
}
