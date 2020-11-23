package uiMain;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class Proceso extends TextField {
    public Proceso(String texto){
        this.setText(texto);
        this.setMaxWidth(500);
        this.setEditable(false);
        this.setAlignment(Pos.CENTER);
    }
}
