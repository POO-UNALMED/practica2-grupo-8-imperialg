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

// En este módulo se crea la clase Factura, en la cual se verán reflejados todos los detalles que la componen, por esta razón,
// en esta clase se implementó una lista llamada "detalles" en la que se encuentran los detalles asociados a la factura. Además 
// se crearon los métodos básicos (Get y Set).

package gestorAplicacion.transacciones;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import BaseDatos.Datos;
import gestorAplicacion.producto.Producto;

public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idFactura;
/*
    private LocalDate fecha = LocalDate.now(); // devuelve la fecha en la que se genera una factura
*/
    private Cliente cliente;
/*
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // formato de fecha dado en d�a/mes/a�o.
*/
    private ArrayList<Detalle> detalles = new ArrayList<Detalle>(); // Lista que contiene todos los detalles de una factura.
    private static ArrayList<Factura> listaFacturas = Datos.listaFacturas; // Lista donde se almacenan las facturas.

/*
    public String getFecha() {
        return fecha.format(formato);
    }
*/

    // Se crean los m�todos Get y Set de los atributos de la Clase Factura.
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Detalle> getDetalles() {
        return detalles;
    }

    public int getIdFactura() {
        return idFactura;
    }
    
    // Agrega una factura a listaFacturas.
    public static void agregarFactura(Factura factura){
        Datos.listaFacturas.add(factura);
    }

    public Factura(Cliente cliente) {
        this.cliente = cliente;
    }

    // Se crea el constructor de la clase Factura con los parametros de Cliente y detalles (lista con todos los detalles que
    // componen la factura).
    public Factura(Cliente cliente, ArrayList<Detalle> detalles) {
        this.cliente = cliente;
        this.detalles = detalles;
        //agregarFactura(this);
    }
    public static ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }
    
    // generar factura cuando se haya producido una venta en la tienda.                                     
    public static void generarFacturaVenta(ArrayList<Producto> productos, Cliente cliente){
        ArrayList<Detalle> listaDetalles = new ArrayList<Detalle>();
        for (Producto producto: productos){
            Detalle detalle = new Detalle(producto, producto.getPrecio(), "Venta");
            listaDetalles.add(detalle);
        }
        Factura factura = new Factura(cliente, listaDetalles);
        agregarFactura(factura);
        System.out.println("Su venta ha sido realizada exitosamente.");
        System.out.println(factura);

    }
    
    // Mostrar en pantalla las facturas registradas:
	public static void facturasRegistradas() {
		for (Factura factura : Datos.listaFacturas) {
			System.out.println(factura.toString());
		}
	}


    //  Se crea el toString de la clase Factura, el cual mostrará por pantalla el Id asociado a la factura, la fecha en que se
    // generó la fatura, el nombre del cliente al cual se le generó la factura, los detalles que componen a la factura y el valor
    // total de la factura.
    @Override
    public String toString(){
        String detas = "";
        float total = 0;
        for (Detalle detalle: detalles){ // el for se implementa para recorrer la lista de detalles, para despues mostrarlos. 
            detas += detalle.toString() + "\n";
            total += detalle.getPrecio();
        }
        return  "ID Factura: " + idFactura + "  ||  " +  "Nombre del cliente: " + cliente.getNombre() + "\n" +  "Detalle " + detas + "Total a pagar: " + "COP $" + total;
        }
}