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
*                                        */

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
	        System.out.println("Ingrese Una Opcion:"+"\n");
	        System.out.println("1. Ingresar o Eliminar Clientes");
	        System.out.println("2. Ingresar o Eliminar Productos");
	        System.out.println("3. Vender Productos");
	        System.out.println("4. Servicios Tecnicos");
	        System.out.println("5. Imperial");
	        System.out.println("6. Salir Del Sistema");
	        
	        int i = entrada.nextInt();
	        switch (i){
	            case 1:
	            	this.menuFlujoClientes();
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
	            case 6:
	            	datos.guardarDatos();
	            	datos.guardarDatos1();
	            	System.exit(1);
	        }
	    }
	
	// Este metodo sera ejecutado si la opcion del usuario en el menu principal fue 2: Ingresar o Eliminar productos.
	public void menuAgregarBorrarProductos(Datos datos){
		System.out.println("Ingrese Una Opcion:"+"\n");
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
				//Consola.ingresarConsola();
				this.presioneParaVolver();
				break;
			case 2:
				Juego.ingresarJuego();
				this.presioneParaVolver();
				break;
			case 3:
				Periferico.ingresarPeriferico();
				this.presioneParaVolver();
				break;
			case 4:
				Consola.borrarConsola();
				System.out.println("Su Consola Ha Sido Eliminada Correctamente.");
				this.presioneParaVolver();
				break;
			case 5:
				Juego.borrarJuego();
				System.out.println("Su Juego Ha Sido Eliminado Correctamente.");
				this.presioneParaVolver();
				break;
			case 6:
				Periferico.borrarPeriferico();
				System.out.println("Su Periferico Ha Sido Eliminado Correctamente.");
				this.presioneParaVolver();
				break;
		}
	}
	
	// Este metodo sera ejecutado si la opcion del usuario en el menu principal fue 3:Vender Productos.
	public void menuVender(Datos datos){
		System.out.println("�El Cliente Ya Esta Registrado?"+"\n");
		System.out.println("0. Volver");
		System.out.println("1. Si El Cliente Esta Registrado");
		System.out.println("2. Si El Cliente NO Esta Registrado");
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
		System.out.println("�Que Producto Desea Vender? Ingrese Una Opcion: "+"\n");
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
				datos.guardarDatos1();
				this.presioneParaVolver();
				break;
			}
			case 2: {
				Juego.ventaJuego(cliente);
				datos.guardarDatos1();
				this.presioneParaVolver();
				break;
			}
			case 3: {
				Periferico.ventaPeriferico(cliente);
				datos.guardarDatos1();
				this.presioneParaVolver();
				break;

			}
		}
	}	
	
	// Metodo para implementar el menu de servicios tecnicos (Reparaciones y modificaciones de productos). 
	public void menuServiciosTecnicos(Datos datos){
		
		// Verificamos si el cliente ya esta registrado a traves de enteros.
		System.out.println("�El Cliente Ya Esta Registrado?"+"\n");
		System.out.println("0. Volver");
		System.out.println("1. Si El Cliente Esta Registrado");
		System.out.println("2. Si El Cliente NO Esta Registrado");
		int verificador = entrada.nextInt(); // A traves de esta variable se verifica con if si el cliente esta registrado.
		Cliente cliente = new Cliente(); // Hacemos una instancia de cliente con el fin de que el codigo compile sin problemas.
		if (verificador == 0){
			this.menu(datos);
		} else if(verificador == 1){
			cliente = Cliente.clienteRegistrado();
		} else if (verificador == 2) {
			cliente = Cliente.clienteNoRegistrado();
		}
		System.out.println("�Cuantos Productos Requieren De Servicio Tecnico?"+"\n");
		int i = entrada.nextInt(); // Scanner para saber cuantos productos se crearan.
		ArrayList<Detalle> detalles = new ArrayList<Detalle>(); // Lista que almacenara cada detalle.
		for (int j = 0; j < i ; j++) {
			System.out.println("�Desea Modificar Una Consola O Un Periferico?"+"\n");
			System.out.println("1. Modificar Una Consola");
			System.out.println("2. Modificar Un Periferico");
			int determinante = entrada.nextInt();
			switch (determinante){
				case 1:
					// Si la entrada fue 1 se modifica la consola y se genera un detalle.
					Consola.modificarConsola(detalles);
					datos.guardarDatos1();
					break;				
				case 2: 
					// Si la entrada fue 2 se modifica el periferico y se genera un detalle.
					Periferico.modificarPeriferico(detalles);
					datos.guardarDatos1();
					break;				
			}
		}		
		
		// Genera una factura y la agrega a la lista listaFacturas en la clase Datos a traves del metodo agregar factura.
		Factura factura = new Factura(Datos.listaFacturas.size(),cliente, detalles);
		Factura.agregarFactura(factura);
		System.out.println(factura);
		datos.guardarDatos1();
		this.presioneParaVolver();

	}	
	
	// Este metodo sera ejecutado si la opcion del usuario en el menu principal fue 5.Imperial.
    public void menuImperial(Datos datos){
        System.out.println("Ingrese Una Upcion:"+"\n");
        System.out.println("0. Volver");
        System.out.println("1. Modificar Precios");
        System.out.println("2. Ver Historial y Reportes");
        System.out.println("3. Ver Cliente Con Mas Puntos");
        System.out.println("4. Recomendar Juegos Por Edad");
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
				this.presioneParaVolver();
            	break;
            case 4:
            	Juego.recomendarPorEdad();
				this.presioneParaVolver();
            	break;
        }
    }
    
    // Metodo para manejar los reportes que se generan en la tienda.
	public void menuReportes(){
		System.out.println("Ingrese Una Opcion:"+"\n");
		System.out.println("0. Volver");
		System.out.println("1. Ver Todos Los Clientes Registrados");
		System.out.println("2. Ver Todas Las Consolas Disponibles En La Tienda");
		System.out.println("3. Ver Todos Los Perifericos Disponibles En La Tienda");
		System.out.println("4. Ver Todos Los Juegos Disponibles En La Tienda");
		System.out.println("5. Lista De Facturas Que Hay Registradas En El Sistema");
		System.out.println("6. Reporte De Todos Los Productos Vendidos");

		int verificador = entrada.nextInt();
		switch (verificador){
			case 0:
				this.menu(datos);
				break;
			case 1:
				Cliente.clientesRegistrados();
				this.presioneParaVolver();
				break;
			case 2:
				Consola.consolasRegistradas();
				this.presioneParaVolver();
				break;
			case 3:
				Periferico.perifericosRegistrados();
				this.presioneParaVolver();
				break;
			case 4:
				Juego.juegosRegistrados();
				this.presioneParaVolver();
				break;
			case 5:
				Factura.facturasRegistradas();
				this.presioneParaVolver();
				break;
			case 6:
				this.menureportesvendidos();
				this.presioneParaVolver();
		}
	}
	
	// Metodo para conocer las ganancias de la tienda y para conocer los productos mas y menos vendidos. 
	public void menureportesvendidos() {
		System.out.println("Ingrese Una Opcion:"+"\n");
		System.out.println("0. Volver");
		System.out.println("1. Ver Productos Vendidos y Las Ganancias");
		System.out.println("2. Ver Productos Mas y Menos Vendidos De La Tienda");
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
			this.presioneParaVolver();
			break;
		case 2:
			Consola.ConsolaMasVendida();
			System.out.println("\n");
			Juego.JuegoMasVendido();
			System.out.println("\n");
			Periferico.PerifericoMasVendido();
			this.presioneParaVolver();
		}
		
	}
	
	// Metodo para modificar el precio de los productos de la tienda.
	public void menuModificarPrecios(){
		System.out.println("�Que Desea Modificar? Seleccione Una Opcion: "+"\n");
		System.out.println("0. Volver");
		System.out.println("1. Modificar Precios De Consolas");
		System.out.println("2. Modificar Precios De Perifericos");
		System.out.println("3. Modificar Precios De Juegos");
		int verificador = entrada.nextInt();
		switch (verificador){
			case 0:
				this.menuImperial(datos);
			case 1:
				this.menuModificarPreciosConsolas();
		        this.menuprincipal(datos);
				this.presioneParaVolver();
				break;
			case 2:
				this.menuModificarPreciosPerifericos();
		        this.menuprincipal(datos);
				this.presioneParaVolver();

				break;
			case 3:
				this.menuModificarPreciosJuegos();
				this.presioneParaVolver();
				break;
		}
	}
	
	// Metodo para modificar el precio de las consolas de la tienda.
	public void menuModificarPreciosConsolas(){
		Consola.consolasRegistradas();
		System.out.println("�A Cuantas Consolas Desea Cambiarles El Precio?");
		int tope = entrada.nextInt();
		System.out.println("Ingrese Uno A Uno Y Separados Por Un Espacio En Blanco El Indice De Las Consolas A Las Que Desea Cambiarles De Precio: ");
		int[] ints = this.seleccionProductos(tope);
		System.out.println("Ingrese Uno A Uno Y Separados Por Un Espacio En Blanco El Nuevo Precio  De Las Consolas A Las Que Desea Cambiarles De Precio: ");
		int[] precios = this.especificacionPrecios(tope);
		Consola.modificarPreciosConsolas(ints, precios);
		System.out.println("Sus Precios Han Sido Modificados Correctamente.");
		datos.guardarDatos();
		this.presioneParaVolver();

	}
	
	// Metodo para modificar el precio de los perifericos de la tienda.
	public void menuModificarPreciosPerifericos(){
		Periferico.perifericosRegistrados();
		System.out.println("�Cuantos Perifericos desea cambiar de precio?");
		int tope = entrada.nextInt();
		System.out.println("Ingrese Uno A Uno Y Separados Por Un Espacio En Blanco El Indice De Los Perifericos A Los Que Desea Cambiarles De Precio: ");
		int[] ints = this.seleccionProductos(tope);
		System.out.println("Ingrese Uno A Uno Y Separados Por Un Espacio En Blanco El Nuevo Precio  De Los Perifericos A Los Que Desea Cambiarles De Precio: ");
		int[] precios = this.especificacionPrecios(tope);
		Periferico.modificarPreciosPerifericos(ints, precios);
		System.out.println("Sus Precios Han Sido Modificados Correctamente.");
		datos.guardarDatos();
		this.presioneParaVolver();
	}
	
	// Metodo para modificar el precio de los juegos de la tienda.
	public void menuModificarPreciosJuegos(){
		Juego.juegosRegistrados();
		System.out.println("�Cuantos Juegos Desea Cambiar De Precio?");
		int tope = entrada.nextInt();
		System.out.println("Ingrese Uno A Uno Y Separados Por Un Espacio En Blanco El Indice De Los Juegos A Los Que Desea Cambiarles De Precio: ");
		int[] ints = this.seleccionProductos(tope);
		System.out.println("Ingrese Uno A Uno Y Separados Por Un Espacio En Blanco El Nuevo Precio De Los Juegos A Las Que Desea Cambiarles De Precio: ");
		int[] precios = this.especificacionPrecios(tope);
		Juego.modificarPreciosJuegos(ints, precios);
		System.out.println("Sus Precios Han Sido Modificados Correctamente.");
		datos.guardarDatos();
		this.presioneParaVolver();
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
		Scanner entrada = new Scanner(System.in);
		int[] precios = new int[tope];
		for(int i=0; i<tope; i++) {
			precios[i] = entrada.nextInt();
		}
		return precios;
	}

	//Menu que especifica si el usuario quiere ingresar o eliminar un cliente
	public void menuFlujoClientes() {
        System.out.println("Ingrese Una Opcion:"+"\n");
        System.out.println("0.Volver");
        System.out.println("1.Ingresar Un Cliente");
        System.out.println("2.Eliminar Un Cliente");
        int j = entrada.nextInt();
        switch(j) {
        	case 0:
        		this.menu(datos);
        	case 1:
        		//Cliente.ingresarCliente();
        		datos.guardarDatos1();
        		this.presioneParaVolver();
        	case 2:
        		Cliente.borrarCliente();
        		datos.guardarDatos1();
        		this.presioneParaVolver();
        }
	}
	
	// Opci�n que permita presionar para volver al menu principal.
	public void presioneParaVolver() {
		System.out.println("Ingrese Cualquier Valor Para Volver Al Menu Principal");
		String algo = entrada.next();
		this.menu(datos);
	}
	
}