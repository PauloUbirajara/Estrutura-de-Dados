public class Lista {
    private No primeiro;
    private No ultimo;
    private int tamanho;

    public Lista() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public void adicionar(String nome) {
        if(tamanho == 26) {
            System.out.println("Lista cheia!");
        } else {

            No n = new No(nome);

            if (primeiro == null) {
                primeiro = n;
                ultimo = n;
            } else {
                ultimo.setProximo(n);
                ultimo = n;
            }
            tamanho++;
        }
    }

    public void remover() {
        if (primeiro == null) {
            System.out.println("Lista vazia!");
        } else {
            No aux = primeiro;
            while (aux.getProximo() != ultimo) {
                aux = aux.getProximo();
            }
            ultimo = aux;
            ultimo.setProximo(null);
            tamanho--;
        }
    }

    public void imprimir() {
        No aux = primeiro;
        System.out.println("Tamanho: " + tamanho);
        while(aux != null) {
            System.out.println("Nome: " + aux.getNome() + "\n- Chave: " + aux.getChave());
            aux = aux.getProximo();
        }
    }

    public int getTamanho() {
        return tamanho;
    }
}
