package desafioHashing;

public class Fila {
    private No primeiro;
    private No ultimo;

    public Fila() {
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
    }

    public void remover() {
        if(primeiro == null) {
            System.out.println("Fila vazia!");
        } else {
            primeiro = primeiro.getProximo();
        }
    }

    public String toString() {
        if(primeiro == null) {
            return "/";
        } else {
            No aux = primeiro;
            String resposta = "";
            while(aux != null) {
                resposta = resposta.concat(aux.getValor() + " -> ");
                aux = aux.getProximo();
            }
            return resposta;
        }
    }
}
