
class MedicoNaoPodeExecutarProcedimentoException extends Exception {

    public MedicoNaoPodeExecutarProcedimentoException(){
        
        super("Especialidade do médico não permite executar este tipo de procedimento!");
    }
}