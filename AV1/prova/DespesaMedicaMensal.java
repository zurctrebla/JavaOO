
class DespesaMedicaMensal {

  private Paciente paciente;

  private AtendimentoMedicoDiario atendimentoMedicoDiario; // necessario incluir para chamar acomodação.

  private final double valorDiariaQuarto = 200; 
  private final double valorDiariaEnfermaria = 100; 

  public DespesaMedicaMensal(Paciente paciente){

    this.paciente = paciente;
  }

  public double getValorDiariaQuarto(){

   return this.valorDiariaQuarto;
  }

  public double getValorDiariaEnfermaria(){

    return this.valorDiariaEnfermaria;
  }

 
  public double calcularDespesaTotal() throws ValorMaximoDespesaMensalAtingidaException{  //  RESPOSTA QUESTÃO 05

    double soma = 0;

    if(atendimentoMedicoDiario.getAcomodacao() == "E")
      soma = soma + getValorDiariaEnfermaria();
    else
      soma = soma + getValorDiariaQuarto();
    
    try {
      soma = soma + atendimentoMedicoDiario.calcularDespesaTotal(); //calcularDespesaTotal();                             // RESPOSTA QUESTÃO 04
    } catch (Exception e) {
      System.out.println(e.getMessage());
      // return;
    }

    // soma = soma + atendimentoMedicoDiario.calcularDespesaTotal();

    // for (ProcedimentoMedico procedimentoMedico : this.getProcedimentos())
    //   soma = soma + procedimentoMedico.getValor();              // soma os procedimentos médicos

    // for (ConsultaMedica consultaMedica : this.getConsultas())
    //   soma = soma + consultaMedica.getValor();                  // soma as consultas médicas

    // for (ExameMedico exameMedico : this.getExames())
    //   soma = soma + exameMedico.getValor();                     // soma os exames médicos

    // for (CirurgiaMedica cirurgiaMedica : this.getCirurgias())
    //   soma = soma + cirurgiaMedica.getValor();                  // soma as cirurgias médicas

    if(paciente.getPlanoSaude().getValorMaximoDespesaMedicaMensal() > soma)
      return soma;
    else
      throw new ValorMaximoDespesaMensalAtingidaException();
      
  }

}