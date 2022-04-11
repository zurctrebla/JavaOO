public class Classe {

    private int numero;
    private String nome;

    public Classe(int numero, String nome) {
        
        this.numero = numero;
        this.nome = nome;
    }

    public static void main(String[] args) {

        Classe novoObjeto1 = new Classe(1, "João");
        Classe novoObjeto2 = new Classe(2, "Maria");
        Classe novoObjeto3 = new Classe(3, "Joana");

        System.out.println("O número é: " + novoObjeto1.numero);
        System.out.println("O nome é: " + novoObjeto1.nome);
        System.out.println("------------------------------------");

        System.out.println("O número é: " + novoObjeto2.numero);
        System.out.println("O nome é: " + novoObjeto2.nome);
        System.out.println("------------------------------------");

        System.out.println("O número é: " + novoObjeto3.numero);
        System.out.println("O nome é: " + novoObjeto3.nome);
        System.out.println("------------------------------------");

        novoObjeto1 = null;
        novoObjeto2 = null;
        novoObjeto3 = null;

        System.gc();
    }

    public void finalize(){

        System.out.println("O método destroy foi chamado pelo garbage collector do java para o objeto com nome: " + this.nome);

        System.out.println("------------------------------------");
    }
}