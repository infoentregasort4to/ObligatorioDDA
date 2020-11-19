

package controlador;

import Observador.Observable;
import Observador.Observador;
import modelo.Fachada;
import modelo.Trabajador;


public class ControladorLogin {
    
    private Fachada ff= Fachada.getInstancia();
    private Trabajador t;
    private VistaLogin vista;
    
    public ControladorLogin(VistaLogin vista){
        this.vista=vista;
    }
     public void login(String usuario, String contrasena) {
        //try{
            Trabajador login = ff.login(usuario, contrasena);
            vista.Ingresar(login);
        //} catch (AgendaException ae) {
            //String msg = ae.getMessage();
            //vista.MostrarError(msg);
        //}
    }
    
    
    
}
