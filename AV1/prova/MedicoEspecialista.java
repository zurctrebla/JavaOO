
class MedicoEspecialista {

  private String CRM;

  private String nome;

  private String especialidade;

  public MedicoEspecialista(String CRM, String nome, String especialidade){

    this.CRM = CRM;
    this.nome = nome;
    this.especialidade = especialidade;
  }

  public String getCRM() {
    return CRM;
  }

  public String getNome() {
    return nome;
  }

  public String getEspecialidade() {

    return Util.semAcento(especialidade).toLowerCase();
  }
}
