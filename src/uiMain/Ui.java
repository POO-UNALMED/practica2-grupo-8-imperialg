/*		 CABECERA DEL ARCHIVO:
 * 
 * 	 funcionalidad del modulo: Aquí se encuentra el Main donde se va a ejecutar cada uno de los menus y sus respectivas funcionalidades
 *  con las que el usuario va a interactuar, su funcionamiento se basa en el uso de switches
 *  
 * 	autores: Santiago Franco Valencia, Anderson Elian Gutierrez, Santiago Valencia Mejia, Daniel Alejandro Giraldo
 * 	 
 * 	componentes del módulo: Clase Ui(carga y guarda todos los archivos .txt mediante serializacion), ademas un Menu principal 
 *  que llama los submenus (todos ellos basados en uso de switches)*/


/* Autores:   - Santiago Franco Valencia 
*            - Anderson Elian Gutierrez 
*            - Santiago Valencia Mejia
*            - Daniel Alejandro Giraldo  */

/*Cabecera en la clase: la clase Ui carga y guarda todos los datos en los archivos .txt, además llama el
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
        //Factura.facturasRegistradas();
        //Cliente.clientesRegistrados();
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
	
	//este metodo menu es el principal, le pedirá una opcion de ingreso al usuario y de acuerdo a la opcion, 
	//mediante switches muestre su respectivo submenu
	public void menu(Datos datos){
	        System.out.println("Ingrese una opcion");
	        System.out.println("1. Ingresar Clientes o Productos");
	        System.out.println("2. Vender Productos");
	        System.out.println("3. Servicios tecnicos");
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
		System.out.println("¿El cliente ya esta registrado?"+"\n");
		System.out.println("0. Volver");
		System.out.println("1. Si el cliente esta registrado");
		System.out.println("2. Si el cliente NO esta registrado");
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
		System.out.println("¿Que articulo desea vender?: Ingrese una opcion");
		System.out.println("0. Volver");
		System.out.println("1. Consola/s");
		System.out.println("2. Juego/s");
		System.out.println("3. Periférico/s");
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
	
	
	// M�todo para implementar el men� de servicios t�cnicos (Reparaciones y modificaciones de productos). 
	public void menuServiciosTecnicos(Datos datos){
		//Verificamos sí el cliente ya está registrado a través de enteros.
		System.out.println("¿El cliente ya esta registrado?"+"\n");
		System.out.println("0. Volver");
		System.out.println("1. Si el cliente esta registrado");
		System.out.println("2. Si el cliente NO esta registrado");
		int verificador = entrada.nextInt(); //A través de esta variable se verífica con if sí el cliente está registrado.
		Cliente cliente = new Cliente(); //Hacemos una instancia de cliente con el fin de que el código compile sin problemas.
		if (verificador == 0){
			this.menu(datos);
		} else if(verificador == 1){
			cliente = Cliente.clienteRegistrado();
		} else if (verificador == 2) {
			cliente = Cliente.clienteNoRegistrado();
		}
		System.out.println("¿Cuantos productos requieren de servicio tecnico?");
		int i = entrada.nextInt(); // Scanner para saber cuantos productos se crearán.
		//ArrayList<Producto> productos = new ArrayList<Producto>(); // Lista que se crea para generar los detalles de la factura.
		ArrayList<Detalle> detalles = new ArrayList<Detalle>(); // Lista que almacenará cada detalle.
		for (int j = 0; j < i ; j++) {
			System.out.println("�Desea modificar una consola o un periferico?");
			System.out.println("1. Modificar una consola");
			System.out.println("2. Modificar un periferico");
			int determinante = entrada.nextInt();
			switch (determinante){
				case 1:
					// Si la entrada fue 1 se modifica la consola y se genera un detalle
					Consola.modificarConsola(detalles);
					break;				
				case 2: 
					// Si la entrada fue 2 se modifica el periferico y se genera un detalle
					Periferico.modificarPeriferico(detalles);
					break;				
			}
		}		
		// Genera una factura y la agrega a la lista listaFacturas en la clase Datos a traves del metodo agregar factura
		Factura factura = new Factura(cliente, detalles);
		Factura.agregarFactura(factura);
		System.out.println(factura);

	}	
	

	// este método sera ejecutado si la opcion del usuario en el menu principal fue 4.Imperial
    public void menuImperial(Datos datos){
        System.out.println("Ingrese una opción");
        System.out.println("0. Volver");
        System.out.println("1. Modificar Precios");
        System.out.println("2. Ver historial y reportes");
        System.out.println("3. Ver Cliente con mas puntos");
        System.out.println("4. Recomendar Juegos por edad");
        int i = entrada.nextInt();
        switch (i){
            case 0:

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
    
	public void menuReportes(){
		System.out.println("Ingrese una opcion");
		System.out.println("0. Volver");
		System.out.println("1. Ver todos los Clientes");
		System.out.println("2. Ver todas las Consolas disponibles");
		System.out.println("3. Ver todos los Perifericos disponibles");
		System.out.println("4. Ver todos los Juegos disponibles");
		System.out.println("5. Lista de facturas que hay en el sistema");
		System.out.println("6. Reporte de productos vendidos");

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
		}
	}

	public void menuModificarPrecios(){
		System.out.println("¿Que desea modificar?: Seleccione una opcion.");
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

	public void menuModificarPreciosConsolas(){
		Consola.consolasRegistradas();
		System.out.println("¿Cuantos productos desea cambiar de precio?");
		int tope = entrada.nextInt();
		System.out.println("Ingrese uno a uno el indice de los productos que desea cambiar de precio");
		int[] ints = this.seleccionProductos(tope);
		System.out.println("Ingrese uno a uno el precio de los productos que desea cambiar de precio");
		int[] precios = this.especificacionPrecios(tope);
		Consola.modificarPreciosConsolas(ints, precios);
		System.out.println("Sus precios han sido modificados correctamente.");
	}
	public void menuModificarPreciosPerifericos(){
		Periferico.perifericosRegistrados();
		System.out.println("¿Cuantos productos desea cambiar de precio?");
		int tope = entrada.nextInt();
		System.out.println("Ingrese uno a uno el indice de los productos que desea cambiar de precio");
		int[] ints = this.seleccionProductos(tope);
		System.out.println("Ingrese uno a uno el precio de los productos que desea cambiar de precio");
		int[] precios = this.especificacionPrecios(tope);
		Periferico.modificarPreciosPerifericos(ints, precios);
		System.out.println("Sus precios han sido modificados correctamente.");
	}
	public void menuModificarPreciosJuegos(){
		Juego.juegosRegistrados();
		System.out.println("¿Cuantos productos desea cambiar de precio?");
		int tope = entrada.nextInt();
		System.out.println("Ingrese uno a uno el indice de los productos que desea cambiar de precio");
		int[] ints = this.seleccionProductos(tope);
		System.out.println("Ingrese uno a uno el precio de los productos que desea cambiar de precio");
		int[] precios = this.especificacionPrecios(tope);
		Juego.modificarPreciosJuegos(ints, precios);
		System.out.println("Sus precios han sido modificados correctamente.");
	}
	public int[] seleccionProductos(int tope){
		Scanner entrada = new Scanner(System.in);
		int[] ints = new int[tope];
		for(int i=0; i<tope; i++) {
			ints[i] = entrada.nextInt();
		}
		return ints;
	}
	public int[] especificacionPrecios(int tope){
		System.out.println("Ingrese uno a uno los precios de los productos que desea modificar");
		Scanner entrada = new Scanner(System.in);
		int[] precios = new int[tope];
		for(int i=0; i<tope; i++) {
			precios[i] = entrada.nextInt();
		}
		return precios;
	}
}