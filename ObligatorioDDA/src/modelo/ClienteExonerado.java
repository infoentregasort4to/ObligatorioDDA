package modelo;

public class ClienteExonerado extends Cliente{

    public ClienteExonerado(TipoCliente tipoCliente, String ci, String nombre, String email)
    {
        super(tipoCliente, ci, nombre, email);
    }
    
    @Override
    public int calcularCosto()
    {
        return this.costoFijo; //pendiente de calculo
    }
}
