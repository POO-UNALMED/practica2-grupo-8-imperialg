package errores.tipo2;

public class ErrorVerificarCelular extends ErrorTipo2{
    public ErrorVerificarCelular(){
        super("Verificar celular");
        this.setDescripcion("Se puso un numero distinto a 10 cifras en el campo celular.");
    }
}
