package gestorAplicacion.producto;
import java.util.ArrayList;
import BaseDatos.DatosProductos;

public class Consola extends Producto {
    private String color;
    private boolean estado;
    private String version;
    private int almacenamiento;
    private int unidadesvendidas;


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isEstado() {
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

    public Consola(String nombre, boolean uso, String color, boolean estado, String version, int almacenamiento) {
        super(nombre, uso);
        this.color = color;
        this.estado = estado;
        this.version = version;
        this.almacenamiento = almacenamiento;
        this.unidadesvendidas += 1;
        DatosProductos.agregarConsola(this);
    }
    public Consola consolaMasVendida(){
        Consola masvendida = DatosProductos.listaConsolas(0);
        for (Consola consola: DatosProductos.listaConsolas){
            if (consola.unidadesvendidas > masvendida.unidadesvendidas ){
                masvendida = consola;
            }
        }
        return masvendida;
    }



}
