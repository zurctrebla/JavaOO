public class Teste {

    public static void main(String[] args){

        ContaBancaria contaBancaria = new ContaBancaria("Fabio");

        Dependente dependente1 = null;
        Dependente dependente2 = null;
        Dependente dependente3 = null;
        // Dependente dependente4 = null;

        try {

            dependente1 = contaBancaria.adicionarDependente("João");
            dependente2 = contaBancaria.adicionarDependente("Maria");
            dependente3 = contaBancaria.adicionarDependente("Ana");
            // dependente4 = contaBancaria.adicionarDependente("Carlos");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }        

        contaBancaria.movimentarConta(200, 'C');
        contaBancaria.movimentarConta(300, 'C');
        contaBancaria.movimentarConta(100, 'C');
        contaBancaria.movimentarConta(50, 'C');

        try {

            dependente1.movimentarConta(200, 'D');
            dependente1.movimentarConta(100, 'D');
            dependente1.movimentarConta(300, 'D');

            dependente2.movimentarConta(30, 'D');
            dependente2.movimentarConta(10, 'D');
            dependente2.movimentarConta(20, 'D');

            dependente3.movimentarConta(500, 'D');
            dependente3.movimentarConta(400, 'D');
            dependente3.movimentarConta(600, 'D');
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }       
        
        System.out.println("Nome do titular da conta: " + contaBancaria.getNomeTitular()); 

        for (MovimentacaoBancaria movimentacaoBancaria : contaBancaria.getMovimentacaoBancaria()) {

            System.out.println("Valor movimentado pelo titular: " + movimentacaoBancaria.getValor()); 
            System.out.println("Tipo da movimentação pelo titular: " + movimentacaoBancaria.getTipo()); 
            
        }

        for (Dependente dependente : contaBancaria.getDependentes()) {

            System.out.println("Nome do dependente da conta: " + dependente.getNomeDependente()); 

            for (MovimentacaoBancaria movimentacaoBancaria : dependente.getMovimentacaoBancaria()) {

                System.out.println("Valor movimentado pelo dependente: " + movimentacaoBancaria.getValor()); 
                System.out.println("Tipo da movimentação pelo dependente: " + movimentacaoBancaria.getTipo()); 

            }
            
        }
        
    }
    
}
