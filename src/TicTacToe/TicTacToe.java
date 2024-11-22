package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос строки для состояния поля
        System.out.print("Enter cells (9 characters, only 'X', 'O', '_'): ");
        String input = scanner.nextLine();

        // Проверка ввода
        while (!isValidInput(input)) {
            System.out.print("Invalid input. Enter exactly 9 characters ('X', 'O', '_'): ");
            input = scanner.nextLine();
        }

        // Создание игрового поля
        char[][] board = {
                {input.charAt(0), input.charAt(1), input.charAt(2)},
                {input.charAt(3), input.charAt(4), input.charAt(5)},
                {input.charAt(6), input.charAt(7), input.charAt(8)}
        };

        // Печать игрового поля
        printBoard(board);

        // Анализ состояния игры
        System.out.println(checkGameState(board));
    }

    // Метод для проверки валидности ввода
    public static boolean isValidInput(String input) {
        if (input.length() != 9) return false;
        for (char c : input.toCharArray()) {
            if (c != 'X' && c != 'O' && c != '_') return false;
        }
        return true;
    }

    // Метод для анализа состояния игры
    public static String checkGameState(char[][] board) {
        int xCount = 0, oCount = 0;

        // Подсчет количества X и O
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == 'X') xCount++;
                if (cell == 'O') oCount++;
            }
        }

        boolean xWins = hasWinner(board, 'X');
        boolean oWins = hasWinner(board, 'O');

        // Логика определения состояния игры
        if (xWins && oWins || Math.abs(xCount - oCount) > 1) return "Impossible";
        if (xWins) return "X wins";
        if (oWins) return "O wins";
        if (xCount + oCount == 9) return "Draw";
        return "Game not finished";
    }

    // Метод для проверки победителя
    private static boolean hasWinner(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            // Проверка строк и столбцов
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        // Проверка диагоналей
        return board[0][0] == player && board[1][1] == player && board[2][2] == player ||
                board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }

    // Метод для печати игрового поля
    public static void printBoard(char[][] board) {
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
