package modelo;

public class ClienteGestor extends Cliente{

    public ClienteGestor(TipoCliente tipoCliente, String ci, String nombre, String email)
    {
        super(tipoCliente, ci, nombre, email);
    }
    
    @Override
    public int calcularCosto()
    {
        return this.costoFijo; //pendiente de calculo
    }
}