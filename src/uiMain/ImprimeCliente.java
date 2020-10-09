package uiMain;
import BaseDatos.DatosTranssacciones;
import gestorAplicacion.transacciones.*;
import java.util.ArrayList;
public class ImprimeCliente {
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
        if (boolean registrado){
            ImprimeCliente.clientesRegistrados();
            int clienteselecto = 0;  //número escaneado -1
            new Factura(DatosTranssacciones.getListaClientes().get(clienteselecto));
        }else{


        }
    }
}
