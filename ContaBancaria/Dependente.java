
import java.util.ArrayList;
import java.util.List;

public class Dependente {

    private List<MovimentacaoBancaria> movimentacaoBancaria;
    private String nomeDependente;

    public Dependente(String nomeDependente){
        
        this.movimentacaoBancaria = new ArrayList<MovimentacaoBancaria>();

        this.nomeDependente = nomeDependente;
    }

    public void movimentarConta(double valorMovimentacao, char tipoMovimentacao){


    }

    public String getNomeDependente(){

        return this.nomeDependente;
    }
}
