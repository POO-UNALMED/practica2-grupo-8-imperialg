package excepciones;

public class  ErrorAplicacion extends Exception{

    public ErrorAplicacion(){

    }
    public ErrorAplicacion(String texto){
    super(texto);
}
}
