package curso.citacao;
// Programa para criar a citação de referências após digitar o nome completo do autor
public class CitacaoMain {

    public static void main(String[] args) {

        AutorCitacao citacao = new AutorCitacao();

        citacao.separarNome();
        citacao.escreverNome();
        citacao.escreverCitacao();

    }
}
