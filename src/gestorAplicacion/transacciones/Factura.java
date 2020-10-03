package gestorAplicacion.transacciones;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Factura {
    private static final long serialVersionUID = 1L;
    private int idFactura;
    private LocalDate fecha = LocalDate.now();
    private Cliente cliente;
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private ArrayList<Detalle> detalles = new ArrayList<Detalle>();

    public String getFecha() {
        return fecha.format(formato);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Detalle> getDetalles() {
        return detalles;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public Factura(Cliente cliente) {
        this.cliente = cliente;
    }
}