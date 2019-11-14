package PilhaComFila;

public class No {
    private int valor;
    private No proximo;

    public No(int valor) {
        this.valor = valor;
        this.proximo = null;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public No getProximo() {
        return proximo;
    }

    public int getValor() {
        return valor;
    }
}
