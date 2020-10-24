/*1). En las fuentes se incluirá la siguiente documentación:
      Cabecera del archivo: funcionalidad del módulo, autores, componentes del módulo, etc.
      Cabeceras en las clases, explicando su finalidad y describiendo las estructuras de datos definidas cuando
        sean relevantes.
      Cabeceras en los métodos, comentando su propósito y describiendo los parámetros de entrada/salida.
      Comentarios en líneas de código de relevante interés o importancia.
      Otros aspectos de interés a tener en cuenta por el profesor.*/

/* Autores:   - Santiago Franco Valencia 
*            - Anderson Elian Gutierrez 
*            - Santiago Valencia Mejia
*            - Daniel Alejandro Giraldo  */


package BaseDatos;
import gestorAplicacion.producto.Consola;
import gestorAplicacion.producto.Juego;
import gestorAplicacion.producto.Periferico;
import gestorAplicacion.producto.Producto;
import gestorAplicacion.transacciones.Cliente;
import gestorAplicacion.transacciones.Detalle;
import gestorAplicacion.transacciones.Factura;

import java.io.*;
import java.util.ArrayList;

public class Datos{
	public static ArrayList<Consola> listaConsolas = new ArrayList<Consola>();
	public static ArrayList<Periferico> listaPerifericos = new ArrayList<Periferico>();
	public static ArrayList<Juego> listaJuegos = new ArrayList<Juego>();
	
	public static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	public static ArrayList<Factura> listaFacturas = new ArrayList<Factura>();	
  
    // Guardar datos de productos
    public void guardarDatos() {
        try {
            FileOutputStream c = new FileOutputStream(new File("src/BaseDatos/temp/Consolas.txt"));
            FileOutputStream d = new FileOutputStream(new File("src/BaseDatos/temp/Juegos.txt"));
            FileOutputStream e = new FileOutputStream(new File("src/BaseDatos/temp/Perifericos.txt"));
            ObjectOutputStream o = new ObjectOutputStream(c);
            ObjectOutputStream p = new ObjectOutputStream(d);
            ObjectOutputStream q = new ObjectOutputStream(e);
            o.writeObject(listaConsolas);
            p.writeObject(listaJuegos);
            q.writeObject(listaPerifericos);
            o.close();
            p.close();
            q.close();
            c.close();
            d.close();
            e.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException e) {
            System.out.println("Error Flujo de inicialización");
        }
    }
    
    // Leer datos de los productos que previamente hayan sido guardados 
    public void leerDatos() {
        try {
            FileInputStream ci = new FileInputStream("src/BaseDatos/temp/Consolas.txt");
            FileInputStream di = new FileInputStream("src/BaseDatos/temp/Juegos.txt");
            FileInputStream ei = new FileInputStream("src/BaseDatos/temp/Perifericos.txt");
            ObjectInputStream oi = new ObjectInputStream(ci);
            ObjectInputStream pi = new ObjectInputStream(di);
            ObjectInputStream qi = new ObjectInputStream(ei);
            listaConsolas = (ArrayList<Consola>) oi.readObject();
            listaJuegos = (ArrayList<Juego>) pi.readObject();
            listaPerifericos = (ArrayList<Periferico>) qi.readObject();
            oi.close();
            pi.close();
            qi.close();
            ci.close();
            di.close();
            ei.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException e) {
            System.out.println("Error Flujo de inicialización");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    

    // Guardar datos de transacciones
    public void guardarDatos1() {
        try {
            FileOutputStream c = new FileOutputStream(new File("src/BaseDatos/temp/Clientes.txt"));
            FileOutputStream d = new FileOutputStream(new File("src/BaseDatos/temp/Facturas.txt"));
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
            System.out.println("Error Flujo de inicialización xd2");
        }
    }

    public void leerDatos1() {
        try {
            FileInputStream ci = new FileInputStream("src/BaseDatos/temp/Clientes.txt");
            ObjectInputStream oi = new ObjectInputStream(ci);
            listaClientes = (ArrayList<Cliente>) oi.readObject();
            oi.close();
            ci.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException e) {
            System.out.println("Error Flujo de inicialización xd");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    // Leer los datos de facturas.
    public void leerDatosFacturas(){
     try{
        FileInputStream di = new FileInputStream("src/BaseDatos/temp/Facturas.txt");
        ObjectInputStream pi = new ObjectInputStream(di);
        listaFacturas = (ArrayList<Factura>) pi.readObject();
        pi.close();
        di.close();
    } catch (FileNotFoundException e) {
        System.out.println("No se encuentra el archivo");
    } catch (IOException e) {
        System.out.println("Error Flujo de inicialización xd");
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    }

}