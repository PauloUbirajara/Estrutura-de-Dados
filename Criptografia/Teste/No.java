package Criptografia.Teste;

public class No {
    private char letraDescript;
    private char letraCript;
    private No prox;
    private No ant;

    public No(char letraDescript, char letraCript) {
        this.letraDescript = letraDescript;
        this.letraCript = letraCript;
        this.prox = null;
        this.ant = null;
    }

    public void setAnt(No ant) {
        this.ant = ant;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    public void setLetraCript(char letraCript) {
        this.letraCript = letraCript;
    }

    public void setLetraDescript(char letraDescript) {
        this.letraDescript = letraDescript;
    }

    public No getProx() {
        return prox;
    }

    public No getAnt() {
        return ant;
    }

    public char getLetraCript() {
        return letraCript;
    }

    public char getLetraDescript() {
        return letraDescript;
    }
}
