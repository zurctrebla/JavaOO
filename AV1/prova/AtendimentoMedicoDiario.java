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

    if(getMedico() == "E")
      cirurgias.add(cirurgia);
    else
      throw new MedicoNaoPodeRealizarCirurgiaException(); //  RESPOSTA QUESTÃO 03

    if(paciente.getPlanoSaude().permiteCirurgia() == true)  // RESPOSTA QUESTÃO 01
      cirurgias.add(cirurgia);
    else
      throw new CirurgiaNaoPermitidaException();

    try {
      calcularDespesaTotal();                               // RESPOSTA QUESTÃO 04
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }
  
  }

  public List<ProcedimentoMedico> getProcedimentos() {
    return procedimentos;
  }

  public void addProcedimento(ProcedimentoMedico procedimento) throws ProcedimentoNaoPermitidoException{

    if(paciente.getPlanoSaude().permiteProcedimento() == true)  // RESPOSTA QUESTÃO 01
      procedimentos.add(procedimento);
    else
      throw new ProcedimentoNaoPermitidoException();

    try {
      calcularDespesaTotal();                                   // RESPOSTA QUESTÃO 04
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }
  
  }

  public List<ConsultaMedica> getConsultas() {
    return consultas;
  }

  public void addConsulta(ConsultaMedica consulta) throws ConsultaNaoPermitidaException, MedicoNaoPodeRealizarConsultaException{

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
    
    /**
     * Questão 02
     */
    
    if((getMedico() == "C") && ((getSintomas() == "Gripe" || getSintomas() == "Virose")))
      consultas.add(consulta);
    else
      throw new MedicoNaoPodeRealizarConsultaException();

    // if(getSintomas() == "Gripe" || getSintomas() == "Virose") // gripe ou virose
    // if(getMedico() == "E" && getMedico() == "E")
    // if(paciente.getSexo() == 'M')// paciente sexo masculino

    if(getMedico() == "E" && ((getSintomas() == "hipertensão" || getSintomas() == "cancer de mama")))
      consultas.add(consulta);

    if(getMedico() == "E" && ((getSintomas() == "cancer de prostata")))
      consultas.add(consulta);

    // tiposDoenca == "hipertensão";

    if(paciente.getSexo() == 'M')
      consultas.add(consulta);


      // public List<TipoDoenca> getTiposDoenca() {
      //   return tiposDoenca;
      // }

      for (TipoDoenca tipoDoenca : getTiposDoenca()) {
        if ((tipoDoenca.getDescricao() == "hipertensao") || (tipoDoenca.getDescricao() == "cancer de mama") ) {
          // System.out.println(tipoDoenca);
        }
      }

      // for (MovimentacaoBancaria movimentacaoBancaria : contaBancaria.getMovimentacaoBancaria()) {

      //   System.out.println("Valor movimentado pelo titular: " + movimentacaoBancaria.getValor()); 
      //   System.out.println("Tipo da movimentação pelo titular: " + movimentacaoBancaria.getTipo()); 
        
      // }


  }

  public List<ExameMedico> getExames() {
    return exames;
  }

  public void addExame(ExameMedico exame) throws ExameNaoPermitidoException, MedicoNaoPodeSolicitarExameException{    

    if(getMedico() == "E")
      exames.add(exame);
    else
      throw new MedicoNaoPodeSolicitarExameException(); //  RESPOSTA QUESTÃO 03

    if(paciente.getPlanoSaude().permiteExame() == true)  // RESPOSTA QUESTÃO 01
      exames.add(exame);
    else
      throw new ExameNaoPermitidoException();    

    try {
      calcularDespesaTotal();                             // RESPOSTA QUESTÃO 04
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
  
}
