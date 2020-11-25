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
        Datos.listaClientes.add(this);
    }
    
    // Metodo que agrega el cliente que se registra en una lista juntos con los demas clientes registrados anteriormente.
    public void agregarClientes(Cliente cliente){
        listaClientes.add(cliente);
    }
    
    // Metodo que devuelve una lista con todos los clientes registrados hasta el momento.
    public static ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
    
 	
    // Se crea el toString de la clase Cliente, el cual retorna el nombre del cliente, su cedula
    // y la cantidad de puntos que posee en la tienda.
    public String toString(){
        return "Nombre: " + nombre + "  ||  " + "C.C: " + cc +"  ||  "+"Celular: "+celular+"  ||  "+"e-mail: "+email+"  ||  " + "Puntos del cliente: " +  puntos;
    }

    // Este metodo agregara 1 punto al cliente, cada vez que este realice una compra de un periferico o un juego.
    public void agregarPunto() {
    	puntos++;
    }    
    // Esta sobrecarga de metodo es para agregar 5 puntos al cliente cuando compra cualquier consola.
    public void agregarPunto(int x) {
    	if(x==0) {
    		this.puntos=0;
    	}
    	else {
    		this.puntos+=x;
    	}
    }
}