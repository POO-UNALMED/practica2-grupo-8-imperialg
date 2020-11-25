package errores.tipo1;

import uiMain.DialogError;

public class ErrorCampoVacio extends ErrorTipo1{

    public ErrorCampoVacio(){
        super("Campo vacío");
        this.setDescripcion("Hay algun campo vacio");
    }
}
