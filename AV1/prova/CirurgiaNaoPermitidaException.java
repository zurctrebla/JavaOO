
class CirurgiaNaoPermitidaException extends Exception {

    public CirurgiaNaoPermitidaException(){
        
        super("Cirurgia não é permitida pelo plano de saúde do paciente!");
    }
}
