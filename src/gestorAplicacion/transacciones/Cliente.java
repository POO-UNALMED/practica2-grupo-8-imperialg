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
*            - Daniel Alejandro Giraldo  */

// En este modulo se crea la clase Cliente, asi como sus metodos basicos (Get y Set), ademas se definen un conjunto de atributos,
// los cuales almacenaran informacion acerca de cada Cliente que se vaya registrando en la plataforma.

package gestorAplicacion.transacciones;
import java.util.ArrayList;
import java.util.Scanner;
import BaseDatos.Datos;
import java.io.Serializable;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int cc;
    private long celular;
    private String email;
    private int puntos = 0;
    private static ArrayList<Cliente> listaClientes = Datos.listaClientes; // lista en la cual se almacenaran todos los clientes 
    //  registrados en la tienda.
   
    public Cliente() {

    }
    
    // Se crean los metodos Get y Set de los atributos de la Clase Cliente
    
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    // Se crea el constructor de la clase Cliente, con sus atributos como parametros.
    public Cliente(String nombre, int cc, long celular, String email) {
        this.nombre = nombre;
        this.cc = cc;
        this.celular = celular;
        this.email = email;
    }
    
    // Metodo para recopilar por pantalla los datos basicos del cliente, para luego ser ingresado a la base de datos 
    // de la tienda. 
    public static void ingresarCliente() {
    	Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = entrada.next();
        System.out.println("Ingrese su cedula: ");
        int cc = entrada.nextInt();
        System.out.println("Ingrese su celular: ");
        long celular = entrada.nextLong();
        System.out.println("Ingrese su e-mail: ");
        String email = entrada.next();
        Cliente cliente = new Cliente(nombre, cc, celular, email);
        Datos.listaClientes.add(cliente);
        Cliente.clientesRegistrados();
        
    }
    
    // Metodo que agrega el cliente que se registra en una lista juntos con los demas clientes registrados anteriormente.
    public void agregarClientes(Cliente cliente){
        listaClientes.add(cliente);
    }
    
    // Metodo que devuelve una lista con todos los clientes registrados hasta el momento.
    public static ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
    
    // Metodo para seleccionar al cliente con el indice i de listaClientes.
    public static Cliente seleccionarCliente(int i){
        Cliente cliente = Datos.listaClientes.get(i);
        return cliente;
    }
    
    // Metodo para seleccionar el ultimo cliente de la lista, es decir, el ultimo que fue registrado en la tienda.
    public static Cliente seleccionarUltimoCliente(){
        Cliente cliente = Datos.listaClientes.get(listaClientes.size() - 1);
        return  cliente;
    }
    
    // Selecciona el cliente registrado marcado con el indice i.
	public static Cliente clienteRegistrado(){ 
		 Scanner entrada = new Scanner(System.in); 
		clientesRegistrados();                                           
		int i = entrada.nextInt();
		return seleccionarCliente(i-1);
	}
	
	// Este metodo registra un cliente.
	public static Cliente clienteNoRegistrado(){
		ingresarCliente();
		return seleccionarUltimoCliente();
	}
	
	// Mostrar en pantalla los clientes registrados.
 	public static void clientesRegistrados() {
 		int indiceCliente = 1;
 		for (Cliente cliente : Datos.listaClientes) {
 			System.out.println(indiceCliente + " " + cliente.toString());
 			indiceCliente ++;
 		}
 	}
 	
 	// Metodo para obtener al cliente con mas puntos de la tienda.
 	public static void clienteConMasPuntos() {
 		int aux = 0;
 		Cliente cl=null;
 		for(Cliente cliente:Datos.listaClientes ) {
 			
 			if(cliente.getPuntos()>aux) {
 				aux = cliente.getPuntos();
 				cl = cliente;
 			}
 		}System.out.println (cl);
 	}
    
    // Se crea el toString de la clase Cliente, el cual retorna el nombre del cliente, su cedula
    // y la cantidad de puntos que posee en la tienda.
    public String toString(){
        return "Nombre: " + nombre + "  ||  " + "C.C: " + cc + "  ||  " + "Puntos del cliente: " +  puntos;
    }
 
    // Este metodo agregara 1 punto al cliente, cada vez que este realice una compra de un periferico o un juego.
    public void agregarPunto() {
    	puntos++;
    }    
    // Esta sobrecarga de metodo es para agregar 5 puntos al cliente cuando compra cualquier consola.
    public void agregarPunto(int x) {
    	this.puntos+=x;
    }
}
