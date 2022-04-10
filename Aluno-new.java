import java.util.ArrayList;
import java.util.List;

public class Aluno {

    private int matricula, numero;
    private String nome;
    private double notaAV1, notaAV2;

    public Aluno (int matricula, int numero, String nome, double notaAV1, double notaAV2) {
        this.matricula  = matricula;
        this.numero     = numero;
        this.nome       = nome;
        this.notaAV1    = notaAV1;
        this.notaAV2    = notaAV2;
    }
    public static void main(String[] args) {
        List<Aluno> listaAluno = new ArrayList<Aluno>();
        
        listaAluno.add(new Aluno(12345, 1, "João", 9, 6));
        listaAluno.add(new Aluno(12346, 2, "Maria", 8, 9));
        listaAluno.add(new Aluno(12347, 3, "Gabriel", 6, 5));
        listaAluno.add(new Aluno(12348, 4, "Lucas", 4, 7));
        listaAluno.add(new Aluno(12349, 5, "Pedro", 8, 9));
        for (int i = 0; i < 5; i++) {
            System.out.println("A matrícula é: " + ((Aluno) listaAluno.get(i)).matricula);
            System.out.println("O nome é: " +((Aluno) listaAluno.get(i)).nome);
            if ( ( ((((Aluno) listaAluno.get(i)).notaAV1 + ((Aluno) listaAluno.get(i)).notaAV2)/2) ) >= 7 ) {
                System.out.println("Aprovado");
            }else{
                System.out.println("Reprovado");
            }
            System.out.println("---------------------------------------------------");
            
        }
        // Aluno1 = null;
        // Aluno2 = null;
        // Aluno3 = null;
        // Aluno4 = null;
        // Aluno5 = null;
        // System.gc();
    }
    // public void finalize() {
    //     System.out.println("O método destroy foi chamado pelo garbage collector do java para o objeto com nome: " + this.nome);
    //     System.out.println("-----------------------------------------------------------------------------------------------");
    // }
}