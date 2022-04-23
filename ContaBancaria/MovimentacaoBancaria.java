public class MovimentacaoBancaria {

    private double valorMovimentacao;
    private char tipoMovimentacao;

    public MovimentacaoBancaria(double valorMovimentacao, char tipoMovimentacao){

        this.valorMovimentacao = valorMovimentacao;
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public double getValor(){

        return this.valorMovimentacao;

    }

    public char getTipo(){

        return this.tipoMovimentacao;
        
    }
}
