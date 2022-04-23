
import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {

    private String nomeTitular;
    private List<MovimentacaoBancaria> movimentacaoBancaria;
    private List<Dependente> dependentes;

    public ContaBancaria(String nomeTitular){

        this.movimentacaoBancaria = new ArrayList<MovimentacaoBancaria>();
        this.dependentes = new ArrayList<Dependente>();

        this.nomeTitular = nomeTitular;

    }

    public Dependente adicionarDependente(String nomeDependente) throws LimiteDependentesException{ 

        Dependente dependente = new Dependente(nomeDependente);
        
        if(dependentes.size() < 3)
            dependentes.add(dependente);
        else
            throw new LimiteDependentesException();
            
        return dependente;

    }

    public void movimentarConta(double valorMovimentacao, char tipoMovimentacao){

        movimentacaoBancaria.add(new MovimentacaoBancaria(valorMovimentacao, tipoMovimentacao));

    }

    public String getNomeTitular(){

        return this.nomeTitular;
    }

    public List<MovimentacaoBancaria> getMovimentacaoBancaria(){

        return this.movimentacaoBancaria;
    }

    public List<Dependente> getDependentes(){

        return this.dependentes;
    } 

}