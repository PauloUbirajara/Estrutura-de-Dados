package Criptografia;

public class Lista {
    private No inicio;
    private No fim;

    public Lista() {
        this.inicio = null;
        this.fim = null;
    }

    public void adicionar(char letraDesconvertida, char letraConvertida) {
        No n = new No(letraDesconvertida, letraConvertida);
        if(inicio == null) {
            inicio = n;
            fim = n;
        } else {
            fim.setProximo(n);
            n.setAnterior(fim);
            fim = n;
        }
    }

    public void converter(char letraDesconvertida, int chave) {

        int pos = 0;
        char letraConvertida = ' ';

    if(letraDesconvertida != ' ') {

        if (Character.isUpperCase(letraDesconvertida)) { // Caso a letra for maiúscula, irá transformar o alfabeto em maiúsculo

            String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            pos = achaLetraAlfabeto(letraDesconvertida, alfabeto);
            pos += chave;

            letraConvertida = alfabeto.charAt(pos);

        } else if (Character.isLowerCase(letraDesconvertida)) { // Caso a letra for minúscula, vai manter o alfabeto no minúsculo

            String alfabeto = "abcdefghijklmnopqrstuvwxyz";
            pos = achaLetraAlfabeto(letraDesconvertida, alfabeto);
            pos += chave;

            letraConvertida = alfabeto.charAt(pos);
        }
    } else {         // Caso a letra for um espaço, irá mostrar um espaço;

            letraDesconvertida = ' ';
            letraConvertida = ' ';

        }

        if(pos > 25) {
            pos = pos % 25; // Como ele vai ler o caractere na posicao de uma frase, ele lê como um vetor e o vetor começa do 0, caso quisesse usar sem adicionar o +1, bastava deixar o pos inicial como -1
        }

        System.out.println("Letra desconvertida: " + letraDesconvertida + " |  Letra convertida: " + letraConvertida);
        adicionar(letraDesconvertida, letraConvertida);
    }

    public int achaLetraAlfabeto(char letra, String alfabeto) {
        int pos = 0;
        for (int i = 0; i < alfabeto.length(); i++) {
            if (letra == alfabeto.charAt(i)) {
                pos = i;
            }
        }
        return pos;
    }
}
