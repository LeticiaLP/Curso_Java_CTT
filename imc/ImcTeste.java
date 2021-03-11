package curso.imc;
// Programa de teste de alguns métodos do programa construído para o cálculo de IMC
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.io.*;

public class ImcTeste {

    Imc teste = new Imc(70, (float) 1.70, "João", 40);

    @Test
    public void testeNome() {
        Assert.assertEquals("João", teste.getNome());
    }

    @Test
    public void testeIdade() {
        Assert.assertEquals(40,teste.getIdade());
    }

    @Test
    public void testeImc() {
        Assert.assertEquals(24, teste.getImc(), 0.23);
    }

    @Test
    public void testeClassifica() {
        Imc teste1 = new Imc((float) 53.2,(float) 1.70, "João", 40);

        teste1.getImc();
        Assert.assertEquals("abaixo do peso", teste1.getClassifica());
    }


    private final ByteArrayOutputStream saida = new ByteArrayOutputStream();

    @Before
    public void configurar() {
        System.setOut(new PrintStream(saida));
    }

    @After
    public void fechar() throws IOException { saida.close(); }

    @Test
    public void testeSalvarRelatorioImc() {
        String linha;

        teste.getImc();
        teste.getClassifica();
        teste.salvarRelatorioImc();

        try {
            FileReader leitor = new FileReader(teste.getArquivo());
            BufferedReader leitura = new BufferedReader(leitor);

            while ((linha = leitura.readLine()) != null ) {
                System.out.println(linha);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String expected = "RELATÓRIO IMC\r\n" +
                "-------------------------------------------\r\n" +
                "Nome: João\r\n" +
                "Idade: 40 anos\r\n" +
                "Peso: 70,00 kg\r\n" +
                "Altura: 1,70 m\r\n" +
                "IMC: 24,22\r\n" +
                "Condição: Você está no peso ideal\r\n" +
                "-------------------------------------------\r\n";

        Assert.assertEquals(expected, saida.toString());

    }

    @Test
    public void testeExibirRelatorioImc() {
        teste.getImc();
        teste.getClassifica();
        teste.exibirRelatorioImc();

        String expected = "RELATÓRIO IMC\r\n" +
                "-------------------------------------------\r\n" +
                "Nome: João" +
                "\nIdade: 40 anos\r\n" +
                "Peso: 70,00 kg\r\n" +
                "Altura: 1,70 m\r\n" +
                "IMC: 24,22" +
                "\nCondição: Você está no peso ideal\r\n" +
                "-------------------------------------------";

        Assert.assertEquals(expected, saida.toString());

    }

 }
