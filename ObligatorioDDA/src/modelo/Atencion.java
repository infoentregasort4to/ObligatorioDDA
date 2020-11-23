package modelo;
import java.util.Date;
import Observador.Observable;
import java.time.temporal.ChronoUnit;

public class Atencion  extends Observable
{    
    private int numero;     
    private Puesto puesto; 
    private Cliente cliente;
    private Date fechaHora;
    private String descripcion;   
    private Date fechaHoraFin;
    private Sector sector;    
    public enum Eventos{nuevaAtencion;}
    
    public Atencion(int numero, Cliente cliente, Sector s, Puesto p) // atencion sin espera
    {
        this.sector=s;
        this.numero = numero;
        this.cliente = cliente;
        this.puesto=p;
        avisar(Eventos.nuevaAtencion);
    }
    
    public Atencion(int numero, Cliente cliente,Sector sector) // atencion con espera
    {
        this.sector=sector;
        this.numero = numero;
        this.cliente = cliente;        
        avisar(Eventos.nuevaAtencion);
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

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public Date getFechaHora()
    {
        return fechaHora;
    }

    public void setFechaHora(Date fecha_hora)
    {        
        this.fechaHora = fecha_hora;
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
    
    public void comenzarAtencion(Puesto puesto)
    {
        puesto.setPuestoDisponible(false);
        this.puesto = puesto;
        this.fechaHora = new Date();         
    }
    
    public void finalizarAtencion(String d)
    {
        this.fechaHoraFin = new Date();
        this.descripcion = d;        
    }
    
    public boolean atencionPendiente()
    {
        return this.puesto == null;
    }
    
    public boolean atencionEnCurso()
    {
        return this.puesto!=null && this.fechaHoraFin==null;
    }
    
    public long calcularTiempo()
    {   
       long segundos = ChronoUnit.SECONDS.between(fechaHora.toInstant(),fechaHoraFin.toInstant());
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