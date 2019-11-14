package CifraCompleto;
public class Fila {
    private No primeiro;
    private No ultimo;

    public Fila() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public void adicionar(String fragmento, String chave) {
        No n = new No(fragmento, chave);

        if(primeiro == null) {
            primeiro = n;
            ultimo = n;
        } else {
            ultimo.setProximo(n);
            ultimo = n;
        }
    }

    public No remover() {
        if(primeiro == null) {
            System.out.println("Fila vazia!");
            return null;
        } else {
            No removido = primeiro;
            primeiro = primeiro.getProximo();
            return removido;
        }
    }

    public String imprimir() {
        No aux = primeiro;
        String frase = "---Frase---|---Chave---\n";
        while(aux != null) {
            frase += (aux.getFragmento() + " | " + aux.getChave());
            aux = aux.getProximo();
        }
        return frase;
    }

    public No peek() {
        return primeiro;
    }

    public int size() {
        No aux = primeiro;
        int contador = 0;
        while(aux != null) {
            aux = aux.getProximo();
            contador++;
        }
        return contador;
    }
}
