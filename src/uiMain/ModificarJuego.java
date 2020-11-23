package uiMain;

import BaseDatos.Datos;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ModificarJuego extends VBox{

    ComboBox listamj;
    FieldPanel fp;

    public ModificarJuego(){

        listamj = new ComboBox(FXCollections.observableArrayList(Datos.listaJuegos));

        this.setSpacing(50);
        this.setAlignment(Pos.CENTER);

        //Textfield con el titulo del proceso
        Proceso procesoj = new Proceso("Ingresar un Juego a la Base De Datos");

        //Textfield con el detalle del proceso

        DetalleProceso detalleprocesoj = new DetalleProceso("Debe llenar todos los campos correspondientes para ingresar un Juego");

        //Formulario:

        String[] criterios = new String[] {"Nombre", "Precio", "Pegi", "Plataforma", "Genero"};
        String[] booleanos = new String[] {"Uso"};

        this.fp = new FieldPanel("Datos Juegos",criterios,"Datos",null,booleanos);


        //Boton de modificar y cancelar:

        Button modificarjueg = new Button("Modificar");
        Button cancelarjueg = new Button("Cancelar");

        //Interactividad

        ComboBoxJuegoSeleccionado comboBoxJuegoSeleccionado = new ComboBoxJuegoSeleccionado();
        listamj.setOnAction(comboBoxJuegoSeleccionado);

        BotonModificarJuego botonModificarJuego = new BotonModificarJuego();
        modificarjueg.setOnAction(botonModificarJuego);

        //Anadir elementos al vbox
        this.getChildren().addAll(procesoj, detalleprocesoj,listamj, fp);

    }


    //Mostrar informacion de los juegos en pantalla:

    //Seleccionar una juego y que se rellenen automaticamente los textfield:
    class ComboBoxJuegoSeleccionado implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Juego juego = (Juego) listamj.getSelectionModel().getSelectedItem();
            fp.getCampo("Nombre").setText(juego.getNombre());
            fp.getCampo("Precio").setText(Float.toString(juego.getPrecio()));
            fp.getCampo("Pegi").setText(Integer.toString(juego.getPegi()));
            fp.getCampo("Plataforma").setText(juego.getPlataforma());
            fp.getCampo("Genero").setText(juego.getGenero());
            Boolean uso = juego.getUso();
            if (uso == true){
                fp.getCheckBox("Uso").setSelected(true);
            } else if(uso == false){
                fp.getCheckBox("Uso").setSelected(false);
            }
            listamj.getItems().clear();
            listamj.setItems(FXCollections.observableArrayList(Datos.listaJuegos));
        }
    }


    //Modificar atributos de la consola cuando se presiona el boton modificar:
    class BotonModificarJuego implements  EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            Juego juego = (Juego) listamj.getSelectionModel().getSelectedItem();
            juego.setNombre(fp.getValue("Nombre"));
            juego.setPrecio(Float.parseFloat(fp.getValue("Precio")));
            juego.setPegi(Integer.parseInt(fp.getValue("Pegi")));
            juego.setPlataforma(fp.getValue("Plataforma"));
            juego.setGenero(fp.getValue("Genero"));
            if(fp.getCondicion("Uso") == true) {
                juego.setUso(true);
            }else if(fp.getCondicion("Uso") == false) {
                juego.setUso(false);
            }
            listamj.getItems().clear();
            listamj.setItems(FXCollections.observableArrayList(Datos.listaJuegos));
        }
        }



    //Eliminar un juego de la base de datos:
    class BotonEliminarJuego implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            Juego juego = (Juego) listamj.getSelectionModel().getSelectedItem();
            Datos.listaJuegos.remove(juego);
        }
    }


}
