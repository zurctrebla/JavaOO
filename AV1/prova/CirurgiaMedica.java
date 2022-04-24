
class CirurgiaMedica {

  private String tipoCirurgia;

  private double valor;

  public CirurgiaMedica(String tipoCirurgia, double valor){

    this.tipoCirurgia = tipoCirurgia;
    this.valor = valor;
  }

  public String getTipoCirurgia() {
    
    return Util.semAcento(tipoCirurgia).toLowerCase();
  }

  public double getValor() {
    return valor;
  }

}
