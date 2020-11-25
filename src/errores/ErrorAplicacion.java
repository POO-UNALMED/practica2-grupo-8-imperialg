package errores;

public class ErrorAplicacion extends Exception{
    String descripcion;
    public ErrorAplicacion(String texto){
        super(texto);
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
