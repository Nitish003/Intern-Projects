import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (char[] row : board) {
            for (int j = 0; j < 3; j++) {
                row[j] = ' ';
            }
        }
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameOver = false;
        int round = 1;
        while (!gameOver) {
            displayBoard(board);
            System.out.println("Round " + round + ": " + currentPlayer + "'s turn");
            int row = getValidInput(scanner, "Enter row (0-2): ", 0, 2);
            int col = getValidInput(scanner, "Enter column (0-2): ", 0, 2);
            if (board[row][col] != ' ') {
                System.out.println("Invalid move. Try again.");
                continue;
            }
            board[row][col] = currentPlayer;

            if (checkWin(board, currentPlayer)) {
                displayBoard(board);
                System.out.println(currentPlayer + " wins!");
                gameOver = true;
            } else if (isDraw(board)) {
                displayBoard(board);
                System.out.println("Draw!");
                gameOver = true;
            } else {
                currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
                round++;
            }
        }
        scanner.close();
    }
    public static void displayBoard(char[][] board) {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int getValidInput(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input >= min && input <= max) {
                    scanner.nextLine(); // consume the newline character
                    return input;
                }
            }
            scanner.nextLine(); // consume invalid input
            System.out.println("Invalid input. Try again.");
        }
    }
    public static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }
    public static boolean isDraw(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}