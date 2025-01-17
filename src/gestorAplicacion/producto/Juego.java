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

// En este modulo se crea la clase Juego, asi� como sus metodos basicos (Get y Set), ademas se definen un conjunto de atributos,
// los cuales almacenaran informacion acerca de cada Juego que se vaya registrando en la plataforma.

package gestorAplicacion.producto;
import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import BaseDatos.Datos;
import gestorAplicacion.transacciones.*;


public class Juego extends Producto implements Serializable{
	private static final long serialVersionUID = 1L;
    private int pegi; // Parametro que categoriza los juegos de acuerdo a la edad minima requerida para poder jugarlos.
    private String plataforma;
    private String genero;
    private static ArrayList<Juego> listaJuegos = Datos.listaJuegos; // Lista con los juegos registrados en la tienda.

    public Juego() {
    }


    // Se crean los metodos Get y Set de los atributos de la Clase Consola.
    public int getPegi() {
        return pegi;
    }

    public void setPegi(int pegi) {
        this.pegi = pegi;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public void agregarJuego(Juego juego) {
        listaJuegos.add(juego);
    }
    public void venderJuego(){
    	
    }
    public ArrayList<Juego> getListaJuegos() {
        return Datos.listaJuegos;
    }
    

    public Juego(String nombre, float precioReparacion){
        super(nombre, precioReparacion);
    }
	
	 public static Float precioss(String nombre) {
	    Float todoslosprecios = (float) 0;
	         for (Factura factura: Datos.listaFacturas){
	       	   if(factura.getDetalles().get(0).getProducto().nombre.equals(nombre)) {
	        		   todoslosprecios += factura.getDetalles().get(0).getPrecio();
	       	   }   	   
	       }
	          return todoslosprecios;
	  }    
	    
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
	            if(detalle.getProducto() instanceof Juego){
	                todoslosNombres.add(detalle.getProducto().nombre);
	            }
	        }
	        
	       return todoslosNombres;
	    }
	 	public static Float precioJuego(String nombre){
	 		float precio = 0;
	 		for(Juego juego: Datos.listaJuegos){
	 			if(juego.getNombre().equals(nombre)) {
	 				precio = juego.getPrecio();
	 			}
	 		}return precio;
	 	}
		
    
    // Se crea el constructor de la clase Juego, con sus atributos como parametros.
    public Juego(String nombre, boolean uso, float precio, int pegi, String plataforma, String genero) {
        super(nombre, uso, precio);
        this.pegi = pegi;
        this.plataforma = plataforma;
        this.genero = genero;
        Datos.listaJuegos.add(this);
    }
    
    // Se crea el toString de la clase Juego, el cual mostrara por pantalla el nombre del juego, la plataforma a la que pertenece y su precio.
    @Override
    public String toString() {
        return "Nombre del juego: "+ getNombre() + "  ||  " + "Plataforma asociada al juego: " + plataforma + "  ||  " + "Precio: " + "COP $" + getPrecio() + this.descripcionProducto();
    }
}