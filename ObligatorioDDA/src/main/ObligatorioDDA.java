package main;
import vista.*;

public class ObligatorioDDA
{    
    public static void main(String[] args)
    {
        PreCargaDeDatos datos = new PreCargaDeDatos();
        datos.Cargar();  
        
        General gg = new General();
        gg.setVisible(true);
        
        
    }
}
