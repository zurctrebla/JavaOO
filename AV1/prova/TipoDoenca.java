
class TipoDoenca {

  private String descricao;

  public TipoDoenca(String descricao){

    this.descricao = descricao;
  }

  public String getDescricao() {
    
    return Util.semAcento(descricao).toLowerCase();
  }
}
