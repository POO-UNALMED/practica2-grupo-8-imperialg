package uiMain;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class DetalleProceso extends TextField {
    public DetalleProceso(String texto){
        this.setText(texto);
        this.setAlignment(Pos.CENTER);
        this.setEditable(false);
        this.setMaxWidth(800);
    }
}
