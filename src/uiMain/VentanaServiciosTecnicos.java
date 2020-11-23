package uiMain;
import BaseDatos.Datos;
import gestorAplicacion.producto.Consola;
import gestorAplicacion.producto.Juego;
import gestorAplicacion.producto.Periferico;
import gestorAplicacion.transacciones.Cliente;
import gestorAplicacion.transacciones.Detalle;
import gestorAplicacion.transacciones.Factura;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import java.util.ArrayList;


public class VentanaServiciosTecnicos {
	VBox serviciost = new VBox(15);
	VBox registrado = new VBox();
	
	public VentanaServiciosTecnicos() {		
		serviciost.setAlignment(Pos.CENTER);
		serviciost.setPadding(new Insets(15,10,10,10));
		TextField servit = new TextField("Servicios Tecnicos IMPERIAL-GAMING");
		servit.setScaleX(1.2);
		servit.setScaleY(1.2);
		servit.setMaxWidth(500);
    	servit.setEditable(false);
    	servit.setAlignment(Pos.CENTER);
    	TextField usr = new TextField("El Usuario se encuentra registrado en la base de Datos del programa?");
    	usr.setScaleX(1);
		usr.setScaleY(1);
		usr.setMaxWidth(500);
    	usr.setEditable(false);
    	Button si = new Button("  SI  ");
    	BotonSiHandlerClass sii = new BotonSiHandlerClass();
		si.setOnAction(sii);
		Button no = new Button("  NO  ");
		HBox sino = new HBox(15);
		sino.getChildren().addAll(si,no);
		sino.setAlignment(Pos.CENTER);
		serviciost.getChildren().addAll(servit,usr,sino,new Label(""));
		
		TextField info = new TextField("A continuacion seleccione el Cliente al cual desea aplicar la transaccion");
        info.setAlignment(Pos.CENTER);
        info.setEditable(false);
        info.setMaxWidth(700);

    //Lista observable de clientes:
    ObservableList<Cliente> listaClientes= FXCollections.observableArrayList(Datos.listaClientes);
    ComboBox comboClientes = new ComboBox(listaClientes);
    comboClientes.setPromptText("Lista de Clientes Registrados ");
    registrado.getChildren().addAll(info,comboClientes);
    registrado.setAlignment(Pos.CENTER);
		
	}
	
	class BotonSiHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			serviciost.getChildren().set(3, registrado);
		}
	}

}
