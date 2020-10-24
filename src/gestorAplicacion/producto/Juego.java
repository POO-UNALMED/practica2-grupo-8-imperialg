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

// En este módulo se crea la clase Juego, así como sus métodos básicos (Get y Set), además se definen un conjunto de atributos,
// los cuales almacenarán información acerca de cada Juego que se vaya registrando en la plataforma.

package gestorAplicacion.producto;

import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import BaseDatos.Datos;
import gestorAplicacion.transacciones.*;
import java.util.ArrayList;

public class Juego extends Producto implements Serializable{
	private static final long serialVersionUID = 1L;
    private int pegi; // parametro que categoriza los juegos de acuerdo a la edad minima requerida para poder jugarlos.
    private String plataforma;
    private String genero;
    private static ArrayList<Juego> listaJuegos = Datos.listaJuegos; // Lista con los juegos registrados en la tienda.
    

    // Se crean los métodos Get y Set de los atributos de la Clase Consola
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
    
    // Metodo que le solicita al usuario ingresar los datos basicos del juego que posteriormente se ingresar� a la base
    // de datos de la tienda.
    public static void ingresarJuego() {
    	Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del juego: ");
        String nombre = entrada.next();
        System.out.println("Ingrese el uso (true si el juego est� usado o  false si el juego est� nuevo): ");
        Boolean uso = entrada.nextBoolean();
        System.out.println("Ingrese el precio del juego: ");
        float precio = entrada.nextFloat();
        System.out.println("Ingrese pegi (Edad m�nima recomendada para jugar: ");
        int pegi = entrada.nextInt();
        System.out.println("Ingrese el nombre plataforma asociada al juego: ");
        String plataforma = entrada.next();
        System.out.println("Ingrese el genero del juego: ");
        String genero = entrada.next();
        Juego juego = new Juego(nombre, uso, precio, pegi, plataforma, genero);
        Datos.listaJuegos.add(juego);
        Juego.juegosRegistrados();
        System.out.println(Datos.listaJuegos);
    }
    
    // M�todo para seleccionar los juegos que se desean vender 
    public static void ventaJuego(Cliente cliente) {
    	Scanner entrada = new Scanner(System.in);
    	//si la entrada fue 2, se muestran los juegos disponibles y se pide la cantidad de juegos a vender
		Juego.juegosRegistrados();
		System.out.println("�Cu�ntos juegos desea vender?: ");
		int tope = entrada.nextInt();
		Juego.juegosRegistrados();
		System.out.println("Seleccione el indice de el/los Juego/s que desea vender: ");
		int[] ints = Producto.seleccionProductos(tope);
		ArrayList<Producto> productos = Juego.juegoPorIndice(ints);
		for(Producto pro: productos) {
			System.out.println(pro);
			Juego.juegoVendido((Juego)pro);
		}
		//se hace el llamado al metodo de la clase Datos para generar una factura de venta
		Factura.generarFacturaVenta(productos, cliente);
		cliente.agregarPunto();
		Juego.juegosRegistrados();
    }
    
    
    public static ArrayList<Producto> juegoPorIndice(int[] ints){
        ArrayList<Producto> nuevaLista = new ArrayList<Producto>();
        for (int i: ints){
            nuevaLista.add(Datos.listaJuegos.get(i-1));
        }
        return nuevaLista;
    }
    
    // Mostrar en pantalla los juegos registrados en la tienda.
	public static void juegosRegistrados() {
		int indiceJuego = 1;
		for (Juego juego : Datos.listaJuegos) {
			System.out.println(indiceJuego + " " + juego.toString());
			indiceJuego ++;
		}
	}
	
	public static void juegoVendido(Juego juego) {
		Datos.listaJuegos.remove(juego);
	}
    

    // Se crea el constructor de la clase Juego, con sus atributos como parámetros.
    public Juego(String nombre, boolean uso, float precio, int pegi, String plataforma, String genero) {
        super(nombre, uso, precio);
        this.pegi = pegi;
        this.plataforma = plataforma;
        this.genero = genero;
    }
    

    // Se crea el toString de la clase Consola, el cual mostrará por pantalla el nombre del juego y la plataforma a la que pertenece.
    @Override
    public String toString() {
        return "Nombre del juego: "+ getNombre() + "  ||  " + "Plataforma asociada al juego: " + plataforma + "  ||  " + "Precio: " + "COP $" + getPrecio() ;
    }
}

