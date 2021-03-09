package curso.funcionario;
// Programa para criar senha e autenticá-la, usando o conceito de herança
import java.util.Scanner;

public class AutenticacaoMain {

    public static void main(String[] args) {
        int digitoSenha;
        boolean autentica;

        Scanner in = new Scanner(System.in);
        Gerente gerente = new Gerente();
        // cadastra um novo usuário, criando uma senha e inserido dados pessoais
        System.out.println("\n====================");
        System.out.println("SISTEMA DE CADASTRO");
        System.out.println("====================\n");

        gerente.criarUsuario();

        gerente.inserirDados();
        // verifica se a senha está de acordo com a cadastrada e entra no sistema se a senha estiver correta
        System.out.println("\n=======================");
        System.out.println("SISTEMA DE AUTENTICAÇÃO");
        System.out.println("=======================\n");

        System.out.print("SENHA: ");
        digitoSenha = in.nextInt();
        in.nextLine();

        autentica = gerente.autenticar(digitoSenha);

        if (autentica) {
            System.out.println("\nDADOS DO USUÁRIO");
            System.out.println("-------------------------");
            System.out.println("Cargo: Gerente");
            System.out.println("Funcionário(a): " + gerente.getNome());
            System.out.println("CPF: " + gerente.getCpf());
            System.out.printf("Salário: R$ %.2f", gerente.getSalario());
        } else {
            System.out.println("\nSenha incorreta...");
        }

        System.exit(0);

    }
}
