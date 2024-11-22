package TicTacToe;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'X', 'O'}
        };
        printBoard(board);
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
