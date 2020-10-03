package uiMain;
import gestorAplicacion.producto.*;
import gestorAplicacion.transacciones.*;
import BaseDatos.*;

public class Ui {
	public static void main(String[] Args) {
		DatosTranssacciones.leerDatos();
		DatosTranssacciones.guardarDatos();
	}
}
