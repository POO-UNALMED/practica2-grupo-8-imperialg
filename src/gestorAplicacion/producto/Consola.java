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
    
    // Metodo que le solicita al usuario ingresar los datos basicos de la consola que posteriormente se ingresara la base
    // de datos de la tienda.
    public static void ingresarConsola(String nombre,Boolean uso,float precio,String color,String version,int almacenamiento) {
        Consola consola = new Consola(nombre, uso, precio, color, version, almacenamiento);
        Datos.listaConsolas.add(consola);
    }
    public static void ventaConsola(Cliente cliente) {
    	// Si la entrada fue 1, se muestran las consolas disponibles y se pide la cantidad de consolas a vender.
    	Scanner entrada = new Scanner(System.in);
		Consola.consolasRegistradas();
		System.out.println("Ingrese la cantidad de Consolas a vender: ");
		int tope = entrada.nextInt();			
		System.out.println("Ingrese el indice de la/s consola/s que desea vender: ");
		int[] ints = Producto.seleccionProductos(tope);
		ArrayList<Producto> productos = Consola.consolaPorIndice(ints);
		for (Producto pro: productos){
			System.out.println(pro);			
		}			
		
		//se hace el llamado al metodo de la clase Datos para generar una factura de venta
		cliente.agregarPunto(5);
		System.out.println("\n"+ "Lista de Clientes con puntos actualizados despues de la compra:" +"\n");
		Cliente.clientesRegistrados();
    }
    
    // Modificar consolas externas de la tienda.
    public static void modificarConsola(ArrayList<Detalle> detalles) {
    	Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese el nombre de la consola: ");
		String nombre = entrada.next();
		System.out.println("Ingrese el color de la consola: ");
		String color = entrada.next();
		System.out.println("Ingrese el estado de la consola (true si la consola esta usada o  false si la consola esta nueva) ");
		Boolean estado = entrada.nextBoolean();
		System.out.println("Ingrese la capacidad de almacenamiento en Gb de la consola: ");
		int almacenamiento = entrada.nextInt();
		Consola producto = new Consola(nombre, color, estado, almacenamiento);
		System.out.println("Ingrese el tipo de Servicio tecnico: ");
		String tiposervicio = entrada.next();
		System.out.println("Ingrese el precio del servicio tecnico: ");
		float precio = entrada.nextFloat();
		System.out.println("Ingrese las unidades a las que se les aplicara el servicio tecnico: ");
		int unidades = entrada.nextInt();
		Detalle detalle = new Detalle(producto, precio, tiposervicio,unidades);
		detalles.add(detalle);
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
    }
    
    // Constructor que se utilizara con la finalidad de crear consolas para reparar.
    public Consola(String nombre, String color, boolean estado, int almacenamiento) {
        super(nombre);
        this.color = color;
        this.estado = estado;
        this.almacenamiento = almacenamiento;
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
  
    
    // Metodo para eliminar una consola de la base de datos.
    public static void borrarConsola() {
    	Scanner entrada = new Scanner(System.in);    	
    	consolasRegistradas();
    	System.out.println("Ingrese el indice de la Consola que desea borrar: ");
    	int indice = entrada.nextInt();    	
    	Datos.listaConsolas.remove(Datos.listaConsolas.get(indice-1));
    	consolasRegistradas();
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
 	// Metodo que obtiene el juego mas vendido en la tienda.
 	public static void ConsolasMasVendidas(){		
        ArrayList<String> nombres = Consola.productosVendidos();        
        ArrayList<String> nombresUnicos = new ArrayList<String>();
        for (String nombre: nombres){
            if(!nombresUnicos.contains(nombre))
                nombresUnicos.add(nombre);
        }
        System.out.println("Nombre de la Consola"+"       ||      "+"Unidades Vendidas"+ "    ||    "+"Precio por unidad"+"    ||    "+" Subtotal ");
        Float total = (float) 0;
        for (String nombre: nombresUnicos){
        	total += precioss(nombre);
            System.out.println("    "+nombre + "                           " +unidadess(nombre) +" undidades                 "+precioConsola(nombre)+"$ COP "+"              "+precioss(nombre));
        } System.out.println("***** TOTAL DE GANANCIAS POR VENTA DE CONSOLAS: " + "||" + "COP $ " + total + " *****");
        
    }
 	
 	// Metodo para conocer cual es la consola mas vendida de la tienda-
 	public static void ConsolaMasVendida(){
 		
        ArrayList<String> nombres = Consola.productosVendidos();
        ArrayList<String> nombresUnicos = new ArrayList<String>();
        ArrayList<Integer> cantidadesunidad = new ArrayList<Integer>();
        for (String nombre: nombres){
            if(!nombresUnicos.contains(nombre))
                nombresUnicos.add(nombre);
        }
        for (String nombre: nombresUnicos){
            cantidadesunidad.add(unidadess(nombre));
        }
        
        int aux = 0;
        String s = "";
        for(int x=0;x<cantidadesunidad.size();x++) {
        	if(cantidadesunidad.get(x)>aux) {
        		aux = cantidadesunidad.get(x);
        		s = nombresUnicos.get(x);
        	}
        }System.out.println("\n"+"NOMBRE DE LA CONSOLA MAS VENDIDA: "+s+"  ||  "+"Unidades Vendidas: "+aux);
        
        int aux1 = cantidadesunidad.get(0);
        String s1 = "";
        for(int x=0;x<cantidadesunidad.size();x++) {
        	if(cantidadesunidad.get(x)<=aux1) {
        		aux1 = cantidadesunidad.get(x);
        		s1 = nombresUnicos.get(x);
        	}
        }System.out.println("\n"+"NOMBRE DE LA CONSOLA MENOS VENDIDA: "+s1+"  ||  "+"Unidades Vendidas: "+aux1);
        
    }
    
 	
 	// Metodo que moodifica el precio de algunas consolas, dado un array de indices y un array de precios.
    public static void modificarPreciosConsolas(int[] ints, int[] precios){
        int indice = 0;
        for (int i: ints){
            Datos.listaConsolas.get(i-1).setPrecio(precios[indice]);
            indice++;
        }
    }
    
    // Implementacion del metodo reparar (Si el estado es false, indica que la consola esta reparada en su defecto buena).
    public void Reparar() {
        this.estado = false;
    }
    
    // Metodo para cambiar el color de una consola.
    public void modificarReparar(String color){
        this.estado= false;
        this.color = color;
    }
    
    // Metodo para cambiar la capacidad de almacenamiento (en GB) de una consola.
    public void modificarReparar(int almacenamiento){
        this.estado = false;
        this.almacenamiento = almacenamiento;
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