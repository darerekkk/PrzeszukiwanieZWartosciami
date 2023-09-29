import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int SIZE_ARRAY = 50;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę, którą chcesz odnaleźć w zbiorze:");
        int lockedForNumber = scanner.nextInt();

        int[] arrayOfNumbers = fillArray();

        boolean found = false;
        int index = -1;
        for (int i = 0; i < SIZE_ARRAY; i++) {
            if (arrayOfNumbers[i] == lockedForNumber) {
                found = true;
                index = i;
                break;
            }
        }

        System.out.println("Tablica pierwsza:");
        printArray(arrayOfNumbers);

        if (found) {
            System.out.println("Znaleziono liczbę " + lockedForNumber + " na pozycji " + index);
            int[] newArray = createNewArrayWithAddedValue(arrayOfNumbers, lockedForNumber);
            System.out.println("Nowa tablica z dodaną wartością:");
            printArray(newArray);
        } else {
            System.out.println("Nie znaleziono liczby " + lockedForNumber + " w zbiorze.");
        }
    }

    public static int[] fillArray() {
        int[] arrayOfNumbers = new int[SIZE_ARRAY];
        Random random = new Random();

        for (int i = 0; i < SIZE_ARRAY; i++) {
            arrayOfNumbers[i] = random.nextInt(100);
        }

        return arrayOfNumbers;
    }

    public static int[] createNewArrayWithAddedValue(int[] originalArray, int valueToAdd) {
        int[] newArray = Arrays.copyOf(originalArray, originalArray.length + 1);
        newArray[newArray.length - 1] = valueToAdd;
        return newArray;
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}