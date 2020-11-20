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

// En este modulo se crea la clase Juego, asi� como sus metodos basicos (Get y Set), ademas se definen un conjunto de atributos,
// los cuales almacenaran informacion acerca de cada Juego que se vaya registrando en la plataforma.

package gestorAplicacion.producto;
import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import BaseDatos.Datos;
import gestorAplicacion.transacciones.*;


public class Juego extends Producto implements Serializable{
	private static final long serialVersionUID = 1L;
    private int pegi; // Parametro que categoriza los juegos de acuerdo a la edad minima requerida para poder jugarlos.
    private String plataforma;
    private String genero;
    private static ArrayList<Juego> listaJuegos = Datos.listaJuegos; // Lista con los juegos registrados en la tienda.
    

    // Se crean los metodos Get y Set de los atributos de la Clase Consola.
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
    
    // Metodo que le solicita al usuario ingresar los datos basicos del juego que posteriormente se ingresara a la base
    // de datos de la tienda.
    public static void ingresarJuego(String nombre, boolean uso, float precio, int pegi, String plataforma, String genero) {
        Juego juego = new Juego(nombre, uso, precio, pegi, plataforma, genero);
        Datos.listaJuegos.add(juego);
    }

    
    // Metodo que moodifica el precio de algunos juegos, dado un array de indices y un array de precios.
    public static void modificarPreciosJuegos(int[] ints, int[] precios){
        int indice = 0;
        for (int i: ints){
            Datos.listaJuegos.get(i-1).setPrecio(precios[indice]);
            indice++;
        }
    }
    
    // Metodo que devuelve un Arraylist con los juegos segun los indices ingresados por el usuario.
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
			System.out.println("Indice: "+indiceJuego +"  ||  "+ juego.toString());
			indiceJuego ++;
		}
	}
	
	// Metodo para eliminar un juego de la base de datos. 
	public static void borrarJuego() {
		Scanner entrada = new Scanner(System.in);    	
    	juegosRegistrados();
    	System.out.println("Ingrese el indice del Juego que desea borrar: ");
    	int indice = entrada.nextInt(); 		
		Datos.listaJuegos.remove(Datos.listaJuegos.remove(indice-1));
		juegosRegistrados();
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
	            if(detalle.getProducto() instanceof Juego){
	                todoslosNombres.add(detalle.getProducto().nombre);
	            }
	        }
	        
	       return todoslosNombres;
	    }
	 	public static Float precioJuego(String nombre){
	 		float precio = 0;
	 		for(Juego juego: Datos.listaJuegos){
	 			if(juego.getNombre().equals(nombre)) {
	 				precio = juego.getPrecio();
	 			}
	 		}return precio;
	 	}
	 	
	 	// Metodo que obtiene el juego mas vendido en la tienda.
	 	public static void JuegosMasVendidos(){		
	        ArrayList<String> nombres = Juego.productosVendidos();        
	        ArrayList<String> nombresUnicos = new ArrayList<String>();
	        for (String nombre: nombres){
	            if(!nombresUnicos.contains(nombre))
	                nombresUnicos.add(nombre);
	        }
	        System.out.println("Nombre del Juego "+"       ||      "+"Unidades Vendidas "+ "    ||    "+"Precio por unidad"+"    ||    "+" Subtotal ");
	        Float total = (float) 0;
	        for (String nombre: nombresUnicos){
	        	total += precioss(nombre);
	            System.out.println("    "+nombre + "                           " +unidadess(nombre) +" undidades                 "+precioJuego(nombre)+"$ COP "+"              "+precioss(nombre));
	        } System.out.println("***** TOTAL DE GANANCIAS POR VENTA DE JUEGOS: " + "||" + "COP $ " + total + " *****");       
	        
	    }
	 	
	 	
	 	public static void JuegoMasVendido(){
	 		
	        ArrayList<String> nombres = Juego.productosVendidos();
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
	        }System.out.println("\n"+"NOMBRE DEL JUEGO MAS VENDID0: "+s+"  ||  "+"Unidades Vendidas: "+aux);
	        
	        int aux1 = cantidadesunidad.get(0);
	        String s1 = "";
	        for(int x=0;x<cantidadesunidad.size();x++) {
	        	if(cantidadesunidad.get(x)<=aux1) {
	        		aux1 = cantidadesunidad.get(x);
	        		s1 = nombresUnicos.get(x);
	        	}
	        }System.out.println("\n"+"NOMBRE DEL JUEGO MENOS VENDIDO: "+s1+"  ||  "+"Unidades Vendidas: "+aux1);
	        
	    }
	
	// Metodo que recomienda los juegos de la tienda por la edad minima sugerida para ser jugados.
	public static void recomendarPorEdad() {
		System.out.println("Juegos recomendados para edad de 6 a�os a 12 a�os inclusive: "+"\n");
		
		for(Juego juego:Datos.listaJuegos) {
			if(juego.pegi<=12) {				
				System.out.println("Nombre del Juego: "+juego.getNombre()+"  ||  "+" Genero: "+juego.getGenero()+"  ||  "+" Precio: "+juego.getPrecio()+"  ||  "+"Edad recomendada para jugar: "+juego.getPegi());
			}
		}	
		System.out.println("\n");
		System.out.println("\n"+"Juegos recomendados para edad de mas de 12 a�os a 18 a�os inclusive: "+"\n");
		
			for(Juego juego:Datos.listaJuegos) {
				if(juego.pegi>12&&juego.pegi<=18) {	
					System.out.println("Nombre del Juego: "+juego.getNombre()+"  ||  "+" Genero: "+juego.getGenero()+"  ||  "+" Precio: "+juego.getPrecio()+"  ||  "+"Edad recomendada para jugar: "+juego.getPegi());

				}
			}
			System.out.println("\n");
			System.out.println("\n"+"Juegos recomendados para edad de +18 a�os: "+"\n");
			for(Juego juego:Datos.listaJuegos) {
				if(juego.pegi>18) {	
					System.out.println("Nombre del Juego: "+juego.getNombre()+"  ||  "+" Genero: "+juego.getGenero()+"  ||  "+" Precio: "+juego.getPrecio()+"  ||  "+"Edad recomendada para jugar: "+juego.getPegi());

				}			
			}
	}
	
    
    // Se crea el constructor de la clase Juego, con sus atributos como parametros.
    public Juego(String nombre, boolean uso, float precio, int pegi, String plataforma, String genero) {
        super(nombre, uso, precio);
        this.pegi = pegi;
        this.plataforma = plataforma;
        this.genero = genero;
    }
    
    // Se crea el toString de la clase Juego, el cual mostrara por pantalla el nombre del juego, la plataforma a la que pertenece y su precio.
    @Override
    public String toString() {
        return "Nombre del juego: "+ getNombre() + "  ||  " + "Plataforma asociada al juego: " + plataforma + "  ||  " + "Precio: " + "COP $" + getPrecio() + this.descripcionProducto();
    }
}