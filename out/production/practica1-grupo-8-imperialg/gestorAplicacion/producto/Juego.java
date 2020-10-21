/*1). En las fuentes se incluirá la siguiente documentación:
         Cabecera del archivo: funcionalidad del módulo, autores, componentes del módulo, etc.
         Cabeceras en las clases, explicando su finalidad y describiendo las estructuras de datos definidas cuando
        sean relevantes.
         Cabeceras en los métodos, comentando su propósito y describiendo los parámetros de entrada/salida.
         Comentarios en líneas de código de relevante interés o importancia.
         Otros aspectos de interés a tener en cuenta por el profesor.*/
// Autores:   - Santiago Franco Valencia
//            - Anderson Elian Gutierrez
//            - Santiago Valencia Mejía
//            - Daniel Alejandro Giraldo
// En este módulo se crea la clase Juego, así como sus métodos básicos (Get y Set), además se definen un conjunto de atributos,
// los cuales almacenarán información acerca de cada Juego que se vaya registrando en la plataforma.
package gestorAplicacion.producto;

public class Juego extends Producto {
    private int pegi;
    private String plataforma;
    private String genero;

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
