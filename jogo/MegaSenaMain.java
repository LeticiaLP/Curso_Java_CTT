package curso.jogo;
// Programa para gerar números aleatórios não repetidos para uma aposta
public class MegaSenaMain {

    public static void main(String[] args) {

        MegaSena sena = new MegaSena();

        System.out.println("===================");
        System.out.println("JOGO DA MEGA-SENA");
        System.out.println("===================");

        do {

            sena.quantidadeAposta();
            sena.quantidadeDezenas();

            if (sena.getTamanho() >= 6 && sena.getTamanho() <= 15) {

                sena.gerarAposta();

                if (sena.getEscolha() == 1)
                    break;

            } else {

                sena.erroQuantidadeDezenas();
            }

        } while (sena.getEscolha() == 1);

        if (sena.getEscolha() == 2)
            System.exit(0);

        sena.gerarComprovante();

    }
}
