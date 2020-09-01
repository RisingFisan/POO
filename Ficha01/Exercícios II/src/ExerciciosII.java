import java.time.LocalDateTime;

public class ExerciciosII {
    public double celsiusParaFahrenheit(double graus) {
        return 1.8 * graus + 32;
    }

    public int maximoNumeros(int a, int b) {
        return a > b ? a : b;
    }

    public String criaDescricaoConta(String nome, double saldo) {
        return "A conta pertencente a " + nome + " tem um saldo de " + saldo;
    }

    public double eurosParaLibras(double valor, double taxaConversao) {
        return valor * taxaConversao;
    }

    public long factorial(int num) {
        return num > 0 ? num * factorial((num - 1)) : 1;
    }

    public long tempoGasto() {
        int startTime = LocalDateTime.now().getNano();
        long factorialOf5000 = factorial(5000);
        int tExec = LocalDateTime.now().getNano() - startTime;
        return tExec;
    }
}
