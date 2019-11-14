package PilhaComFila;

public class Pilha {
    private Fila f1;
    private Fila f2;

    public Pilha() {
        f1 = new Fila();
        f2 = new Fila();
    }

    public void adicionar(int valor) {

        f1.adicionar(valor); // f1 serve como auxiliar, entao irá adicionar o novo valor e irá receber depois todos os valores da fila principal(f2)

        while(f2.getPrimeiro() != null) {
            f1.adicionar(f2.getPrimeiro().getValor());
            f2.remover();
        }

        // após receber os valores, ainda permanecerá em formato fila, então foi passado do auxiliar pra principal

        while (f1.getPrimeiro() != null) {
            f2.adicionar(f1.getPrimeiro().getValor());
            f1.remover();
        }
    }

    public void remover() {
        f2.remover();
    }

    public void imprimir() {

        No aux = f2.getPrimeiro();
        System.out.println("=========");
        while(aux != null ) {

            System.out.println("|   " + aux.getValor() + "   |");

            aux = aux.getProximo();
        }
        System.out.println("=========");
    }
}
