package BaseDatos;

import gestorAplicacion.producto.*;

import java.io.*;
import java.util.ArrayList;

public class DatosProductos {
    public static ArrayList<Consola> listaConsolas = new ArrayList<Consola>();
    public static ArrayList<Juego> listaJuegos = new ArrayList<Juego>();
    public static ArrayList<Periferico> listaPerifericos = new ArrayList<Periferico>();

   //Agregar producos:

    public static void agregarConsola(Consola consola){
        listaConsolas.add(consola);
    }
    public static void agregarJuego(Juego juego){
        listaJuegos.add(juego);
    }
    public static void agregarPeriferico(Periferico periferico){
        listaPerifericos.add(periferico);
    }

    //Guardar datos de productos
    public void guardarDatos(){
        try{
            FileOutputStream c = new FileOutputStream(new File("Consolas.txt"));
            FileOutputStream d = new FileOutputStream(new File("Juegos.txt"));
            FileOutputStream e = new FileOutputStream(new File("Perifericos.txt"));
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
    public void leerDatos(){
        try{
        FileInputStream ci = new FileInputStream("Consolas.txt");
        FileInputStream di = new FileInputStream(" Juegos.txt");
        FileInputStream ei = new FileInputStream("Perifericos.txt");
        ObjectInputStream oi = new ObjectInputStream(ci);
        ObjectInputStream pi = new ObjectInputStream(di);
        ObjectInputStream qi = new ObjectInputStream(ei);
        listaConsolas = (ArrayList<Consola>) oi.readObject();
        listaJuegos = (ArrayList<Juego>) oi.readObject();
        listaPerifericos = (ArrayList<Periferico>) oi.readObject();
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
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Juego juegoMasVendido(){
        Juego masvendido = listaJuegos(0);
        for (Juego juego: listaJuegos){
            if (juego.getUnidadesvendidas() > masvendido.getUnidadesvendidas() ){
                masvendido = juego;
            }
        }
        return masvendido;
    }
    public Consola consolaMenosVendida(){
        Consola menosvendida = DatosProductos.listaConsolas(0);
        for (Consola consola: DatosProductos.listaConsolas){
            if (consola.unidadesvendidas < menosvendida.unidadesvendidas ){
                menosvendida = consola;
            }
        }
        return menosvendida;
    }
}
