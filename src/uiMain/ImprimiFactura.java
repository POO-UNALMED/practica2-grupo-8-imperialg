package uiMain;
import gestorAplicacion.transacciones.*;
public class ImprimiFactura {
    public void imprimirDetalle(Detalle detalle){
        System.out.println(Detalle.getId() + " " + detalle.getTiposervicio() + " " + detalle.producto.getNombre() + " " + detalle.getCantidad() + " " + detalle.getPrecio());
    }
    public void imprimirFactura(Factura factura){
        System.out.println(factura.getIdFactura() + "   " + factura.getFecha() + factura.getCliente().getNombre());
        float total = 0;
        for(Detalle detalle: factura.getDetalles()){
            imprimirDetalle(detalle);
            total += detalle.getPrecio();
        }
        System.out.println("Total" + total);
    }
}
