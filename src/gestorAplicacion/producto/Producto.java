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

// En este módulo se crea la clase asbtracta Producto, así como sus métodos básicos (Get y Set), además se definen un conjunto de atributos,
// los cuales almacenarán información acerca de cada producto  que se vaya registrando en la plataforma.

package gestorAplicacion.producto;
import java.io.Serializable;
import java.util.Scanner;

public abstract class Producto implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id = 1;
    protected String nombre;
    private float precio;
    private Boolean uso;  

    // Se crean los métodos Get y Set de los atributos de la Clase Producto
    public float getPrecio() {
        return precio;
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
    
    // M�todo que especifica los indices para seleccionar uno o m�s productos.
	public static int[] seleccionProductos(int tope){
		 Scanner entrada = new Scanner(System.in);
		int[] ints = new int[tope];
		for(int i=0; i<tope; i++) {
			ints[i] = entrada.nextInt();
			System.out.println(ints[i]);
		}
		return ints;
	}

    public abstract String toString();

    // Se crea el constructor de la clase periferico, con sus atributos como parámetros.
    public Producto(String nombre, boolean uso, float precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.uso = uso;
    }
    
    // Constructor que cambia el nombre del producto.
    public Producto(String nombre) {
        this.nombre=nombre;
    }
    
    //String que retorna la descripci�n de un producto.
    public String descripcionProducto(){
        String checker1 = "";
        if(uso){
            checker1 = " usado";
        } else if (!uso){
            checker1 = " nuevo";
        }
        return getNombre() + " " + checker1;
    }
}
