
class ExameMedico {

  private String tipoExame;

  private double valor;

  public ExameMedico(String tipoExame, double valor){

    this.tipoExame = tipoExame;
    this.valor = valor;
  }

  public String getTipoExame() {
    
    return Util.semAcento(tipoExame).toLowerCase();
  }

  public double getValor() {
    
    return valor;
  }

}
