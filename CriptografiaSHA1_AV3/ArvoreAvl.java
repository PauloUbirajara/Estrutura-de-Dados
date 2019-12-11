package CriptografiaSHA1_AV3;

import java.security.NoSuchAlgorithmException;

public class ArvoreAvl {
    private NoAvl raiz;

    public ArvoreAvl() {
        raiz = null;
    }

    public NoAvl adicionar(String nome, NoAvl noPai) {
        if(noPai == null) {
            noPai = new NoAvl(nome, null, null);
        } else if(nome.compareToIgnoreCase(noPai.getNome()) < 0) {
            noPai.setEsquerda(adicionar(nome, noPai.getEsquerda()));
        } else if(nome.compareToIgnoreCase(noPai.getNome()) > 0) {
            noPai.setDireita(adicionar(nome, noPai.getDireita()));
        }
        noPai = equilibrarArvore(noPai);
        return noPai;
    }

    public NoAvl equilibrarArvore(NoAvl n) {
        if(fatorBalanceamento(n) == 2) {
            if(fatorBalanceamento(n.getEsquerda()) > 0) {
                n = rotacaoDireita(n);
            } else {
                n = rotacaoDuplaDireita(n);
            }
        } else if(fatorBalanceamento(n) == -2) {
            if(fatorBalanceamento(n.getDireita()) < 0) {
                n = rotacaoEsquerda(n);
            } else {
                n = rotacaoDuplaEsquerda(n);
            }
        }
        n.setAltura(maior(altura(n.getEsquerda()), altura(n.getDireita())) + 1);
        return n;
    }

    public NoAvl rotacaoDireita(NoAvl n) {
        NoAvl d = n.getEsquerda();
        n.setEsquerda(d.getDireita());
        d.setDireita(n);

        n.setAltura(maior(altura(n.getEsquerda()), altura(n.getDireita())) + 1);
        d.setAltura(maior(altura(d.getEsquerda()), n.getAltura()) + 1);
        return d;
    }

    public NoAvl rotacaoEsquerda(NoAvl n) {
        NoAvl e = n.getDireita();
        n.setDireita(e.getEsquerda());
        e.setEsquerda(n);

        n.setAltura(maior(altura(n.getEsquerda()), altura(n.getDireita())) + 1);
        e.setAltura(maior(altura(e.getEsquerda()), n.getAltura()) + 1);
        return e;
    }

    public NoAvl rotacaoDuplaDireita(NoAvl n) {
        n.setEsquerda(rotacaoEsquerda(n.getEsquerda()));
        return rotacaoDireita(n);
    }

    public NoAvl rotacaoDuplaEsquerda(NoAvl n) {
        n.setDireita(rotacaoDireita(n.getDireita()));
        return rotacaoEsquerda(n);
    }

    public boolean adicionar(String nome) {
        raiz = adicionar(nome, raiz);
        return true;
    }

    public int altura(NoAvl n) {
        if(n != null) {
            return n.getAltura();
        } else {
            return 0;
        }
    }

    public int maior(int valor1, int valor2) {
        return (valor1 > valor2 ? valor1 : valor2);
    }

    public int fatorBalanceamento(NoAvl n) {
        return altura(n.getEsquerda()) - altura(n.getDireita());
    }

    public void imprimir() {
        System.out.print("PreOrdem = [");
        preOrdem();
        System.out.print("]\nEmOrdem = [");
        emOrdem();
        System.out.print("]\nPosOrdem = [");
        posOrdem();
        System.out.println("]");
    }

    public void preOrdem(NoAvl n) {
        if(n != null) {
            System.out.print("[" + n.getNome() + "]" + " ");
            preOrdem(n.getEsquerda());
            preOrdem(n.getDireita());
        }
    }

    public void emOrdem(NoAvl n) {
        if(n != null) {
            emOrdem(n.getEsquerda());

            System.out.print("[" + n.getNome() + "]" + "\n- Hash: " + n.getHash() + "\n");

            emOrdem(n.getDireita());
        }
    }

    public void posOrdem(NoAvl n) {
        if(n != null) {
            posOrdem(n.getEsquerda());
            posOrdem(n.getDireita());
            System.out.print("[" + n.getNome() + "]" + " ");
        }
    }

    public void geraHashArvore(NoAvl n) {
        if(n != null) {
            if (n.getEsquerda() != null) {
                geraHashArvore(n.getEsquerda());
            }

            if (n.getDireita() != null) {
                geraHashArvore(n.getDireita());
            }

            if(n.getHash() == (null)) {
                StringBuilder resposta = new StringBuilder();
                if(n.getEsquerda() != null) {
                    if(n.getDireita() != null) {
                        resposta = resposta.append(n.getEsquerda().getHash()).append(n.getDireita().getHash());
                    } else {
                        resposta = resposta.append(n.getEsquerda().getHash());
                    }
                } else {
                    if(n.getDireita() != null) {
                        resposta = resposta.append(n.getDireita().getHash());
                    } else {
                            resposta = new StringBuilder(n.getNome());
                    }
                }

                try {
                    n.setHash(ControleHash.geraHashSHA1(resposta.toString()));
                } catch (NoSuchAlgorithmException e) {
                    System.out.println("Erro ao gerar hash a partir de folha");
                }
            }
        }
    }

    public void geraHashArvore() {
        geraHashArvore(raiz);
    }

    public void preOrdem() {
        preOrdem(raiz);
    }

    public void emOrdem() {
        emOrdem(raiz);
    }

    public void posOrdem() {
        posOrdem(raiz);
    }

    public NoAvl getRaiz() {
        return raiz;
    }
}
