package uiMain;

import BaseDatos.Datos;
import gestorAplicacion.producto.Consola;
import gestorAplicacion.producto.Juego;
import gestorAplicacion.producto.Periferico;
import gestorAplicacion.transacciones.Cliente;
import gestorAplicacion.transacciones.Detalle;
import gestorAplicacion.transacciones.Factura;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.ArrayList;

public class VentanaVentas{
    public ArrayList<Detalle> carrito;
    public VBox defecto;
    public VentanaVentas(ArrayList<Detalle> carrito) {
        this.carrito = carrito;
        //Creacion de combobox para mostrar consolas, perifericos y juegos:

        //Importacion de listas:
        ObservableList<Consola> listaconsolas = FXCollections.observableArrayList(Datos.listaConsolas);
        ObservableList<Periferico> listaperifericos = FXCollections.observableArrayList(Datos.listaPerifericos);
        ObservableList<Juego> listajuegos = FXCollections.observableArrayList(Datos.listaJuegos);

        //Creacion de ComboBoxes:
        ComboBox comboJuegos = new ComboBox(listajuegos);
        ComboBox comboPerifericos = new ComboBox(listaperifericos);
        ComboBox comboConsolas = new ComboBox(listaconsolas);
        comboJuegos.setPromptText("Seleccione Juegos");
        comboJuegos.setPrefWidth(750);
        comboPerifericos.setPromptText("Seleccione Perifericos");
        comboPerifericos.setPrefWidth(750);
        comboConsolas.setPromptText("Seleccione Consolas");
        comboConsolas.setPrefWidth(750);

        //Implementacion visual del carrito:
        ObservableList<Detalle> items = FXCollections.observableArrayList(carrito);
        ListView<Detalle> lista = new ListView<Detalle>(items);
        lista.setItems(items);

        //Textfield con las unidades del carrito:
        TextField cantidad1 = new TextField("Unidades de Consola");
        TextField cantidad2 = new TextField("Unidades de Juego");
        TextField cantidad3 = new TextField("Unidades de Periferico");

        //Botones para añadir productos al carrito:

        Button sendConsolas = new Button("Agregar al carrito");
        Button sendJuegos = new Button("Agregar al carrito");
        Button sendPerifericos = new Button("Agregar al carrito");

        //Creacion de Hbox para los respectivos ingresos del usuario al carrito
        HBox pane1 = new HBox();
        HBox pane2 = new HBox();
        HBox pane3 = new HBox();

        //Anadir elementos a los Hbox:

        pane1.getChildren().addAll(comboConsolas, cantidad1, sendConsolas);
        pane2.getChildren().addAll(comboJuegos,cantidad2,sendJuegos);
        pane3.getChildren().addAll(comboPerifericos,cantidad3,sendPerifericos);


        //Anadir juegos al carrito:

        sendJuegos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int cantidad = Integer.parseInt(cantidad2.getText());
                Juego producto = (Juego) comboJuegos.getSelectionModel().getSelectedItem();
                Detalle detalle = new Detalle(producto,producto.getPrecio(),"Venta", cantidad);
                carrito.add(detalle);
                ObservableList<Detalle> items = FXCollections.observableArrayList(carrito);
                lista.setItems(items);
                lista.refresh();
            }
        });

        //Anadir Consolas al carrito:

        sendConsolas.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int cantidad = Integer.parseInt(cantidad1.getText());
                Consola producto = (Consola) comboConsolas.getSelectionModel().getSelectedItem();
                Detalle detalle = new Detalle(producto,producto.getPrecio(),"Venta", cantidad);
                carrito.add(detalle);
                ObservableList<Detalle> items = FXCollections.observableArrayList(carrito);
                lista.setItems(items);
                lista.refresh();
            }
        });

        //Anadir perifericos al carrito:

        sendPerifericos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int cantidad = Integer.parseInt(cantidad3.getText());
                Periferico producto = (Periferico) comboPerifericos.getSelectionModel().getSelectedItem();
                Detalle detalle = new Detalle(producto,producto.getPrecio(),"Venta", cantidad);
                carrito.add(detalle);
                ObservableList<Detalle> items = FXCollections.observableArrayList(carrito);
                lista.setItems(items);
                lista.refresh();
            }
        });

        //Eliminar elementos del carrito con doble clic:

        lista.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)){
                    if(event.getClickCount()==2){
                        Detalle detaller = (Detalle) lista.getSelectionModel().getSelectedItem();
                        carrito.remove(detaller);
                        ObservableList<Detalle> items = FXCollections.observableArrayList(carrito);
                        lista.setItems(items);
                        lista.refresh();
                    }
                }
            }
        });

        //Boton para refrescar los detalles:
        Button botonrefresh = new Button("Refrescar");
            botonrefresh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                carrito.clear();
                ObservableList<Detalle> items = FXCollections.observableArrayList(carrito);
                lista.setItems(items);
                lista.refresh();
            }
        });

        TextField info = new TextField("A continuacion seleccione el Cliente al cual desea aplicar la transaccion");
            info.setAlignment(Pos.CENTER);
            info.setEditable(false);
            info.setMaxWidth(700);

        //Lista observable de clientes:
        ObservableList<Cliente> listaClientes= FXCollections.observableArrayList(Datos.listaClientes);
        ComboBox comboClientes = new ComboBox(listaClientes);



        //Boton para generar una transaccion:
        Button generarF = new Button("Finalizar transaccion");
            generarF.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Cliente cliente = (Cliente) comboClientes.getSelectionModel().getSelectedItem();
                Factura factura = new Factura(cliente, carrito);
                System.out.println(factura);

            }
        });
        defecto = new VBox(10);
        defecto.setSpacing(10);
        defecto.setAlignment(Pos.CENTER);
        defecto.setPadding(new Insets(10,10,10,10));

        defecto.getChildren().add(pane1);
        defecto.getChildren().add(pane2);
        defecto.getChildren().add(pane3);
        defecto.getChildren().add(lista);
        defecto.getChildren().add(info);
        defecto.getChildren().add(comboClientes);
        defecto.getChildren().addAll(botonrefresh, generarF);


}

    public VBox getDefecto() {
        return defecto;
    }

}