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

// En este modulo se crea la clase asbtracta Producto, asi como sus metodos basicos (Get y Set), ademas se definen un conjunto de atributos,
// los cuales almacenaran informacion acerca de cada producto  que se vaya registrando en la plataforma.

package gestorAplicacion.producto;
import java.io.Serializable;
import java.util.Scanner;

public abstract class Producto implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id = 1;
    protected String nombre;
    private float precio;
    private Boolean uso;  

    // Se crean los metodos Get y Set de los atributos de la Clase Producto
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
    	this.precio=precio;
    }

    public Boolean getUso() {
        return uso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Metodo que especifica los indices para seleccionar uno o mas productos.
	public static int[] seleccionProductos(int tope){
		 Scanner entrada = new Scanner(System.in);
		int[] ints = new int[tope];
		for(int i=0; i<tope; i++) {
			ints[i] = entrada.nextInt();
			System.out.println(ints[i]);
		}
		return ints;
	}
	// Metodo abstracto que lo implementaran las Clases Juego, Consola y Periferico.
    public abstract String toString();

    // Se crea el constructor de la clase periferico, con sus atributos como parametros.
    public Producto(String nombre, boolean uso, float precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.uso = uso;
    }
    
    // Constructor que cambia el nombre del producto.
    public Producto(String nombre) {
        this.nombre=nombre;
    }
    
    // String que retorna la descripcion de un producto.
    public String descripcionProducto(){
        String checker1 = "";
        if(uso){
            checker1 = " Usado";
        } else if (!uso){
            checker1 = " Nuevo";
        }
        return "  ||  " + "Estado:"  + checker1;
    }
}