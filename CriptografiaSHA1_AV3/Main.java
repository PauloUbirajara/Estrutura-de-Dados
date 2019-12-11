package CriptografiaSHA1_AV3;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ControleArquivo ca = new ControleArquivo();

        while (true) {
            try {
                int opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Deseja realizar alguma operação? " +
                                "\n1) Gerar hash de um arquivo" +
                                "\n2) Inserir 2 arquivos e comparar autenticidade" +
                                "\n3) Sair", "Trabalho AV3 - SHA1", JOptionPane.QUESTION_MESSAGE));

                if (opcao == 1) {
                    ArvoreAvl a = new ArvoreAvl();
                    ca.gravaArvore(a);

                } else if (opcao == 2) {
                    ArvoreAvl a1 = new ArvoreAvl();
                    ArvoreAvl a2 = new ArvoreAvl();

                    ca.compararArquivos(a1, a2);
                } else if (opcao == 123) {
                    ArvoreAvl a = new ArvoreAvl();
                    String valor = JOptionPane.showInputDialog(null, "Insira o hash para comparar com um arquivo:");
                    if (valor.length() > 0) {
                        ca.verificaArquivoHash(valor, a);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Finalizando programa...", "Sair", JOptionPane.WARNING_MESSAGE);
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Finalizando programa...", "Sair", JOptionPane.WARNING_MESSAGE);
                break;
            }
        }
    }
}
