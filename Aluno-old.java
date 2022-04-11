public class Aluno {

    private int matricula;
    private String nome;
    private double notaAV1, notaAV2;

    public Aluno (int matricula, String nome, float notaAV1, double notaAV2) {

        this.matricula  = matricula;
        this.nome       = nome;
        this.notaAV1    = notaAV1;
        this.notaAV2    = notaAV2;
    }

    public static void main(String[] args) {

        Aluno Aluno1 = new Aluno(123456, "Albert", 9, 8);
        Aluno Aluno2 = new Aluno(102030, "Eduardo", 10, 8);
        Aluno Aluno3 = new Aluno(555222, "Giiulia", 10, 8);
        Aluno Aluno4 = new Aluno(448875, "Cintia", 9, 9);
        Aluno Aluno5 = new Aluno(999999, "Arlisson", 10, 9);

        System.out.println("O Aluno " + Aluno1.nome + " matricula " + Aluno1.matricula + " nota 01 " + Aluno1.notaAV1 + " nota 02 " + Aluno1.notaAV2);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println("O Aluno " + Aluno2.nome + " matricula " + Aluno2.matricula + " nota 01 " + Aluno2.notaAV1 + " nota 02 " + Aluno2.notaAV2);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println("O Aluno " + Aluno3.nome + " matricula " + Aluno3.matricula + " nota 01 " + Aluno3.notaAV1 + " nota 02 " + Aluno3.notaAV2);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println("O Aluno " + Aluno4.nome + " matricula " + Aluno4.matricula + " nota 01 " + Aluno4.notaAV1 + " nota 02 " + Aluno4.notaAV2);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println("O Aluno " + Aluno5.nome + " matricula " + Aluno5.matricula + " nota 01 " + Aluno5.notaAV1 + " nota 02 " + Aluno5.notaAV2);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");

        Aluno1 = null;
        Aluno2 = null;
        Aluno3 = null;
        Aluno4 = null;
        Aluno5 = null;

        System.gc();

    }

    public void finalize() {

        System.out.println("O método destroy foi chamado pelo garbage collector do java para o objeto com nome: " + this.nome);

        System.out.println("-----------------------------------------------------------------------------------------------");

    }


}
