package ProvaTrem;

public class Main {
    public static void main(String[] args) {
        Fila f = new Fila();

        f.adicionar(1, "casa", "trabalho", 1);
        f.adicionar(2, "casa1", "trabalho1", 2);
        f.adicionar(3, "casa2", "trabalho2", 3);
        f.adicionar(4, "casa3", "trabalho3", 4);
        f.imprimir();
        f = inverter(f);
        f.imprimir();

    }

    public static Fila inverter(Fila f) {
        Pilha p = new Pilha();
        while(f.getTamanho() > 0) {
            No aux = f.getPrimeiro();
            p.adicionar(aux.getNumero(), aux.getOrigem(), aux.getDestino(), aux.getQuantidade());
            System.out.println("Nó removido: " + f.remover().getNumero());
        }

        while(p.getTamanho() > 0) {
            No aux2 = p.getTopo();
            f.adicionar(aux2.getNumero(), aux2.getOrigem(), aux2.getDestino(), aux2.getQuantidade());
            System.out.println("Nó removido: " + p.remover().getNumero());
        }
     return f;
    }
}
