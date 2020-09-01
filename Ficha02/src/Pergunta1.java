import java.util.Arrays;
import java.util.Scanner;

public class Pergunta1 {
    int[] getArray() {
        Scanner inputReader = new Scanner(System.in);

        System.out.println("Qual é o tamanho do array?");
        int arraySize = inputReader.nextInt();

        int[] array = new int[arraySize];

        for(int i = 0; i < arraySize; i++) {
            System.out.printf("Introduz o %dº valor:", i + 1);
            array[i] = inputReader.nextInt();
        }

        return array;
    }

    int a(int[] array) {
        int min = Integer.MAX_VALUE;

        for(int elem : array) {
            if(elem < min)
                min = elem;
        }

        return min;
    }

    int[] b(int[] array, int begin, int end) {
        int[] newArray = new int[end - begin + 1];

        for(int i = 0; i < newArray.length; i++)
            newArray[i] = array[i + begin];

        return newArray;
    }

    int[] c(int[] array1, int[] array2) {
        int[] tempArray = new int[Math.max(array1.length, array2.length)];

        int i = 0;
        for(int element1 : array1) {
            for(int element2 : array2) {
                if(element1 == element2) {
                    tempArray[i++] = element1;
                    break;
                }
            }
        }

        int[] newArray = new int[i];
        for(int j = 0; j < i; j++)
            newArray[j] = tempArray[j];

        return newArray;
    }

    void sort(int[] array) {
        Arrays.sort(array);
    }

    int binarySearch(int[] array, int elemToFind) {
        return Arrays.binarySearch(array, elemToFind);
    }
}
