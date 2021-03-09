package curso.funcionario;
// Programa para criar senha e autenticá-la, usando o conceito de herança
import java.util.Scanner;

public class Gerente extends Funcionario {

    Scanner in = new Scanner(System.in);
    // verifica se a senha está correta ou não
    public boolean autenticar(int senha) {
        if (super.getSenha() == senha) {
            return true;
        } else {
            return false;
        }
    }
    // cria uma senha numérica para um usuário
    public void criarUsuario() {
        int senha;

        System.out.println("CRIAR NOVO USUÁRIO\n");

        System.out.print("Criar senha (apenas números): ");
        senha = in.nextInt();
        super.setSenha(senha);
        in.nextLine();

        System.out.println("\nSenha criada com sucesso!\n");

    }
    // insere os dados do usuário
    public void inserirDados() {
        String cpf;
        String nome;
        double salario;

        System.out.println("INSIRA OS DADOS SOLICITADOS\n");

        System.out.println("Cargo: Gerente");

        System.out.print("Nome: ");
        nome = in.nextLine();
        super.setNome(nome);

        System.out.print("CPF: ");
        cpf = in.nextLine();
        super.setCpf(cpf);

        System.out.print("Salário: R$ ");
        salario = in.nextDouble();
        super.setSalario(salario);

        System.out.println("\nDados inseridos com sucesso!");

    }
}
