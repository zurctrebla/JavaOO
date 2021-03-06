import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class AtendimentoMedicoDiario {
  
  private String sintomas;

  private String diagnostico;

  private Date dataAtendimento;

  private Object medico;

  private List<TipoDoenca> tiposDoenca;

  private char tipoAcomodacao;

  private char tipoMedico;

  private List<CirurgiaMedica> cirurgias;

  private List<ProcedimentoMedico> procedimentos;

  private List<ExameMedico> exames;

  private List<ConsultaMedica> consultas;

  private Object acomodacao;

  private Paciente paciente;

  public AtendimentoMedicoDiario(Paciente paciente, Object acomodacao, Object medico){

    this.paciente = paciente;
    this.setAcomodacao(acomodacao);
    this.setMedico(medico);

    tiposDoenca = new ArrayList<TipoDoenca>();
    cirurgias = new ArrayList<CirurgiaMedica>();
    procedimentos = new ArrayList<ProcedimentoMedico>();
    exames = new ArrayList<ExameMedico>();
    consultas = new ArrayList<ConsultaMedica>();
  }

  public String getSintomas() {

    return Util.semAcento(sintomas).toLowerCase();
  }

  public void setSintomas(String sintomas) {
    this.sintomas = sintomas;
  }

  public String getDiagnostico() {
    
    return Util.semAcento(diagnostico).toLowerCase();
  }

  public void setDiagnostico(String diagnostico) {
    this.diagnostico = diagnostico;
  }

  public Date getDataAtendimento() {
    return dataAtendimento;
  }

  public void setDataAtendimento(Date dataAtendimento) {
    this.dataAtendimento = dataAtendimento;
  }

  public Object getMedico() {
    return medico;
  }

  public void setMedico(Object medico) {
    
    this.medico = medico;

    if (medico instanceof MedicoClinicoGeral)
      this.tipoMedico = 'C';
    else  
      this.tipoMedico = 'E';
  }

  public List<TipoDoenca> getTiposDoenca() {
    return tiposDoenca;
  }

  public void addTipoDoenca(TipoDoenca tipoDoenca) {
  
    tiposDoenca.add(tipoDoenca);
  }

  public char getTipoAcomodacao() {

    return Character.toLowerCase(tipoAcomodacao);
  }

  public char getTipoMedico() {

    return Character.toLowerCase(tipoMedico);
  }

  public List<CirurgiaMedica> getCirurgias() {
    return cirurgias;
  }

  public void addCirurgia(CirurgiaMedica cirurgia) throws CirurgiaNaoPermitidaException, MedicoNaoPodeRealizarCirurgiaException{

    if(paciente.getPlanoSaude().permiteCirurgia() == true)  // RESPOSTA QUEST??O 01
      if(getMedico() != "C")
        cirurgias.add(cirurgia);
      else
        throw new MedicoNaoPodeRealizarCirurgiaException(); //  RESPOSTA QUEST??O 03.1
    else
      throw new CirurgiaNaoPermitidaException();  

    try {
      calcularDespesaTotal();                               // RESPOSTA QUEST??O 04
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }
  
  }

  public List<ProcedimentoMedico> getProcedimentos() {
    return procedimentos;
  }

  public void addProcedimento(ProcedimentoMedico procedimento) throws ProcedimentoNaoPermitidoException, MedicoNaoPodeExecutarProcedimentoException{

    if(paciente.getPlanoSaude().permiteProcedimento() == true)  // RESPOSTA QUEST??O 01
      if(getMedico() != "C")
        procedimentos.add(procedimento);
      else
        throw new MedicoNaoPodeExecutarProcedimentoException(); //  RESPOSTA QUEST??O 03.1
    else
      throw new ProcedimentoNaoPermitidoException();

    try {
      calcularDespesaTotal();                                   // RESPOSTA QUEST??O 04
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }
  
  }

  public List<ConsultaMedica> getConsultas() {
    return consultas;
  }

  public void addConsulta(ConsultaMedica consulta) throws ConsultaNaoPermitidaException, MedicoNaoPodeRealizarConsultaException, MedicoNaoPodeTratarDoencaException{

    try {
      calcularDespesaTotal();                               // RESPOSTA QUEST??O 04
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }

    if(paciente.getPlanoSaude().permiteConsulta() == true)  // RESPOSTA QUEST??O 01
      consultas.add(consulta);   
    else
      throw new ConsultaNaoPermitidaException(); 

    /**
     * Quest??o 03.1
     */
    for (ConsultaMedica consultas : getConsultas())
      if (!consultas.getTipoConsulta().equals("consulta clinico geral"))
        throw new MedicoNaoPodeRealizarConsultaException();

    /**
     * Quest??o 02.1
     */
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

  public List<ExameMedico> getExames() {
    return exames;
  }

  public void addExame(ExameMedico exame) throws ExameNaoPermitidoException, MedicoNaoPodeSolicitarExameException{        

    if(paciente.getPlanoSaude().permiteExame() == true)  // RESPOSTA QUEST??O 01    
      if(getMedico() != "C")
        exames.add(exame);
      else
        throw new MedicoNaoPodeSolicitarExameException(); //  RESPOSTA QUEST??O 03.1
    else
      throw new ExameNaoPermitidoException();    

    try {
      calcularDespesaTotal();                             // RESPOSTA QUEST??O 04
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }

  }

  public Object getAcomodacao() {
    return acomodacao;
  }

  public void setAcomodacao(Object acomodacao) {

    this.acomodacao = acomodacao;

    if (acomodacao instanceof Quarto)
      this.tipoAcomodacao = 'Q';
    else  
      this.tipoAcomodacao = 'E';    
  }

  public double calcularDespesaTotal() throws ValorMaximoAtendimentoDiarioAtingidoException{  //  RESPOSTA QUEST??O 04

    double soma = 0;

    for (ProcedimentoMedico procedimentoMedico : this.getProcedimentos())
      soma = soma + procedimentoMedico.getValor();              // soma os procedimentos m??dicos

    for (ConsultaMedica consultaMedica : this.getConsultas())
      soma = soma + consultaMedica.getValor();                  // soma as consultas m??dicas

    for (ExameMedico exameMedico : this.getExames())
      soma = soma + exameMedico.getValor();                     // soma os exames m??dicos

    for (CirurgiaMedica cirurgiaMedica : this.getCirurgias())
      soma = soma + cirurgiaMedica.getValor();                  // soma as cirurgias m??dicas

    if(paciente.getPlanoSaude().getValorMaximoAtendimentoMedicoDiario() > soma)
      return soma;
    else
      throw new ValorMaximoAtendimentoDiarioAtingidoException();
            
  }
  
}
