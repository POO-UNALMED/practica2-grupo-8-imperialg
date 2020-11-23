package uiMain;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.HashMap;

public class FieldPanel extends Pane {
    GridPane formularioingreso = new GridPane();


    HashMap<String, TextField> hashMap = new HashMap<>();
    public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, String[] valores, boolean[] habilitado){

        //Parametros del formulario:

        this.formularioingreso.setPadding(new Insets(10, 10, 10, 10));
        this.formularioingreso.setVgap(20);
        this.formularioingreso.setHgap(20);
        this.formularioingreso.setAlignment(Pos.CENTER);

        //Componentes del formulario:

        formularioingreso.add(new Label(tituloCriterios), 0,0);
        formularioingreso.add(new Label(tituloValores),0,0);

        Label titulo;
        TextField campo;

        //Campo nombre:

        for (int i = 0; i < criterios.length; i++) {

            titulo = new Label(criterios[i]);
            campo = new TextField(valores[i]);

            this.hashMap.put(criterios[i], campo);

            formularioingreso.add(titulo, 0, i+1);
            formularioingreso.add(campo, 1, i+1);

        }

    }

    public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, boolean[] habilitado){


        ///Gridpane con formulario:

        GridPane formularioingresoc1 = new GridPane();

        //Componentes del formulario:

        formularioingresoc1.add(new Label(tituloCriterios), 0,0);
        formularioingresoc1.add(new Label(tituloValores),0,0);

        Label titulo;
        TextField campo;

        //Campo nombre:

        for (int i = 0; i < criterios.length; i++) {

            titulo = new Label(criterios[i]);
            campo = new TextField();

            this.hashMap.put(criterios[i], campo);

            formularioingresoc1.add(titulo, 0, i+1);
            formularioingresoc1.add(campo, 1, i+1);

        }

    }

    public String getValue(String criterio){
        return hashMap.get(criterio).getText();
    }

    public TextField getCampo(String criterio){
        return hashMap.get(criterio);
    }
}
