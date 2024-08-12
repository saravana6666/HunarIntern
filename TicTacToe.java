import java.util.Scanner;
public class TicTacToe 
{
    private static char[][] board = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
    private static char currentPlayer = 'X';
    private static boolean gameEnded = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;
        do
        {
            initializeBoard();
            while (!gameEnded) 
            {
                printBoard();
                playerMove(scanner);
                checkForWinner();
                switchPlayer();
            }
            printBoard();
            System.out.println("Game Over!");
            System.out.println("Do you want to play again? (yes/no)");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }
         while (playAgain);
        System.out.println("Thanks for playing!");
    }

    private static void initializeBoard()
     {
        board = new char[][]{{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
        currentPlayer = 'X';
        gameEnded = false;
    }

    private static void printBoard()
     {
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("-----------");
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("-----------");
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }

    private static void playerMove(Scanner scanner) 
    {
        int choice;
        boolean validMove = false;

        while (!validMove)
         {
            System.out.println("Player " + currentPlayer + ", enter a number (1-9) to make a move:");
            choice = scanner.nextInt();
            validMove = makeMove(choice);
        }
    }

    private static boolean makeMove(int choice)
     {
        char mark = currentPlayer;
        int row = (choice - 1) / 3;
        int col = (choice - 1) % 3;

        if (choice < 1 || choice > 9 || board[row][col] == 'X' || board[row][col] == 'O')
         {
            System.out.println("This move is not valid.");
            return false;
        } else 
        {
            board[row][col] = mark;
            return true;
        }
    }

    private static void checkForWinner()
     {
        if (checkRows() || checkColumns() || checkDiagonals()) {
            System.out.println("Player " + currentPlayer + " wins!");
            gameEnded = true;
        } else if (isBoardFull()) 
        {
            System.out.println("It's a tie!");
            gameEnded = true;
        }
    }

    private static boolean checkRows()
     {
        for (int i = 0; i < 3; i++)
         {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) 
            {
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumns() 
    {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
             {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonals()
     {
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
               (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O')
                 {
                    return false;
                }
            }
        }
        return true;
    }

    private static void switchPlayer() 
    {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}

