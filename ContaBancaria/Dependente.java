
import java.util.ArrayList;
import java.util.List;

public class Dependente {

    private List<MovimentacaoBancaria> movimentacaoBancaria;
    private String nomeDependente;

    public Dependente(String nomeDependente){
        
        this.movimentacaoBancaria = new ArrayList<MovimentacaoBancaria>();

        this.nomeDependente = nomeDependente;
    }

    public void movimentarConta(double valorMovimentacao, char tipoMovimentacao) throws TipoOperacaoException, LimiteMovimentacaoException{

        if (tipoMovimentacao != 'D')
            throw new TipoOperacaoException();

        double soma = 0;

        for (MovimentacaoBancaria movimentacaoBancaria : this.getMovimentacaoBancaria())
            soma = soma + movimentacaoBancaria.getValor();         

        if (soma > 1200)
            throw new LimiteMovimentacaoException();

        this.movimentacaoBancaria.add(new MovimentacaoBancaria(valorMovimentacao, tipoMovimentacao));
    }

    public String getNomeDependente(){

        return this.nomeDependente;
    }

    public List<MovimentacaoBancaria> getMovimentacaoBancaria(){

        return this.movimentacaoBancaria;
    }

}
