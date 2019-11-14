package desafioHashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // Nó //
    public static class No {
        private int valor;
        private No proximo;

        public No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }

        public int getValor() {
            return valor;
        }

        public void setValor(int valor) {
            this.valor = valor;
        }

        public No getProximo() {
            return proximo;
        }

        public void setProximo(No proximo) {
            this.proximo = proximo;
        }
    }
    // Nó //

    // Fila //
    public static class Fila {
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
                return "\\";
//                return "/";
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
// Fila //

    // Controle do Hash //
    public static class Hashing {
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
//              resposta = resposta.concat("\\\n"); // Erro no site para compreender
                resposta = resposta.concat("\\\n");
            }
            return resposta;
        }
    }
// Controle do Hash //

    // Main //
    public static void main(String[] args) throws IOException {

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);

        int numeroVezes = Integer.parseInt(in.readLine());
        String respostas[] = new String[numeroVezes];
        for(int i = 0; i < numeroVezes; i++) {
            String[] segundaEntrada = in.readLine().split(" ");
            int posicoesVetor = Integer.parseInt(segundaEntrada[0]);
            int quantidadeElementos = Integer.parseInt(segundaEntrada[1]);

            String[] elementos = in.readLine().split(" ");

            Hashing hashing = new Hashing(posicoesVetor);
            for(int j = 0; j < quantidadeElementos; j++) {
                hashing.adicionarValor(Integer.parseInt(elementos[j]));
            }
            respostas[i] = hashing.toString();
        }

        if(respostas[respostas.length-1].endsWith("\n")) {
            respostas[respostas.length-1] = respostas[respostas.length-1].substring(0, respostas[respostas.length-1].length()-1);
        }

        for(String i: respostas) {
            System.out.println(i);
        }
    }
    // Main //
}

