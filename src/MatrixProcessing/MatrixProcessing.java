package MatrixProcessing;

import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитати розміри матриць
        System.out.println("Enter size of first matrix:");
        int n1 = scanner.nextInt();
        int m1 = scanner.nextInt();

        int[][] matrixA = new int[n1][m1];
        System.out.println("Enter first matrix:");
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter size of second matrix:");
        int n2 = scanner.nextInt();
        int m2 = scanner.nextInt();

        if (n1 != n2 || m1 != m2) {
            System.out.println("ERROR");
            return;
        }

        int[][] matrixB = new int[n2][m2];
        System.out.println("Enter second matrix:");
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        // Обчислити суму матриць
        int[][] result = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        // Вивести результат
        System.out.println("The result is:");
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
