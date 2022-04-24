
class ProcedimentoMedico {

  private String tipoProcedimento;

  private double valor;

  public ProcedimentoMedico(String tipoProcedimento, double valor){

    this.tipoProcedimento = tipoProcedimento;
    this.valor = valor;
  }

  public String getTipoProcedimento() {
    
    return Util.semAcento(tipoProcedimento).toLowerCase();
  }

  public double getValor() {
    return valor;
  }
}
