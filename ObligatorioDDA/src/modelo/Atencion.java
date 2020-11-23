package modelo;
import java.util.Date;
import Observador.Observable;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Atencion  extends Observable {
    
    //si no tiene puesto esta "cola", si tiene puesto pero no tiene fecha de fin esta en "atencion" y si tiene fecha de fin es "finalizada"    
    
    private int numero;     
    private Puesto puesto; 
    private Cliente cliente;
    private Date fechaHora;
    private String descripcion;   
    private Date fechaHoraFin;
    private Sector sector;
    
    public Atencion(int numero, Cliente cliente, Sector s, Puesto p) {
        this.sector=s;
        this.numero = numero;
        this.cliente = cliente;
        this.puesto=p;
        avisar(Eventos.nuevaAtencion);
    }
   
    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
    
    
    public enum Eventos{nuevaAtencion;}
    
    public Atencion(int numero, Cliente cliente,Sector sector)
    {
        this.sector=sector;
        this.numero = numero;
        this.cliente = cliente;
        avisar(Eventos.nuevaAtencion);
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fecha_hora) {
        
        this.fechaHora = fecha_hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Date fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }
    
    public void comenzarAtencion(Puesto puesto)
    {
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
    
    public long calcularTiempo(Date dateInicio, Date dateFinal) {
    long diferencia=dateInicio.getTime()-dateFinal.getTime();
    long   minutos = TimeUnit.MILLISECONDS.toSeconds(diferencia);
    return minutos;
    }
    
    public float obtenerTiempoAtencion()
    {
        if(fechaHoraFin != null)
        {
            return calcularTiempo(fechaHoraFin,fechaHora);
        }
        return 0;
        
    }
    
    @Override
    public String toString()
    {
        String str = this.sector.toString();        
        str += (this.puesto!=null) ? this.puesto.getNombre(): "-- PENDIENTE de ATENCION";
        str += "-- " + this.numero + " "; 
        str += "-- " + this.cliente.getNombre()+ " ";   
        str += "-- TIEMPO PROMEDIO PENDIENTE";
                
        return str;
    }
    
}
