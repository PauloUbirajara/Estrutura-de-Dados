package ProvaTrem;

public class No {
    private int numero;
    private String origem;
    private String destino;
    private int quantidade;
    private No proximo;

    public No(int numero, String origem, String destino, int quantidade) {
        this.numero = numero;
        this.origem = origem;
        this.destino = destino;
        this.quantidade = quantidade;
        this.proximo = null;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getProximo() {
        return proximo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
