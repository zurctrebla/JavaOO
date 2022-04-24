import java.util.ArrayList;
import java.util.List;

class ProntuarioMedico {
  
  private List<AtendimentoMedicoDiario> atendimentos;

  private DespesaMedicaMensal despesaMedica;

  private Paciente paciente;

  public ProntuarioMedico(Paciente paciente){

    this.paciente = paciente;
        
    despesaMedica = new DespesaMedicaMensal(paciente);
    atendimentos = new ArrayList<AtendimentoMedicoDiario>();
  }

  public AtendimentoMedicoDiario criarAtendimento(Object acomodacao, Object medico) {
    
    AtendimentoMedicoDiario atendimentoMedico = new AtendimentoMedicoDiario(this.paciente, acomodacao, medico);

    atendimentos.add(atendimentoMedico);

    return atendimentoMedico;
  }

  public DespesaMedicaMensal getDespesaMedica() {

    return despesaMedica;
  }

  public List<AtendimentoMedicoDiario> getAtendimentos() {

    return atendimentos;
  }
}
