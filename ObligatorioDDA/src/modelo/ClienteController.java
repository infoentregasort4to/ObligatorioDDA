package modelo;

import java.util.ArrayList;
import modelo.Cliente;

public class ClienteController
{
    private ArrayList<Cliente> clientes = new ArrayList();     
    
    public ArrayList<Cliente> getClientes()
    {
       return clientes;
    } 
    
    public void agregarCliente(Cliente c)
    {
        this.clientes.add(c);
    }
     
    public Cliente getCliente(String ci) throws AtencionException
    {
        for(Cliente c: this.clientes)
        {
            if(c.getCi().equals(ci))
                return c;
        }        
        throw new AtencionException("El usuario no existe.");
    }
}