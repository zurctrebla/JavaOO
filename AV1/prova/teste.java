public class teste {
    
}

public void addCirurgia(CirurgiaMedica cirurgia) throws CirurgiaNaoPermitidaException
{
    if(paciente.getPlanoSaude().permiteCirurgia() == true)  // RESPOSTA QUESTÃO 01
        cirurgias.add(cirurgia);
    else
      throw new CirurgiaNaoPermitidaException();  
  
}

public void addProcedimento(ProcedimentoMedico procedimento) throws ProcedimentoNaoPermitidoException{

    if(paciente.getPlanoSaude().permiteProcedimento() == true)  // RESPOSTA QUESTÃO 01
        procedimentos.add(procedimento);
    else
      throw new ProcedimentoNaoPermitidoException();
  
}

public void addConsulta(ConsultaMedica consulta) throws ConsultaNaoPermitidaException{

    if(paciente.getPlanoSaude().permiteConsulta() == true)  // RESPOSTA QUESTÃO 01
      consultas.add(consulta);   
    else
      throw new ConsultaNaoPermitidaException();   

}


public void addExame(ExameMedico exame) throws ExameNaoPermitidoException{        

    if(paciente.getPlanoSaude().permiteExame() == true)  // RESPOSTA QUESTÃO 01    
        exames.add(exame);
    else
      throw new ExameNaoPermitidoException(); 
}

////////////////////////////////

public void addCirurgia(CirurgiaMedica cirurgia) throws CirurgiaNaoPermitidaException, MedicoNaoPodeRealizarCirurgiaException{

    if(paciente.getPlanoSaude().permiteCirurgia() == true)  // RESPOSTA QUESTÃO 01
      if(getMedico() != "C")
        cirurgias.add(cirurgia);
      else
        throw new MedicoNaoPodeRealizarCirurgiaException(); //  RESPOSTA QUESTÃO 03.1
    else
      throw new CirurgiaNaoPermitidaException(); 

  
}


public void addProcedimento(ProcedimentoMedico procedimento) throws ProcedimentoNaoPermitidoException, MedicoNaoPodeExecutarProcedimentoException{

    if(paciente.getPlanoSaude().permiteProcedimento() == true)  // RESPOSTA QUESTÃO 01
      if(getMedico() != "C")
        procedimentos.add(procedimento);
      else
        throw new MedicoNaoPodeExecutarProcedimentoException(); //  RESPOSTA QUESTÃO 03.1
    else
      throw new ProcedimentoNaoPermitidoException();
  
  }

  public void addConsulta(ConsultaMedica consulta) throws ConsultaNaoPermitidaException, MedicoNaoPodeRealizarConsultaException{
    

    if(paciente.getPlanoSaude().permiteConsulta() == true)  // RESPOSTA QUESTÃO 01
      consultas.add(consulta);   
    else
      throw new ConsultaNaoPermitidaException(); 

    /**
     * Questão 03.1
     */
    for (ConsultaMedica consultas : getConsultas())
      if (!consultas.getTipoConsulta().equals("consulta clinico geral"))
        throw new MedicoNaoPodeRealizarConsultaException();
  

  }

  public void addExame(ExameMedico exame) throws ExameNaoPermitidoException, MedicoNaoPodeSolicitarExameException{        

    if(paciente.getPlanoSaude().permiteExame() == true)  // RESPOSTA QUESTÃO 01    
      if(getMedico() != "C")
        exames.add(exame);
      else
        throw new MedicoNaoPodeSolicitarExameException(); //  RESPOSTA QUESTÃO 03.1
    else
      throw new ExameNaoPermitidoException();    


  }


  //////////////////////////////////////////////
  public void addCirurgia(CirurgiaMedica cirurgia) throws CirurgiaNaoPermitidaException, MedicoNaoPodeRealizarCirurgiaException{
    if(paciente.getPlanoSaude().permiteCirurgia() == true)  // RESPOSTA QUESTÃO 01
      if(getMedico() != "C")
        cirurgias.add(cirurgia);
      else
        throw new MedicoNaoPodeRealizarCirurgiaException(); //  RESPOSTA QUESTÃO 03.1
    else
      throw new CirurgiaNaoPermitidaException();  
    try {
      calcularDespesaTotal();                               // RESPOSTA QUESTÃO 04
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }
  }
  public void addProcedimento(ProcedimentoMedico procedimento) throws ProcedimentoNaoPermitidoException, MedicoNaoPodeExecutarProcedimentoException{
    if(paciente.getPlanoSaude().permiteProcedimento() == true)  // RESPOSTA QUESTÃO 01
      if(getMedico() != "C")
        procedimentos.add(procedimento);
      else
        throw new MedicoNaoPodeExecutarProcedimentoException(); //  RESPOSTA QUESTÃO 03.1
    else
      throw new ProcedimentoNaoPermitidoException();
    try {
      calcularDespesaTotal();                                   // RESPOSTA QUESTÃO 04
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }
  }
  public void addConsulta(ConsultaMedica consulta) throws ConsultaNaoPermitidaException, MedicoNaoPodeRealizarConsultaException, MedicoNaoPodeTratarDoencaException{
    try {
      calcularDespesaTotal();                               // RESPOSTA QUESTÃO 04
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }
    if(paciente.getPlanoSaude().permiteConsulta() == true)  // RESPOSTA QUESTÃO 01
      consultas.add(consulta);   
    else
      throw new ConsultaNaoPermitidaException(); 
    for (ConsultaMedica consultas : getConsultas())
      if (!consultas.getTipoConsulta().equals("consulta clinico geral"))
        throw new MedicoNaoPodeRealizarConsultaException();
    for (TipoDoenca tipoDoenca : getTiposDoenca()) 
      if(
        !((tipoDoenca.getDescricao().equals("virose") || tipoDoenca.getDescricao().equals("dengue") && (getMedico() == "C"))) 
        || 
        !((tipoDoenca.getDescricao().equals("hipertensao") || tipoDoenca.getDescricao().equals("cancer de mama") && (paciente.getSexo() == 'F') && ((MedicoEspecialista)(this.medico)).getEspecialidade().equals("ginecologista")))
        ||
        !((tipoDoenca.getDescricao().equals("cancer de prostata") && (paciente.getSexo() == 'M') && ((MedicoEspecialista)(this.medico)).getEspecialidade().equals("urologista")))
      )
        throw new MedicoNaoPodeTratarDoencaException();    
  }
  public void addExame(ExameMedico exame) throws ExameNaoPermitidoException, MedicoNaoPodeSolicitarExameException{        
    if(paciente.getPlanoSaude().permiteExame() == true)  // RESPOSTA QUESTÃO 01    
      if(getMedico() != "C")
        exames.add(exame);
      else
        throw new MedicoNaoPodeSolicitarExameException(); //  RESPOSTA QUESTÃO 03.1
    else
      throw new ExameNaoPermitidoException();    
    try {
      calcularDespesaTotal();                             // RESPOSTA QUESTÃO 04
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }
  }
  public double calcularDespesaTotal() throws ValorMaximoAtendimentoDiarioAtingidoException{  //  RESPOSTA QUESTÃO 04
    double soma = 0;
    for (ProcedimentoMedico procedimentoMedico : this.getProcedimentos())
      soma = soma + procedimentoMedico.getValor();              // soma os procedimentos médicos
    for (ConsultaMedica consultaMedica : this.getConsultas())
      soma = soma + consultaMedica.getValor();                  // soma as consultas médicas
    for (ExameMedico exameMedico : this.getExames())
      soma = soma + exameMedico.getValor();                     // soma os exames médicos
    for (CirurgiaMedica cirurgiaMedica : this.getCirurgias())
      soma = soma + cirurgiaMedica.getValor();                  // soma as cirurgias médicas
    if(paciente.getPlanoSaude().getValorMaximoAtendimentoMedicoDiario() > soma)
      return soma;
    else
      throw new ValorMaximoAtendimentoDiarioAtingidoException();            
  }