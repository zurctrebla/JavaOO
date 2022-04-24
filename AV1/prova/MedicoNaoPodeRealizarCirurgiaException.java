
class MedicoNaoPodeRealizarCirurgiaException extends Exception {

    public MedicoNaoPodeRealizarCirurgiaException(){
        
        super("Especialidade do médico não permite realizar este tipo de cirurgia!");
    }    
}
