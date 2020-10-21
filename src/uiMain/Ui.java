/*		 CABECERA DEL ARCHIVO:
 * 
 * 	 funcionalidad del modulo: Aquí se encuentra el Main donde se va a ejecutar cada uno de los menus y sus respectivas funcionalidades
 *  con las que el usuario va a interactuar, su funcionamiento se basa en el uso de switches
 *  
 * 	autores: Santiago Franco Valencia, Anderson Elian Gutierrez, Santiago Valencia Mejía, Daniel Alejandro Giraldo
 * 	 
 * 	componentes del módulo: Clase Ui(carga y guarda todos los archivos .txt mediante serializacion), ademas un Menu principal 
 * que llama los submenus (todos ellos basado en uso de switches)*/
 

package uiMain;

import BaseDatos.Datos;
import gestorAplicacion.transacciones.*;
import gestorAplicacion.producto.*;

import java.util.ArrayList;
import java.util.Scanner;
/*Cabecera en la clase: la clase Ui carga y guarda todos los datos en los archivos .txt, además llama el
 * menu principal con el que el usuario va a interactuar*/
public class Ui {
	public static void main(String[] Args) {
		Datos datos = new Datos();
		Ui uimain = new Ui();
		datos.leerDatos();
		datos.leerDatos1();
		uimain.clientesRegistrados(datos);
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
//este metodo menu es el principal, le pedirá una opcion de ingreso al usuario y de acuerdo a la opcion, 
//mediante switches muestre su respectivo submenu
	public void menu(Datos datos){
	    /*    for (int i = 0; i < 30 ; i++) {
	            datos.ingresarCliente();
	            datos.ingresarConsola();
	            datos.ingresarJuego();
	            datos.ingresarPeriferico();
	        }*/
	        System.out.println("Ingrese una opción");
	        System.out.println("1. Ingresar Clientes o Productos");
	        System.out.println("2. Vender Productos");
	        System.out.println("3. Servicios técnicos");
	        System.out.println("4. Imperial");
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
	        }
	    }
// este método sera ejecutado si la opcion del usuario en el menu principal fue 1: Ingresar Clientes o Productos
	public void menuAgregar(Datos datos){
		System.out.println("Ingrese una opcion");
		System.out.println("0. Volver");
		System.out.println("1. Ingresar Cliente");
		System.out.println("2. Ingresar Consola/s");
		System.out.println("3. Ingresar Juego/s");
		System.out.println("4. Ingresar Periferico/s");
		int i = entrada.nextInt();
		switch (i){
//dependiendo del caso a excepcion de 0, se llamará su respectivo metodo en la clase Datos
			case 0:
				this.menu(datos);
			case 1:
				datos.ingresarCliente();
				break;
			case 2:
				datos.ingresarConsola();
				break;
			case 3:
				datos.ingresarJuego();
				break;
			case 4:
				datos.ingresarPeriferico();
				break;

		}
	}
// este metodo sera ejecutado si la opcion del usuario en el menu principal fue 2:Vender Productos
	public void menuVender(Datos datos){
		System.out.println("¿El cliente ya está registrado?"+"\n");
		System.out.println("0. Volver");
		System.out.println("1. Sí el cliente está registrado");
		System.out.println("2. Sí el cliente NO está registrado");
		int verificador = entrada.nextInt();
		//un entero que verifica si el cliente esta o no registrado y ejecutar el respectivo metodo
		Cliente cliente = new Cliente();
		if (verificador == 0){
			this.menu(datos);
		} else if(verificador == 1){
			cliente = this.clienteRegistrado(datos);
		} else if (verificador == 2) {
			cliente = this.clienteNoRegistrado(datos);
		}
		//se le pide al usuario una entrada despues de saber si esta registrado o no
		System.out.println("¿Qué artículo desea vender?: Ingrese una opcion");
		System.out.println("0. Volver");
		System.out.println("1. Consola/s");
		System.out.println("2. Juego/s");
		System.out.println("3. Periferico/s");
		int i =entrada.nextInt();
		System.out.println("Seleccione su producto:");
		switch (i){
			case 0:
				this.menuVender(datos);
			case 1: {
				//si la entrada fue 1, se muestran las consolas disponibles y se pide la cantidad de consolas a vender
				consolasRegistradas(datos);
				System.out.println("¿Cuántas consolas desea vender?: ");
				int tope = entrada.nextInt();
				this.consolasRegistradas(datos);
				//FALTA IMPLEMENTAR BIEN ESTA PARTE
				System.out.println("Seleccione qué consola/s desea vender: (Ejemplo: [1, 2, 3])");
				int[] ints = this.seleccionProductos(tope);
				ArrayList<Producto> productos = datos.consolaPorIndice(ints);
				for (Producto pro: productos){
					System.out.println(pro);
				}
				//se hace el llamado al metodo de la clase Datos para generar una factura de venta
				datos.generarFacturaVenta(productos, cliente);
				break;
			}
			case 2: {
				//si la entrada fue 2, se muestran los juegos disponibles y se pide la cantidad de juegos a vender
				juegosRegistrados(datos);
				System.out.println("¿Cuantos juegos desea vender?: ");
				int tope = entrada.nextInt();
				this.juegosRegistrados(datos);
				//FALTA IMPLEMENTAR BIEN ESTA PARTE
				System.out.println("Seleccione qué Juego/s desea vender: (Ejemplo: [1, 2, 3])");
				int[] ints = this.seleccionProductos(tope);
				ArrayList<Producto> productos = datos.juegoPorIndice(ints);
				//se hace el llamado al metodo de la clase Datos para generar una factura de venta
				datos.generarFacturaVenta(productos, cliente);
				break;
			}
			case 3: {
				//si la entrada fue 3, se muestran los perifercios disponibles y se pide la cantidad de perifericos a vender
				perifericosRegistrados(datos);
				System.out.println("¿Cuántos perifericos desea vender?:");
				int tope = entrada.nextInt();
				this.perifericosRegistrados(datos);
				//FALTA IMPLEMENTAR BIEN ESTA PARTE
				System.out.println("Seleccione qué periferico/s desea vender: (Ejemplo: [1, 2, 3])");
				int[] ints = this.seleccionProductos(tope);
				ArrayList<Producto> productos = datos.perifericoPorIndice(ints);
				//se hace el llamado al metodo de la clase Datos para generar una factura de venta
				datos.generarFacturaVenta(productos, cliente);
				break;

			}
		}
	}	
	
	public void menuServiciosTecnicos(Datos datos){
		//Verificamos sí el cliente ya está registrado a través de enteros.
		System.out.println("¿El cliente ya está registrado?"+"\n");
		System.out.println("0. Volver");
		System.out.println("1. Sí el cliente está registrado");
		System.out.println("2. Sí el cliente NO está registrado");
		int verificador = entrada.nextInt(); //A través de esta variable se verífica con if sí el cliente está registrado.
		Cliente cliente = new Cliente(); //Hacemos una instancia de cliente con el fin de que el código compile sin problemas.
		if (verificador == 0){
			this.menu(datos);
		} else if(verificador == 1){
			cliente = this.clienteRegistrado(datos);
		} else if (verificador == 2) {
			cliente = this.clienteNoRegistrado(datos);
		}
		System.out.println("¿Cuántos productos requieren de servicio técnico?");
		int i = entrada.nextInt(); // Scanner para saber cuantos productos se crearán.
		ArrayList<Producto> productos = new ArrayList<Producto>(); // Lista que se crea para generar los detalles de la factura.
		ArrayList<Detalle> detalles = new ArrayList<Detalle>(); // Lista que almacenará cada detalle.
		for (int j = 0; j < i ; j++) {
			System.out.println("¿Desea modificar una consola o periferico?");
			System.out.println("1. Modificar una consola");
			System.out.println("2. Modificar un periférico");
			int determinante = entrada.nextInt();
			switch (determinante){
				case 1: {
					//si la entrada fue 1 se modifica la consola y se genera un detalle
					System.out.println("Ingrese el nombre de la consola:");
					String nombre = entrada.next();
					System.out.println("Ingrese el color de la consola:");
					String color = entrada.next();
					System.out.println("Ingrese el estado de la consola (true or false)");
					Boolean estado = entrada.nextBoolean();
					System.out.println("Ingrese el almacenamiento de la consola:");
					int almacenamiento = entrada.nextInt();
					Consola producto = new Consola(nombre, color, estado, almacenamiento);
					System.out.println("Ingrese el tipo de Servicio Técnico");
					String tiposervicio = entrada.next();
					System.out.println("Ingrese el precio del servicio técnico");
					float precio = entrada.nextFloat();
					Detalle detalle = new Detalle(producto, precio, tiposervicio);
					detalles.add(detalle);
					break;
				}
				case 2: {
					//si la entrada fue 2 se modifica el periferico y se genera un detalle
					System.out.println("Ingrese el nombre de la consola:");
					String nombre = entrada.next();
					System.out.println("Ingrese el estado de la consola (true or false)");
					Boolean estado = entrada.nextBoolean();
					Periferico producto = new Periferico(nombre, estado);
					System.out.println("Ingrese el tipo de Servicio Técnico");
					String tiposervicio = entrada.next();
					System.out.println("Ingrese el precio del servicio técnico");
					float precio = entrada.nextFloat();
					Detalle detalle = new Detalle(producto, precio, tiposervicio);
					detalles.add(detalle);
					break;
				}
			}
		}
		//genera una factura y la agrega a la lista listaFacturas en la clase Datos a traves del metodo agregar factura
		Factura factura = new Factura(cliente, detalles);
		datos.agregarFactura(factura);
		System.out.println(factura);

	}	
	// Mostrar en pantalla los clientes registrados:
	public void clientesRegistrados(Datos datos) {
		int indiceCliente = 1;
		for (Cliente cliente : datos.getListaClientes()) {
			System.out.println(indiceCliente + " " + cliente.toString());
			indiceCliente ++;
		}
	}
	// Mostrar en pantalla las consolas registradas:
	public void consolasRegistradas(Datos datos) {
		int indiceConsola = 1;
		for (Consola consola : datos.getListaConsolas()) {
			System.out.println(indiceConsola + " " + consola.toString());
			indiceConsola ++;
		}
	}
	// Mostrar en pantalla los juegos registrados:

	public void juegosRegistrados(Datos datos) {
		int indiceJuego = 1;
		for (Juego juego : datos.getListaJuegos()) {
			System.out.println(indiceJuego + " " + juego.toString());
			indiceJuego ++;
		}
	}
	// Mostrar en pantalla los perifericos registrados:

	public void perifericosRegistrados(Datos datos) {
		int indicePeriferico = 1;
		for (Periferico periferico : datos.getListaPerifericos()) {
			System.out.println(indicePeriferico + " " + periferico.toString());
			indicePeriferico ++;
		}
	}
	// Mostrar en pantalla las facturas registradas:

	public void facturasRegistradas(Datos datos) {
		for (Factura factura : datos.getListaFacturas()) {
			System.out.println(factura.toString());
		}
	}
	
	
	public int[] seleccionProductos(int tope){
		int[] ints = new int[tope];
		for(int i=0; i<tope; i++) {
			ints[i] = entrada.nextInt();
			System.out.println(ints[i]);
		}
		return ints;
	}
	
	//este metodo selecciona un cliente dada una entrada i
	public Cliente clienteRegistrado(Datos datos){
		this.clientesRegistrados(datos);
		int i = entrada.nextInt();
		return datos.seleccionarCliente(i-1);
	}
	
	//este metodo registra un cliente
	public Cliente clienteNoRegistrado(Datos datos){
		datos.ingresarCliente();
		return datos.seleccionarUltimoCliente();
	}
	// este método sera ejecutado si la opcion del usuario en el menu principal fue 4.Imperial
	public void menuImperial(Datos datos){
		System.out.println("Ingrese una opción");
		System.out.println("0. Volver");
		System.out.println("1. Alquilar");
		System.out.println("2. Vender");
		System.out.println("3. Comprar");
		int i = entrada.nextInt();
	}
	
}
