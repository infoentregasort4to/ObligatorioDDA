package modelo;

public class Exonerado implements ITipoCobro
{ 
    @Override
    public float Cobrar(float tiempo, float costoFijo)
    {
        return 0; 
    }
}
