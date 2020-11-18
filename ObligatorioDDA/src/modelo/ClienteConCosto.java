package modelo;

public class ClienteConCosto extends Cliente{
    
    public ClienteConCosto(TipoCliente tipoCliente, String ci, String nombre, String email)
    {
        super(tipoCliente, ci, nombre, email);
    }
    
    @Override
    public int calcularCosto()
    {
        return this.costoFijo; //pendiente de calculo
    }
}
