package PilhaComFila;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Pilha p = new Pilha();
        Scanner s = new Scanner(System.in);
        boolean ativo = true;
        while(ativo) {
            System.out.println("Selecione uma operação: \n- 1) Adicionar um número\n- 2) Remover um número\n- 3) Imprimir a pilha\n- 4) Finalizar programa");
            int resposta = s.nextInt();

            if(resposta == 1) {
                System.out.println("Digite um número para adicionar à pilha: "); int numero = s.nextInt();
                p.adicionar(numero);
            } else if(resposta == 2) {
                p.remover();
            } else if(resposta == 3) {
                p.imprimir();
            } else if(resposta == 4) {
                System.out.println("Finalizando programa...");
                break;
            } else {
                System.out.println("Operação inválida!");
            }
            System.out.println("\n");
        }
    }
}
