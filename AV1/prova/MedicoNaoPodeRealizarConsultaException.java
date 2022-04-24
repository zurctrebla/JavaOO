
class MedicoNaoPodeRealizarConsultaException extends Exception {

    public MedicoNaoPodeRealizarConsultaException(){
        
        super("Especialidade do médico não permite realizar este tipo de consulta!");
    }       
}
