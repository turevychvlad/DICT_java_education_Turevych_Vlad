package MatrixProcessing;

import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class MatrixProcessing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Exiting program...");
                break;
            }

            handleMenuChoice(scanner, choice);
        }
    }


    // Displays the menu
    private static void printMenu() {
        System.out.println("\nMatrix Processing Menu:");
        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix by a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose matrix");
        System.out.println("5. Calculate a determinant");
        System.out.println("6. Inverse matrix");
        System.out.println("0. Exit");
        System.out.print("Your choice: ");
    }

    // Handles the user choice
    private static void handleMenuChoice(Scanner scanner, int choice) {
        switch (choice) {
            case 1 -> addMatrices(scanner);
            case 2 -> multiplyMatrixByConstant(scanner);
            case 3 -> multiplyMatrices(scanner);
            case 4 -> transposeMatrix(scanner);
            case 5 -> calculateDeterminant(scanner);
            case 6 -> inverseMatrix(scanner);
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }


    // Reads a matrix from the user
    private static double[][] readMatrix(Scanner scanner, String prompt) {
        System.out.print(prompt);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        // Перевірка на недійсні розміри
        if (rows <= 0 || cols <= 0) {
            System.out.println("Matrix dimensions must be positive integers.");
            return null;
        }

        double[][] matrix = new double[rows][cols];
        System.out.println("Enter the matrix values row by row:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }


    // Prints a matrix
    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%.2f ", value);
            }
            System.out.println();
        }
    }

    private static void addMatrices(Scanner scanner) {
        double[][] matrixA = readMatrix(scanner, "Enter size of the first matrix: ");
        double[][] matrixB = readMatrix(scanner, "Enter size of the second matrix: ");

        assert matrixA != null;
        assert matrixB != null;
        if (!areMatricesSameSize(matrixA, matrixB)) {
            System.out.println("Matrices must have the same size for addition.");
            return;
        }

        double[][] result = new double[matrixA.length][matrixA[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        System.out.println("The result is:");
        printMatrix(result);
    }

    private static boolean areMatricesSameSize(double[][] matrixA, double[][] matrixB) {
        return matrixA.length == matrixB.length && matrixA[0].length == matrixB[0].length;
    }

    private static void multiplyMatrixByConstant(Scanner scanner) {
        double[][] matrix = readMatrix(scanner, "Enter size of the matrix: ");
        System.out.print("Enter constant: ");
        double constant = scanner.nextDouble();

        for (int i = 0; i < Objects.requireNonNull(matrix).length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] *= constant;
            }
        }

        System.out.println("The result is:");
        printMatrix(matrix);
    }

    private static void multiplyMatrices(Scanner scanner) {
        double[][] matrixA = readMatrix(scanner, "Enter size of the first matrix: ");
        double[][] matrixB = readMatrix(scanner, "Enter size of the second matrix: ");

        assert matrixA != null;
        assert matrixB != null;
        if (matrixA[0].length != matrixB.length) {
            System.out.println("The number of columns in the first matrix must equal the number of rows in the second.");
            return;
        }

        double[][] result = new double[matrixA.length][matrixB[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                for (int k = 0; k < matrixA[0].length; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        System.out.println("The result is:");
        printMatrix(result);
    }

    private static void transposeMatrix(Scanner scanner) {
        double[][] matrix = readMatrix(scanner, "Enter size of the matrix: ");
        System.out.println("Transpose options:");
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();

        double[][] result;
        result = switch (choice) {
            case 1 -> {
                assert matrix != null;
                yield transposeMainDiagonal(matrix);
            }
            case 2 -> {
                assert matrix != null;
                yield transposeSideDiagonal(matrix);
            }
            case 3 -> {
                assert matrix != null;
                yield transposeVertical(matrix);
            }
            case 4 -> {
                assert matrix != null;
                yield transposeHorizontal(matrix);
            }
            default -> {
                System.out.println("Invalid choice.");
                yield null;
            }
        };

        if (result != null) {
            System.out.println("The result is:");
            printMatrix(result);
        }
    }

    private static double[][] transposeMainDiagonal(double[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        double[][] transposed = new double[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    private static double[][] transposeSideDiagonal(double[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        double[][] transposed = new double[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[cols - j - 1][rows - i - 1] = matrix[i][j];
            }
        }
        return transposed;
    }

    private static double[][] transposeVertical(double[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        double[][] transposed = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[i][cols - j - 1] = matrix[i][j];
            }
        }
        return transposed;
    }

    private static double[][] transposeHorizontal(double[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        double[][] transposed = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(matrix[i], 0, transposed[rows - i - 1], 0, cols);
        }
        return transposed;
    }

    private static void calculateDeterminant(Scanner scanner) {
        double[][] matrix = readMatrix(scanner, "Enter size of the matrix: ");
        assert matrix != null;
        if (matrix.length != matrix[0].length) {
            System.out.println("Determinant can only be calculated for square matrices.");
            return;
        }

        double determinant = calculateDeterminant(matrix);
        System.out.printf("The result is: %.2f%n", determinant);
    }

    private static double calculateDeterminant(double[][] matrix) {
        int n = matrix.length;
        if (n == 1) return matrix[0][0];
        if (n == 2) return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        double determinant = 0;
        for (int i = 0; i < n; i++) {
            determinant += Math.pow(-1, i) * matrix[0][i] * calculateDeterminant(getSubMatrix(matrix, i));
        }
        return determinant;
    }

    private static double[][] getSubMatrix(double[][] matrix, int excludeCol) {
        int n = matrix.length;
        double[][] subMatrix = new double[n - 1][n - 1];
        for (int i = 1; i < n; i++) {
            int colIndex = 0;
            for (int j = 0; j < n; j++) {
                if (j == excludeCol) continue;
                subMatrix[i - 1][colIndex++] = matrix[i][j];
            }
        }
        return subMatrix;
    }

    private static void inverseMatrix(Scanner scanner) {
        double[][] matrix = readMatrix(scanner, "Enter size of the matrix: ");
        assert matrix != null;
        if (matrix.length != matrix[0].length) {
            System.out.println("Only square matrices can have an inverse.");
            return;
        }

        double determinant = calculateDeterminant(matrix);
        if (determinant == 0) {
            System.out.println("This matrix doesn't have an inverse.");
            return;
        }

        double[][] inverse = calculateInverse(matrix);
        System.out.println("The result is:");
        printMatrix(inverse);
    }

    private static double[][] calculateInverse(double[][] matrix) {
        int n = matrix.length;
        double[][] augmented = new double[n][2 * n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, augmented[i], 0, n);
            augmented[i][i + n] = 1;
        }

        for (int i = 0; i < n; i++) {
            double diagValue = augmented[i][i];
            for (int j = 0; j < 2 * n; j++) {
                augmented[i][j] /= diagValue;
            }

            for (int k = 0; k < n; k++) {
                if (k == i) continue;
                double factor = augmented[k][i];
                for (int j = 0; j < 2 * n; j++) {
                    augmented[k][j] -= factor * augmented[i][j];
                }
            }
        }

        double[][] inverse = new double[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(augmented[i], n, inverse[i], 0, n);
        }
        return inverse;
    }
}
