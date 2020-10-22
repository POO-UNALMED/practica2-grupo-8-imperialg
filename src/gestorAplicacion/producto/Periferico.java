/*1). En las fuentes se incluir√° la siguiente documentaci√≥n:
//Se crea la clase perif√©rico y sus respectivos m√©todos, haciendo parte del paquete producto.
        Cabeceras en las clases, explicando su finalidad y describiendo las estructuras de datos definidas cuando
        sean relevantes.
        Cabeceras en los m√©todos, comentando su prop√≥sito y describiendo los par√°metros de entrada/salida.
        Comentarios en l√≠neas de c√≥digo de relevante inter√©s o importancia.
        Otros aspectos de inter√©s a tener en cuenta por el profesor.*/

/* Autores:   - Santiago Franco Valencia 
*            - Anderson Elian Gutierrez 
*            - Santiago Valencia Mejia
*            - Daniel Alejandro Giraldo  */

// En este m√≥dulo se crea la clase Periferico, as√≠ como sus m√©todos b√°sicos (Get y Set), adem√°s se definen un conjunto de atributos,
// los cuales almacenar√°n informaci√≥n acerca de cada Periferico  que se vaya registrando en la plataforma.

// La clase contiene aquellos atributos que modelan los perif√©ricos, es decir la plataforma en la que funcionan y su estado.

package gestorAplicacion.producto;
import java.util.Scanner;
import BaseDatos.Datos;
import java.util.ArrayList;
import java.util.ArrayList;


public class Periferico extends Producto {
    private String plataforma;
    private boolean estado;
    private static ArrayList<Periferico> listaPerifericos = Datos.listaPerifericos; // Lista con los perifericos registrados en la tienda.
    
    // Se crean los m√©todos Get y Set de los atributos de la Clase Periferico

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
    
    public static ArrayList<Periferico> getListaPerifericos() {
        return listaPerifericos;
    }
    
    // MÈtodo que solicita al usuario por pantalla los datos basicos del periferico, para posteriormente agregarlo a la base de 
    // datos de la tienda. 
    public static void ingresarPeriferico() {
    	Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del perifÈrico: ");
        String nombre = entrada.next();
        System.out.println("Ingrese el uso (true si el perifÈrico est· usado o  false si el perifÈrico est· nuevo): ");
        Boolean uso = entrada.nextBoolean();
        System.out.println("Ingrese el precio del perifÈrico (En COP $");
        float precio = entrada.nextFloat();
        System.out.println("Ingrese el nombre plataforma asociada al perifÈrico: ");
        String plataforma = entrada.next();
        Periferico periferico = new Periferico(nombre, uso, precio, plataforma);       
        Datos.listaPerifericos.add(periferico);
        Periferico.perifericosRegistrados();
    }
    
    // 
    public static ArrayList<Producto> perifericoPorIndice(int[] ints){
        ArrayList<Producto> nuevaLista = new ArrayList<Producto>();
        for (int i: ints){
            nuevaLista.add(listaPerifericos.get(i-1));
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

    // Se crea el constructor de la clase perifÈrico, con sus atributos como par√°metros.
    public Periferico(String nombre, boolean uso, float precio, String plataforma) {
        super(nombre, uso, precio);
        this.plataforma = plataforma;
    }

    // Constructor que retornar· el nobre del perifÈrico y el estado del mismo (bueno o malo)
    public Periferico(String nombre, boolean estado) {
        super(nombre);
        this.estado = estado;
    }
    // Se crea el toString de la clase Periferico, el cual mostrar√° por pantalla el nombre del periferico y la plataforma a la
    // cual est· asociado.
    @Override
    public String toString() {
        return getNombre() + " " + plataforma + getPrecio();
    }

    // Se crea metodo repararPeriferico para comprobar si el periferico ya se ha reparado.
    public void repararPeriferico(Periferico periferico){
    	if (periferico.getEstado()==false){
    		System.out.println("El perifÈrico ya se encuentra reparado");
    	}else {
    		periferico.setEstado(false);
    		System.out.println("Se ha reparado el perifÈrico");
    	}
    }
}

