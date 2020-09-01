import java.util.Scanner;

public class TestePrograma {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        ExerciciosII exs = new ExerciciosII();

        System.out.println("Introduz o nº da alínea:");
        int alinea = inputReader.nextInt();
        inputReader.nextLine();

        switch(alinea) {
            case 1:
                System.out.println("Introduz uma temperatura em graus Celsius:");
                double grausC = inputReader.nextDouble();
                double grausF = exs.celsiusParaFahrenheit(grausC);
                System.out.printf("%fºC = %fºF\n", grausC, grausF);
                break;
            case 2:
                System.out.println("Introduz dois valores, separados por um espaço:");
                String nums = inputReader.nextLine();
                Scanner numSplitter = new Scanner(nums);
                int a = numSplitter.nextInt();
                int b = numSplitter.nextInt();
                System.out.printf("O maior de %d e %d é %d.\n",a,b,exs.maximoNumeros(a,b));
                break;
            case 3:
                System.out.println("Introduz um nome e um valor (saldo):");
                String nome = inputReader.nextLine();
                int saldo = inputReader.nextInt();
                System.out.println(exs.criaDescricaoConta(nome,saldo));
                break;
            case 4:
                System.out.println("Introduz um valor em euros:");
                double valueEuros = inputReader.nextDouble();
                // System.out.println("Introduz o valor da taxa de conversão de euros para libras:");
                // double conversionRate = inputReader.nextDouble();
                double conversionRate = 0.8428;
                double valuePounds = exs.eurosParaLibras(valueEuros,conversionRate);
                System.out.printf("%f EUR = %f GBP", valueEuros, valuePounds);
                break;
            case 5:
                System.out.println("Introduz dois valores inteiros, separados por um espaço:");
                nums = inputReader.nextLine();
                numSplitter = new Scanner(nums);
                a = numSplitter.nextInt();
                b = numSplitter.nextInt();
                System.out.printf("Os dois valores por ordem decrescente ficam: %d %d\n", a > b ? a : b, a > b ? b : a);
                System.out.printf("A média destes dois valores é %f\n.", (a + b) / 2.0);
                break;
            case 6:
                if(args.length == 0) {
                    System.out.println("Erro - não foi passado nenhum argumento ao programa");
                    break;
                }
                int num = Integer.parseInt(args[0]);
                long factNum = exs.factorial(num);
                System.out.printf("O fatorial de %d é %d. (o valor %d foi passado como argumento ao programa.)\n", num, factNum, num);
                break;
            case 7:
                long tExec_ns = exs.tempoGasto();
                System.out.printf("O ciclo demorou %f ms a executar.\n",tExec_ns / 100000.0);
                break;
            default:
                break;
        }
    }
}
