package curso.tabuada;
// O programa cria um gerador de tabuada
public class TabuadaMetodo {
    private int a;

    public int getA() { return a; }
    public void setA(int a) { this.a = a; }

    public int somar(int b) {
        int soma;
        soma = a + b;
        return soma;
    }

    public int subtrair(int b) {
        int sub;
        sub = a - b;
        return sub;
    }

    public int multiplicar(int b) {
        int multi;
        multi = a * b;
        return multi;
    }

    public float dividir(float b) {
        float divisao;
        divisao = a / b;
        return divisao;
    }
}
