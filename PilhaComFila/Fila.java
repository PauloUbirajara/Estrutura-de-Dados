package PilhaComFila;

public class Fila {
    private No primeiro;
    private No ultimo;
    private int tamanho;

    public Fila() {
        this.tamanho = 0;
        this.primeiro = null;
        this.ultimo = null;
    }

    public void adicionar(int valor) {
        No n = new No(valor);

        if(primeiro == null) {
            primeiro = n;
            ultimo = n;
        } else {
            ultimo.setProximo(n);
            ultimo = n;
        }
        tamanho++;
    }

    public void remover() {
        if(primeiro == null) {
            System.out.println("Pilha vazia!");
        } else {
            primeiro = primeiro.getProximo();
        }
        tamanho--;
    }

    public No getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(No primeiro) {
        this.primeiro = primeiro;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getTamanho() {
        return tamanho;
    }
}
