
class ExameNaoPermitidoException extends Exception {

    public ExameNaoPermitidoException(){
        
        super("Exame não é permitido pelo plano de saúde do paciente!");
    }  
}
