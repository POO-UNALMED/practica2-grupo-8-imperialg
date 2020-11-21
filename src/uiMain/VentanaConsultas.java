package uiMain;

import BaseDatos.Datos;
import gestorAplicacion.producto.Consola;
import gestorAplicacion.producto.Juego;
import gestorAplicacion.producto.Periferico;
import gestorAplicacion.transacciones.Cliente;
import gestorAplicacion.transacciones.Detalle;
import gestorAplicacion.transacciones.Factura;
import javafx.application.Application;
import javafx.scene.control.ComboBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import uiMain.VentanaImperial.BotonIngresarConsolaHandlerClass;
import javafx.geometry.Insets;
import java.util.ArrayList;
import java.util.List;

public class VentanaConsultas {
	VBox consultas = new VBox(15);
	TextField textconsulta = new TextField();
	GridPane opciones;
	
	public VentanaConsultas() {
		consultas.setAlignment(Pos.CENTER);
		consultas.setPadding(new Insets(10,10,10,10));
		TextField cons = new TextField("Consultas IMPERIAL-GAMING");
		cons.setMaxWidth(500);
    	cons.setEditable(false);
    	cons.setAlignment(Pos.CENTER);
		String submenuimperial[] = {"Modificar Precios","Ver Historial y Reportes","Ver Cliente Con Mas Puntos","Recomendar Juegos Por Edad"};
		ComboBox menu = new ComboBox(FXCollections.observableArrayList(submenuimperial));
		menu.valueProperty().addListener(new ChangeListener<String>() {
    		public void changed(ObservableValue x,String y,String t) {
    			textconsulta.setText(t);
    		}
    	});
		
		menu.setPromptText("Seleccione una opcion");
		Button consultar = new Button("Consultar");
		BotonConsultaHandlerClass ingresarConsola = new BotonConsultaHandlerClass();
        consultar.setOnAction(ingresarConsola);
		opciones = new GridPane();
		opciones.setPadding(new Insets(10,10,10,10));
		opciones.setVgap(15);
		opciones.setHgap(15);
		opciones.add(menu, 0, 0);
		opciones.add(consultar, 1, 0);
		
		consultas.getChildren().addAll(cons,opciones);
	}
	
	
	class BotonConsultaHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			String consulta = textconsulta.getText();
			if(consulta.equals("Modificar Precios")) {
				
			}
			else if(consulta.equals("Ver Historial y Reportes")) {
				
			}
			else if(consulta.equals("Ver Cliente Con Mas Puntos")) {
				
			}else if(consulta.equals("Recomendar Juegos Por Edad")) {				
			}
		}
	}

}

