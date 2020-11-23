package controlador;

public interface ITrabajadorAtencion
{
    public void mostrarTitulo(String t );
    public void mostrarAtencion(Object a);
    public void mostrarInfo(String s);
    public void mostrarError(String s);
    public void Salir();
    public void finYSiguiente();
    public void actualizarInfo(String t,String c);
}
