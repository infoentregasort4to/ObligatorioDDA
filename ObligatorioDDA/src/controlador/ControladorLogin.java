package controlador;

import Observador.Observable;
import Observador.Observador;
import modelo.AtencionException;
import modelo.Fachada;
import modelo.Trabajador;


public class ControladorLogin
{    
    private Fachada ff= Fachada.getInstancia();
    private VistaLogin vista;
    
    public ControladorLogin(VistaLogin vista)
    {
        this.vista=vista;
    }
    
    public void login(String usuario, String contrasena)
    {
        try{
            Trabajador trabajador = ff.login(usuario, contrasena);
            vista.ingresar(trabajador);
        } catch (AtencionException ae) {
            String msg = ae.getMessage();
            vista.mostrarError(msg);
        }
    }
}
