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

public class ModificarJuego {
    ObservableList<Juego> listajuegos = FXCollections.observableArrayList(Datos.listaJuegos);
    VBox modificarJuego;
    ComboBox listamj = new ComboBox(listajuegos);
    TextField nombrejueg = new TextField();
    TextField usojueg = new TextField();
    TextField preciojueg = new TextField();
    TextField pegijueg = new TextField();
    TextField plataformajueg = new TextField();
    TextField generojueg = new TextField();
    ComboBox<String> usojue = new ComboBox<String>();

    public ModificarJuego(){
        //Creacion de Vbox

        modificarJuego = new VBox(50);
        modificarJuego.setAlignment(Pos.CENTER);

        //Textfield con el titulo del proceso
        TextField procesoj = new TextField("Ingresar un Juego a la Base De Datos");
        procesoj.setMaxWidth(500);
        procesoj.setEditable(false);
        procesoj.setAlignment(Pos.CENTER);

        //Textfield con el detalle del proceso

        TextField detalleprocesoj = new TextField("Debe llenar todos los campos correspondientes para ingresar un Juego");
        detalleprocesoj.setAlignment(Pos.CENTER);
        detalleprocesoj.setEditable(false);
        detalleprocesoj.setMaxWidth(800);

        ///Gridpane con formulario:

        GridPane formularioingresojuego = new GridPane();

        //Componentes del formulario:

        //Campo nombre:

        Label nombrejuego = new Label("Nombre:");
        nombrejuego.setScaleX(1.1);
        nombrejuego.setScaleY(1.1);

        //Campo Uso

        Label usojuego = new Label("Uso del Juego:");
        usojue.getItems().addAll("Nuevo","Usado");
        usojue.setPromptText("Seleccione una opcion");
        usojue.valueProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue x, String y, String t) {
                usojueg.setText(t);
            }
        });
        usojuego.setScaleX(1.1);
        usojuego.setScaleY(1.1);

        //Campo precio

        Label preciojuego = new Label("Precio:");
        preciojuego.setScaleX(1.1);
        preciojuego.setScaleY(1.1);

        //Campo pegi

        Label pegijuego = new Label("Pegi:");
        pegijuego.setScaleX(1.1);
        pegijuego.setScaleY(1.1);

        //Campo plataforma:

        Label plataformajuego = new Label("Plataforma Asociada:");
        plataformajuego.setScaleX(1.1);
        plataformajuego.setScaleY(1.1);

        //Campo genero:

        Label generojuego = new Label("Genero:");
        generojuego.setScaleX(1.1);
        generojuego.setScaleY(1.1);

        //Boton de modificar y cancelar:

        Button modificarjueg = new Button("Modificar");
        Button cancelarjueg = new Button("Cancelar");

        //Ingresar campos al formulario:

        formularioingresojuego.setPadding(new Insets(10, 10, 10, 10));
        formularioingresojuego.setVgap(20);
        formularioingresojuego.setHgap(20);
        formularioingresojuego.setAlignment(Pos.CENTER);
        formularioingresojuego.add(nombrejuego, 0, 0);
        formularioingresojuego.add(nombrejueg, 1, 0);
        formularioingresojuego.add(usojuego, 0, 1);
        formularioingresojuego.add(usojue, 1, 1);
        formularioingresojuego.add(preciojuego, 0, 2);
        formularioingresojuego.add(preciojueg, 1, 2);
        formularioingresojuego.add(pegijuego, 0, 3);
        formularioingresojuego.add(pegijueg, 1, 3);
        formularioingresojuego.add(plataformajuego, 0, 4);
        formularioingresojuego.add(plataformajueg, 1, 4);
        formularioingresojuego.add(generojuego, 0, 5);
        formularioingresojuego.add(generojueg, 1, 5);
        formularioingresojuego.add(modificarjueg, 0, 6);
        formularioingresojuego.add(cancelarjueg, 1, 6);

        //Anadir elementos al vbox
        modificarJuego.getChildren().addAll(procesoj, detalleprocesoj,listamj, formularioingresojuego);

    }

    public VBox getModificarJuego() {
        return modificarJuego;
    }


    //Mostrar informacion de los juegos en pantalla:

    //Seleccionar una juego y que se rellenen automaticamente los textfield:
    class ComboBoxJuegoSeleccionado implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Juego juego = (Juego) listamj.getSelectionModel().getSelectedItem();
            nombrejueg.setText(juego.getNombre());
            preciojueg.setText(Float.toString(juego.getPrecio()));
            pegijueg.setText(Integer.toString(juego.getPegi()));
            plataformajueg.setText(juego.getPlataforma());
            Boolean uso = juego.getUso();
            if (uso == true){
                usojue.getSelectionModel().select(2);
            } else if(!uso){
                usojue.getSelectionModel().select(1);
            }
        }
    }


    //Modificar atributos de la consola cuando se presiona el boton modificar:
    class BotonModificarJuego implements  EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            Juego juego = (Juego) listamj.getSelectionModel().getSelectedItem();
            juego.setNombre(nombrejueg.getText());
            juego.setPrecio(Float.parseFloat(preciojueg.getText()));
            juego.setPegi(Integer.parseInt(pegijueg.getText()));
            juego.setPlataforma(plataformajueg.getText());
            if(usojueg.getText().equals("Nuevo")) {
                juego.setUso(false);
            }else if(usojueg.getText().equals("Usado")) {
                juego.setUso(true);
            }
            System.out.println(juego);

        }

    }


}
