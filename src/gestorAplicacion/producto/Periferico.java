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

// En este modulo se crea la clase Periferico, asi como sus metodos basicos (Get y Set), ademas se definen un conjunto de atributos,
// los cuales almacenaran informacion acerca de cada Periferico  que se vaya registrando en la plataforma.

// La clase contiene aquellos atributos que modelan los perifericos, es decir la plataforma en la que funcionan y su estado.

package gestorAplicacion.producto;
import java.io.Serializable;
import BaseDatos.Datos;
import gestorAplicacion.transacciones.*;
import java.util.*;

public class Periferico extends Producto implements Serializable,Hardware{
	private static final long serialVersionUID = 1L;
    private String plataforma;
    private boolean estado;
    private static ArrayList<Periferico> listaPerifericos = Datos.listaPerifericos; // Lista con los perifericos registrados en la tienda.
    
    // Se crean los metodos Get y Set de los atributos de la Clase Periferico

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
    
    // Metodo que devuelve un Arraylist con los perifericos segun los indices ingresados por el usuario.
    public static ArrayList<Producto> perifericoPorIndice(int[] ints){
        ArrayList<Producto> nuevaLista = new ArrayList<Producto>();
        for (int i: ints){
            nuevaLista.add(Datos.listaPerifericos.get(i-1));
        }
        return nuevaLista;
    }
    
	// Mostrar en pantalla los perifericos registrados.
	public static void perifericosRegistrados() {
		int indicePeriferico = 1;
		for (Periferico periferico : Datos.listaPerifericos) {
			System.out.println("Indice: "+indicePeriferico + "  ||  " + periferico.toString());
			indicePeriferico ++;
		}
	}

    // Se crea el constructor de la clase periferico, con sus atributos como parametros.
    public Periferico(String nombre, boolean uso, float precio, String plataforma) {
        super(nombre, uso, precio);
        this.plataforma = plataforma;
        Datos.listaPerifericos.add(this);
    }

    // Constructor que retornara el nobre del periferico y el estado del mismo (bueno o malo).
    public Periferico(String nombre, boolean estado) {
        super(nombre);
        this.estado = estado;
    }
    // Se crea el toString de la clase Periferico, el cual mostrara por pantalla el nombre del periferico y la plataforma a la
    // cual esta asociado.
    @Override
    public String toString() {
        return  "Nombre del periferico: " + getNombre() + "  ||  " + "Plataforma asociada al periferico: " + plataforma + "  ||  " + "Precio: " + "COP $" +  getPrecio()+this.descripcionProducto();
    }

    // Se crea metodo repararPeriferico para comprobar si el periferico ya se ha reparado.
    public void repararPeriferico(Periferico periferico){
    	if (periferico.getEstado()==false){
    		System.out.println("El periferico ya se encuentra reparado.");
    	}else {
    		periferico.setEstado(false);
    		System.out.println("Se ha reparado el periferico.");
    	}
    }
    
    // Metodo para eliminar un periferico de la base de datos de la tienda.
	public static void borrarPeriferico() {
		Scanner entrada = new Scanner(System.in);    	
    	perifericosRegistrados();
    	System.out.println("Ingrese el indice del Periferico que desea borrar: ");
    	int indice = entrada.nextInt(); 		
		Datos.listaPerifericos.remove(Datos.listaPerifericos.remove(indice-1));
		perifericosRegistrados();
	}

    // Metodo que modifica el precio de uno o mas perifericos dados un array de indices y uno de precios.
    public static void modificarPreciosPerifericos(int[] ints, int[] precios){
        int indice = 0;
        for (int i: ints){
            Datos.listaPerifericos.get(i-1).setPrecio(precios[indice]);
            indice++;
        }
    }
    
    // Suma de precios en listaFacturas dado un nombre de periferico
    public static Float precioss(String nombre) {
    	Float todoslosprecios = (float) 0;
           for (Factura factura: Datos.listaFacturas){
        	   if(factura.getDetalles().get(0).getProducto().nombre.equals(nombre)) {
        		   todoslosprecios += factura.getDetalles().get(0).getPrecio();
        	   }   	   
           }
          return todoslosprecios;
    }    
    
    // Suma de las unidades vendidas en listaFacturas dado un nombre de periferico
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
            if(detalle.getProducto() instanceof Periferico){
                todoslosNombres.add(detalle.getProducto().nombre);
            }
        }
        
       return todoslosNombres;
    }
    
    // Permite ver el precio de un periferico en la lista de facturas dado su nombre.
 	public static Float precioPeriferico(String nombre){
 		float precio = 0;
 		for(Periferico periferico: Datos.listaPerifericos){
 			if(periferico.getNombre().equals(nombre)) {
 				precio = periferico.getPrecio();
 			}
 		}return precio;
 	}
 	// Metodo que obtiene el juego mas vendido en la tienda.
 	public static void PerifericosMasVendidos(){		
        ArrayList<String> nombres = Periferico.productosVendidos();        
        ArrayList<String> nombresUnicos = new ArrayList<String>();
        for (String nombre: nombres){
            if(!nombresUnicos.contains(nombre))
                nombresUnicos.add(nombre);
        }
        System.out.println("Nombre del Periferico"+"       ||      "+"Unidades Vendidas"+ "    ||    "+"Precio por unidad"+"    ||    "+" Subtotal ");
        Float total = (float) 0;
        for (String nombre: nombresUnicos){
        	total += precioss(nombre);
            System.out.println("    "+nombre + "                           " +unidadess(nombre) +" undidades                 "+precioPeriferico(nombre)+"$ COP "+"              "+precioss(nombre));
        } System.out.println("***TOTAL DE GANANCIAS POR VENTA DE PERIFERICOS: ||"+total+"$ COP|| ***");       
        
    }
 	
 	// Metodo que permite conocer el periferico que se vende con mas frecuencia en la tienda.
 	public static void PerifericoMasVendido(){
 		
        ArrayList<String> nombres = Periferico.productosVendidos();
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
        }System.out.println("\n"+"NOMBRE DEL PERIFERICO MAS VENDIDO: "+s+"  ||  "+"Unidades Vendidas: "+aux);
        
        int aux1 = cantidadesunidad.get(0);
        String s1 = "";
        for(int x=0;x<cantidadesunidad.size();x++) {
        	if(cantidadesunidad.get(x)<=aux1) {
        		aux1 = cantidadesunidad.get(x);
        		s1 = nombresUnicos.get(x);
        	}
        }
        
        System.out.println("\n"+"NOMBRE DEL PERIFERICO MENOS VENDIDO: "+s1+"  ||  "+"Unidades Vendidas: "+aux1);
    }
    
    // Metodo que modifica los perifericos externos.
    public static void modificarPeriferico(ArrayList<Detalle> detalles) {
    	Scanner entrada = new Scanner(System.in);
    	System.out.println("Ingrese el nombre del periferico: ");
		String nombre = entrada.next();
		System.out.println("Ingrese el estado del periferico (true si el periferico se encuentra malo o false si se encuentra bueno)");
		Boolean estado = entrada.nextBoolean();
		Periferico producto = new Periferico(nombre, estado);
		System.out.println("Ingrese el tipo de Servicio tecnico: ");
		String tiposervicio = entrada.next();
		System.out.println("Ingrese el precio del servicio tecnico: ");
		float precio = entrada.nextFloat();
		System.out.println("Ingrese las unidades: ");
		int unidades = entrada.nextInt();
		Detalle detalle = new Detalle(producto, precio, tiposervicio,unidades);
		detalles.add(detalle);
    }
    
    @Override
    // Si el estado se encuentra en false, quiere decir que el periferico esta reparado o bueno en su defecto.
    public void Reparar() {
        this.estado = false;
    }
    @Override
    // String que retorna la descripcion del producto, aqui aplica ligadura dinamica.
    public String descripcionProducto(){
        String checker= null;
        if (estado){
            checker = "Averiado/a";
        } else if (!estado){
            checker = "Funcional";
        }
        return "  ||  "  + " Estado: " + checker;
    }
}