package modelo;
public abstract class Cliente {
    
    private TipoCliente tipoCliente;    
    private String ci;
    private String nombre;
    private String email;
    protected int costoFijo = 1000;
     
    public Cliente(TipoCliente tipoCliente, String ci, String nombre, String email) {
        this.tipoCliente = tipoCliente;
        this.ci = ci;
        this.nombre = nombre;
        this.email = email;
    }
    public abstract int calcularCosto();
    
    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getCostoFijo() {
        return costoFijo;
    }

    public void setCostoFijo(int costoFijo) {
        this.costoFijo = costoFijo;
    }    
    @Override
    public String toString(){
        return this.getNombre();
    }
}
