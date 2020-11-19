
package modelo;

import java.util.ArrayList;
import modelo.Cliente;
import modelo.TipoCliente;

public class ClienteController
{
    private ArrayList<Cliente> clientes = new ArrayList();     
    private ArrayList<TipoCliente> tiposClientes = new ArrayList();
    
    public ArrayList<Cliente> getClientes()
    {
       return clientes;
    }  
    
    public void setTipoCliente(TipoCliente tc)
    {
        this.tiposClientes.add(tc);
    }
    
    public void setCliente(Cliente c)
    {
        this.clientes.add(c);
    }
     
    public Cliente getCliente(String ci)
    {
        for(Cliente c: this.clientes)
        {
            if(c.getCi().equals(ci))
                return c;
        }        
        return null;
    }
}