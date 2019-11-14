package Criptografia.Teste;

public class Lista {
    private No inicio;
    private No fim;

    public Lista() {
        this.inicio = null;
        this.fim = null;
    }

    public void adicionar(char letraDescript, char letraCript) {
        No n = new No(letraDescript, letraCript);
        if(inicio == null) {
            inicio = n;
            fim = n;
        } else {
            fim.setProx(n);
            n.setAnt(fim);
            fim = n;
        }
    }

    public void converter(char letraDescript, int chave) {
        char letraCript = ' ';
        int pos = 0;
        if(letraDescript != '\f') {

            if(Character.isLowerCase(letraDescript)) {

                char alfabeto[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
                while(letraDescript != alfabeto[pos]) {
                    pos++;
                }
                pos += chave;
                if(pos > 25) {
                    pos = pos % 25;
                }
                 letraCript = alfabeto[pos];

            } else if(Character.isUpperCase(letraDescript)) {

                char alfabeto[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
                while(letraDescript != alfabeto[pos]) {
                    pos++;
                }
                pos += chave;
                if(pos > 25) {
                    pos = pos % 25;
                }
                letraCript = alfabeto[pos];

            } else {

            }
            adicionar(letraDescript, letraCript);
        }
    }

    public void desconverter(char letraCript, int chave) {
        char letraDescript = ' ';
        int pos = 0;
        if(letraCript != '\f') {

            if(Character.isLowerCase(letraCript)) {

                char alfabeto[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
                while(letraCript != alfabeto[pos]) {
                    pos++;
                }
                pos -= chave;
                if(pos < 0) {
                    pos = 26 + pos % 25;
                }
                letraDescript = alfabeto[pos];

            } else if(Character.isUpperCase(letraCript)) {

                char alfabeto[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
                while(letraCript != alfabeto[pos]) {
                    pos++;
                }
                pos -= chave;
                if(pos < 0) {
                    pos = 26 + pos % 25;
                }
                letraDescript = alfabeto[pos];

            } else {

            }
            adicionar(letraCript, letraDescript);
        }
    }

    public void limpaLista() {
        inicio = null;
    }

    public void imprimirCript() {
        System.out.println("====================================================");
        No aux = inicio;
        while(aux != null) {
            System.out.println("Letra Descriptografada: " + aux.getLetraDescript() + " |  Letra criptografada: " + aux.getLetraCript());
            aux = aux.getProx();
        }
        System.out.println("====================================================");
        limpaLista();
    }

    public void imprimirDescript() {
        System.out.println("====================================================");
        No aux = inicio;
        while(aux != null) {
            System.out.println("Letra Criptografada: " + aux.getLetraCript() + " |  Letra Descriptografada: " + aux.getLetraDescript());
            aux = aux.getProx();
        }
        System.out.println("====================================================");
        limpaLista();
    }

//    public static void main(String[] args) {
//        //Teste
//        Lista l = new Lista();
//        l.converter(' ', 3);
//    }
}
