package Criptografia.Teste;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Lista l = new Lista();
        Scanner s = new Scanner(System.in);

            System.out.println("Digite uma frase: ");
            String frase = s.nextLine();

            System.out.println("Frase recebida!\nDigite uma chave: ");
            int chave = s.nextInt();

            System.out.println("Chave recebida!\n- Deseja criptografar ou descriptografar?\n- C) Criptografar\n- D) Descriptografar");
            char resposta = s.next().charAt(0);

            if (resposta == 'c' || resposta == 'C') {

                for (int i = 0; i < frase.length(); i++) {

                    l.converter(frase.charAt(i), chave);

                }


                l.imprimirCript();

            } else {

                for (int i = 0; i < frase.length(); i++) {

                    l.desconverter(frase.charAt(i), chave);

                }

                System.out.println("=======================");
                l.imprimirDescript();

            }
        }
    }
