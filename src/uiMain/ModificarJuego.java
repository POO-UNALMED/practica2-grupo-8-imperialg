package uiMain;

import BaseDatos.Datos;
import errores.tipo1.ErrorCampoNumerico;
import errores.tipo1.ErrorCampoVacio;
import gestorAplicacion.producto.Consola;
import gestorAplicacion.producto.Juego;
import gestorAplicacion.transacciones.Cliente;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

public class ModificarJuego extends VBox{

    ComboBox listamj;
    FieldPanel fp;
    Juego juego;

    public ModificarJuego(){

        listamj = new ComboBox(FXCollections.observableArrayList(Datos.listaJuegos));
        listamj.setPromptText("Seleccione un Juego");
        listamj.setPrefWidth(500);
        this.setSpacing(50);
        this.setAlignment(Pos.CENTER);

        this.setSpacing(50);
        this.setAlignment(Pos.CENTER);

        //Textfield con el titulo del proceso
        Proceso procesoj = new Proceso("Ingresar, Eliminar o Modificar un Juego de la Base De Datos");

        //Textfield con el detalle del proceso

        DetalleProceso detalleprocesoj = new DetalleProceso("Debe llenar todos los campos correspondientes para ingresar un Juego");

        //Formulario:

        String[] criterios = new String[] {"Nombre", "Precio", "Pegi", "Plataforma", "Genero"};
        String[] booleanos = new String[] {"Uso"};

        this.fp = new FieldPanel("Datos Juegos",criterios,"Datos",null,booleanos);


        //Boton de modificar y cancelar:

        Button modificarjueg = new Button("Modificar");
        Button cancelarjueg = new Button("Cancelar");
        Button ingresarjueg = new Button("Ingresar");
        Button refrescar = new Button("Refrescar Campos");

        //Interactividad


        ComboBoxJuegoSeleccionado comboBoxJuegoSeleccionado = new ComboBoxJuegoSeleccionado();
        listamj.setOnAction(comboBoxJuegoSeleccionado);

        BotonModificarJuego botonModificarJuego = new BotonModificarJuego();
        modificarjueg.setOnAction(botonModificarJuego);

        BotonEliminarJuego botonEliminarJuego = new BotonEliminarJuego();
        cancelarjueg.setOnAction(botonEliminarJuego);

        BotonAnadirJuego botonAnadirJuego = new BotonAnadirJuego();
        ingresarjueg.setOnAction(botonAnadirJuego);

        BotonRefrescar botonRefrescar= new BotonRefrescar();
        refrescar.setOnAction(botonRefrescar);

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(ingresarjueg,modificarjueg, cancelarjueg);

        //Anadir elementos al vbox
        HBox field = new HBox(fp);
        field.setAlignment(Pos.CENTER);
        this.getChildren().addAll(procesoj, detalleprocesoj,listamj, field, hbox, refrescar);

    }


    //Mostrar informacion de los juegos en pantalla:

    //Seleccionar una juego y que se rellenen automaticamente los textfield:
    class ComboBoxJuegoSeleccionado implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            juego = (Juego) listamj.getSelectionModel().getSelectedItem();
            if (juego != null) {
                fp.getCampo("Nombre").setText(juego.getNombre());
                fp.getCampo("Precio").setText(Float.toString(juego.getPrecio()));
                fp.getCampo("Pegi").setText(Integer.toString(juego.getPegi()));
                fp.getCampo("Plataforma").setText(juego.getPlataforma());
                fp.getCampo("Genero").setText(juego.getGenero());
                Boolean uso = juego.getUso();
                if (uso == true) {
                    fp.getCheckBox("Uso").setSelected(true);
                } else if (uso == false) {
                    fp.getCheckBox("Uso").setSelected(false);
                }
            }
        }
    }


    //Modificar atributos de la consola cuando se presiona el boton modificar:
    class BotonModificarJuego implements  EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            try{
                juego.setNombre(fp.getValue("Nombre"));

                try {
                    juego.setPrecio(Float.parseFloat(fp.getValue("Precio")));
                    juego.setPegi(Integer.parseInt(fp.getValue("Pegi")));
                } catch (NumberFormatException s){
                    throw new ErrorCampoNumerico();
                }

                juego.setPlataforma(fp.getValue("Plataforma"));
                juego.setGenero(fp.getValue("Genero"));
                if (fp.getCondicion("Uso") == true) {
                    juego.setUso(true);
                } else if (fp.getCondicion("Uso") == false) {
                    juego.setUso(false);
                }
                listamj.getItems().clear();
                listamj.setItems(FXCollections.observableArrayList(Datos.listaJuegos));
                fp.refrescar();
            }catch (ErrorCampoVacio e){
                new DialogError(e);
            }catch (ErrorCampoNumerico s){
                new DialogError(s);
            }
        }
        }
    //Agregar Juegos a la base de datos:
    class BotonAnadirJuego implements  EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            try {
                Juego juego = new Juego();
                juego.setNombre(fp.getValue("Nombre"));
                try {
                    juego.setPrecio(Float.parseFloat(fp.getValue("Precio")));
                    juego.setPegi(Integer.parseInt(fp.getValue("Pegi")));
                } catch (NumberFormatException s){
                    throw new ErrorCampoNumerico();
                }
                juego.setPlataforma(fp.getValue("Plataforma"));
                juego.setGenero(fp.getValue("Genero"));
                if (fp.getCondicion("Uso") == true) {
                    juego.setUso(true);
                } else if (fp.getCondicion("Uso") == false) {
                    juego.setUso(false);
                }
                Datos.listaJuegos.add(juego);
                listamj.getItems().clear();
                listamj.setItems(FXCollections.observableArrayList(Datos.listaJuegos));
                fp.refrescar();

                // Dialogo de confirmacion despues de agregado el juego a la base de datos de la tienda.
                Alert dialogoDescripcion = new Alert(Alert.AlertType.INFORMATION);
                dialogoDescripcion.setTitle(" MENSAJE DE CONFIRMACION");
                dialogoDescripcion.setHeaderText("Usted acaba de agregar un nuevo Juego a la base de datos de la tienda.");
                dialogoDescripcion.setContentText("Proceso Exitoso.");
                dialogoDescripcion.showAndWait();
            } catch (ErrorCampoVacio e){
                new DialogError(e);
            } catch (ErrorCampoNumerico f){
                new DialogError(f);
            }
        }
    }


    //Eliminar un juego de la base de datos:
    class BotonEliminarJuego implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            Datos.listaJuegos.remove(juego);
            listamj.getItems().clear();
            listamj.setItems(FXCollections.observableArrayList(Datos.listaJuegos));
            fp.refrescar();
        }
    }

    class BotonRefrescar implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            fp.refrescar();
        }
    }


}
