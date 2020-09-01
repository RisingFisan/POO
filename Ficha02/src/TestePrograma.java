import java.util.Arrays;
import java.util.Scanner;
import java.time.LocalDate;

public class TestePrograma {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Introduz o nº da pergunta:");
        int alinea = inputReader.nextInt();
        switch (alinea) {
            case 1:
                Pergunta1 p1 = new Pergunta1();

                int[] array = p1.getArray();

                int min = p1.a(array);
                System.out.printf("\nO valor mínimo do array é: %d\n", min);

                System.out.println("Introduz os dois índices para cortar o array:");

                int begin = inputReader.nextInt();
                int end = inputReader.nextInt();

                int[] chopped = p1.b(array, begin, end);
                System.out.println("O array cortado é " + Arrays.toString(chopped));

                int[] array2 = p1.getArray();
                int[] intersection = p1.c(array, array2);
                System.out.println("A interseção dos dois arrays é " + Arrays.toString(intersection));

                p1.sort(array);
                break;
            case 3:
                LocalDateArray dateArray = new LocalDateArray(5);
                dateArray.insereData(LocalDate.of(2020,2,29));
                System.out.println("Inserida data 2020-02-29");
                dateArray.insereData(LocalDate.of(2000, 8, 31));
                System.out.println("Inserida data 2000-08-31");
                dateArray.insereData(LocalDate.of(2012,12,21));
                System.out.println("Inserida data 2012-12-21");
                dateArray.insereData(LocalDate.of(2001,9,11));
                System.out.println("Inserida data 2001-09-11");
                LocalDate closestDate = dateArray.dataMaisProxima(LocalDate.of(2007,7,7));
                System.out.println("A data mais próxima de 2007-07-07 é " + closestDate.toString());
                System.out.println("A lista de datas é:");
                System.out.println(dateArray.toString());
                break;
        }
    }
}
