package curso.tabuada;
// O programa cria um gerador de tabuada
import java.util.Scanner;

public class Tabuada {

    public static void main(String[] args) {
        int a;
        int b;
        int operacao;
        int escolha = 0;

        Scanner in = new Scanner(System.in);
        TabuadaMetodo tab = new TabuadaMetodo();

        do {
            // escolhe operação da tabuada
            System.out.println("Qual operação realizar?" +
                    "\n1 - Soma" +
                    "\n2 - Subtração" +
                    "\n3 - Multiplicação" +
                    "\n4 - Divisão");
            operacao = in.nextInt();

            // escolhe o número para criar a tabuada
            System.out.print("\nFazer a tubuada do número: ");
            a = in.nextInt();
            tab.setA(a);
            // condiciona a criação da tabuada para números iguais ou maiores que zero
            if (a >= 0) {
                // escolhe até que número será realizada a tabuada
                System.out.print("\nRealizar a tubuada até: ");
                b = in.nextInt();
                System.out.print("\n");
                // calcula a operação escolhida
                for (int n = 0; n <= b; n++) {

                    switch (operacao) {
                        case 1:
                            System.out.println((tab.getA()) + " + " + n + " = " + (tab.somar(n)));
                            break;
                        case 2:
                            System.out.println((tab.getA()) + " - " + n + " = " + (tab.subtrair(n)));
                            break;
                        case 3:
                            System.out.println((tab.getA()) + " x " + n + " = " + (tab.multiplicar(n)));
                            break;
                        case 4:
                            System.out.println((tab.getA()) + " / " + n + " = " + (tab.dividir(n)));
                            break;
                    }

                }

                System.out.println("\nRealizar outra operação?" +
                        "\n1 - Sim" +
                        "\n2 - Não");
                escolha = in.nextInt();
                System.out.print("\n");

            } else {
                System.out.println("\nTabuada inválida para o número " + a + ".\n");
            }

        } while (escolha == 1);

            System.out.println("Operação finalizada.");

    }

}


