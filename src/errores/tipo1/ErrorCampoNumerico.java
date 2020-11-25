package errores.tipo1;

public class ErrorCampoNumerico extends ErrorTipo1{
    public ErrorCampoNumerico(){
        super("Campo numerico");
        this.setDescripcion("No se colocaron numeros en algun campo numerico.");
    }
}
