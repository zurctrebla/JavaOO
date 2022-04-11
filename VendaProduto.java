public class VendaProduto {

    private double valor;
    private double desconto;

    public VendaProduto(double valor, double desconto){

        this.valor = valor;
        this.desconto = desconto;

    }

    public double calcularValorTotal(){

        return this.valor - (this.valor * this.desconto);
    }

    public static void main(String[] args) {

        VendaProduto venda = new VendaProduto(40, 0.05);
        double valorTotal = venda.calcularValorTotal();

        System.out.println("O valor do produto final é:" + valorTotal);
    }

}