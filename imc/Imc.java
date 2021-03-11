package curso.imc;
// Programa para cálculo de IMC, com a opção de exibir e salvar em TXT um relatório com os dados obtidos
import java.io.*;
import java.util.Scanner;

public class Imc {
    private float peso;
    private float altura;
    private String nome;
    private int idade;
    private float imc;
    private String classifica;
    private File arquivo;

    Scanner in = new Scanner(System.in);

    public Imc(float peso, float altura, String nome, int idade) {
        this.peso = peso;
        this.altura = altura;
        this.nome = nome;
        this.idade = idade;
    }

    public File getArquivo() { return arquivo; }
    // exibe algumas informações sobre IMC
    public void exibirInformacao() {
        System.out.println("\nCALCULADORA IMC");
        System.out.println("\nO IMC, Índice de Massa Corpórea, é um parâmetro para identificar a condição de peso de uma pessoa, relacionando-o com a altura.");
        System.out.println("Para descobrir seu IMC, insira seus dados abaixo.");

    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
    // faz o cálculo do IMC
    public float getImc() {
        imc = (peso / (altura * altura));
        return imc;
    }
    // seleciona uma classificação da condição da pessoa de acordo com o resultado do IMC
    public String getClassifica() {
        if (imc < 18.5) {
            return classifica = "abaixo do peso";

        } else if (imc == 18.5 || imc < 25) {
            return classifica = "no peso ideal";

        } else if ((imc == 25 || imc > 25) && imc < 30) {
            return classifica = "com sobrepeso";

        } else if ((imc == 30 || imc > 30) && imc < 40) {
            return classifica = "com obesidade";

        } else {
            return classifica = "com obesidade grave";

        }
    }
    // exibe um relatório com todas as informações inseridas e calculadas
    public void exibirRelatorioImc() {
        System.out.println("RELATÓRIO IMC");
        System.out.println("-------------------------------------------");
        System.out.println("Nome: " + nome +
                "\nIdade: " + idade + " anos");
        System.out.printf("Peso: %.2f", peso);
        System.out.println(" kg");
        System.out.printf("Altura: %.2f", altura);
        System.out.println(" m");
        System.out.printf("IMC: %.2f", imc);
        System.out.println("\nCondição: Você está " + classifica);
        System.out.print("-------------------------------------------");

    }
    // escreve o relatório num arquivo TXT. IMPORTANTE: APENAS PARA O SISTEMA OPERACIONAL WINDOWS
    public void salvarRelatorioImc() {

        File diretorio = new File("C:\\Relatorio IMC");
        boolean dir = diretorio.mkdir();

        File pasta = new File(diretorio, nome);
        boolean past = pasta.mkdir();

        File arquivo = new File(pasta, "Relatorio.txt");
        try {
            boolean arq = arquivo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.arquivo = arquivo;

        try {
            FileWriter escreve = new FileWriter(arquivo, true);
            PrintWriter salva = new PrintWriter(escreve);

            salva.println("RELATÓRIO IMC");
            salva.println("-------------------------------------------");
            salva.println("Nome: " + nome +
                    "\nIdade: " + idade + " anos");
            salva.printf("Peso: %.2f", peso);
            salva.println(" kg");
            salva.printf("Altura: %.2f", altura);
            salva.println(" m");
            salva.printf("IMC: %.2f", imc);
            salva.println("\nCondição: Você está " + classifica);
            salva.print("-------------------------------------------");

            salva.flush();

            salva.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    // insere os dados para a realização do cálculo IMC e da classificação
    public void montarCalculoImc() {

        System.out.println("\nQual é o seu nome?");
        nome = in.nextLine();
        getNome();

        System.out.println("\nQual é a sua idade?");
        idade = in.nextInt();
        getIdade();

        System.out.println("\nQual é o seu peso, em kg?");
        peso = in.nextFloat();
        System.out.println("\nQual é a sua altura, em m?");
        altura = in.nextFloat();
        getImc();

        getClassifica();
        System.out.println("\n" + nome + ", o seu IMC atual é " + imc + "." +
                "\nVocê está " + classifica + ".");

    }
    // inicia o funcionamento do programa, dando a opção de exibir e salvar um relatório e realizar nova consulta
    public void iniciarCalculoImc() {
        int num = 0;
        int relatorio;

        exibirInformacao();

        do {
            montarCalculoImc();

            System.out.println("\nExibir e salvar relatório do IMC?" +
                    "\n1 Sim" +
                    "\n2 Não");
            relatorio = in.nextInt();
            if (relatorio == 1) {
                exibirRelatorioImc();
                salvarRelatorioImc();
            }

            System.out.println("\nRepetir consulta?" +
                    "\n1 Sim" +
                    "\n2 Não");
            num = in.nextInt();
            in.nextLine();

        } while (num == 1);

        System.out.println("\nConsulta Finalizada");

    }

}
