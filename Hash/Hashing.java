public class Hashing {
    public Lista[] vetorPessoas = new Lista[26];

    public Hashing() {

    }

    public void inserirNome(String nome) {
        int posChave = Character.toLowerCase(nome.charAt(0)) - 61;
        int posVetor = posChave % 26;
        if(vetorPessoas[posVetor] == null) {
            vetorPessoas[posVetor] = new Lista();
            vetorPessoas[posVetor].adicionar(nome);
            System.out.println("Nome inserido!");
        } else {
            System.out.println("Colisão detectada!");
            if(vetorPessoas[posVetor].getTamanho() == 26) {
                System.out.println("Lista da posição " + posVetor + " cheia!" +
                        "\n- Procurando outra posição!");

                while(vetorPessoas[posVetor] != null) {
                    posVetor = (posVetor + 1) % 26;
                    if(vetorPessoas[posVetor].getTamanho() != 26) {
                        System.out.println("Lista encontrada na posição: " + posVetor + "!");
                        vetorPessoas[posVetor] = new Lista();
                        vetorPessoas[posVetor].adicionar(nome);
                    }
                }
            } else {
                vetorPessoas[posVetor].adicionar(nome);
            }
        }
    }

    public void imprimirNomes() {
        for(int i = 0; i < 26; i++) {
            if(vetorPessoas[i] != null) {
                vetorPessoas[i].imprimir();
            }
        }
    }

    public static void main(String[] args) {
        // Teste //

        Hashing h = new Hashing();
        h.inserirNome("Joao");
        h.inserirNome("Ruan");
        h.inserirNome("Joaquim");
        h.inserirNome("Jubileu");
        h.inserirNome("Amanda");
        h.inserirNome("Zeus"); // Caso adicionar demais em uma fila, irá resultar em um nullPointer //


        h.imprimirNomes();
    }


}
