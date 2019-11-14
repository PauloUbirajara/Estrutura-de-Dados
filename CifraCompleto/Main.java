package CifraCompleto;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        boolean ativo = true;
        while (ativo) {

            String fraseCompleta = JOptionPane.showInputDialog(null, "Digite a frase que deseja criptografar ou descriptografar: ", "Frase", JOptionPane.INFORMATION_MESSAGE);
            String chave = JOptionPane.showInputDialog(null, "Digite a chave para criptografar ou descriptografar: ", "Chave", JOptionPane.INFORMATION_MESSAGE);
            int tamanhoBloco = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o tamanho do bloco: ", "Tamanho do bloco", JOptionPane.INFORMATION_MESSAGE));

            if(fraseCompleta.isEmpty() || chave.isEmpty() || Character.isLetter(tamanhoBloco)) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir informações! Finalizando...", "Erro", JOptionPane.ERROR_MESSAGE);
                break;
            }

            Cripto c = new Cripto(fraseCompleta, chave, tamanhoBloco);

            // Imprimindo na interface //
            String opcoes[] = {
                    "Criptografar frase",
                    "Descriptografar Frase",
                    "Redefinir informações",
                    "Finalizar Programa"
            };

//            int resposta = JOptionPane.showOptionDialog(null, "Selecione uma operação: ","Criptografia por blocos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
//            if(resposta == 0) {
//                JOptionPane.showMessageDialog(null, c.Criptografar(), "Criptografar Frase", JOptionPane.INFORMATION_MESSAGE);
//            } else if(resposta == 1) {
//                JOptionPane.showMessageDialog(null, c.Descriptografar(), "Descriptografar Frase", JOptionPane.INFORMATION_MESSAGE);
//            } else if(resposta == 2) {
//                JOptionPane.showMessageDialog(null, "Redefinindo informações...", "Redefinir Informações", JOptionPane.WARNING_MESSAGE);
//            } else if(resposta == 3) {
//                JOptionPane.showMessageDialog(null, "Finalizando o programa...", "Finalizar Programa", JOptionPane.WARNING_MESSAGE);
//                break;
//            }

            // Imprimindo no "console" //
            int resposta = Integer.parseInt(JOptionPane.showInputDialog(null, "Deseja realizar qual operação:\n- 1) Criptografar Frase\n- 2) Descriptografar Frase\n- 3)Redefinir Configurações\n- 4)Finalizar programa"));
            if(resposta == 1) {
                System.out.println(c.Criptografar());
            } else if(resposta == 2) {
                System.out.println(c.Descriptografar());
            } else if(resposta == 3) {
                System.out.println("Redefinindo configurações");
            } else if(resposta == 4) {
                System.out.println("Finalizando programa...");
                break;
            }
        }
    }
}
