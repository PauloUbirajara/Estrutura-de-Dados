package desafioHashing;

public class Hashing {
    private Fila[] vetorHash;

    public Hashing(int tamanho) {
        this.vetorHash = new Fila[tamanho];
    }

    public void adicionarValor(int valor) {
        int pos = valor % vetorHash.length;

        if(vetorHash[pos] == null) {
            vetorHash[pos] = new Fila();
        }

        vetorHash[pos].adicionar(valor);
    }

    public String toString() {
        String resposta = "";
        for(int i = 0; i < vetorHash.length; i++) {
            if(vetorHash[i] == null) {
                resposta = resposta.concat(i + " -> ");
            } else {
                resposta = resposta.concat(i + " -> " + vetorHash[i].toString());
            }
            resposta = resposta.concat("/\n");
        }
        return resposta;
    }
}
