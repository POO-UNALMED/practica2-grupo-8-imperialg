package uiMain;

import BaseDatos.Datos;
import gestorAplicacion.producto.Consola;
import gestorAplicacion.producto.Juego;
import gestorAplicacion.producto.Periferico;
import gestorAplicacion.transacciones.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;

public class ModificarCliente extends VBox {

    FieldPanel fp;
    ComboBox listamc;

    public ModificarCliente() {
        listamc = new ComboBox(FXCollections.observableArrayList(Datos.listaClientes));
        //Creacion de Vbox para modificar Clientes

        this.setSpacing(50);
        this.setAlignment(Pos.CENTER);

        //Textfield con el titulo del proceso

        TextField proceso = new Proceso("Modificar un cliente de la Base De Datos");

        //TextField con el detalle del proceso

        TextField detalleproceso = new DetalleProceso("Debe llenar todos los campos correspondientes para ingresar un Cliente");


        ///Formulario:


        String[] criterios = new String[] {"Nombre", "Cedula", "Celular", "Email"};
        fp = new FieldPanel("Datos Cliente", criterios, "Datos",null);

        //Botones modificar y cancelar :

        Button modificar = new Button("Modificar");
        Button cancelar = new Button("Cancelar");


        //Mostrar en pantalla datos de los clientes:

        ComboBoxClienteSeleccionado handlercombo = new ComboBoxClienteSeleccionado();
        listamc.setOnAction(handlercombo);

        //Modificar cuando se presiona el boton modificar:

        BotonModificarCliente botonModificarCliente = new BotonModificarCliente();
        modificar.setOnAction(botonModificarCliente);


        //Agregar elementos a un Vbox:

        HBox hBox = new HBox();
        hBox.getChildren().addAll(modificar,cancelar);
        this.getChildren().addAll(proceso, detalleproceso, listamc, fp, hBox);
    }




    //Creacion de clases anonimas:

    //Mostrar informacion de los clientes en pantalla:

    class ComboBoxClienteSeleccionado implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Cliente cliente = (Cliente) listamc.getSelectionModel().getSelectedItem();
            fp.getCampo("Nombre").setText(cliente.getNombre());
            fp.getCampo("Cedula").setText(Integer.toString(cliente.getCc()));
            fp.getCampo("Celular").setText(Long.toString(cliente.getCelular()));
            fp.getCampo("Email").setText(cliente.getEmail());

        }
    }
    //Modificar atributos del cliente cuando se presiona el boton modificar:

    //OJO, Aquí hay un error:

    class BotonModificarCliente implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Cliente cliente = (Cliente) listamc.getSelectionModel().getSelectedItem();
            cliente.setNombre(fp.getValue("Nombre"));
            cliente.setCc(Integer.parseInt(fp.getValue("Cedula")));
            cliente.setCelular(Long.parseLong(fp.getValue("Celular")));
            cliente.setEmail(fp.getValue("Email"));
            listamc.getItems().clear();
            listamc.setItems(FXCollections.observableArrayList(Datos.listaClientes));

        }

    }
    //Eliminar un cliente de la base de datos:
    class BotonEliminarCliente implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            Cliente cliente = (Cliente) listamc.getSelectionModel().getSelectedItem();
            Datos.listaClientes.remove(cliente);
            listamc.getItems().clear();
            listamc.setItems(FXCollections.observableArrayList(Datos.listaClientes));
        }
    }



}
