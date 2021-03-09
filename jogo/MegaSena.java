package curso.jogo;
// Programa para gerar números aleatórios não repetidos para uma aposta
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class MegaSena {
    private int tamanho;
    private int aposta;
    private int escolha;
    private String[] V;

    LinkedHashSet<Integer> hs = new LinkedHashSet<Integer>();
    Random num = new Random();
    Scanner in = new Scanner(System.in);

    public int getEscolha() { return escolha; }

    public void setEscolha(int escolha) { this.escolha = escolha; }

    public int getTamanho() { return tamanho; }

    public void setTamanho(int tamanho) { this.tamanho = tamanho; }

    public int quantidadeAposta() {
        System.out.println("\nQuantidade de apostas: ");
        return aposta = in.nextInt();
    }

    public int quantidadeDezenas() {
        System.out.println("\nQuantidade de números da aposta (6 a 15): ");
        return tamanho = in.nextInt();
    }

    public void gerarAposta() {
        int numero;
        V = new String[aposta];

        for (int i = 0; i < aposta; i++) {

            while (hs.size() < tamanho) {
                numero = num.nextInt(60) + 1; //escolhe um número de forma aleatória, variando de 1 até 60
                hs.add(numero); // adiciona um número na lista
            }
            // transforma a lista de números não repetidos num array e depois converte o Object para uma String
            V[i] = Arrays.toString(hs.toArray());
            // limpa a lista
            hs.clear();

        }
    }

    public void erroQuantidadeDezenas() {
        System.out.println("\nNão é possível realizar a aposta com a quantidade de dezenas escolhidas." +
                "\nEscolha a quantidade de dezenas entre 6 e 15.");

        System.out.println("\nRealizar nova aposta?" +
                "\n1 - Sim" +
                "\n2 - Não");
        escolha = in.nextInt();
    }

    public void gerarComprovante() {
        DateFormat hj = new SimpleDateFormat("dd/MM/yyyy              HH:mm:ss");
        Date data = new Date();

        System.out.printf("\n\n\n%-12s%-10s\n", "", "MEGA-SENA");
        System.out.println(hj.format(data));

        for (int n = 0; n < aposta; n++) {
                //muda um caractere da String alocada no vetor para nada/vazio
            V[n] = V[n].replaceAll("\\,", "");
            V[n] = V[n].replaceAll("\\]", "");
            V[n] = V[n].replaceAll("\\[", "");

            System.out.println("---------------------------------");
            System.out.println(V[n]);
        }
        System.out.println("---------------------------------");
    }

}
