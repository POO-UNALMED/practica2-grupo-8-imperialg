/*		 CABECERA DEL ARCHIVO:
 * 
 * 	 Funcionalidad del modulo: Aqui se encuentra el Main donde se va a ejecutar cada uno de los menus y sus respectivas funcionalidades
 *   con las que el usuario va a interactuar, su funcionamiento se basa en el uso de switches.
 *  
 * 	 Componentes del modulo: Clase Ui(carga y guarda todos los archivos .txt mediante serializacion), ademas un Menu principal 
 *   que llama los submenus (todos ellos basados en uso de switches)*/


/* Autores:   - Santiago Franco Valencia 
*            - Anderson Elian Gutierrez 
*            - Santiago Valencia Mejia
*            - Daniel Alejandro Giraldo  */

/*Cabecera en la clase: la clase Ui carga y guarda todos los datos en los archivos .txt, ademas llama el
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
        uimain.menuprincipal(datos);
        datos.guardarDatos();
        datos.guardarDatos1();
	}
	
	// Se usa el scanner entrada para recibir la entrada del usuario en cada caso que se requiera ingresar un dato.
	Scanner entrada = new Scanner(System.in);
	
	public void menuprincipal(Datos datos) {
		System.out.println("***** BIENVENIDO A IMPERIALGAMING, LA MEJOR TIENDA VIRTUAL *****"+"\n");
		this.menu(datos);
	}
	
	// Este metodo menu es el principal, le pedira una opcion de ingreso al usuario y de acuerdo a la opcion, 
	// Mediante switches muestre su respectivo submenu.
	public void menu(Datos datos){
	        System.out.println("Ingrese una opcion:"+"\n");
	        System.out.println("1. Ingresar Clientes");
	        System.out.println("2. Ingresar o Eliminar Productos");
	        System.out.println("3. Vender Productos");
	        System.out.println("4. Servicios tecnicos");
	        System.out.println("5. Imperial");
	        
	        int i = entrada.nextInt();
	        switch (i){
	            case 1:
	                Cliente.ingresarCliente();
	                break;
	            case 2:
	            	this.menuAgregarBorrarProductos(datos);
	            	break;
	            case 3:
	                this.menuVender(datos);
	                break;
	            case 4:
	                this.menuServiciosTecnicos(datos);
	                break;
	            case 5:
	                this.menuImperial(datos);
	                break;
	        }
	    }
	
	// Este metodo sera ejecutado si la opcion del usuario en el menu principal fue 2: Ingresar o Eliminar productos.
	public void menuAgregarBorrarProductos(Datos datos){
		System.out.println("Ingrese una opcion");
		System.out.println("0. Volver");
		System.out.println("1. Ingresar Consola/s");
		System.out.println("2. Ingresar Juego/s");
		System.out.println("3. Ingresar Periferico/s");
		System.out.println("4. Borrar Consola");
		System.out.println("5. Borrar Juego");
		System.out.println("6. Borrar Periferico");
		int i = entrada.nextInt();
		switch (i){
		
		// Dependiendo del caso a excepcion de 0, se llamara su respectivo metodo en la clase Datos.
			case 0:
				this.menu(datos);
			case 1:
				Consola.ingresarConsola();
				break;
			case 2:
				Juego.ingresarJuego();
				break;
			case 3:
				Periferico.ingresarPeriferico();
				break;
			case 4:
				Consola.borrarConsola();
				break;
			case 5:
				Juego.borrarJuego();
				break;
			case 6:
				Periferico.borrarPeriferico();
				break;
		}
	}
	
	// Este metodo sera ejecutado si la opcion del usuario en el menu principal fue 3:Vender Productos.
	public void menuVender(Datos datos){
		System.out.println("¿El cliente ya esta registrado?"+"\n");
		System.out.println("0. Volver");
		System.out.println("1. Si el cliente esta registrado");
		System.out.println("2. Si el cliente NO esta registrado");
		int verificador = entrada.nextInt();
		
		// Un entero que verifica si el cliente esta o no registrado y ejecutar el respectivo metodo.
		Cliente cliente = new Cliente();
		if (verificador == 0){
			this.menu(datos);
		} else if(verificador == 1){
			cliente = Cliente.clienteRegistrado();
		} else if (verificador == 2) {
			cliente = Cliente.clienteNoRegistrado();
		}	
		
		// Se le pide al usuario una entrada despues de saber si esta registrado o no.
		System.out.println("¿Que articulo desea vender? Ingrese una opcion: ");
		System.out.println("0. Volver");
		System.out.println("1. Consola/s");
		System.out.println("2. Juego/s");
		System.out.println("3. Periferico/s");
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
	
	// Metodo para implementar el menu de servicios tecnicos (Reparaciones y modificaciones de productos). 
	public void menuServiciosTecnicos(Datos datos){
		
		// Verificamos si el cliente ya esta registrado a traves de enteros.
		System.out.println("¿El cliente ya esta registrado?"+"\n");
		System.out.println("0. Volver");
		System.out.println("1. Si el cliente esta registrado");
		System.out.println("2. Si el cliente NO esta registrado");
		int verificador = entrada.nextInt(); // A traves de esta variable se verifica con if si el cliente esta registrado.
		Cliente cliente = new Cliente(); // Hacemos una instancia de cliente con el fin de que el codigo compile sin problemas.
		if (verificador == 0){
			this.menu(datos);
		} else if(verificador == 1){
			cliente = Cliente.clienteRegistrado();
		} else if (verificador == 2) {
			cliente = Cliente.clienteNoRegistrado();
		}
		System.out.println("¿Cuantos productos requieren de servicio tecnico?");
		int i = entrada.nextInt(); // Scanner para saber cuantos productos se crearan.
		ArrayList<Detalle> detalles = new ArrayList<Detalle>(); // Lista que almacenara cada detalle.
		for (int j = 0; j < i ; j++) {
			System.out.println("¿Desea modificar una consola o un periferico?");
			System.out.println("1. Modificar una consola");
			System.out.println("2. Modificar un periferico");
			int determinante = entrada.nextInt();
			switch (determinante){
				case 1:
					// Si la entrada fue 1 se modifica la consola y se genera un detalle.
					Consola.modificarConsola(detalles);
					break;				
				case 2: 
					// Si la entrada fue 2 se modifica el periferico y se genera un detalle.
					Periferico.modificarPeriferico(detalles);
					break;				
			}
		}		
		
		// Genera una factura y la agrega a la lista listaFacturas en la clase Datos a traves del metodo agregar factura.
		Factura factura = new Factura(Datos.listaFacturas.size(),cliente, detalles);
		Factura.agregarFactura(factura);
		System.out.println(factura);

	}	
	
	// Este metodo sera ejecutado si la opcion del usuario en el menu principal fue 5.Imperial.
    public void menuImperial(Datos datos){
        System.out.println("Ingrese una opcion");
        System.out.println("0. Volver");
        System.out.println("1. Modificar Precios");
        System.out.println("2. Ver Historial y Reportes");
        System.out.println("3. Ver Cliente con mas Puntos");
        System.out.println("4. Recomendar Juegos por Edad");
        int i = entrada.nextInt();
        switch (i){
            case 0:
            	this.menu(datos);
            case 1:
                this.menuModificarPrecios();
            case 2:
                this.menuReportes();
                break;
            case 3:
            	Cliente.clienteConMasPuntos();
            	break;
            case 4:
            	Juego.recomendarPorEdad();
            	break;
        }
    }
    
    // Metodo para manejar los reportes que se generan en la tienda.
	public void menuReportes(){
		System.out.println("Ingrese una opcion");
		System.out.println("0. Volver");
		System.out.println("1. Ver todos los Clientes Registrados ");
		System.out.println("2. Ver todas las Consolas disponibles en la tienda");
		System.out.println("3. Ver todos los Perifericos disponibles en la tienda");
		System.out.println("4. Ver todos los Juegos disponibles en la tienda");
		System.out.println("5. Lista de facturas que hay registradas en el sistema");
		System.out.println("6. Reporte de todos los productos vendidos");

		int verificador = entrada.nextInt();
		switch (verificador){
			case 0:
				this.menu(datos);
				break;
			case 1:
				Cliente.clientesRegistrados();
				break;
			case 2:
				Consola.consolasRegistradas();
				break;
			case 3:
				Periferico.perifericosRegistrados();
				break;
			case 4:
				Juego.juegosRegistrados();
				break;
			case 5:
				Factura.facturasRegistradas();
				break;
			case 6:
				this.menureportesvendidos();
		}
	}
	
	// Metodo para conocer las ganancias de la tienda y para conocer los productos mas y menos vendidos. 
	public void menureportesvendidos() {
		System.out.println("Ingrese una opcion");
		System.out.println("0. Volver");
		System.out.println("1. Ver Productos Vendidos y las Ganancias");
		System.out.println("2. Ver Productos Mas y Menos Vendidos de la tienda");
		int verificador = entrada.nextInt();
		
		switch(verificador) {
		case 0:
			this.menuReportes();
			break;
		case 1:
			Consola.ConsolasMasVendidas();
			System.out.println("\n");
			Juego.JuegosMasVendidos();
			System.out.println("\n");
			Periferico.PerifericosMasVendidos();			
			break;
		case 2:
			Consola.ConsolaMasVendida();
			System.out.println("\n");
			Juego.JuegoMasVendido();
			System.out.println("\n");
			Periferico.PerifericoMasVendido();
		}
		
	}
	
	// Metodo para modificar el precio de los productos de la tienda.
	public void menuModificarPrecios(){
		System.out.println("¿Que desea modificar? Seleccione una opcion: ");
		System.out.println("0. Volver");
		System.out.println("1. Modificar precios de Consolas");
		System.out.println("2. Modificar precios de Perifericos");
		System.out.println("3. Modificar precios de Juegos");
		int verificador = entrada.nextInt();
		switch (verificador){
			case 0:
				this.menuImperial(datos);
			case 1:
				this.menuModificarPreciosConsolas();
				break;
			case 2:
				this.menuModificarPreciosPerifericos();

				break;
			case 3:
				this.menuModificarPreciosJuegos();
				break;
		}
	}
	
	// Metodo para modificar el precio de las consolas de la tienda.
	public void menuModificarPreciosConsolas(){
		Consola.consolasRegistradas();
		System.out.println("¿ A cuantas consolas desea cambiarles el precio?");
		int tope = entrada.nextInt();
		System.out.println("Ingrese uno a uno y separados por un espacio en blanco el indice de las consolas a las que desea cambiarles de precio: ");
		int[] ints = this.seleccionProductos(tope);
		System.out.println("Ingrese uno a uno y separados por un espacio en blanco el nuevo precio de las consolas a las que desea cambiarles el precio: ");
		int[] precios = this.especificacionPrecios(tope);
		Consola.modificarPreciosConsolas(ints, precios);
		System.out.println("Sus precios han sido modificados correctamente.");
	}
	
	// Metodo para modificar el precio de los perifericos de la tienda.
	public void menuModificarPreciosPerifericos(){
		Periferico.perifericosRegistrados();
		System.out.println("¿Cuantos productos desea cambiar de precio?");
		int tope = entrada.nextInt();
		System.out.println("Ingrese uno a uno y separados por un espacio en blanco el indice de los perifericos a los que desea cambiarles el precio: ");
		int[] ints = this.seleccionProductos(tope);
		System.out.println("Ingrese uno a uno y separados por un espacio en blanco el nuevo precio de los perifericos a los que desea cambiarles el precio: ");
		int[] precios = this.especificacionPrecios(tope);
		Periferico.modificarPreciosPerifericos(ints, precios);
		System.out.println("Sus precios han sido modificados correctamente.");
	}
	
	// Metodo para modificar el precio de los juegos de la tienda.
	public void menuModificarPreciosJuegos(){
		Juego.juegosRegistrados();
		System.out.println("¿Cuantos productos desea cambiar de precio?");
		int tope = entrada.nextInt();
		System.out.println("Ingrese uno a uno y separados por un espacio en blanco el indice de los juegos a los que desea cambiarles el precio: ");
		int[] ints = this.seleccionProductos(tope);
		System.out.println("Ingrese uno a uno y separados por un espacio en blanco el nuevo precio de los juegos a los que desea cambiarles el precio: ");
		int[] precios = this.especificacionPrecios(tope);
		Juego.modificarPreciosJuegos(ints, precios);
		System.out.println("Sus precios han sido modificados correctamente.");
	}
	
	// Selecciona un conjunto de productos dado un indice y los ingresa a una lista estatica.
	public int[] seleccionProductos(int tope){
		Scanner entrada = new Scanner(System.in);
		int[] ints = new int[tope];
		for(int i=0; i<tope; i++) {
			ints[i] = entrada.nextInt();
		}
		return ints;
	}
	
	// Especifica los nuevos precios de los productos. 
	public int[] especificacionPrecios(int tope){
		System.out.println("Ingrese uno a uno y separados por un espacio en blanco los indices de los productos que desea modificar: ");
		Scanner entrada = new Scanner(System.in);
		int[] precios = new int[tope];
		for(int i=0; i<tope; i++) {
			precios[i] = entrada.nextInt();
		}
		return precios;
	}
}