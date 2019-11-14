package Criptografia;

public class No {
    private char letraDesconvertida;
    private char letraConvertida;
    private No proximo;
    private No anterior;

    public No(char letraDesconvertida, char letraConvertida) {
        this.letraDesconvertida = letraDesconvertida;
        this.letraConvertida = letraConvertida;
        this.proximo = null;
        this.anterior = null;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public void setLetraConvertida(char letraConvertida) {
        this.letraConvertida = letraConvertida;
    }

    public void setLetraDesconvertida(char letraDesconvertida) {
        this.letraDesconvertida = letraDesconvertida;
    }

    public No getProximo() {
        return proximo;
    }

    public char getLetraConvertida() {
        return letraConvertida;
    }

    public char getLetraDesconvertida() {
        return letraDesconvertida;
    }

    public No getAnterior() {
        return anterior;
    }
}
