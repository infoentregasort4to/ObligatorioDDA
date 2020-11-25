package modelo;

public class Gestor implements ITipoCobro
{ 
    @Override
    public float Cobrar(float tiempo, float costoFijo)
    {
        /*
            Gestores: Pagan el costo fijo de la atención, pero a este valor se le descuenta $1 por cada
            segundo transcurrido entre que solicito el numero de la atención y llego al puesto de
            trabajo. 
        */
        return costoFijo - tiempo; 
    }
}