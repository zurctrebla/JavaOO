
class MedicoClinicoGeral {

  private String CRM;

  private String nome;

  public MedicoClinicoGeral(String CRM, String nome){

    this.CRM = CRM;
    this.nome = nome;
  }

  public String getCRM() {
    return CRM;
  }

  public String getNome() {
    return nome;
  }
}
