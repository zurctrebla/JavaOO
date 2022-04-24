
class ConsultaMedica {

  private String tipoConsulta;

  private double valor;

  public ConsultaMedica(String tipoConsulta, double valor){

    this.tipoConsulta = tipoConsulta;
    this.valor = valor;
  }

  public String getTipoConsulta() {
    
    return Util.semAcento(tipoConsulta).toLowerCase();
  }

  public double getValor() {
    return valor;
  }

}
