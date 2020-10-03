package gestorAplicacion.producto;
import java.io.Serializable;

public class Producto implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id = 1;
    private String nombre;
    public int stock = 0;
    private boolean uso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isUso() {
        return uso;
    }

    public void setUso(boolean uso) {
        this.uso = uso;
    }

    public Producto(String nombre, boolean uso) {
        this.nombre = nombre;
        this.uso = uso;
    }
}
