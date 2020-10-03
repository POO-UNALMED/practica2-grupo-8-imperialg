package uiMain;
import gestorAplicacion.transacciones.*;
public class ImprimeFactura {
    public void imprimirFactura(Factura factura){
        System.out.println(factura.getIdFactura() + "   " + factura.getFecha() + factura.getCliente().getNombre() + "\n");
        float total = 0;

        for(Detalle detalle: factura.getDetalles()){
            System.out.println(detalle);
            total += detalle.getPrecio();
        }

        System.out.println("\n"+"Total:" + total);
    }
}
