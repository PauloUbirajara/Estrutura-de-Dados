public class No {
    private int valor;
    private No proximo;
    private No anterior;

    public No(int valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }

    public int getValor() {
        return valor;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
}
