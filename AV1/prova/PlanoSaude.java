

class PlanoSaude {

  private boolean permiteConsulta;

  private boolean permiteExame;

  private boolean permiteProcedimento;

  private boolean permiteCirurgia;

  private double valorMaximoAtendimentoMedicoDiario;

  private double valorMaximoDespesaMedicaMensal;

  public PlanoSaude(boolean permiteConsulta,
                    boolean permiteExame,
                    boolean permiteProcedimento,
                    boolean permiteCirurgia,
                    double valorMaximoAtendimentoMedicoDiario,
                    double valorMaximoDespesaMedicaMensal){


    this.permiteConsulta = permiteConsulta;
    this.permiteExame = permiteExame;
    this.permiteProcedimento = permiteProcedimento;
    this.permiteCirurgia = permiteCirurgia;
    this.valorMaximoAtendimentoMedicoDiario = valorMaximoAtendimentoMedicoDiario;
    this.valorMaximoDespesaMedicaMensal = valorMaximoDespesaMedicaMensal;
  }

  public boolean permiteConsulta() {
    
    return permiteConsulta;
  }

  public boolean permiteExame() {

    return permiteExame;
  }

  public boolean permiteProcedimento() {

    return permiteProcedimento;
  }

  public  boolean permiteCirurgia() {

    return permiteCirurgia;
  }

  public double getValorMaximoAtendimentoMedicoDiario() {

    return this.valorMaximoAtendimentoMedicoDiario;
  }

  public double getValorMaximoDespesaMedicaMensal() {

    return this.valorMaximoDespesaMedicaMensal;
  }

}
