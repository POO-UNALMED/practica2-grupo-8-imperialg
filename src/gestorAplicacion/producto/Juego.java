/*1). En las fuentes se incluirá la siguiente documentación:
         Cabecera del archivo: funcionalidad del módulo, autores, componentes del módulo, etc.
         Cabeceras en las clases, explicando su finalidad y describiendo las estructuras de datos definidas cuando
        sean relevantes.
<<<<<<< HEAD
         Cabeceras en los métodos, comentando su propósito y describiendo los parámetros de entrada/salida.
         Comentarios en líneas de código de relevante interés o importancia.
        Otros aspectos de interés a tener en cuenta por el profesor.*/
// Autores:   - Santiago Franco Valencia
//            - Anderson Elian Gutierrez
//            - Santiago Valencia Mejía
//            - Daniel Alejandro Giraldo
// En este módulo se crea la clase Juego, así como sus métodos básicos (Get y Set), además se definen un conjunto de atributos,
// los cuales almacenarán información acerca de cada Juego que se vaya registrando en la plataforma.
package gestorAplicacion.producto;
import java.util.Scanner;

import BaseDatos.Datos;

import java.util.ArrayList;

public class Juego extends Producto {
    private int pegi;
    private String plataforma;
    private String genero;
    private static ArrayList<Juego> listaJuegos = Datos.listaJuegos;   

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
    public static ArrayList<Juego> getListaJuegos() {
        return listaJuegos;
    }
    public static void ingresarJuego() {
    	Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese nombre del juego: ");
        String nombre = entrada.next();
        System.out.println("Ingrese uso(true or false): ");
        Boolean uso = entrada.nextBoolean();
        System.out.println("Ingrese precio ");
        float precio = entrada.nextFloat();
        System.out.println("Ingrese pegi: ");
        int pegi = entrada.nextInt();
        System.out.println("Ingrese nombre plataforma: ");
        String plataforma = entrada.next();
        System.out.println("Ingrese genero: ");
        String genero = entrada.next();
        Juego juego = new Juego(nombre, uso, precio, pegi, plataforma, genero);
        Datos.listaJuegos.add(juego);
        Juego.juegosRegistrados();
    }
    
    public static ArrayList<Producto> juegoPorIndice(int[] ints){
        ArrayList<Producto> nuevaLista = new ArrayList<Producto>();
        for (int i: ints){
            nuevaLista.add(listaJuegos.get(i-1));
        }
        return nuevaLista;
    }
    
    // Mostrar en pantalla los juegos registrados:
	public static void juegosRegistrados() {
		int indiceJuego = 1;
		for (Juego juego : Datos.listaJuegos) {
			System.out.println(indiceJuego + " " + juego.toString());
			indiceJuego ++;
		}
	}
    
    /* public Juego juegoMasVendido() {
    Juego masvendido = listaJuegos.get(0);
    for (Juego juego : listaJuegos) {
        if (juego.getUnidadesVendidas() > masvendido.getUnidadesVendidas()) {
            masvendido = juego;
        }
    }
    return masvendido;
}*/


    // Se crea el constructor de la clase Juego, con sus atributos como parámetros.
    public Juego(String nombre, boolean uso, float precio, int pegi, String plataforma, String genero) {
        super(nombre, uso, precio);
        this.pegi = pegi;
        this.plataforma = plataforma;
        this.genero = genero;
    }
    

    // Se crea el toString de la clase Consola, el cual mostrará por pantalla el Juego y sus caracteristicas.
    @Override
    public String toString() {
        return getNombre() + " " + plataforma + getPrecio() ;
    }
}
