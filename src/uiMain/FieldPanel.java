package uiMain;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
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
    HashMap<String, CheckBox> condicionales = new HashMap<>();

    public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, String[] valores, boolean[] habilitado){
        //Parametros del formulario:

        this.formularioingreso.setPadding(new Insets(10, 10, 10, 10));
        this.formularioingreso.setVgap(20);
        this.formularioingreso.setHgap(20);
        this.formularioingreso.setAlignment(Pos.CENTER);

        //Componentes del formulario:

        this.formularioingreso.add(new Label(tituloCriterios), 0,0);
        this.formularioingreso.add(new Label(tituloValores),0,0);

        Label titulo;
        TextField campo;

        //Campo nombre:

        for (int i = 0; i < criterios.length; i++) {

            titulo = new Label(criterios[i]);
            campo = new TextField(valores[i]);

            System.out.println(criterios[i]);
            this.hashMap.put(criterios[i], campo);

            this.formularioingreso.add(titulo, 0, i+1);
            this.formularioingreso.add(campo, 1, i+1);

        }
        this.getChildren().add(formularioingreso);
    }

    public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, boolean[] habilitado){

        //Parametros del formulario:

        this.formularioingreso.setPadding(new Insets(10, 10, 10, 10));
        this.formularioingreso.setVgap(20);
        this.formularioingreso.setHgap(20);
        this.formularioingreso.setAlignment(Pos.CENTER);

        //Componentes del formulario:

        this.formularioingreso.add(new Label(tituloCriterios), 0,0);
        this.formularioingreso.add(new Label(tituloValores),1,0);

        Label titulo;
        TextField campo;

        //Campo nombre:

        for (int i = 0; i < criterios.length; i++) {

            titulo = new Label(criterios[i]);
            campo = new TextField();

            this.hashMap.put(criterios[i], campo);

            this.formularioingreso.add(titulo, 0, i+1);
            this.formularioingreso.add(campo, 1, i+1);

        }
        this.getChildren().add(formularioingreso);

    }

    public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, String[] valores, boolean[] habilitado, String[] booleanos){
        //Parametros del formulario:

        this.formularioingreso.setPadding(new Insets(10, 10, 10, 10));
        this.formularioingreso.setVgap(20);
        this.formularioingreso.setHgap(20);
        this.formularioingreso.setAlignment(Pos.CENTER);

        //Componentes del formulario:

        this.formularioingreso.add(new Label(tituloCriterios), 0,0);
        this.formularioingreso.add(new Label(tituloValores),0,0);

        Label titulo;
        TextField campo;
        CheckBox checkBox;

        //Campo nombre:

        for (int i = 0; i < criterios.length; i++) {

            titulo = new Label(criterios[i]);
            campo = new TextField(valores[i]);

            System.out.println(criterios[i]);
            this.hashMap.put(criterios[i], campo);

            this.formularioingreso.add(titulo, 0, i+1);
            this.formularioingreso.add(campo, 1, i+1);

        }

        for (int i = criterios.length; i < (booleanos.length + criterios.length) ; i++) {



            titulo = new Label(booleanos[i-criterios.length]);
            checkBox = new CheckBox();

            this.condicionales.put(booleanos[i-criterios.length], checkBox);

            this.formularioingreso.add(titulo, 0, i+1);
            this.formularioingreso.add(checkBox, 1, i+1);

        }
        this.getChildren().add(formularioingreso);
    }

    public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, boolean[] habilitado, String[] booleanos){

        //Parametros del formulario:

        this.formularioingreso.setPadding(new Insets(10, 10, 10, 10));
        this.formularioingreso.setVgap(20);
        this.formularioingreso.setHgap(20);
        this.formularioingreso.setAlignment(Pos.CENTER);

        //Componentes del formulario:

        this.formularioingreso.add(new Label(tituloCriterios), 0,0);
        this.formularioingreso.add(new Label(tituloValores),1,0);

        Label titulo;
        TextField campo;
        CheckBox checkBox;

        //Campo nombre:

        for (int i = 0; i < criterios.length; i++) {

            titulo = new Label(criterios[i]);
            campo = new TextField();

            this.hashMap.put(criterios[i], campo);

            this.formularioingreso.add(titulo, 0, i+1);
            this.formularioingreso.add(campo, 1, i+1);

        }

        for (int i = criterios.length; i < (booleanos.length + criterios.length) ; i++) {



            titulo = new Label(booleanos[i-criterios.length]);
            checkBox = new CheckBox();

            this.condicionales.put(booleanos[i-criterios.length], checkBox);

            this.formularioingreso.add(titulo, 0, i+1);
            this.formularioingreso.add(checkBox, 1, i+1);

        }
        this.getChildren().add(formularioingreso);

    }
    public String getValue(String criterio){
        return hashMap.get(criterio).getText();
    }

    public TextField getCampo(String criterio){
        return hashMap.get(criterio);
    }

    public CheckBox getCheckBox(String condicion){
        return condicionales.get(condicion);
    }

    public Boolean getValor(String condicion){
        return condicionales.get(condicion).isSelected();
    }
}
