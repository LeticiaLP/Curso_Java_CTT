package curso.imc;
// Programa para cálculo de IMC, com a opção de exibir e salvar em TXT um relatório com os dados obtidos
import java.io.IOException;

public class ImcMain {

    public static void main (String[] args) throws IOException {

        Imc imc = new Imc(0, 0, null, 0);

        imc.iniciarCalculoImc();

    }
}
