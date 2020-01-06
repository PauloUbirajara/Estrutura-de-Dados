public class Stack {
    private Pilha topo;
    private Pilha fundo;

    public Stack() {
        this.topo = null;
        this.fundo = null;
    }

    public void adicionar(int valor) {
        Pilha n = new Pilha();
        if (topo == null) {
            n.adicionar(valor);
            fundo = n;
            topo = n;
        } else {
            if(topo.getTamanho() > 5) {
                n.setProximo(topo);
                fundo.setAnterior(n);
                topo = n;
            } else {
                topo.adicionar(valor);
            }
        }
    }

    public void remover() {
        if(topo == null) {
            System.out.println("Stack de pilhas vazio!");
        } else {
            if(topo.getTamanho() > 0) {
                topo.remover();
            } else {
                topo = topo.getProximo();
            }
        }
    }

    public void imprimir() {
        if(topo == null) {
            System.out.println("Stack de pilhas vazio!");
        } else {
            Pilha aux = topo;
            int contador = 1;
            while(aux != null) {
                System.out.println("----------- Pilha " + contador + " ----------");
                aux.imprimir();
                System.out.println("--------- Fim Pilha " + contador + " --------");
                aux = aux.getProximo();
                contador++;
            }
        }
    }
}
