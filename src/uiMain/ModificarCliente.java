package uiMain;

import BaseDatos.Datos;
import errores.tipo1.ErrorCampoNumerico;
import errores.tipo1.ErrorCampoVacio;
import errores.tipo2.ErrorVerificarCelular;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;

public class ModificarCliente extends VBox {
	Datos datos = new Datos();
    FieldPanel fp;
    ComboBox listamc;
    Cliente cliente;

    public ModificarCliente() {
        listamc = new ComboBox(FXCollections.observableArrayList(Datos.listaClientes));
        listamc.setPromptText("Seleccione un Cliente");
        listamc.setPrefWidth(500);
        this.setSpacing(50);
        this.setAlignment(Pos.CENTER);
       
        //Creacion de Vbox para modificar Clientes

        this.setSpacing(50);
        this.setAlignment(Pos.CENTER);
        

        //Textfield con el titulo del proceso

        TextField proceso = new Proceso("Ingresar, Eliminar o Modificar un Cliente de la Base De Datos");

        //TextField con el detalle del proceso

        TextField detalleproceso = new DetalleProceso("Debe llenar todos los campos correspondientes para ingresar un Cliente");


        ///Formulario:


        String[] criterios = new String[] {"Nombre",  "Email", "Cedula", "Celular"};
        fp = new FieldPanel("Datos Cliente", criterios, "Datos",null);

        //Botones modificar y cancelar :

        Button modificar = new Button("Modificar");
        Button cancelar = new Button("Eliminar");
        Button ingresar = new Button("Agregar");
        Button refrescar = new Button("Refrescar Campos");


        //Mostrar en pantalla datos de los clientes:

        ComboBoxClienteSeleccionado handlercombo = new ComboBoxClienteSeleccionado();
        listamc.setOnAction(handlercombo);

        //Modificar cuando se presiona el boton modificar:

        BotonModificarCliente botonModificarCliente = new BotonModificarCliente();
        modificar.setOnAction(botonModificarCliente);

        //Agregar Clientes a la base de datos:

        BotonAgregarCliente botonAgregarCliente = new BotonAgregarCliente();
        ingresar.setOnAction(botonAgregarCliente);

        //Eliminar cliente de la base de datos:

        BotonEliminarCliente botonEliminarCliente = new BotonEliminarCliente();
        cancelar.setOnAction(botonEliminarCliente);

        //Refrescar campos del textField:

        BotonRefrescar botonRefrescar= new BotonRefrescar();
        refrescar.setOnAction(botonRefrescar);

        //Agregar elementos a un Vbox:

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(ingresar, modificar, cancelar);
        HBox field = new HBox(fp);
        field.setAlignment(Pos.CENTER);
        this.getChildren().addAll(proceso, detalleproceso, listamc, field, hBox, refrescar);
    }


    //Creacion de clases anonimas:

    //Mostrar informacion de los clientes en pantalla:

    class ComboBoxClienteSeleccionado implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            cliente = (Cliente) listamc.getSelectionModel().getSelectedItem();
            if(cliente != null){
                fp.getCampo("Nombre").setText(cliente.getNombre());
                fp.getCampo("Cedula").setText(Integer.toString(cliente.getCc()));
                fp.getCampo("Celular").setText(Long.toString(cliente.getCelular()));
                fp.getCampo("Email").setText(cliente.getEmail());
            }

        }
    }
    //Modificar atributos del cliente cuando se presiona el boton modificar:


    class BotonModificarCliente implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            try {
                cliente.setNombre(fp.getValue("Nombre"));
                try {
                    cliente.setCc(Integer.parseInt(fp.getValue("Cedula")));
                    cliente.setCelular(Long.parseLong(fp.getValue("Celular")));
                } catch (NumberFormatException e){
                    throw new ErrorCampoNumerico();
                }
                String celular = fp.getValue("Celular");
                if(celular.length()!=10){
                    throw new ErrorVerificarCelular();
                }

                cliente.setEmail(fp.getValue("Email"));
                listamc.getItems().clear();
                listamc.setItems(FXCollections.observableArrayList(Datos.listaClientes));
                fp.refrescar();

            } catch (ErrorCampoVacio e){
                new DialogError(e);
            } catch (ErrorCampoNumerico f){
                new DialogError(f);
            } catch (ErrorVerificarCelular g){
                new DialogError(g);
            }
			datos.guardarDatos();
	        datos.guardarDatos1();
        }

    }
    //Eliminar un cliente de la base de datos:
    class BotonEliminarCliente implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            Datos.listaClientes.remove(cliente);
            listamc.getItems().clear();
            listamc.setItems(FXCollections.observableArrayList(Datos.listaClientes));
            fp.refrescar();
            Datos datos = new Datos();
            datos.guardarDatos();
            datos.guardarDatos1();
        }
    }

    //Agregar Cliente a la base de datos:
    class BotonAgregarCliente implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            //Creacion de cliente y registro de datos:
            try {
                cliente = new Cliente();
                cliente.setNombre(fp.getValue("Nombre"));

                try {
                    cliente.setCc(Integer.parseInt(fp.getValue("Cedula")));
                    cliente.setCelular(Long.parseLong(fp.getValue("Celular")));
                } catch (NumberFormatException e){
                    throw new ErrorCampoNumerico();
                }
                String celular = fp.getValue("Celular");
                if(celular.length()!=10){
                    throw new ErrorVerificarCelular();
                }
                cliente.setEmail(fp.getValue("Email"));
                Datos.listaClientes.add(cliente);
                listamc.getItems().clear();
                listamc.setItems(FXCollections.observableArrayList(Datos.listaClientes));
                Alert dialogoDescripcion = new Alert(AlertType.INFORMATION);
                dialogoDescripcion.setTitle(" MENSAJE DE CONFIRMACION");
                dialogoDescripcion.setHeaderText("Usted acaba de agregar un nuevo Cliente a la base de datos de la tienda.");
                dialogoDescripcion.setContentText("Proceso Exitoso.");
                dialogoDescripcion.showAndWait();
                fp.refrescar();
                } catch (ErrorCampoVacio e){
                  new DialogError(e);
                } catch (ErrorCampoNumerico f){
                  new DialogError(f);
                } catch (ErrorVerificarCelular g){
                  new DialogError(g);
                }
            datos.guardarDatos();
	        datos.guardarDatos1();
            }
        }



    class BotonRefrescar implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            fp.refrescar();
			datos.guardarDatos();
	        datos.guardarDatos1();
        }
    }

}
