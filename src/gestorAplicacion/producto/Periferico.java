/*1). En las fuentes se incluirá la siguiente documentación:
//Se crea la clase periférico y sus respectivos métodos, haciendo parte del paquete producto.
         Cabeceras en las clases, explicando su finalidad y describiendo las estructuras de datos definidas cuando
        sean relevantes.
         Cabeceras en los métodos, comentando su propósito y describiendo los parámetros de entrada/salida.
         Comentarios en líneas de código de relevante interés o importancia.
         Otros aspectos de interés a tener en cuenta por el profesor.*/
// Autores:   - Santiago Franco Valencia
//            - Anderson Elian Gutierrez
//            - Santiago Valencia Mejía
//            - Daniel Alejandro Giraldo
// En este módulo se crea la clase Periferico, así como sus métodos básicos (Get y Set), además se definen un conjunto de atributos,
// los cuales almacenarán información acerca de cada Periferico  que se vaya registrando en la plataforma.

package gestorAplicacion.producto;

// La clase contiene aquelos atributos que modelan los periféricos, es decir la plataforma en la que funcionan y su estado.

public class Periferico extends Producto {
    private String plataforma;
    private boolean estado;

    // Se crean los métodos Get y Set de los atributos de la Clase Periferico

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

    // Se crea el constructor de la clase periferico, con sus atributos como parámetros.

    public Periferico(String nombre, boolean uso, float precio, String plataforma) {
        super(nombre, uso, precio);
        this.plataforma = plataforma;
    }

  //Constructor que se utilizará para generar periféricos que se puedan reparar

    public Periferico(String nombre, boolean estado) {
        super(nombre);
        this.estado = estado;
    }

    // Se crea el toString de la clase Periferico, el cual mostrará por pantalla el periferico y sus caracteristicas.

    @Override
    public String toString() {
        return getNombre() + " " + plataforma + getPrecio();
    }

    // se crea metodo repararPeriferico para comprobar si el periferico ya se ha reparado.

    public void repararPeriferico(Periferico periferico){
    	if (periferico.getEstado()==false){
    		System.out.println("El periferico ya se encuentra reparada");
    	}else {
    		periferico.setEstado(false);
    		System.out.println("Se ha reparado el periferico");
    	}
    }
}

