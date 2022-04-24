
class ProcedimentoNaoPermitidoException extends Exception {

    public ProcedimentoNaoPermitidoException(){
        
        super("Procedimento não é permitido pelo plano de saúde do paciente!");
    }
}
