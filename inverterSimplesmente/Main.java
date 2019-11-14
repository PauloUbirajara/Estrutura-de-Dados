package inverterSimplesmente;

public class Main {
    public static void main(String[] args) {
        Lista l = new Lista();

        l.adicionar(1);
        l.adicionar(2);
        l.adicionar(3);
        l.adicionar(4);
        l.adicionar(5);
        l.imprimir();
        l.inverter(l);
        l.imprimir();
        l.inverter(l);
        l.imprimir();
        l.remover();
        l.imprimir();
        l.inverter(l);
        l.imprimir();


    }
}
