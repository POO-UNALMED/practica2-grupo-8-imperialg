package uiMain;
import gestorAplicacion.transacciones.*;
import BaseDatos.*;
import java.util.Scanner;

public class Ui {
	public static void main(String[] Args) {
		DatosTranssacciones.leerDatos();
		DatosTranssacciones.guardarDatos();
	}
	Scanner entrada = new Scanner(System.in);
	public void ingresarConsola(String nombre, boolean uso, String color, boolean estado, String version, int almacenamiento){
		System.out.println("Ingrese nombre de consola: ");
		nombre = entrada.next();
		System.out.println("Ingrese uso(true or false): ");
		uso = entrada.nextBoolean();
		System.out.println("Ingrese color: ");
		color = entrada.next();
		System.out.println("Ingrese estado(true or false): ");
		estado = entrada.nextBoolean();
		System.out.println("Ingrese nombre de la version: ");
		version = entrada.next();
		System.out.println("Ingrese cantidad almacenamiento: ");
		almacenamiento = entrada.nextInt();
	}
	public void ingresarJuego(String nombre, boolean uso, int pegi, String plataforma, String genero){
		System.out.println("Ingrese nombre del juego: ");
		nombre = entrada.next();
		System.out.println("Ingrese uso(true or false): ");
		uso = entrada.nextBoolean();
		System.out.println("Ingrese pegi: ");
		pegi = entrada.nextInt();
		System.out.println("Ingrese nombre plataforma: ");
		plataforma = entrada.next();
		System.out.println("Ingrese genero: ");
		genero = entrada.next();
	}
	public void ingresarPeriferico(String nombre, boolean uso, boolean estado, String plataforma){
		System.out.println("Ingrese nombre de periferico: ");
		nombre = entrada.next();
		System.out.println("Ingrese uso(true or false): ");
		uso = entrada.nextBoolean();
		System.out.println("Ingrese estado(true or false): ");
		estado = entrada.nextBoolean();
		System.out.println("Ingrese nombre plataforma: ");
		plataforma = entrada.next();
	}
	
	public void ingresarCliente() {
		System.out.println("Ingrese nombre de Cliente: ");
		String nombre = entrada.next();
		System.out.println("Ingrese cedula: ");
		int cc = entrada.nextInt();
		System.out.println("Ingrese celular: ");
		long celular = entrada.nextLong();
		System.out.println("Ingrese email: ");
		String email = entrada.next();
		Cliente cliente = new Cliente(nombre,cc,celular,email);
		DatosTranssacciones.agregarCliente(cliente);
	}

	public static void clientesRegistrados(){
		int indiceCliente = 1;
		for (Cliente cliente: DatosTranssacciones.getListaClientes()){
			System.out.println(indiceCliente + ":"+ cliente.getNombre() + "       " + cliente.getCc());
		}//Sí selecciona un cliente se selecciona de la lista de clientes el cliente i-1.
		//Sí el cliente no está registrado, se crea un nuevo objeto de la clase cliente y se añade a la lista.
	}
	public void iniciarTransaccion(){
		boolean registrado = false;
		//ingrese scanner
		System.out.println("¿El cliente se encuentra registrado: Indique true sí lo está y false para registrarlo");
		if (registrado){
			ImprimeCliente.clientesRegistrados();
			int clienteselecto = 0;  //número escaneado -1
			Factura factura = new Factura(DatosTranssacciones.getListaClientes().get(clienteselecto));
		}else if(!registrado){
			Factura factura = new Factura(DatosTranssacciones.getListaClientes().get(DatosTranssacciones.getListaClientes().size()-1));
		}
	}
}
