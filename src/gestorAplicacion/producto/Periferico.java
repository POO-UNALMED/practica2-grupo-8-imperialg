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

// En este modulo se crea la clase Periferico, asi como sus metodos basicos (Get y Set), ademas se definen un conjunto de atributos,
// los cuales almacenaran informacion acerca de cada Periferico  que se vaya registrando en la plataforma.

// La clase contiene aquellos atributos que modelan los perifericos, es decir la plataforma en la que funcionan y su estado.

package gestorAplicacion.producto;
import java.io.Serializable;
import BaseDatos.Datos;
import gestorAplicacion.transacciones.*;
import java.util.*;

public class Periferico extends Producto implements Serializable,Hardware{
	private static final long serialVersionUID = 1L;
    private String plataforma;
    private boolean estado;
    private static ArrayList<Periferico> listaPerifericos = Datos.listaPerifericos; // Lista con los perifericos registrados en la tienda.
    
    // Se crean los metodos Get y Set de los atributos de la Clase Periferico

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    
    public boolean getEstado() {
    	return estado;
    }
    
    public void setEstado(boolean estado) {
    	this.estado=estado;
    }
    
    // Agrega un periferico a listaPerifericos
    public void agregarPeriferico(Periferico periferico) {
        listaPerifericos.add(periferico);
    }
    
    public ArrayList<Periferico> getListaPerifericos() {
        return Datos.listaPerifericos;
    }  
    
    // Metodo que devuelve un Arraylist con los perifericos segun los indices ingresados por el usuario.
    public static ArrayList<Producto> perifericoPorIndice(int[] ints){
        ArrayList<Producto> nuevaLista = new ArrayList<Producto>();
        for (int i: ints){
            nuevaLista.add(Datos.listaPerifericos.get(i-1));
        }
        return nuevaLista;
    }

    public Periferico() {
    }
    public Periferico(String nombre,float precio) {
    	super(nombre,precio);
    }


    // Se crea el constructor de la clase periferico, con sus atributos como parametros.
    public Periferico(String nombre, boolean uso, float precio, String plataforma) {
        super(nombre, uso, precio);
        this.plataforma = plataforma;
        Datos.listaPerifericos.add(this);
    }

    // Constructor que retornara el nobre del periferico y el estado del mismo (bueno o malo).
    public Periferico(String nombre, boolean estado) {
        super(nombre);
        this.estado = estado;
    }
    // Se crea el toString de la clase Periferico, el cual mostrara por pantalla el nombre del periferico y la plataforma a la
    // cual esta asociado.
    @Override
    public String toString() {
        return  "Nombre del periferico: " + getNombre() + "  ||  " + "Plataforma asociada al periferico: " + plataforma + "  ||  " + "Precio: " + "COP $" +  getPrecio()+this.descripcionProducto();
    }

    // Se crea metodo repararPeriferico para comprobar si el periferico ya se ha reparado.
    public void repararPeriferico(Periferico periferico){
    	if (periferico.getEstado()==false){
    		System.out.println("El periferico ya se encuentra reparado.");
    	}else {
    		periferico.setEstado(false);
    		System.out.println("Se ha reparado el periferico.");
    	}
    }
    // Metodo que modifica el precio de uno o mas perifericos dados un array de indices y uno de precios.
    public static void modificarPreciosPerifericos(int[] ints, int[] precios){
        int indice = 0;
        for (int i: ints){
            Datos.listaPerifericos.get(i-1).setPrecio(precios[indice]);
            indice++;
        }
    }
    
    // Suma de precios en listaFacturas dado un nombre de periferico
    public static Float precioss(String nombre) {
    	Float todoslosprecios = (float) 0;
           for (Factura factura: Datos.listaFacturas){
        	   if(factura.getDetalles().get(0).getProducto().nombre.equals(nombre)) {
        		   todoslosprecios += factura.getDetalles().get(0).getPrecio();
        	   }   	   
           }
          return todoslosprecios;
    }    
    
    // Suma de las unidades vendidas en listaFacturas dado un nombre de periferico
    public static int unidadess(String nombre) {
    	int todaslasfacturas = 0;
           for (Factura factura: Datos.listaFacturas){
        	   if(factura.getDetalles().get(0).getProducto().nombre.equals(nombre)) {
        		   todaslasfacturas += factura.getDetalles().get(0).getUnidades();
        	   }   	   
           }
          return todaslasfacturas;
    }
    // Se crea un arraylist que contiene los nombres de las consolas que se han vendido y la frecuencia de venta de cada uno.
    public static ArrayList<String> productosVendidos(){
        ArrayList<Detalle> todoslosdetalles = new ArrayList<Detalle>();
        for (Factura factura: Datos.listaFacturas){
            todoslosdetalles.addAll(factura.getDetalles());
            
        }
        ArrayList<Detalle> depurados = new ArrayList<Detalle>();
        for (Detalle detalle: todoslosdetalles){
            if(detalle.getTiposervicio().equals("Venta")){            	
                depurados.add(detalle);
            }
        }
        ArrayList<String> todoslosNombres = new ArrayList<String>();
        for (Detalle detalle: depurados){        	
            if(detalle.getProducto() instanceof Periferico){
                todoslosNombres.add(detalle.getProducto().nombre);
            }
        }
        
       return todoslosNombres;
    }
    
    // Permite ver el precio de un periferico en la lista de facturas dado su nombre.
 	public static Float precioPeriferico(String nombre){
 		float precio = 0;
 		for(Periferico periferico: Datos.listaPerifericos){
 			if(periferico.getNombre().equals(nombre)) {
 				precio = periferico.getPrecio();
 			}
 		}return precio;
 	}

    @Override
    // Si el estado se encuentra en false, quiere decir que el periferico esta reparado o bueno en su defecto.
    public void Reparar() {
        this.estado = false;
    }
    @Override
    // String que retorna la descripcion del producto, aqui aplica ligadura dinamica.
    public String descripcionProducto(){
        String checker= null;
        if (estado){
            checker = "Averiado/a";
        } else if (!estado){
            checker = "Funcional";
        }
        return "  ||  "  + " Estado: " + checker;
    }
}