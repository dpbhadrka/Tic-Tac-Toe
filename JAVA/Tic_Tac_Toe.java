import java.util.Scanner;

public class Tic_Tac_Toe {
    public static void main(String[] args) {
        // Scanner for input
        Scanner input = new Scanner(System.in);
        System.out.println();

        // 3x3 game board for playing
        char[][] gameBoard = new char[3][3];

        // Initialisation of game board
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard.length; col++) {
                gameBoard[row][col] = ' ';
            }
        }

        // Print the game Board
        printBoard(gameBoard);

        // Variables use for players
        char player1 = 'X';
        char player2 = 'O';
        char currnetPlayer = player1;
        boolean gameOver = false;
        char winner = 'N';
        int move = 0;

        // Now the actual taking input from user and display it to the game board
        while (!gameOver) {

            // Increase the move by one
            move++;

            // Taking choise for placing 0 and X
            System.out.print(currnetPlayer + " Enter your choise(row col): ");
            int row = (input.nextInt() - 1);
            int col = (input.nextInt() - 1);

            // Put X or O in place which is given by user
            if (gameBoard[row][col] == ' ') {
                gameBoard[row][col] = currnetPlayer;
                // After placing the X or O check for winner
                if (hasWon(gameBoard, currnetPlayer)) {
                    winner = currnetPlayer;
                    gameOver = true;
                    System.out.println("The Winner is :" + currnetPlayer);
                    break;
                }
            } else {
                System.out.println("Invalid input  !!!");
            }

            // Now changing the Turn

            // if (currnetPlayer == player1) {
            // currnetPlayer = player2;
            // } else {
            // currnetPlayer = player1;
            // }
            currnetPlayer = (currnetPlayer == player1) ? player2 : player1;

            // There is tie or not
            if (winner == 'N' && move == 9) {
                gameOver = true;
                System.out.println("Tie !! well played....");
                break;
            }
            // Printing the game board
            printBoard(gameBoard);
        }

        // Printing the game board
        printBoard(gameBoard);
    }

    // Function for printng the game board
    public static void printBoard(char[][] board) {
        System.out.println("---------------");
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print("| " + board[row][col] + " |");
            }
            System.out.println();
            System.out.println("---------------");
        }
    }

    // Checking for winnner
    public static boolean hasWon(char[][] gameBoard, char currnetPlayer) {
        for (int row = 0; row < gameBoard.length; row++) {

            // For three rows
            if (gameBoard[row][0] == gameBoard[row][1] && gameBoard[row][2] == gameBoard[row][1]
                    && gameBoard[row][0] == currnetPlayer) {
                System.out.println("Winner is :" + currnetPlayer);
                return true;
            }

            // For three column
            if (gameBoard[0][row] == gameBoard[1][row] && gameBoard[1][row] == gameBoard[1][row]
                    && gameBoard[0][row] == currnetPlayer) {
                System.out.println("Winner is :" + currnetPlayer);
                return true;
            }

            // First diagonal
            if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[2][2] == gameBoard[1][1]
                    && gameBoard[0][0] == currnetPlayer) {
                System.out.println("Winner is :" + currnetPlayer);
                return true;
            }

            // Second diagonal
            if (gameBoard[0][2] == gameBoard[1][1] && gameBoard[2][0] == gameBoard[1][1]
                    && gameBoard[0][2] == currnetPlayer) {
                System.out.println("Winner is :" + currnetPlayer);
                return true;
            }
        }

        return false;
    }
}