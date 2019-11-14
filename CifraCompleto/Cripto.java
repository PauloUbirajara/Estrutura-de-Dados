package CifraCompleto;
import java.text.Normalizer;
import java.util.regex.Pattern;

public class Cripto {
    private Fila f = new Fila();
    char alfabeto[];

    public Cripto(String fraseCompleta, String chave, int tamanhoBloco)
    {
        int contador = 0;
        int contadorChave = 0;

        //aa para 3

        while (chave.length() < tamanhoBloco) {
            chave += chave;
        }

        chave.substring(0, tamanhoBloco-1);


        while (contador < fraseCompleta.length()) {
            String aux = "";
            String auxChave = "";


            while (contadorChave < tamanhoBloco && contador < fraseCompleta.length()) {
                aux += fraseCompleta.charAt(contador);
                auxChave += chave.charAt(contadorChave);
                contador++;
                contadorChave++;
                if (contadorChave == tamanhoBloco) {
                    contadorChave = 0;
                }
            }
            f.adicionar(aux, auxChave);
        }
    }

    public String Criptografar() {
        Fila f2 = new Fila();

        //Remover simbolos especiais
        while(f.size() > 0) {
            No aux = f.remover();
            aux.setFragmento(deAccent(aux.getFragmento()));
            aux.setChave(deAccent(aux.getChave()));

            String fragmento = aux.getFragmento();
            String novoFragmento = "";

            for(int i = 0; i < fragmento.length(); i++) {

                novoFragmento += CriptografaLetra(aux.getFragmento().charAt(i), aux.getChave().charAt(i));

            }
            f2.adicionar(novoFragmento, aux.getChave());
            aux = aux.getProximo();
        }
        return f2.imprimir();
    }

    public String Descriptografar() {
            Fila f2 = new Fila();

            //Remover simbolos especiais
            while(f.size() > 0) {
                No aux = f.remover();
                aux.setFragmento(deAccent(aux.getFragmento()));
                aux.setChave(deAccent(aux.getChave()));

                String fragmento = aux.getFragmento();
                String novoFragmento = "";

                for(int i = 0; i < fragmento.length(); i++) {

                    novoFragmento += DescriptografaLetra(aux.getFragmento().charAt(i), aux.getChave().charAt(i));

                }
                f2.adicionar(novoFragmento, aux.getChave());
                aux = aux.getProximo();
            }
            return f2.imprimir();
        }

        public static char CriptografaLetra(char letra, char chave) {
            int casasParaPassar = 0;
            char alfabeto[];
            int posLetra = -1;

            char novaLetra = ' ';

            int valorChave = chave;
            if(Character.isUpperCase(chave)){
                valorChave -= 65;
                casasParaPassar = valorChave;
            } else if(Character.isLowerCase(chave)) {
                valorChave -= 97;
                casasParaPassar = valorChave;
            } else {
                casasParaPassar = 0;
            }
            // Quantas casas pular


            if(Character.isUpperCase(letra)) {
                alfabeto = new char[]{'A' ,'B' ,'C' ,'D' ,'E' ,'F' ,'G' ,'H' ,'I' ,'J' ,'K' ,'L' ,'M' ,'N', 'O' ,'P' ,'Q' ,'R' ,'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
                for(int i = 0; i < alfabeto.length; i++) {
                    if(alfabeto[i] == letra) {
                        posLetra = i;
                    }
                }

                posLetra += casasParaPassar;
                if(posLetra > 25) {
                    posLetra -= 25;
                }
                novaLetra = alfabeto[posLetra];
            } else if(Character.isLowerCase(letra)) {
                alfabeto = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

                for(int i = 0; i < alfabeto.length; i++) {
                    if(alfabeto[i] == letra) {
                        posLetra = i;
                    }
                }
                posLetra += casasParaPassar;
                if(posLetra > 25) {
                    posLetra -= 25;
                }
                novaLetra = alfabeto[posLetra];
            } else {
                novaLetra = letra;
            }
            return novaLetra;
        }

    public static char DescriptografaLetra(char letra, char chave) {
        int casasParaPassar = 0;
        char alfabeto[];
        int posLetra = -1;

        char novaLetra = ' ';

        int valorChave = chave;
        if(Character.isUpperCase(chave)){
            valorChave -= 65;
            casasParaPassar = valorChave;
        } else if(Character.isLowerCase(chave)) {
            valorChave -= 97;
            casasParaPassar = valorChave;
        } else {
            casasParaPassar = 0;
        }

        if(Character.isUpperCase(letra)) {
            alfabeto = new char[]{'A' ,'B' ,'C' ,'D' ,'E' ,'F' ,'G' ,'H' ,'I' ,'J' ,'K' ,'L' ,'M' ,'N', 'O' ,'P' ,'Q' ,'R' ,'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
            for(int i = 0; i < alfabeto.length; i++) {
                if(alfabeto[i] == letra) {
                    posLetra = i;
                }
            }

            posLetra -= casasParaPassar;
            if(posLetra < 0) {
                posLetra += 26;
            }
            novaLetra = alfabeto[posLetra];
        } else if(Character.isLowerCase(letra)) {
            alfabeto = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

            for(int i = 0; i < alfabeto.length; i++) {
                if(alfabeto[i] == letra) {
                    posLetra = i;
                }
            }
            posLetra -= casasParaPassar;
            if(posLetra < 0) {
                posLetra += 26;
            }
            novaLetra = alfabeto[posLetra];
        } else {
            novaLetra = letra;
        }
        return novaLetra;
    }

    public static String deAccent(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }
}
