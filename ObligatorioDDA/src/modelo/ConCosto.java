package modelo;

public class ConCosto implements ITipoCobro
{    
    @Override
    public float Cobrar(float tiempo, float costoFijo)
    {
        /*
            Pagan el costo fijo de la atención si el tiempo de espera desde que solicitaron el
            número y llegaron al puesto de atención es menor a 1 minuto. Si es mayor pagan la mitad
            del costo fijo.
        */
        if(tiempo > 60)
        {
            return costoFijo/2;
        }
        
        return costoFijo; 
    }
}
