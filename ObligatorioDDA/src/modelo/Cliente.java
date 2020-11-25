package modelo;

public class Cliente 
{        
    private String ci;
    private String nombre;
    private String email;
    private ITipoCobro tipoCobro;    
     
    public Cliente(String ci, String nombre, String email,ITipoCobro tipoCobro)
    {
        this.ci = ci;
        this.nombre = nombre;
        this.email = email;
        this.tipoCobro = tipoCobro;
    }
    
    public float Cobrar(float tiempo, float costoFijo)
    {
        return tipoCobro.Cobrar(tiempo,costoFijo);
    }

    public void setTipoCobro(ITipoCobro tipoCobro)
    {
        this.tipoCobro = tipoCobro;
    }    

    public String getCi()
    {
        return ci;
    }

    public void setCi(String ci)
    {
        this.ci = ci;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }   
    
    @Override
    public String toString()
    {
        return this.getNombre();
    }
}