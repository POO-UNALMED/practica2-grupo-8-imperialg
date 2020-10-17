package uiMain;

import BaseDatos.Datos;
import gestorAplicacion.transacciones.Cliente;
import gestorAplicacion.producto.*;
import java.util.Scanner;

public class Ui {
	public static void main(String[] Args) {
		Datos datos = new Datos();
		Ui uimain = new Ui();
		datos.leerDatos();
		datos.leerDatos1();
		uimain.clientesRegistrados(datos);
		uimain.menu(datos);
		datos.guardarDatos();
		datos.guardarDatos1();
	}

	Scanner entrada = new Scanner(System.in);

	public void menu(Datos datos){
		System.out.println("Ingrese una opción");
		System.out.println("1. Ingresar Clientes o Productos");
		int i = entrada.nextInt();
		switch (i){
			case 1:
				this.menuAgregar(datos);
				break;
		}
	}

	public void menuAgregar(Datos datos){
		System.out.println("Ingrese una opcion");
		System.out.println("0. Volver");
		System.out.println("1. Ingresar Cliente");
		System.out.println("2. Ingresar Consola/s");
		System.out.println("3. Ingresar Juego/s");
		System.out.println("4. Ingresar Periferico/s");
		int i = entrada.nextInt();
		switch (i){
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

	public void clientesRegistrados(Datos datos) {
		int indiceCliente = 1;
		for (Cliente cliente : datos.getListaClientes()) {
			System.out.println(indiceCliente + " " + cliente.toString());
			indiceCliente ++;
		}
	}
}
