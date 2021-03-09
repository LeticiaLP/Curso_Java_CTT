package curso.texto;
// Programa para manipular arquivos do tipo TXT por meio do Java
import java.io.IOException;
import java.util.Scanner;

public class EscreveLe {

    public static void main(String[] args) throws IOException {
        int selecao;
        int escolha;

        Scanner in = new Scanner(System.in);
        Texto textos = new Texto();

        System.out.println("\nMANIPULAÇÃO DE ARQUIVOS TXT");
        System.out.println("\nQual ação deseja realizar?");

        do {

            System.out.println("\n1. Criar novo diretório" +
                    "\n2. Criar novo arquivo" +
                    "\n3. Verificar a existência de diretório" +
                    "\n4. Verificar existência de arquivo" +
                    "\n5. Listar diretório e/ou arquivo" +
                    "\n6. Renomear diretório" +
                    "\n7. Renomear arquivo" +
                    "\n8. Excluir diretório vazio " +
                    "\n9. Excluir arquivo" +
                    "\n10. Escrever texto" +
                    "\n11. Ler texto" +
                    "\n12. Ler texto e inverter posição");
            escolha = in.nextInt();

            switch (escolha) {
                case 1:
                    textos.inserirDiretorio();
                    textos.criarDiretorio();
                    break;

                case 2:
                    textos.inserirArquivo();
                    textos.criarArquivo();
                    break;

                case 3:
                    textos.inserirDiretorio();
                    textos.existirDiretorio();
                    break;

                case 4:
                    textos.inserirArquivo();
                    textos.existirArquivo();
                    break;

                case 5:
                    textos.listar();
                    break;

                case 6:
                    textos.inserirDiretorio();
                    textos.renomearDiretorio();
                    break;

                case 7:
                    textos.inserirArquivo();
                    textos.renomearArquivo();
                    break;

                case 8:
                    textos.inserirDiretorio();
                    textos.excluirDiretorio();
                    break;

                case 9:
                    textos.inserirArquivo();
                    textos.excluirArquivo();
                    break;

                case 10:
                    textos.inserirArquivo();
                    textos.escrever();
                    break;

                case 11:
                    textos.inserirArquivo();
                    textos.ler();
                    break;

                case 12:
                    textos.inserirArquivo();
                    textos.inverterLeitura();
                    break;
            }

            System.out.println("\nRealizar outra ação?" +
                    "\n1. Sim" +
                    "\n2. Não");
            selecao = in.nextInt();

        } while (selecao == 1);

        System.out.println("\nAção finalizada.");

    }
}
