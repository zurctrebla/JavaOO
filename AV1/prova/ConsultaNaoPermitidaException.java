
class ConsultaNaoPermitidaException extends Exception {

    public ConsultaNaoPermitidaException(){
        
        super("Consulta não é permitida pelo plano de saúde do paciente!");
    }
}
