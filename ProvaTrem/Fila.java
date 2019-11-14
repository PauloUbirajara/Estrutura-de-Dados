package ProvaTrem;

public class Fila {
    private No primeiro;
    private No ultimo;
    private int tamanho;

    public Fila() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void adicionar(int numero, String origem, String destino, int quantidade) {
        No n = new No(numero, origem, destino, quantidade);

        if(primeiro == null || tamanho <= 0) {
            primeiro = n;
            ultimo = n;
        } else {
            ultimo.setProximo(n);
            ultimo = n;
        }
        tamanho++;
    }

    public void adicionar(No n) {

        if(primeiro == null || tamanho <= 0) {
            primeiro = n;
            ultimo = n;
        } else {
            ultimo.setProximo(n);
            ultimo = n;
        }
        tamanho++;
    }


    public No remover() {
        if(primeiro == null) {
            System.out.println("Fila de trens vazia!");
            return null;
        } else {
            No removido = primeiro;
            primeiro = primeiro.getProximo();
            tamanho--;
            return removido;
        }
    }

    public void imprimir() {
        if(primeiro == null || tamanho <= 0) {
            System.out.println("Fila vazia!");
        } else {
            No aux = primeiro;
            int contador = 1;
            while (aux != null) {
                System.out.println("Trem " + contador + ": \n- Número: " + aux.getNumero() + "\n- Origem: " + aux.getOrigem() + "\n- Destino: " + aux.getDestino() + "\n- Quantidade de passageiros: " + aux.getQuantidade());
                aux = aux.getProximo();
                contador++;
            }
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    public No getPrimeiro() {
        return primeiro;
    }
}
