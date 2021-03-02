package curso.citacao;
// Programa para criar a citação de referências após digitar o nome completo do autor
import java.util.Scanner;

public class AutorCitacao {
    private String nome;
    private int palavra;
    private String [] V;
    private char letra;

    Scanner in = new Scanner(System.in);

    public void separarNome() {

        System.out.print("\nDigite o nome completo do autor: ");
        nome = in.nextLine();
        // a variável palavra recebe a quantidade, em números interiros, de espaços existentes no nome completo
        palavra = nome.split(" ").length - 1;
        // um vetor "V" é criado do tamanho da quantidade de espaços no nome completo
        V = new String[palavra];
        // a string é separada e o vetor recebe cada palavra do nome completo
        V = nome.split(" ");

    }

    public void escreverNome() {

        System.out.print("Nome completo do autor: ");
        // transforma a primeira letra de cada palavra do vetor em maiúscula
        for(int n = 0; n <= palavra; n++) {
            System.out.print(V[n].substring(0, 1).toUpperCase().concat(V[n].substring(1)) + " ");
        }

    }

    public void escreverCitacao() {

        System.out.print("\nCitação do autor para referências: ");
        // a última palavra da string, armazanada no último índice do vetor, tem os seus caracteres convertidos para maiúsculo
        System.out.print(V[palavra].toUpperCase() + ", ");
        // a variável "letra" recebe o primeiro caractere das primeiras palavras armazenadas do vetor, em ordem crescente
        // e imprime essa letra na forma maiúscula
        for(int n = 0; n <= palavra - 1; n++) {
            letra = V[n].charAt(0);
            System.out.print(String.valueOf(letra).toUpperCase() + ". ");
        }

    }
}

