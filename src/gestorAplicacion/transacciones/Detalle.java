/*1). En las fuentes se incluirá la siguiente documentación:
         Cabecera del archivo: funcionalidad del módulo, autores, componentes del módulo, etc.
        Cabeceras en las clases, explicando su finalidad y describiendo las estructuras de datos definidas cuando
        sean relevantes.
        Cabeceras en los métodos, comentando su propósito y describiendo los parámetros de entrada/salida.
         Comentarios en líneas de código de relevante interés o importancia.
        Otros aspectos de interés a tener en cuenta por el profesor.*/

/* Autores:   - Santiago Franco Valencia 
*            - Anderson Elian Gutierrez 
*            - Santiago Valencia Mejia
*            - Daniel Alejandro Giraldo  */

// En este módulo se crea la clase Detalle, asi como sus métodos básicos (Get y Set), además se definen un conjunto de atributos
// para su funcionamiento. Esta clase se verá implementada en cada una de las lineas que componen una Factura, pues una Factura         
// está compuesta por uno o más detalles

package gestorAplicacion.transacciones;
import gestorAplicacion.producto.Producto;
import java.io.Serializable;
public class Detalle implements Serializable{
	private static final long serialVersionUID = 1L;
	
    private int idDetalle;
    public Producto producto;
    private float precio;
    private String tiposervicio;
    
    // Se crean los métodos Get y Set de los atributos de la Clase Detalle.
    
    public float getPrecio() {
        return precio;
    }
    public Producto getProducto() {
    	return producto;
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
    
    // Se crea el constructor de la clase Detalle, el cual recibe como parametros los atributos de esta clase
    public Detalle(Producto producto, float precio, String tiposervicio) {
        this.producto = producto;
        this.precio = precio;
        this.tiposervicio = tiposervicio;
    }

    @Override
    // Se crea el toString de la clase Detalle, el cual mostrará por pantalla el tipo de servicio al cual esta asosicado el 
    // detalle (compra, venta, reparacion, cambio de almacenamiento de una consola, cambio de color de un procuto, etc ),
    // el nombre del producto involucrado en el detalle y el precio del detalle, el cual depende del tipo de servicio realizado.
    
    public String toString() {
    	 return  " :  " + "Tipo de servicio: " +  tiposervicio + "  ||  " + "Nombre del producto: " +  producto.getNombre() + "  ||  " + "Subtotal: " + "COP $"+  precio;
    }
}