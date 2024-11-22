package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "_XXOO_OX_";
        char[][] board = {
                {input.charAt(0), input.charAt(1), input.charAt(2)},
                {input.charAt(3), input.charAt(4), input.charAt(5)},
                {input.charAt(6), input.charAt(7), input.charAt(8)}
        };

        printBoard(board);

        while (true) {
            System.out.print("Enter the coordinates: ");
            try {
                int row = scanner.nextInt() - 1;
                int col = scanner.nextInt() - 1;

                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (board[row][col] != '_') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    board[row][col] = 'X';
                    printBoard(board);
                    break;
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine(); // Очистка ввода
            }
        }
    }

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
