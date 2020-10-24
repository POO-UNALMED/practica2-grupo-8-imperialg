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
        System.out.println("Ingrese el precio de la consola: ");
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
		System.out.println("�Cu�ntas consolas desea vender?: ");
		int tope = entrada.nextInt();				
		System.out.println("Ingrese el indice de la/s consola/s que desea vender: ");
		int[] ints = Producto.seleccionProductos(tope);
		ArrayList<Producto> productos = Consola.consolaPorIndice(ints);
		for (Producto pro: productos){
			System.out.println(pro);
			//se borra la/s consola/s vendidas de la lista
			Consola.consolaVendida((Consola)pro);
		}	
		
		//se hace el llamado al metodo de la clase Datos para generar una factura de venta
		Factura.generarFacturaVenta(productos, cliente);
		cliente.agregarPunto(5);
		Consola.consolasRegistradas();
		Cliente.clientesRegistrados();
    }
    
    
    public static void modificarConsola(ArrayList<Detalle> detalles) {
    	Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese el nombre de la consola: ");
		String nombre = entrada.next();
		System.out.println("Ingrese el color de la consola: ");
		String color = entrada.next();
		System.out.println("Ingrese el estado de la consola (true si la consola est� usada o  false si la consola est� nueva) ");
		Boolean estado = entrada.nextBoolean();
		System.out.println("Ingrese el almacenamiento de la consola: ");
		int almacenamiento = entrada.nextInt();
		Consola producto = new Consola(nombre, color, estado, almacenamiento);
		System.out.println("Ingrese el tipo de Servicio T�cnico: ");
		String tiposervicio = entrada.next();
		System.out.println("Ingrese el precio del servicio t�cnico: ");
		float precio = entrada.nextFloat();
		Detalle detalle = new Detalle(producto, precio, tiposervicio);
		detalles.add(detalle);
    }
    
    // M�todo que devuelve un Arraylist con las consolas seg�n los indices ingresados por el usuario
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
			System.out.println(indiceConsola + "  ||  " + consola.toString());
			indiceConsola ++;
		}
	}
   
    // Se crea el toString de la clase Consola, el cual mostrará por pantalla la consola y sus caracteristicas
    @Override
    public String toString() {
        return "Nombre de la consola: " + getNombre() + "  ||  " + "Capacidad de almacenamiento: " +  almacenamiento + " Gb" + "  ||  " +"Garantía: "+ garantia +" meses "+"  ||  " + "Version de la consola: " +  getVersion() + "  ||  " + "Precio: " + "COP $" + getPrecio();
    }
  
    
    // M�todo para eliminar una consola de la base de datos de la tienda luego de ser vendida.
    public static void consolaVendida(Consola consola) {
    	Datos.listaConsolas.remove(consola);
    }
    
    
    // Se crea un arraylist que contiene los nombres de las consolas que se han vendido y la frecuencia de venta de cada uno.
    public static ArrayList<String> productosVendidos(){
        ArrayList<Detalle> todoslosdetalles = new ArrayList<Detalle>();
        for (Factura factura: Datos.listaFacturas){
            todoslosdetalles.addAll(factura.getDetalles());
        }
        ArrayList<Detalle> depurados = new ArrayList<Detalle>();
        for (Detalle detalle: todoslosdetalles){
            if(detalle.getTiposervicio()== "Venta"){
                depurados.add(detalle);
            }
        }
        ArrayList<String> todoslosNombres = new ArrayList<String>();
        for (Detalle detalle: depurados){
            if(detalle.getProducto() instanceof Consola){
                todoslosNombres.add(detalle.getProducto().nombre);
                System.out.println(detalle.getProducto().nombre);
            }
        }
        return todoslosNombres;
    }
    
    // M�todo para obtener la consola m�s vendida de la tienda.
    public static void consolaMasVendida(){
        ArrayList<String> nombres = Consola.productosVendidos();
        ArrayList<String> nombresUnicos = new ArrayList<String>();
        for (String nombre: nombres){
            if(!nombresUnicos.contains(nombre))
                nombresUnicos.add(nombre);
        }
        ArrayList<Integer> numeroDeUnidadesVendidas = new ArrayList<Integer>();
        int i = 0;
        for (String nombre: nombresUnicos){
            System.out.println("Nombre de la consola: " + nombre + "  ||  " + "Unidades vendidas: " + Collections.frequency(nombres, nombre));
        }
        
    }
    
 // Método que moodifica el precio de algunas consolas, dado un array de indices y un array de precios.
    public static void modificarPreciosConsolas(int[] ints, int[] precios){
        int indice = 0;
        for (int i: ints){
            Datos.listaConsolas.get(i-1).setPrecio(precios[indice]);
            indice++;
        }
    }
    
    // Implementaci�n del m�todo reparar (Si el estado es false, indica que la consola est� reparada en su defecto buena).
    public void Reparar() {
        this.estado = false;
    }
    
    // M�todo para cambiar el color de una consola.
    public void modificarReparar(String color){
        this.estado= false;
        this.color = color;
    }
    
    // M�todo para cambiar la capacidad de almacenamiento (en GB) de una consola.
    public void modificarReparar(int almacenamiento){
        this.estado = false;
        this.almacenamiento = almacenamiento;
    }
    
    // M�todo que obtiene la descripci�n de las consolas de listaConsolas.
    public static void descripcionConsolas() {
        int indiceConsola = 1;
        for (Consola consola : Datos.listaConsolas) {
            System.out.println(indiceConsola + " " + consola.descripcionProducto());
            indiceConsola ++;
        }
    }
    
    
    //String que retorna la descripci�n del producto, aqu� aplica ligadura din�mica.
    // La descripci�n de una consola consta de: Su versi�n, su capacidad de almacenamiento y su estado ( buena o mala )
    @Override
    public String descripcionProducto(){
        String checker= null;
        if (estado){
            checker = "Averiado/a";
        } else if (!estado){
            checker = "Funcional";
        }
        return "Nombre de la consola: " +   getNombre() +  "  ||  " + "Versi�n: " + getVersion() + "  ||  " +  "Con almacenamiento de: " + almacenamiento + " Gb" +  "  ||  " + "Garantía: "+ garantia +" meses "+ "en estado: " + checker;
    }
        
}



