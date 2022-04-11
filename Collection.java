import java.util.ArrayList;
import java.util.List;

public class Collection {
    private int numero;
    private String nome;

    public Collection(int numero, String nome) {
        this.numero = numero;
        this.nome   = nome;
    }

    public static void main(String[] args) {
        List<Collection> listaObjetos = new ArrayList<Collection>();

        listaObjetos.add(new Collection(1, "João"));
        listaObjetos.add(new Collection(2, "Maria"));
        listaObjetos.add(new Collection(3, "Joana"));

        for (int i=0;i < 3; i++) {

            System.out.println("O número é: " + ((Collection) listaObjetos.get(i)).numero);
            System.out.println("O nome é: " +((Collection) listaObjetos.get(i)).nome);
            System.out.println("---------------------------------------------------");
        }
    }
}

