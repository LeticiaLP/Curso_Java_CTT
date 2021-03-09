package curso.texto;
// Programa para manipular arquivos do tipo TXT por meio do Java
import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Texto {
    String local;
    String pasta;
    String txt;
    String novoNome;
    File diretorio;
    File arquivo;
    String linha; // irá receber cada linha do arquivo

    Scanner in = new Scanner(System.in);
        // o atributo diretorio da classe Texto recebe o atributo diretorio da classe File (é atribuído ao)
    public void setDiretorio(File diretorio) {
        this.diretorio = diretorio;
    }

    public File getDiretorio() {
        return diretorio;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

    public File getArquivo() {
        return arquivo;
    }
    // insere o local e o nome do diretório onde se encontra o arquivo
    public void inserirDiretorio() {
        System.out.print("\nLocal do diretório: ");
        local = in.nextLine();
        System.out.print("Nome do diretório: ");
        pasta = in.nextLine();
            // instancia a classe File, indicando local e nome do diretório no construtor
        File diretorio = new File(local, pasta); // o construtor da classe File recebe as Strings digitadas
        setDiretorio(diretorio); // o método setDiretorio da classe Texto modifica o atributo (this)diretorio para os valores inseridos construtor da classe File
    }
    // insere o local e o nome do diretório e o nome do arquivo onde serão escritos e lidos os textos
    public void inserirArquivo() {
        inserirDiretorio();
        System.out.print("Nome do arquivo: ");
        txt = in.nextLine();

        File arquivo = new File(diretorio, txt); // instancia a classe File, indicando diretório e nome do arquivo
        setArquivo(arquivo);
    }
    // cria um novo direório
    public void criarDiretorio() {

        boolean criadoDir = diretorio.mkdir(); // cria o diretório
        if (criadoDir) {
            System.out.println("\nO diretório " + diretorio + " foi criado.");
        } else {
            System.out.println("\nO diretório " + diretorio + " não foi criado.");
        }
    }
    // cria um novo arquivo
    public void criarArquivo() {

        try {
            boolean criadoArq = arquivo.createNewFile(); // cria arquivo txt
            if (criadoArq) {
                System.out.println("\nO arquivo " + txt + " foi criado.");
            } else {
                System.out.println("\nO arquivo " + txt + " não foi criado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // verifica a existência do nome de uma pasta
    public void existirDiretorio() {
        if (diretorio.exists()) {
            System.out.println("\nO diretório " + diretorio + " já existe.");
        } else {
            System.out.println("\nO diretório " + diretorio + " não existe.");
        }
    }
    // verifica a existência do nome de um arquivo
    public void existirArquivo() {
        if (arquivo.exists()) {
            System.out.println("\nO arquivo " + arquivo + " já existe.");
        } else {
            System.out.println("\nO arquivo " + arquivo + " não existe.");
        }
    }
    // lista o nome das pastas e arquivos dentro de um diretório
    public void listar() {
        System.out.print("\nLocal do diretório: ");
        local = in.nextLine();
        System.out.println("\nArquivos que compõe o diretório " + local + ":");

        File lista = new File(local);
        for (File file: Objects.requireNonNull(lista.listFiles())) {
            System.out.println(file);
        }
    }
    // altera o nome da pasta
    public void renomearDiretorio() {
        System.out.print("\nNovo nome do diretório: ");
        novoNome = in.nextLine();

        File antigoDir = new File(local, pasta);
        File novoDir = new File(local, novoNome);
        boolean renomeado = antigoDir.renameTo(novoDir);
        if (renomeado) {
            System.out.println("\nO diretório foi reanomeado para " + novoDir + ".");
        } else {
            System.out.println("\nO diretório não foi reanomeado.");
        }
    }
    // altera o nome do arquivo
    public void renomearArquivo() {
        System.out.print("\nNovo nome do arquivo: ");
        novoNome = in.nextLine();

        File antigoArq = new File(diretorio, txt);
        File novoArq = new File(diretorio, novoNome);
        boolean renomeado = antigoArq.renameTo(novoArq);
        if (renomeado) {
            System.out.println("\nO arquivo foi reanomeado para " + novoArq + ".");
        } else {
            System.out.println("\nO arquivo não foi reanomeado.");
        }
    }
    // exclui um diretório vazio
    public void excluirDiretorio() {

        boolean dir = diretorio.delete();
        if (dir){
            System.out.println("\nO diretório " + diretorio + " foi apagado com sucesso.");
        } else {
            System.out.println("\nO diretório " + diretorio + " não foi apagado.");
        }
    }
    // exclui um arquivo
    public void excluirArquivo() {

        boolean arq = arquivo.delete();
        if (arq) {
            System.out.println("\nO arquivo " + txt + " foi apagado com sucesso.");
        } else {
            System.out.println("\nO arquivo " + txt + " não foi apagado.");
        }
    }
    // escreve textos dentro do arquivo
    public void escrever() {
        String escrita;
        int apagar = 0;
        int repetir = 0;

        System.out.println("\nApagar informações escritas no arquivo escolhido?" +
                "\n1. Sim" +
                "\n2. Não");
        apagar = in.nextInt(); in.nextLine();

        do {

            System.out.println("\nEscreva o texto:");
            escrita = in.nextLine();

            String[] esc = escrita.split(" ");

            if (apagar == 1) {

                try {
                    FileWriter escreve = new FileWriter(arquivo, false); // false indica que o conteúdo do arquivo será apagado
                    BufferedWriter imprimi = new BufferedWriter(escreve);
                    imprimi.write(escrita);
                    imprimi.newLine();

                    imprimi.close();
                    escreve.close();

                } catch(IOException e) {
                    e.printStackTrace();
                }
            } else {

                try {
                    FileWriter escreve = new FileWriter(arquivo, true); //true indica que o conteúdo do arquivo será mantido
                    BufferedWriter imprimi = new BufferedWriter(escreve);
                    imprimi.write(escrita);
                    imprimi.newLine();

                    imprimi.close();
                    escreve.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            System.out.println("\nEscrever novamente?" +
                    "\n1. Sim" +
                    "\n2. Não");
            repetir = in.nextInt(); in.nextLine();

            if(repetir == 1) {
                apagar = 2;
            }

        } while (repetir == 1);

    }
    // lê os textos dentro do arquivo
    public void ler() {

        try {
            FileReader leitor = new FileReader(arquivo);
            BufferedReader leitura = new BufferedReader(leitor);

            System.out.println("\nLeitura das linhas do arquivo TXT:");
            while ((linha = leitura.readLine()) != null ) {
                System.out.println(linha);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // lê os textos do arquivo no sentido das linhas em que foram escritos e no sentido inverso das linhas
    public void inverterLeitura() throws IOException {
        int numeroLinha;
        int n = 0;
        String[] I;

        LineNumberReader contarLinha = new LineNumberReader(new InputStreamReader(new FileInputStream(arquivo)));

        contarLinha.skip(arquivo.length());
        numeroLinha = contarLinha.getLineNumber();

        I = new String[numeroLinha];

        try {
            FileReader leitor = new FileReader(arquivo);
            BufferedReader leitura = new BufferedReader(leitor);

            System.out.println("\nLeitura das linhas do arquivo TXT:");
            while ((linha = leitura.readLine()) != null ) {
                System.out.println(linha);

                I[n] = linha;
                n++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nLeitura das linhas do arquivo TXT de forma invertida:");
        for (int i = numeroLinha - 1; i >= 0; i--) {
            System.out.println(I[i]);
        }

    }

}
