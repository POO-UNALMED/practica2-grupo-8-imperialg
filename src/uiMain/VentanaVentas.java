package uiMain;

import BaseDatos.Datos;
import gestorAplicacion.producto.Consola;
import gestorAplicacion.producto.Juego;
import gestorAplicacion.producto.Periferico;
import gestorAplicacion.transacciones.Cliente;
import gestorAplicacion.transacciones.Detalle;
import gestorAplicacion.transacciones.Factura;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.ArrayList;

public class VentanaVentas extends VBox{
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
        Button senServiciosTecnicos = new Button("Añadir al carrito");

        //Creacion de Hbox para los respectivos ingresos del usuario al carrito
        HBox pane1 = new HBox();
        HBox pane2 = new HBox();
        HBox pane3 = new HBox();
        HBox pane4 = new HBox();

        //Anadir elementos a los Hbox:

        pane1.getChildren().addAll(comboConsolas, cantidad1, sendConsolas);
        pane2.getChildren().addAll(comboJuegos,cantidad2,sendJuegos);
        pane3.getChildren().addAll(comboPerifericos,cantidad3,sendPerifericos);



        TextField tiposerv = new TextField("Servicio:");
        tiposerv.setPrefWidth(100);
        tiposerv.setEditable(false);
        TextField tiposerv1 = new TextField("");
        tiposerv1.setPrefWidth(140);
        TextField tiprod = new TextField("Producto:");
        TextField tip = new TextField();
        tiprod.setEditable(false);
        tiprod.setPrefWidth(110);
        String tiprod1[] = {"Consola","Periferico"};
        ComboBox tipoproduc = new ComboBox(FXCollections.observableArrayList(tiprod1));
		tipoproduc.valueProperty().addListener(new ChangeListener<String>() {
    		public void changed(ObservableValue x,String y,String t) {
    			tip.setText(t);
    		}
		}
		);
		tipoproduc.setPrefWidth(135);
        
        TextField nombreprod = new TextField("Nombre:");
        nombreprod.setEditable(false);
        nombreprod.setPrefWidth(100);
        TextField nombreprod1 = new TextField("");
        nombreprod1.setPrefWidth(150);
        TextField unidades = new TextField("Unidades:");
        unidades.setEditable(false);
        unidades.setPrefWidth(110);
        TextField unidades1 = new TextField("");
        unidades1.setPrefWidth(100);
        TextField precio = new TextField("Precio Servicio:");
        precio.setEditable(false);
        precio.setPrefWidth(150);
        TextField precio1 = new TextField("");
        precio1.setPrefWidth(100);        
        senServiciosTecnicos.setPrefWidth(150);
        pane4.getChildren().addAll(tiposerv, tiposerv1, tiprod, tipoproduc, nombreprod, nombreprod1, unidades, unidades1,
                precio, precio1, senServiciosTecnicos);


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
        
        senServiciosTecnicos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
                int cantidad = Integer.parseInt(unidades1.getText());
                float precio =Float.parseFloat(precio1.getText());
                String servicio = tiposerv1.getText();
                
                if(tip.getText().equals("Consola")) {
                	Consola producto = new Consola(nombreprod1.getText(),precio);
                	Detalle detalle = new Detalle(producto,precio,servicio, cantidad);
                	carrito.add(detalle);
                	ObservableList<Detalle> items = FXCollections.observableArrayList(carrito);
                	 lista.setItems(items);
                     lista.refresh();
                }else if(tip.getText().equals("Periferico")) {
                	Periferico producto = new Periferico(nombreprod1.getText(),precio);
                	Detalle detalle = new Detalle(producto,precio,servicio, cantidad);
                	carrito.add(detalle);
                	ObservableList<Detalle> items = FXCollections.observableArrayList(carrito);
                	 lista.setItems(items);
                     lista.refresh();
                }

               
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
        comboClientes.setPromptText("Lista de Clientes Registrados ");



        //Boton para generar una transaccion:
        Button generarF = new Button("Finalizar transaccion");
            generarF.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Cliente cliente = (Cliente) comboClientes.getSelectionModel().getSelectedItem();
                Factura factura = new Factura(cliente, carrito);
                
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("TRANSACCION EXITOSA");
                dialogoInfo.setHeaderText("Confirmacion de transaccion.");
                dialogoInfo.setContentText("La transaccion se ha realizado exitosamente.");
                dialogoInfo.showAndWait();


            }
        });

        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10,10,10,10));
        TextField vent = new TextField("Venta de Productos");
        vent.setAlignment(Pos.CENTER);
        vent.setEditable(false);
        vent.setPrefWidth(350);
        this.getChildren().add(vent);
        this.getChildren().add(pane1);
        this.getChildren().add(pane2);
        this.getChildren().add(pane3);
        TextField servtec = new TextField("Servicios Tecnicos");
        servtec.setAlignment(Pos.CENTER);
        servtec.setEditable(false);
        servtec.setPrefWidth(350);
        this.getChildren().add(servtec);        
        this.getChildren().add(pane4);
        lista.setMaxHeight(300);
        this.getChildren().add(lista);
        this.getChildren().add(info);
        this.getChildren().add(comboClientes);
        this.getChildren().addAll(botonrefresh, generarF);


}
}
