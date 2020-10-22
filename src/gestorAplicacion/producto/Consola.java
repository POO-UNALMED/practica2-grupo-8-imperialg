/*1). En las fuentes se incluirá la siguiente documentación:
      Cabecera del archivo: funcionalidad del módulo, autores, componentes del módulo, etc.
      Cabeceras en las clases, explicando su finalidad y describiendo las estructuras de datos definidas cuando
        sean relevantes.
      Cabeceras en los métodos, comentando su propósito y describiendo los parámetros de entrada/salida.
         Comentarios en líneas de código de relevante interés o importancia.
         Otros aspectos de interés a tener en cuenta por el profesor.*/
package gestorAplicacion.producto;

import java.util.ArrayList;
import java.util.Scanner;

import BaseDatos.Datos;
public class Consola extends Producto {
    private String color;
    private boolean estado;
    private String version;
    private int almacenamiento;
    private static ArrayList<Consola> listaConsolas = Datos.listaConsolas;

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
    
    public void agregarConsola(Consola consola) {
        listaConsolas.add(consola);
    }    
    public ArrayList<Consola> getListaConsolas() {
        return Datos.listaConsolas;
    }
    public static void ingresarConsola() {
    	Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese nombre de consola: ");
        String nombre = entrada.next();
        System.out.println("Ingrese uso(true or false): ");
        Boolean uso = entrada.nextBoolean();
        System.out.println("Ingrese precio ");
        float precio = entrada.nextFloat();
        System.out.println("Ingrese color: ");
        String color = entrada.next();
        System.out.println("Ingrese nombre de la version: ");
        String version = entrada.next();
        System.out.println("Ingrese cantidad almacenamiento: ");
        int almacenamiento = entrada.nextInt();
        Consola consola = new Consola(nombre, uso, precio, color, version, almacenamiento);
        Datos.listaConsolas.add(consola);
        Consola.consolasRegistradas();
        System.out.println(Datos.listaConsolas);
    }
    
    public static ArrayList<Producto> consolaPorIndice(int[] ints){
        ArrayList<Producto> nuevaLista = new ArrayList<Producto>();
        for (int i: ints){
            nuevaLista.add(Datos.listaConsolas.get(i-1));
        }
        return nuevaLista;
    }


    public Consola(String nombre, boolean uso, float precio, String color, String version, int almacenamiento) {
        super(nombre, uso, precio);
        this.color = color;
        this.version = version;
        this.almacenamiento = almacenamiento;      
    }
  //Constructor que se utilizará con la finalidad de crear consolas para reparar
    public Consola(String nombre, String color, boolean estado, int almacenamiento) {
        super(nombre);
        this.color = color;
        this.estado = estado;
        this.almacenamiento = almacenamiento;
    }
    
	// Mostrar en pantalla las consolas registradas:
	public static void consolasRegistradas() {
		int indiceConsola = 1;
		for (Consola consola : Datos.listaConsolas) {
			System.out.println(indiceConsola + " " + consola.toString());
			indiceConsola ++;
		}
	}
   
    @Override
    public String toString() {
        return "Consola: " + getNombre() + " " + almacenamiento + " " + getVersion() + getPrecio();
    }
    
   // métodos
    
    public void repararConsola(Consola consola){
    	if (consola.getEstado()==false){
    		System.out.println("La Consola ya se encuentra reparada");
    	}else {
    		consola.setEstado(false);
    		System.out.println("Se ha reparado la consola");
    	}
    }
}



