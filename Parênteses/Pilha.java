package Expressao;

public class Pilha {
    private No topo;
    private No fundo;
    private int tamanho;
    private int quantNumeros;
    private int numeroMais;
    private int numeroMenos;

    public Pilha() {
        this.topo = null;
        this.fundo = null;
        this.tamanho = 0;
        this.numeroMais = 0;
        this.numeroMenos = 0;
    }

    public void adicionar(char caractere) {
        No n = new No(caractere);
        if(topo == null) {
            topo = n;
            fundo = n;
        } else {
            topo.setProximo(n);
            topo = n;
        }
        tamanho++;
    }

    public void remover() {
        if(tamanho == 0) {
            System.out.println("Pilha vazia!");
        } else {
            No aux = fundo;
            No anterior = null;

            while(aux != topo) {
                anterior = aux;
                aux = aux.getProximo();
            }
            topo = anterior;
            if(topo == null) {
                tamanho = 0;
            } else {
                topo.setProximo(null);
                tamanho--;
            }
        }
    }

    public void verificaParentese(String expressao) {
        for(int i = 0; i < expressao.length(); i++) {
            if(expressao.charAt(i) == '(') {
                adicionar('(');
            } else if(expressao.charAt(i) == ')'){
                if(tamanho == 0) {
                    break;
                } else {
                    remover();
                }
            }
        }
        if(tamanho == 0) {
            System.out.println("Expressão válida por parêntese!");
        } else {
            System.out.println("Expressão inválida por parêntese!");
        }
    }

    public void verificaNumeroSinal(String expressao) {
        char numeros[] = {'0','1','2','3','4','5','6','7','8','9'};
        for(int j = 0; j < expressao.length(); j++) {
            for(int i = 0; i < numeros.length; i++) {
                if(expressao.charAt(j) == numeros[i]) {
                    quantNumeros++;
                }
            }
            if(expressao.charAt(j) == '+') {
                numeroMais++;
            } else if(expressao.charAt(j) == '-') {
                numeroMenos++;
            }
        }

////        if(expressao.charAt(expressao.length()-1) == '+' || expressao.charAt(expressao.length()-1) == '-') {
////            System.out.println("Expressão inválida por sinal!"); // ultimo sem parentese
////        } else
//            if(quantNumeros >= numeroMenos + numeroMais) {
//            System.out.println("Expressão válida por sinal!");
//        } else if(numeroMais > quantNumeros - tamanho + 1) {
//            System.out.println("Expressão inválida por sinal!"); // ultimo sem parentese
//        } else {
//            System.out.println("Expressão inválida por sinal!");
//        }
        if(quantNumeros >= numeroMenos + numeroMais && numeroMais < quantNumeros - tamanho) {
            System.out.println("Expressão válida por sinal!");
        } else {
            System.out.println("Expressão inválida por sinal!");
        }

    }
}
