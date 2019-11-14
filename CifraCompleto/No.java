package CifraCompleto;
public class No {
    private String fragmento;
    private String chave;
    private No proximo;

    public No(String fragmento, String chave) {
        this.fragmento = fragmento;
        this.chave = chave;
        this.proximo = null;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public void setFragmento(String fragmento) {
        this.fragmento = fragmento;
    }

    public No getProximo() {
        return proximo;
    }

    public String getFragmento() {
        return fragmento;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getChave() {
        return chave;
    }
}
