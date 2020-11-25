package modelo;
import java.util.Date;
import Observador.Observable;
import java.time.temporal.ChronoUnit;

public class Atencion  extends Observable
{    
    private int numero;     
    private Puesto puesto; 
    private Cliente cliente;    
    private Date fechaHoraPedido;   
    private Date fechaHoraComienzo;
    private Date fechaHoraFin;
    private String descripcion;
    private Sector sector;
    private float costoFijo = 1500;
    
    public enum Eventos{nuevaAtencion;}
    
    public Atencion(int numero, Cliente cliente, Sector s, Puesto p) // atencion sin espera
    {
        this.fechaHoraPedido = new Date();
        this.sector=s;
        this.numero = numero;
        this.cliente = cliente;
        this.puesto=p;
        avisar(Eventos.nuevaAtencion);
    }
    
    public Atencion(int numero, Cliente cliente,Sector sector) // atencion con espera
    {
        this.fechaHoraPedido = new Date();
        this.sector=sector;
        this.numero = numero;
        this.cliente = cliente;        
        avisar(Eventos.nuevaAtencion);
    }

    public float getCostoFijo()
    {
        return costoFijo;
    }

    public void setCostoFijo(float costoFijo)
    {
        this.costoFijo = costoFijo;
    }
   
    public Sector getSector()
    {
        return sector;
    }

    public void setSector(Sector sector)
    {
        this.sector = sector;
    }
    
    public int getNumero()
    {
        return numero;
    }

    public void setNumero(int numero)
    {
        this.numero = numero;
    }

    public Puesto getPuesto()
    {
        return puesto;
    }

    public void setPuesto(Puesto puesto)
    {
        this.puesto = puesto;
    }

    public Cliente getCliente()
    {
        return cliente;
    }
    
    public float Cobrar()
    {
        return cliente.Cobrar(this.calcularTiempoEspera(), this.costoFijo);
    }

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public Date getFechaHora()
    {
        return fechaHoraComienzo;
    }

    public void setFechaHora(Date fecha_hora)
    {        
        this.fechaHoraComienzo = fecha_hora;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public Date getFechaHoraFin()
    {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Date fechaHoraFin)
    {
        this.fechaHoraFin = fechaHoraFin;
    }
    
    public Date getFechaHoraPedido()
    {
        return fechaHoraPedido;
    }

    public void setFechaHoraPedido(Date fechaHoraPedido)
    {
        this.fechaHoraPedido = fechaHoraPedido;
    }
    
    public void comenzarAtencion(Puesto puesto)
    {
        puesto.setPuestoDisponible(false);
        this.puesto = puesto;
        this.fechaHoraComienzo = new Date();         
    }
    
    public float finalizarAtencion(String d)
    {
        this.fechaHoraFin = new Date();
        this.descripcion = d; 
        
        return this.Cobrar();
    }
    
    public boolean atencionPendiente()
    {
        return this.puesto == null;
    }
    
    public boolean atencionEnCurso()
    {
        return this.puesto!=null && this.fechaHoraFin==null;
    }
    
    public long calcularTiempoEspera()
    {   
       long segundos = ChronoUnit.SECONDS.between(fechaHoraPedido.toInstant(),fechaHoraComienzo.toInstant());
       return segundos ;
    }
    
    public long calcularTiempo()
    {   
       long segundos = ChronoUnit.SECONDS.between(fechaHoraComienzo.toInstant(),fechaHoraFin.toInstant());
       return segundos ;
    }   
    
    public long obtenerTiempoAtencion()
    {
        if(fechaHoraFin != null)
        {
            return calcularTiempo();
        }
        return 0;        
    }
    
    @Override
    public String toString()
    {
        String str = this.sector.toString() +"| ";        
        str += (this.puesto!=null) ? this.puesto.getNombre(): " Pendiente ";
        str += "| Nro: " + this.numero ; 
        str += "| Cliente: " + this.cliente.getNombre()+ " ";
        
        return str;
    }    
}