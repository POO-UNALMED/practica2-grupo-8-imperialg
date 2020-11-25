package errores.tipo1;

public class ErrorComboVacio extends ErrorTipo1{
    public ErrorComboVacio(){
        super("Seleccion Vacia");
        this.setDescripcion("No se selecciono ningun elemento del desplegable.");
    }
}
