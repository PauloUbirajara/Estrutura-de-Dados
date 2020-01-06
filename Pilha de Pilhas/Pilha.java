public class Pilha {
    private No topo;
    private No fundo;
    private Pilha proximo;
    private Pilha anterior;
    private int tamanho;

    public Pilha() {
        this.topo = null;
        this.fundo = null;
        this.proximo = null;
        this.anterior = null;
        this.tamanho = 0;
    }

    public void adicionar(int valor) {
        No n = new No(valor);
        if (topo == null) {
            fundo = n;
            topo = n;
        } else {
            n.setProximo(topo);
            topo.setAnterior(n);
            topo = n;
        }
        tamanho++;
    }

    public void remover() {
        if (topo == null) {
            System.out.println("Pilha vazia!");
        } else {
            topo = topo.getProximo();
            tamanho--;
        }
    }

    public void imprimir() {
        if(topo != null) {
            No aux = topo;
            System.out.println("----- Pilha -----");
            while(aux != null) {
                System.out.println("Valor: " + aux.getValor());
                aux = aux.getProximo();
            }
            System.out.println("--- Fim Pilha ---");
        } else {
            System.out.println("Pilha vazia!");
        }
    }

    public void setProximo(Pilha proximo) {
        this.proximo = proximo;
    }

    public Pilha getProximo() {
        return proximo;
    }

    public void setAnterior(Pilha anterior) {
        this.anterior = anterior;
    }

    public Pilha getAnterior() {
        return anterior;
    }

    public int getTamanho() {
        return tamanho;
    }
}
