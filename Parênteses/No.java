package Expressao;

public class No<T> {
    private T dado;
    private No proximo;

    public No(T dado) {
        this.dado = dado;
        this.proximo = null;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getProximo() {
        return proximo;
    }

    public T getDado() {
        return dado;
    }
}
