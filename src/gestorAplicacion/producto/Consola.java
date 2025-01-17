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

// En este modulo se crea la clase Consola, asi como sus metodos basicos (Get y Set), ademas se definen un conjunto de atributos,
// los cuales almacenaran informacion acerca de cada Consola que se vaya registrando en la plataforma.

package gestorAplicacion.producto;
import BaseDatos.Datos;
import gestorAplicacion.transacciones.*;
import java.util.*;

import java.io.Serializable;

public class Consola extends Producto implements Serializable, Hardware {
	private static final long serialVersionUID = 1L;
    private String color;
    private boolean estado;
    private String version;
    private int almacenamiento;
    private final int garantia=6;
    private static ArrayList<Consola> listaConsolas = Datos.listaConsolas; // Lista que almacena las consolas registradas en la tienda.


    // Se crean los metodos Get y Set de los atributos de la Clase Consola.
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public boolean getEstado() {
    	return estado;
    }
    
    public void setEstado(boolean estado) {
    	this.estado = estado;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = almacenamiento;
    }
    
    // Agrega una consola a listaConsolas.
    public void agregarConsola(Consola consola) {
        listaConsolas.add(consola);
    }    
    public ArrayList<Consola> getListaConsolas() {
        return Datos.listaConsolas;
    }

    
    // Metodo que devuelve un Arraylist con las consolas segun los indices ingresados por el usuario.
    public static ArrayList<Producto> consolaPorIndice(int[] ints){
        ArrayList<Producto> nuevaLista = new ArrayList<Producto>();
        for (int i: ints){
            nuevaLista.add(Datos.listaConsolas.get(i-1));
        }
        return nuevaLista;
    }

    // Se crea el constructor de la clase Consola, con sus atributos como parametros.
    public Consola(String nombre, boolean uso, float precio, String color, String version, int almacenamiento) {
        super(nombre, uso, precio);
        this.color = color;
        this.version = version;
        this.almacenamiento = almacenamiento;
        Datos.listaConsolas.add(this);
    }
    
    // Constructor que se utilizara con la finalidad de crear consolas para reparar.
    public Consola(String nombre, String color, boolean estado, int almacenamiento) {
        super(nombre);
        this.color = color;
        this.estado = estado;
        this.almacenamiento = almacenamiento;
    }

    public Consola(String nombre,float precio){
    	super(nombre,precio);
    	
    }
    public Consola() {
    	
    }

    // Mostrar en pantalla las consolas registrads.
	public static void consolasRegistradas() {
		int indiceConsola = 1;
		for (Consola consola : Datos.listaConsolas) {
			System.out.println("Indice: "+indiceConsola + "  ||  " + consola.toString());
			indiceConsola ++;
		}
	}
   
    // Se crea el toString de la clase Consola, el cual mostrara por pantalla la consola y sus caracteristicas.
    @Override
    public String toString() {
        return "Nombre de la consola: " + getNombre() + "  ||  " + "Capacidad de almacenamiento: " +  almacenamiento + " Gb" + "  ||  " +"Garantia: "+ garantia +" meses "+"  ||  " + "Version de la consola: " +  getVersion() + "  ||  " + "Precio: " + "COP $" + getPrecio()+"  ||  "+this.descripcionProducto();
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
            if(detalle.getProducto() instanceof Consola){
                todoslosNombres.add(detalle.getProducto().nombre);
            }
        }
        
       return todoslosNombres;
    }
    
 	public static Float precioConsola(String nombre){
 		float precio = 0;
 		for(Consola consola: Datos.listaConsolas){
 			if(consola.getNombre().equals(nombre)) {
 				precio = consola.getPrecio();
 			}
 		}return precio;
 	}
    
    // Implementacion del metodo reparar (Si el estado es false, indica que la consola esta reparada en su defecto buena).
    public void Reparar() {
        this.estado = false;
    }
    

    // Metodo que obtiene la descripcion de las consolas de listaConsolas.
    public static void descripcionConsolas() {
        int indiceConsola = 1;
        for (Consola consola : Datos.listaConsolas) {
            System.out.println("Indice: "+indiceConsola + " " + consola.descripcionProducto());
            indiceConsola ++;
        }
    }
    
    
    // String que retorna la descripcion del producto, aqui aplica ligadura dinamica.
    // La descripcion de una consola consta de: Su version, su capacidad de almacenamiento y su estado ( buena o mala )
    @Override
    public String descripcionProducto(){
        String checker= null;
        if (estado){
            checker = "Averiado/a";
        } else if (!estado){
            checker = "Funcional";
        }
        return "En estado: " + checker;
    }


}