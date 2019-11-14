package ProvaTrem;

public class Pilha {
    private No topo;
    private No fundo;
    private int tamanho;

    public Pilha() {
        this.topo = null;
        this.fundo = null;
        this.tamanho = 0;
    }

    public void adicionar(int numero, String origem, String destino, int quantidade) {
        No n = new No(numero, origem, destino, quantidade);
        if(topo == null) {
            topo = n;
            fundo = n;
        } else {
            topo.setProximo(n);
            topo = n;
        }
        tamanho++;
    }

    public No remover() {
        No removido = null;
        if(topo == null) {
            System.out.println("Pilha vazia!");
        } else {
            No aux = fundo;

            if(aux.getProximo() == null) {
                removido = topo;
                topo = aux;
                topo.setProximo(null);
                tamanho--;
            } else {
                while (aux.getProximo() != topo) {
                    aux = aux.getProximo();
                }
                removido = topo;
                topo = aux;
                topo.setProximo(null);
                tamanho--;
            }
        }
        return removido;
    }

    public int getTamanho() {
        return tamanho;
    }

    public No getTopo() {
        return topo;
    }
}
