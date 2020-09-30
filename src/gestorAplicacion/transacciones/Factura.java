package gestorAplicacion.transacciones;

import java.time.LocalDate;
import java.util.ArrayList;

public class Factura {
    private int idFactura;
    private LocalDate fecha;
    private Cliente cliente;
    private ArrayList<Detalle> detalles = new ArrayList<Detalle>();


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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
}