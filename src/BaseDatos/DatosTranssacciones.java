package BaseDatos;
import gestorAplicacion.producto.Consola;
import gestorAplicacion.producto.Juego;
import gestorAplicacion.producto.Periferico;
import gestorAplicacion.transacciones.*;
import java.io.*;
import java.util.ArrayList;

public class DatosTranssacciones {
    static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    static ArrayList<Factura> listaFacturas = new ArrayList<Factura>();

    //Agregar transacciones
    public static void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public static void agregarFactura(Factura factura) {
        listaFacturas.add(factura);
    }

    //Guardar datos de productos
    public static void guardarDatos() {
        try {
            FileOutputStream c = new FileOutputStream(new File("Clientes.txt"));
            FileOutputStream d = new FileOutputStream(new File("Facturas.txt"));
            ObjectOutputStream o = new ObjectOutputStream(c);
            ObjectOutputStream p = new ObjectOutputStream(d);
            o.writeObject(listaClientes);
            p.writeObject(listaFacturas);
            o.close();
            p.close();
            c.close();
            d.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException e) {
            System.out.println("Error Flujo de inicialización");
        }
    }

    public static void leerDatos() {
        try {
            FileInputStream ci = new FileInputStream("Clientes.txt");
            FileInputStream di = new FileInputStream("Facturas.txt");
            ObjectInputStream oi = new ObjectInputStream(ci);
            ObjectInputStream pi = new ObjectInputStream(di);
            listaClientes = (ArrayList<Cliente>) oi.readObject();
            listaFacturas = (ArrayList<Factura>) oi.readObject();
            oi.close();
            pi.close();
            ci.close();
            di.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException e) {
            System.out.println("Error Flujo de inicialización");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
