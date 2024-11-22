package MatrixProcessing;

import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Меню
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
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
                case 3: // Множення матриць
                    multiplyMatrices(scanner);
                    break;
                case 4: // Транспонування матриці
                    transposeMatrix(scanner);
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

        double[][] matrixA = new double[n1][m1];
        System.out.println("Enter first matrix:");
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                matrixA[i][j] = scanner.nextDouble();
            }
        }

        // Зчитування другої матриці
        System.out.println("Enter size of second matrix:");
        int n2 = scanner.nextInt();
        int m2 = scanner.nextInt();

        if (n1 != n2 || m1 != m2) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        double[][] matrixB = new double[n2][m2];
        System.out.println("Enter second matrix:");
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                matrixB[i][j] = scanner.nextDouble();
            }
        }

        // Обчислення суми матриць
        double[][] result = new double[n1][m1];
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

        double[][] matrix = new double[n][m];
        System.out.println("Enter matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        // Зчитування константи
        System.out.println("Enter constant:");
        double constant = scanner.nextDouble();

        // Множення матриці на константу
        double[][] result = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = matrix[i][j] * constant;
            }
        }

        // Виведення результату
        System.out.println("The result is:");
        printMatrix(result);
    }

    private static void multiplyMatrices(Scanner scanner) {
        // Зчитування першої матриці
        System.out.println("Enter size of first matrix:");
        int n1 = scanner.nextInt();
        int m1 = scanner.nextInt();

        double[][] matrixA = new double[n1][m1];
        System.out.println("Enter first matrix:");
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                matrixA[i][j] = scanner.nextDouble();
            }
        }

        // Зчитування другої матриці
        System.out.println("Enter size of second matrix:");
        int n2 = scanner.nextInt();
        int m2 = scanner.nextInt();

        if (m1 != n2) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        double[][] matrixB = new double[n2][m2];
        System.out.println("Enter second matrix:");
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                matrixB[i][j] = scanner.nextDouble();
            }
        }

        // Множення матриць
        double[][] result = new double[n1][m2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                for (int k = 0; k < m1; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        // Виведення результату
        System.out.println("The result is:");
        printMatrix(result);
    }

    private static void transposeMatrix(Scanner scanner) {
        // Меню для вибору способу транспонування
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();

        // Зчитування матриці
        System.out.println("Enter matrix size:");
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        double[][] matrix = new double[n][m];
        System.out.println("Enter matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        double[][] result;
        switch (choice) {
            case 1: // Головна діагональ
                result = new double[m][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        result[j][i] = matrix[i][j];
                    }
                }
                break;
            case 2: // Побічна діагональ
                result = new double[m][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        result[m - j - 1][n - i - 1] = matrix[i][j];
                    }
                }
                break;
            case 3: // Вертикальна лінія
                result = new double[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        result[i][m - j - 1] = matrix[i][j];
                    }
                }
                break;
            case 4: // Горизонтальна лінія
                result = new double[n][m];
                for (int i = 0; i < n; i++) {
                    System.arraycopy(matrix[i], 0, result[n - i - 1], 0, m);
                }
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        // Виведення результату
        System.out.println("The result is:");
        printMatrix(result);
    }

    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
