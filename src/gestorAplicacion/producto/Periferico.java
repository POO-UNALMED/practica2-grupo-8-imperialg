/*1). En las fuentes se incluirá la siguiente documentación:
//Se crea la clase periférico y sus respectivos métodos, haciendo parte del paquete producto.
        Cabeceras en las clases, explicando su finalidad y describiendo las estructuras de datos definidas cuando
        sean relevantes.
        Cabeceras en los métodos, comentando su propósito y describiendo los parámetros de entrada/salida.
        Comentarios en líneas de código de relevante interés o importancia.
        Otros aspectos de interés a tener en cuenta por el profesor.*/

/* Autores:   - Santiago Franco Valencia 
*            - Anderson Elian Gutierrez 
*            - Santiago Valencia Mejia
*            - Daniel Alejandro Giraldo  */

// En este módulo se crea la clase Periferico, así como sus métodos básicos (Get y Set), además se definen un conjunto de atributos,
// los cuales almacenarán información acerca de cada Periferico  que se vaya registrando en la plataforma.

// La clase contiene aquellos atributos que modelan los periféricos, es decir la plataforma en la que funcionan y su estado.

package gestorAplicacion.producto;
import java.util.Scanner;
import java.io.Serializable;
import BaseDatos.Datos;
import java.util.ArrayList;

public class Periferico extends Producto implements Serializable{
	private static final long serialVersionUID = 1L;
    private String plataforma;
    private boolean estado;
    private static ArrayList<Periferico> listaPerifericos = Datos.listaPerifericos; // Lista con los perifericos registrados en la tienda.
    
    // Se crean los métodos Get y Set de los atributos de la Clase Periferico

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
    
    // M�todo que solicita al usuario por pantalla los datos basicos del periferico, para posteriormente agregarlo a la base de 
    // datos de la tienda. 
    public static void ingresarPeriferico() {
    	Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del perif�rico: ");
        String nombre = entrada.next();
        System.out.println("Ingrese el uso (true si el perif�rico est� usado o  false si el perif�rico est� nuevo): ");
        Boolean uso = entrada.nextBoolean();
        System.out.println("Ingrese el precio del perif�rico (En COP $");
        float precio = entrada.nextFloat();
        System.out.println("Ingrese el nombre plataforma asociada al perif�rico: ");
        String plataforma = entrada.next();
        Periferico periferico = new Periferico(nombre, uso, precio, plataforma);       
        Datos.listaPerifericos.add(periferico);
        Periferico.perifericosRegistrados();
        System.out.println(Datos.listaPerifericos);
    }
    
    // 
    public static ArrayList<Producto> perifericoPorIndice(int[] ints){
        ArrayList<Producto> nuevaLista = new ArrayList<Producto>();
        for (int i: ints){
            nuevaLista.add(Datos.listaPerifericos.get(i-1));
        }
        return nuevaLista;
    }
    
	// Mostrar en pantalla los perifericos registrados:
	public static void perifericosRegistrados() {
		int indicePeriferico = 1;
		for (Periferico periferico : Datos.listaPerifericos) {
			System.out.println(indicePeriferico + " " + periferico.toString());
			indicePeriferico ++;
		}
	}

    // Se crea el constructor de la clase perif�rico, con sus atributos como parámetros.
    public Periferico(String nombre, boolean uso, float precio, String plataforma) {
        super(nombre, uso, precio);
        this.plataforma = plataforma;
    }

    // Constructor que retornar� el nobre del perif�rico y el estado del mismo (bueno o malo)
    public Periferico(String nombre, boolean estado) {
        super(nombre);
        this.estado = estado;
    }
    // Se crea el toString de la clase Periferico, el cual mostrará por pantalla el nombre del periferico y la plataforma a la
    // cual est� asociado.
    @Override
    public String toString() {
        return getNombre() + " " + plataforma + getPrecio();
    }

    // Se crea metodo repararPeriferico para comprobar si el periferico ya se ha reparado.
    public void repararPeriferico(Periferico periferico){
    	if (periferico.getEstado()==false){
    		System.out.println("El perif�rico ya se encuentra reparado");
    	}else {
    		periferico.setEstado(false);
    		System.out.println("Se ha reparado el perif�rico");
    	}
    }
}

