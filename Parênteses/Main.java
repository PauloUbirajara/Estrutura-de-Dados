package Expressao;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String expressao = JOptionPane.showInputDialog(null, "Digite a expressão (sem espaços): ", "Verificação da expressão", JOptionPane.INFORMATION_MESSAGE);
        System.out.println(expressao);
        Pilha p = new Pilha();

        p.verificaParentese(expressao);
        p.verificaNumeroSinal(expressao);
    }
}
