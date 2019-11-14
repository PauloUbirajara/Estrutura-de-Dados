package Criptografia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Lista l = new Lista();
        boolean ativo = true;
        while(ativo) {
            System.out.println("Selecione uma operação: " +
                    "\n- 1) Criptografar uma frase" +
                    "\n- 2) Descriptografar uma frase" +
                    "\n- 3) Finalizar o programa");
            int resposta = s.nextInt();
            if(resposta == 1) {
                System.out.println("Criptografando...\n- Digite uma frase: "); String frase = s.next();
                System.out.println("Frase recebida!\n- Digite a chave para criptografar a frase: "); int chave = s.nextInt();
                System.out.println("----------------------------------");
                for(int i = 0; i < frase.length(); i++) {
                    l.converter(frase.charAt(i), chave);
                }
                System.out.println("----------------------------------");
            }
        }
    }
}
