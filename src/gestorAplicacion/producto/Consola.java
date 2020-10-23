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

// En este módulo se crea la clase Consola, así como sus métodos básicos (Get y Set), además se definen un conjunto de atributos,
// los cuales almacenarán información acerca de cada Consola que se vaya registrando en la plataforma.

package gestorAplicacion.producto;

import java.util.ArrayList;
import java.util.Scanner;
import BaseDatos.Datos;
import gestorAplicacion.transacciones.Cliente;
import gestorAplicacion.transacciones.Factura;

import java.io.Serializable;

public class Consola extends Producto implements Serializable {
	private static final long serialVersionUID = 1L;
    private String color;
    private boolean estado;
    private String version;
    private int almacenamiento;
    private static ArrayList<Consola> listaConsolas = Datos.listaConsolas; // Lista que almacena las consolas registradas en la tienda.
    
    
    // Se crean los métodos Get y Set de los atributos de la Clase Consola
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
    
    // Agrega una consola a listaConsolas
    public void agregarConsola(Consola consola) {
        listaConsolas.add(consola);
    }    
    public ArrayList<Consola> getListaConsolas() {
        return Datos.listaConsolas;
    }
    
    // metodo que le solicita al usuario ingresar los datos basicos de la consola que posteriormente se ingresar� a la base
    // de datos de la tienda.
    public static void ingresarConsola() {
    	Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre de consola: ");
        String nombre = entrada.next();
        System.out.println("Ingrese el uso (true si la consola est� usada o  false si la consola est� nueva): ");
        Boolean uso = entrada.nextBoolean();
        System.out.println("Ingrese el precio de la consola ");
        float precio = entrada.nextFloat();
        System.out.println("Ingrese el color de la consola: ");
        String color = entrada.next();
        System.out.println("Ingrese el  nombre de la version de la consola: ");
        String version = entrada.next();
        System.out.println("Ingrese la cantidad almacenamiento en Gb: ");
        int almacenamiento = entrada.nextInt();
        Consola consola = new Consola(nombre, uso, precio, color, version, almacenamiento);
        Datos.listaConsolas.add(consola);
        Consola.consolasRegistradas();
        System.out.println(Datos.listaConsolas);
    }
    public static void ventaConsola(Cliente cliente) {
    	//si la entrada fue 1, se muestran las consolas disponibles y se pide la cantidad de consolas a vender
    	Scanner entrada = new Scanner(System.in);
		Consola.consolasRegistradas();
		System.out.println("¿Cuántas consolas desea vender?: ");
		int tope = entrada.nextInt();				
		System.out.println("Ingrese el índice de la/s consola/s desea vender: ");
		int[] ints = Producto.seleccionProductos(tope);
		ArrayList<Producto> productos = Consola.consolaPorIndice(ints);
		for (Producto pro: productos){
			System.out.println(pro);
			//se borra la/s consola/s vendidas de la lista
			Consola.consolaVendida((Consola)pro);
		}				
		//se hace el llamado al metodo de la clase Datos para generar una factura de venta
		Factura.generarFacturaVenta(productos, cliente);
		cliente.agregarPunto();
		Consola.consolasRegistradas();
		Cliente.clientesRegistrados();
    }
    
    // 
    public static ArrayList<Producto> consolaPorIndice(int[] ints){
        ArrayList<Producto> nuevaLista = new ArrayList<Producto>();
        for (int i: ints){
            nuevaLista.add(Datos.listaConsolas.get(i-1));
        }
        return nuevaLista;
    }

    // Se crea el constructor de la clase Consola, con sus atributos como parámetros.
    public Consola(String nombre, boolean uso, float precio, String color, String version, int almacenamiento) {
        super(nombre, uso, precio);
        this.color = color;
        this.version = version;
        this.almacenamiento = almacenamiento;      
    }
    
  //Constructor que se utilizará con la finalidad de crear consolas para reparar.
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
   
    // Se crea el toString de la clase Consola, el cual mostrará por pantalla la consola y sus caracteristicas
    @Override
    public String toString() {
        return "Consola: " + getNombre() + " " + almacenamiento + " " + getVersion() +" "+ getPrecio();
    }
    
   // se crea metodo repararConsola para comprobar si la consola ya se ha reparado.
    public void repararConsola(Consola consola){
    	if (consola.getEstado()==false){
    		System.out.println("La Consola ya se encuentra reparada");
    	}else {
    		consola.setEstado(false);
    		System.out.println("Se ha reparado la consola");
    	}
    }
    
    public static void consolaVendida(Consola consola) {
    	Datos.listaConsolas.remove(consola);
    }
}



