
class MedicoNaoPodeSolicitarExameException extends Exception {

    public MedicoNaoPodeSolicitarExameException(){
        
        super("Especialidade do médico não permite solicitar este tipo de exame!");
    }          
}
