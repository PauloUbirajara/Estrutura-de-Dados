public class No {
    private char chave;
    private String nome;
    private No proximo;

    public No(String nome) {
        this.chave = nome.charAt(0);
        this.nome = nome;
        this.proximo = null;
    }

    public No() {
        this.proximo = null;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public void setChave(char chave) {
        this.chave = chave;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public No getProximo() {
        return proximo;
    }

    public char getChave() {
        return chave;
    }

    public String getNome() {
        return nome;
    }
}
