/*		 CABECERA DEL ARCHIVO:
 * 
 * 	 funcionalidad del modulo: Aqu√≠ se encuentra el Main donde se va a ejecutar cada uno de los menus y sus respectivas funcionalidades
 *  con las que el usuario va a interactuar, su funcionamiento se basa en el uso de switches
 *  
 * 	autores: Santiago Franco Valencia, Anderson Elian Gutierrez, Santiago Valencia Mejia, Daniel Alejandro Giraldo
 * 	 
 * 	componentes del m√≥dulo: Clase Ui(carga y guarda todos los archivos .txt mediante serializacion), ademas un Menu principal 
 *  que llama los submenus (todos ellos basados en uso de switches)*/


/* Autores:   - Santiago Franco Valencia 
*            - Anderson Elian Gutierrez 
*            - Santiago Valencia Mejia
*            - Daniel Alejandro Giraldo  */

/*Cabecera en la clase: la clase Ui carga y guarda todos los datos en los archivos .txt, adem√°s llama el
 * menu principal con el que el usuario va a interactuar*/
 
package uiMain;
import BaseDatos.Datos;
import gestorAplicacion.transacciones.*;
import gestorAplicacion.producto.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
	public static Datos datos = new Datos();
	
	public static void main(String[] Args) {
        Ui uimain = new Ui();
        datos.leerDatos();
        datos.leerDatos1();
        datos.leerDatosFacturas();
        Factura.facturasRegistradas();
        Cliente.clientesRegistrados();
        Consola.consolaMasVendida();
        uimain.menuprincipal(datos);
        datos.guardarDatos();
        datos.guardarDatos1();
	}
	
	// se usa el scanner entrada para recibir la entrada del usuario en cada caso que se requiera ingresar un dato
	Scanner entrada = new Scanner(System.in);
	
	public void menuprincipal(Datos datos) {
		System.out.println("**BIENVENIDO A IMPERIALGAMING, LA MEJOR TIENDA VIRTUAL**"+"\n");
		this.menu(datos);
	}
	
	//este metodo menu es el principal, le pedir√° una opcion de ingreso al usuario y de acuerdo a la opcion, 
	//mediante switches muestre su respectivo submenu
	public void menu(Datos datos){
	        System.out.println("Ingrese una opciÛn");
	        System.out.println("1. Ingresar Clientes o Productos");
	        System.out.println("2. Vender Productos");
	        System.out.println("3. Servicios tÈcnicos");
	        System.out.println("4. Imperial");
	        System.out.println("5. Cliente con mas puntos");
	        int i = entrada.nextInt();
	        switch (i){
	            case 1:
	                this.menuAgregar(datos);
	                break;
	            case 2:
	                this.menuVender(datos);
	                break;
	            case 3:
	                this.menuServiciosTecnicos(datos);
	                break;
	            case 4:
	                this.menuImperial(datos);
	                break;
	            case 5:
	            	Cliente.clienteConMasPuntos();
	        }
	    }
	
	// este m√©todo sera ejecutado si la opcion del usuario en el menu principal fue 1: Ingresar Clientes o Productos
	public void menuAgregar(Datos datos){
		System.out.println("Ingrese una opcion");
		System.out.println("0. Volver");
		System.out.println("1. Ingresar Cliente");
		System.out.println("2. Ingresar Consola/s");
		System.out.println("3. Ingresar Juego/s");
		System.out.println("4. Ingresar Periferico/s");
		int i = entrada.nextInt();
		switch (i){
		//dependiendo del caso a excepcion de 0, se llamar√° su respectivo metodo en la clase Datos
			case 0:
				this.menu(datos);
			case 1:
				Cliente.ingresarCliente();
				break;
			case 2:
				Consola.ingresarConsola();
				break;
			case 3:
				Juego.ingresarJuego();
				break;
			case 4:
				Periferico.ingresarPeriferico();
				break;

		}
	}
	
	// este metodo sera ejecutado si la opcion del usuario en el menu principal fue 2:Vender Productos
	public void menuVender(Datos datos){
		System.out.println("øEl cliente ya est· registrado?"+"\n");
		System.out.println("0. Volver");
		System.out.println("1. Si el cliente est· registrado");
		System.out.println("2. Si el cliente NO est· registrado");
		int verificador = entrada.nextInt();
		
		//un entero que verifica si el cliente esta o no registrado y ejecutar el respectivo metodo
		Cliente cliente = new Cliente();
		if (verificador == 0){
			this.menu(datos);
		} else if(verificador == 1){
			cliente = Cliente.clienteRegistrado();
		} else if (verificador == 2) {
			cliente = Cliente.clienteNoRegistrado();
		}	
		
		//se le pide al usuario una entrada despues de saber si esta registrado o no
		System.out.println("øQue articulo desea vender?: Ingrese una opcion");
		System.out.println("0. Volver");
		System.out.println("1. Consola/s");
		System.out.println("2. Juego/s");
		System.out.println("3. PerifÈrico/s");
		int i =entrada.nextInt();
		switch (i){
			case 0:
				this.menuVender(datos);
			case 1: {
				Consola.ventaConsola(cliente);
				break;
			}
			case 2: {
				Juego.ventaJuego(cliente);
				break;
			}
			case 3: {
				Periferico.ventaPeriferico(cliente);
				break;

			}
		}
	}	
	
	
	// MÈtodo para implementar el men˙ de servicios tÈcnicos (Reparaciones y modificaciones de productos). 
	public void menuServiciosTecnicos(Datos datos){
		//Verificamos s√≠ el cliente ya est√° registrado a trav√©s de enteros.
		System.out.println("øEl cliente ya est· registrado?"+"\n");
		System.out.println("0. Volver");
		System.out.println("1. Si el cliente est· registrado");
		System.out.println("2. Si el cliente NO est· registrado");
		int verificador = entrada.nextInt(); //A trav√©s de esta variable se ver√≠fica con if s√≠ el cliente est√° registrado.
		Cliente cliente = new Cliente(); //Hacemos una instancia de cliente con el fin de que el c√≥digo compile sin problemas.
		if (verificador == 0){
			this.menu(datos);
		} else if(verificador == 1){
			cliente = Cliente.clienteRegistrado();
		} else if (verificador == 2) {
			cliente = Cliente.clienteNoRegistrado();
		}
		System.out.println("øCu·ntos productos requieren de servicio tÈcnico?");
		int i = entrada.nextInt(); // Scanner para saber cuantos productos se crear√°n.
		ArrayList<Producto> productos = new ArrayList<Producto>(); // Lista que se crea para generar los detalles de la factura.
		ArrayList<Detalle> detalles = new ArrayList<Detalle>(); // Lista que almacenar√° cada detalle.
		for (int j = 0; j < i ; j++) {
			System.out.println("øDesea modificar una consola o un perifÈrico?");
			System.out.println("1. Modificar una consola");
			System.out.println("2. Modificar un perifÈrico");
			int determinante = entrada.nextInt();
			switch (determinante){
				case 1: {
					// Si la entrada fue 1 se modifica la consola y se genera un detalle
					System.out.println("Ingrese el nombre de la consola: ");
					String nombre = entrada.next();
					System.out.println("Ingrese el color de la consola: ");
					String color = entrada.next();
					System.out.println("Ingrese el estado de la consola (true si la consola est· usada o  false si la consola est· nueva) ");
					Boolean estado = entrada.nextBoolean();
					System.out.println("Ingrese el almacenamiento de la consola: ");
					int almacenamiento = entrada.nextInt();
					Consola producto = new Consola(nombre, color, estado, almacenamiento);
					System.out.println("Ingrese el tipo de Servicio TÈcnico: ");
					String tiposervicio = entrada.next();
					System.out.println("Ingrese el precio del servicio tÈcnico: ");
					float precio = entrada.nextFloat();
					Detalle detalle = new Detalle(producto, precio, tiposervicio);
					detalles.add(detalle);
					break;
				}
				case 2: {
					// Si la entrada fue 2 se modifica el periferico y se genera un detalle
					System.out.println("Ingrese el nombre de la consola: ");
					String nombre = entrada.next();
					System.out.println("Ingrese el estado de la consola (true si la ocnsola se encuentra mala o false si se encuentra buena)");
					Boolean estado = entrada.nextBoolean();
					Periferico producto = new Periferico(nombre, estado);
					System.out.println("Ingrese el tipo de Servicio tÈcnico: ");
					String tiposervicio = entrada.next();
					System.out.println("Ingrese el precio del servicio tÈcnico: ");
					float precio = entrada.nextFloat();
					Detalle detalle = new Detalle(producto, precio, tiposervicio);
					detalles.add(detalle);
					break;
				}
			}
		}
		
		// Genera una factura y la agrega a la lista listaFacturas en la clase Datos a traves del metodo agregar factura
		Factura factura = new Factura(cliente, detalles);
		Factura.agregarFactura(factura);
		System.out.println(factura);

	}	
	

	// Este m√©todo sera ejecutado si la opcion del usuario en el menu principal fue 4.Imperial
	public void menuImperial(Datos datos){
		System.out.println("Ingrese una opciÛn");
		System.out.println("0. Volver");
		System.out.println("1. Alquilar");
		System.out.println("2. Vender");
		System.out.println("3. Comprar");
		System.out.println("4. ");
		int i = entrada.nextInt();
	}
}