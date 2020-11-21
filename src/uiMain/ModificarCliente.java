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

public class ModificarCliente {
    //Importacion de listas:
    ObservableList<Cliente> listaClientes = FXCollections.observableArrayList(Datos.listaClientes);

    VBox modificarCliente;
    ComboBox listamc = new ComboBox(listaClientes);
    TextField nombrec = new TextField();
    TextField cedulac = new TextField();
    TextField celularc = new TextField();
    TextField emailc = new TextField();

    public ModificarCliente() {
        //Creacion de Vbox para modificar Clientes

        modificarCliente = new VBox(50);
        modificarCliente.setAlignment(Pos.CENTER);

        //Textfield con el titulo del proceso

        TextField proceso = new TextField("Modificar un cliente de la Base De Datos");
        proceso.setMaxWidth(500);
        proceso.setEditable(false);
        proceso.setAlignment(Pos.CENTER);

        //TextField con el detalle del proceso

        TextField detalleproceso = new TextField("Debe llenar todos los campos correspondientes para ingresar un Cliente");
        detalleproceso.setAlignment(Pos.CENTER);
        detalleproceso.setMaxWidth(800);
        detalleproceso.setEditable(false);

        ///Gridpane con formulario:

        GridPane formularioingresoc1 = new GridPane();

        //Componentes del formulario:

        //Campo nombre:

        Label nombre = new Label("Nombre:");
        nombre.setScaleX(1.1);
        nombre.setScaleY(1.1);

        //Campo cedula

        Label cedula = new Label("Cedula:");
        cedula.setScaleX(1.1);
        cedula.setScaleY(1.1);

        //Campo celular

        Label celular = new Label("Nro Celular:");
        celular.setScaleX(1.1);
        celular.setScaleY(1.1);

        //Campo email

        Label email = new Label("e-mail:");
        email.setScaleX(1.1);
        email.setScaleY(1.1);

        //Botones modificar y cancelar :

        Button modificar = new Button("Modificar");
        Button cancelar = new Button("Cancelar");

        //Parametros del formulario:

        formularioingresoc1.setPadding(new Insets(10, 10, 10, 10));
        formularioingresoc1.setVgap(20);
        formularioingresoc1.setHgap(20);
        formularioingresoc1.setAlignment(Pos.CENTER);

        //Anadir componetes al formulario:

        formularioingresoc1.add(nombre, 0, 0);
        formularioingresoc1.add(nombrec, 1, 0);
        formularioingresoc1.add(cedula, 0, 1);
        formularioingresoc1.add(cedulac, 1, 1);
        formularioingresoc1.add(celular, 0, 2);
        formularioingresoc1.add(celularc, 1, 2);
        formularioingresoc1.add(email, 0, 3);
        formularioingresoc1.add(emailc, 1, 3);
        formularioingresoc1.add(modificar, 0, 4);
        formularioingresoc1.add(cancelar, 1, 4);

        //Anadir interactividad al formulario:

        //Mostrar en pantalla datos de los clientes:

        ComboBoxClienteSeleccionado handlercombo = new ComboBoxClienteSeleccionado();
        listamc.setOnAction(handlercombo);

        //Modificar cuando se presiona el boton modificar:

        BotonModificarCliente botonModificarCliente = new BotonModificarCliente();
        modificar.setOnAction(botonModificarCliente);


        //Agregar elementos a un Vbox:

        modificarCliente.getChildren().addAll(proceso, detalleproceso, listamc, formularioingresoc1);
    }

    //Retornar Vbox
    public VBox getModificarCliente() {
        return modificarCliente;
    }

    //Creacion de clases anonimas:

    //Mostrar informacion de los clientes en pantalla:

    class ComboBoxClienteSeleccionado implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Cliente cliente = (Cliente) listamc.getSelectionModel().getSelectedItem();
            nombrec.setText(cliente.getNombre());
            cedulac.setText(Integer.toString(cliente.getCc()));
            celularc.setText(Long.toString(cliente.getCelular()));
            emailc.setText(cliente.getEmail());

        }
    }
    //Modificar atributos del cliente cuando se presiona el boton modificar:

    class BotonModificarCliente implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Cliente cliente = (Cliente) listamc.getSelectionModel().getSelectedItem();
            cliente.setNombre(nombrec.getText());
            cliente.setCc(Integer.parseInt(cedulac.getText()));
            cliente.setCelular(Long.parseLong(celularc.getText()));
            cliente.setEmail(emailc.getText());

        }

    }
}
