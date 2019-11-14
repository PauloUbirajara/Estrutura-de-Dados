package inverterSimplesmente;

public class Lista {
    private No primeiro;
    private No fim;
    private int tamanho;

    public Lista() {
        this.primeiro = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void adicionar(int valor) {
        No n = new No(valor);

        if(primeiro == null) {
            primeiro = n;
            fim = n;
        } else {
            fim.setProximo(n);
            fim = n;
        }
        tamanho++;
    }

    public void remover() {
        if(primeiro == null) {
            System.out.println("Lista vazia!");
        } else {
            No aux = primeiro;
            while(aux.getProximo() != null) {
                aux = aux.getProximo();
            }
            fim = aux;
            tamanho--;
        }
    }


    public void imprimir() {
        No aux = primeiro;
        System.out.println("Primeiro\n=========");
        while(aux != null) {
            System.out.println("|   " + aux.getValor() + "   |");
            aux = aux.getProximo();
        }
        System.out.println("=========\nÚltimo");
    }

    public void inverter(Lista l) {

        Lista listaAux = new Lista();

        for(int i = tamanho; i > 0; i--) {
            No aux = primeiro;
            int contador = 1;
            while(aux != null && contador != i) {
                aux = aux.getProximo();
                contador++;
            }

            if (aux != null) {
                listaAux.adicionar(aux.getValor());
                l.remover();
            }
        }
        this.primeiro = listaAux.primeiro;
        this.fim = listaAux.fim;
        this.tamanho = listaAux.tamanho;
    }

}


