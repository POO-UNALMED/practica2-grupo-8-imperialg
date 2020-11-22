/*1). En las fuentes se incluira la siguiente documentacion:
         Cabecera del archivo: funcionalidad del modulo, autores, componentes del modulo, etc.
         Cabeceras en las clases, explicando su finalidad y describiendo las estructuras de datos definidas cuando
         sean relevantes.
         Cabeceras en los metodos, comentando su proposito y describiendo los parametros de entrada/salida.
         Comentarios en lineas de codigo de relevante interes o importancia.
         Otros aspectos de interes a tener en cuenta por el profesor.*/

/* Autores:   - Santiago Franco Valencia
 *            - Anderson Elian Gutierrez
 *            - Santiago Valencia Mejia
 *                                        */

// En este modulo se crea la clase Factura, en la cual se veran reflejados todos los detalles que la componen, por esta razon,
// en esta clase se implementa una lista llamada "detalles" en la que se encuentran los detalles asociados a la factura. Ademas
// se crearon los metodos basicos (Get y Set).

package gestorAplicacion.transacciones;
import java.io.Serializable;
import java.util.*;



import BaseDatos.Datos;
import gestorAplicacion.producto.*;

public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idFactura;
    private Cliente cliente;
    private ArrayList<Detalle> detalles = new ArrayList<Detalle>(); // Lista que contiene todos los detalles de una factura.
    private static ArrayList<Factura> listaFacturas = Datos.listaFacturas; // Lista donde se almacenan las facturas.

    // Se crean los metodos Get y Set de los atributos de la Clase Factura.

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
        this.idFactura=(Datos.listaFacturas.size());
        Datos.listaFacturas.add(this);
    }
    public static ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }


    // Mostrar en pantalla las facturas registradas.
    public static void facturasRegistradas() {
        for (Factura factura : Datos.listaFacturas) {
            System.out.println(factura.toString()+"\n");
            
        }
    }


    //  Se crea el toString de la clase Factura, el cual mostrara por pantalla el Id asociado a la factura, la fecha en que se
    // genera la fatura, el nombre del cliente al cual se le generara la factura, los detalles que componen a la factura y el valor
    // total de la factura.
    @Override
    public String toString(){

        String detas = "";
        float total = 0;
        for (Detalle detalle: detalles){ // el for se implementa para recorrer la lista de detalles, para despues mostrarlos.
            detas += detalle.toString() + "\n";
            total += detalle.getPrecio();
        }
        return  "ID Factura: " + idFactura + "  ||  "+  "Nombre del cliente: " + cliente.getNombre() + "\n" +  "Detalle: "+"\n"+ detas + "Total a pagar: " + "COP $" + total;
    }
}