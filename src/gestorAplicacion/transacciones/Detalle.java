/*1). En las fuentes se incluirá la siguiente documentación:
         Cabecera del archivo: funcionalidad del módulo, autores, componentes del módulo, etc.
         Cabeceras en las clases, explicando su finalidad y describiendo las estructuras de datos definidas cuando
        sean relevantes.
         Cabeceras en los métodos, comentando su propósito y describiendo los parámetros de entrada/salida.
         Comentarios en líneas de código de relevante interés o importancia.
         Otros aspectos de interés a tener en cuenta por el profesor.*/
package gestorAplicacion.transacciones;

import gestorAplicacion.producto.Producto;

public class Detalle {
    private int idDetalle;
    public Producto producto;
    private float precio;
    private String tiposervicio;


    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTiposervicio() {
        return tiposervicio;
    }

    public void setTiposervicio(String tiposervicio) {
        this.tiposervicio = tiposervicio;
    }

    public Detalle(Producto producto, float precio, String tiposervicio) {
        this.producto = producto;
        this.precio = precio;
        this.tiposervicio = tiposervicio;
    }

    @Override
    public String toString() {
        return  " " + tiposervicio + " " + producto.getNombre() + " " + precio;
    }
}