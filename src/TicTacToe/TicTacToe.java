package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создаем пустое поле
        char[][] board = initializeBoard();

        // Флаг для отслеживания хода
        boolean isXTurn = true;

        // Печатаем начальное состояние поля
        displayBoard(board);

        while (true) {
            System.out.println("Enter the coordinates: ");
            int row, col;

            try {
                // Читаем координаты пользователя
                row = scanner.nextInt() - 1;
                col = scanner.nextInt() - 1;

                // Проверяем корректность координат
                if (!areValidCoordinates(row, col)) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }

                // Проверяем, свободна ли клетка
                if (!isCellEmpty(board, row, col)) {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }

                // Вносим ход игрока
                board[row][col] = isXTurn ? 'X' : 'O';

                // Обновляем отображение поля
                displayBoard(board);

                // Проверяем победу или ничью
                if (checkWinner(board, isXTurn ? 'X' : 'O')) {
                    System.out.println((isXTurn ? 'X' : 'O') + " wins");
                    break;
                }

                if (isBoardFull(board)) {
                    System.out.println("Draw");
                    break;
                }

                // Меняем ход
                isXTurn = !isXTurn;

            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                scanner.next(); // Очищаем буфер ввода
            }
        }
    }

    // Инициализация пустого игрового поля
    public static char[][] initializeBoard() {
        return new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
    }

    // Проверка валидности координат
    public static boolean areValidCoordinates(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }

    // Проверка, пустая ли клетка
    public static boolean isCellEmpty(char[][] board, int row, int col) {
        return board[row][col] == ' ';
    }

    // Проверка победы игрока
    public static boolean checkWinner(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            // Проверка строк и столбцов
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        // Проверка диагоналей
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    // Проверка на заполненность поля
    public static boolean isBoardFull(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Отображение игрового поля
    public static void displayBoard(char[][] board) {
        System.out.println("---------");
        for (char[] row : board) {
            System.out.print("| ");
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
