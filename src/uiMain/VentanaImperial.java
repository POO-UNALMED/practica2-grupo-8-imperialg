package uiMain;

import BaseDatos.Datos;
import gestorAplicacion.producto.Consola;
import gestorAplicacion.transacciones.Factura;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class VentanaImperial extends Application {

    public void start(Stage primaryStage) throws Exception {

///////////////////////////Ventana Imperial////////////////////////////////
        //Creacion de barra de menus:
        MenuBar barramenu = new MenuBar();

        //Creacion de menus:
        Menu archivo = new Menu("Archivo");
        Menu procon = new Menu("Procesos y consultas");
        Menu aiuda = new Menu("Ayuda");

        //Items de archivo:
        MenuItem usuario = new MenuItem("Usuario");
        MenuItem salir = new MenuItem("Salir");

        //Items de procesos y consultas:
        MenuItem vender = new MenuItem("Vender");
        MenuItem sertec = new MenuItem("Servicio tecnico");
        MenuItem stock = new MenuItem("Anadir o remover Stock");
        MenuItem consultas = new MenuItem("Consultas");

        //Items de ayuda:
        MenuItem acerca = new MenuItem("Acerca de");

        //Agregar items a menus:

        archivo.getItems().addAll(usuario, salir);
        procon.getItems().addAll(vender,sertec,stock, consultas);
        aiuda.getItems().addAll(acerca);


        //Agregar menus:
        barramenu.getMenus().addAll(archivo, procon, aiuda);

        VBox vusuario = new VBox();
        vusuario.getChildren().add(barramenu);

        VBox vusuario2 =new VBox();
        Label lbl = new Label("Hay que trabajar acá");



        TextField txt = new TextField("Hola");
        vusuario.getChildren().add(txt);


        ListView<String> visorConsolas = new ListView<String>();
        ArrayList<String> listaPrueba = new ArrayList<String>();
        for (Consola consola: Datos.listaConsolas){
            listaPrueba.add(consola.getNombre());
        }
        ObservableList<String> listica = FXCollections.observableArrayList(listaPrueba);
        visorConsolas.setItems(listica);

        vusuario.getChildren().add(visorConsolas);
        Scene imperial = new Scene(vusuario, 1000, 800);


        primaryStage.setScene(imperial);
        primaryStage.show();

    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
