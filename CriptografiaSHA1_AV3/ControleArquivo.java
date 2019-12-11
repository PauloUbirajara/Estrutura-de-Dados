package CriptografiaSHA1_AV3;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ControleArquivo {

    public boolean gravaArvore(ArvoreAvl a) {
        try {
            JFileChooser jfc = new JFileChooser();
            int resposta = jfc.showOpenDialog(null);
            if (resposta == JFileChooser.APPROVE_OPTION) {
                File f = new File(jfc.getSelectedFile().getAbsolutePath());

                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);

                String linha = br.readLine();

                while (linha != null) {

                    if (!linha.isEmpty()) {
                        a.adicionar(linha);
                    }
                    linha = br.readLine();
                }

                a.geraHashArvore();
                a.emOrdem();

                JOptionPane.showMessageDialog(null, "Hash do pai: [" + a.getRaiz().getHash() + "]", "Gerar hash", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Hash do pai: [" + a.getRaiz().getHash() + "]");
                return true;

            } else {
                JOptionPane.showMessageDialog(null, "Erro ao ler arquivo!");
                return false;

            }
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo!");
            return false;

        }
    }

    public boolean compararArquivos(ArvoreAvl a1, ArvoreAvl a2) {
        JFileChooser jfc = new JFileChooser();
        int resposta1 = jfc.showOpenDialog(null);
        if (resposta1 == JFileChooser.APPROVE_OPTION) {
            try {
                File f1 = new File(jfc.getSelectedFile().getAbsolutePath());

                FileReader fr1 = new FileReader(f1);
                BufferedReader br1 = new BufferedReader(fr1);

                String linha1 = br1.readLine();

                while (linha1 != null) {

                    if (linha1.length() > 0) {
                        a1.adicionar(linha1);
                    }
                    linha1 = br1.readLine();
                }

                a1.geraHashArvore();
                a1.emOrdem();

                JOptionPane.showMessageDialog(null, "Hash do pai 1: [" + a1.getRaiz().getHash() + "]", "Gerar hash", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Hash do pai 1: [" + a1.getRaiz().getHash() + "]");

                if (f1.exists()) {
                    int resposta2 = jfc.showOpenDialog(null);
                    if (resposta2 == JFileChooser.APPROVE_OPTION) {

                        File f2 = new File(jfc.getSelectedFile().getAbsolutePath());

                        FileReader fr2 = new FileReader(f2);
                        BufferedReader br2 = new BufferedReader(fr2);

                        String linha2 = br2.readLine();
                        while (linha2 != null) {
                            if (linha2.length() > 0) {
                                a2.adicionar(linha2);
                            }
                            linha2 = br2.readLine();
                        }
                        a2.geraHashArvore();
                        a2.emOrdem();

                        JOptionPane.showMessageDialog(null, "Hash do pai 2: [" + a2.getRaiz().getHash() + "]", "Gerar hash", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("Hash do pai 2: [" + a2.getRaiz().getHash() + "]");

                        if (f1.exists() && f2.exists()) {
                            if (a1.getRaiz().getHash().equals(a2.getRaiz().getHash())) {
                                JOptionPane.showMessageDialog(null, "Os arquivos são autênticos!", "Verificação", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Os arquivos foram modificados!", "Verificação", JOptionPane.WARNING_MESSAGE);
                            }
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Finalizando programa...", "Sair", JOptionPane.WARNING_MESSAGE);
                        return false;
                    }
                }

                return true;

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao ler arquivo!");
                return false;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Finalizando programa...", "Sair", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    public boolean verificaArquivoHash(String hash, ArvoreAvl a) {
        try {
            JFileChooser jfc = new JFileChooser();
            int resposta = jfc.showOpenDialog(null);
            if (resposta == JFileChooser.APPROVE_OPTION) {
                File f = new File(jfc.getSelectedFile().getAbsolutePath());

                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);

                String linha = br.readLine();

                while (linha != null) {

                    if (!linha.isEmpty()) {
                        a.adicionar(linha);
                    }
                    linha = br.readLine();
                }

                a.geraHashArvore();
                a.emOrdem();

                System.out.println("Hash do pai: [" + a.getRaiz().getHash() + "]");
                JOptionPane.showMessageDialog(null, "Hash do pai: [" + a.getRaiz().getHash() + "]", "Gerar hash", JOptionPane.INFORMATION_MESSAGE);
                if(a.getRaiz().getHash().equals(hash)) {
                    JOptionPane.showMessageDialog(null, "Os dois arquivos coincidem!", "Verificação", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Os dois arquivos não coincidem!", "Verificação", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

            } else {
                JOptionPane.showMessageDialog(null, "Erro ao ler arquivo!");
                return false;

            }
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo!");
            return false;

        }
    }
}




