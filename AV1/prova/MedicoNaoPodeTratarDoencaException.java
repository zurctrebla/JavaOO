
class MedicoNaoPodeTratarDoencaException extends Exception {

    public MedicoNaoPodeTratarDoencaException(){
        
        super("Especialidade do médico não permite tratar este tipo de doença!");
    }      
}
