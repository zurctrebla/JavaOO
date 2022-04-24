
class Paciente {

  private String nome;

  private String tipoSanguineo;

  private int idade;

  private char sexo;

  private ProntuarioMedico prontuario;

  private PlanoSaude planoSaude;
  
  public Paciente(String nome,
                  String tipoSanguineo,
                  int idade,
                  char sexo,
                  PlanoSaude planoSaude){

    this.nome = nome;
    this.tipoSanguineo = tipoSanguineo;
    this.idade = idade;
    this.sexo = sexo;
    this.planoSaude = planoSaude;

    this.prontuario = new ProntuarioMedico(this);
  }

  public String getNome() {
    return nome;
  }

  public String getTipoSanguineo() {
    return tipoSanguineo;
  }

  public int getIdade() {
    return idade;
  }

  public char getSexo() {
    
    return Character.toLowerCase(sexo);
  }

  public PlanoSaude getPlanoSaude() {
    return planoSaude;
  }

  public ProntuarioMedico getProntuario() {
    return prontuario;
  }

}
