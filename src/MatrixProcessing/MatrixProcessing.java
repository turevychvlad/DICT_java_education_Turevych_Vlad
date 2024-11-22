package MatrixProcessing;

import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Меню
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break; // Завершення програми
            }

            switch (choice) {
                case 1: // Додавання матриць
                    addMatrices(scanner);
                    break;
                case 2: // Множення матриці на константу
                    multiplyMatrixByConstant(scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addMatrices(Scanner scanner) {
        // Зчитування першої матриці
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

        // Зчитування другої матриці
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

        // Обчислення суми матриць
        int[][] result = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        // Виведення результату
        System.out.println("The result is:");
        printMatrix(result);
    }

    private static void multiplyMatrixByConstant(Scanner scanner) {
        // Зчитування матриці
        System.out.println("Enter size of matrix:");
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] matrix = new int[n][m];
        System.out.println("Enter matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Зчитування константи
        System.out.println("Enter constant:");
        int constant = scanner.nextInt();

        // Множення матриці на константу
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = matrix[i][j] * constant;
            }
        }

        // Виведення результату
        System.out.println("The result is:");
        printMatrix(result);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
