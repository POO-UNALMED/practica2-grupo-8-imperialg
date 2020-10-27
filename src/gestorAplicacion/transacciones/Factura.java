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
    private static int idFactura;
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
    public Factura(int idFactura,Cliente cliente, ArrayList<Detalle> detalles) {
    	this.idFactura=idFactura;
        this.cliente = cliente;
        this.detalles = detalles;
    }
    public static ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }
    
    // Generar factura cuando se haya producido una venta en la tienda.                                     
    public static void generarFacturaVenta(ArrayList<Producto> productos, Cliente cliente){
    	Scanner entrada = new Scanner(System.in);
    	System.out.println("Ingrese unidades de esta venta: ");
    	int unidades = entrada.nextInt();
        ArrayList<Detalle> listaDetalles = new ArrayList<Detalle>();
        for (Producto producto: productos){
            Detalle detalle = new Detalle(producto, producto.getPrecio(), "Venta",unidades);
            listaDetalles.add(detalle);
        }
        Factura factura = new Factura(Datos.listaFacturas.size(),cliente, listaDetalles);
        agregarFactura(factura);
        System.out.println("***** SU VENTA HA SIDO REALIZADA EXITOSAMENTE *****");
        System.out.println(factura);

    }
    
    // Mostrar en pantalla las facturas registradas.
	public static void facturasRegistradas() {
		for (Factura factura : Datos.listaFacturas) {
			System.out.println(factura.toString()+"\n");
			idFactura++;
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
    
    
    // Generar factura cuando se haya producido una venta de una consola  en la tienda.
    public static void generarFacturaVenta1(ArrayList<Consola> productos, Cliente cliente){
        ArrayList<Detalle> listaDetalles = new ArrayList<Detalle>();
        for (Producto producto: productos){
            Detalle detalle = new Detalle(producto, producto.getPrecio(), "Venta",2);
            listaDetalles.add(detalle);
        }
        Factura factura = new Factura(Datos.listaFacturas.size(),cliente, listaDetalles);
        agregarFactura(factura);
        System.out.println(factura);

    }
    
    // Generar factura cuando se haya producido una venta de un perif�rico  en la tienda.
     public static void generarFacturaVenta2(ArrayList<Periferico> productos, Cliente cliente){
    	 Scanner entrada = new Scanner(System.in);
    	 System.out.println("Ingrese las unidades de esta venta: ");
    	 int unidades = entrada.nextInt();
        ArrayList<Detalle> listaDetalles = new ArrayList<Detalle>();
        for (Producto producto: productos){
            Detalle detalle = new Detalle(producto, producto.getPrecio(), "Venta",unidades);
            listaDetalles.add(detalle);
        }
        Factura factura = new Factura(Datos.listaFacturas.size(),cliente, listaDetalles);
        agregarFactura(factura);
        System.out.println(factura);
    }
    
    // Generar factura cuando se haya producido una venta de un juego en la tienda.
    public static void generarFacturaVenta3(ArrayList<Juego> productos, Cliente cliente){
    	Scanner entrada = new Scanner(System.in);
    	System.out.println("Ingrese las unidades de esta venta: ");
    	int unidades = entrada.nextInt();
        ArrayList<Detalle> listaDetalles = new ArrayList<Detalle>();
        for (Producto producto: productos){
            Detalle detalle = new Detalle(producto, producto.getPrecio(), "Venta",unidades);
            listaDetalles.add(detalle);
        }
        Factura factura = new Factura(Datos.listaFacturas.size(),cliente, listaDetalles);
        agregarFactura(factura);
        System.out.println(factura);
    }
}