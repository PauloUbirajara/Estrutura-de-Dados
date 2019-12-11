package CriptografiaSHA1_AV3;

public class NoAvl {
    private String nome, hash;
    private int altura;
    private NoAvl esquerda;
    private NoAvl direita;

    public NoAvl(String nome) {
        this.nome = nome;
        this.altura = 0;
    }

    public NoAvl(String nome, NoAvl esquerda, NoAvl direita) {
        this.nome = nome;
        this.esquerda = esquerda;
        this.direita = direita;
        this.altura = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public NoAvl getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoAvl esquerda) {
        this.esquerda = esquerda;
    }

    public NoAvl getDireita() {
        return direita;
    }

    public void setDireita(NoAvl direita) {
        this.direita = direita;
    }
}
