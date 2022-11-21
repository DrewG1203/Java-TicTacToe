import java.util.Scanner;

public class TicTacToe {
    private static int r;

    public static void main(String[] args) {
        char[][] board = new char[3][3];

        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                board[a][b] = '-';
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Who's ready to play Tic Tac Toe?");
        System.out.print("\nPlayer one, please enter your name. ");
        String firstPlayer = scanner.nextLine();
        System.out.print("\nPlayer two, please enter your name. ");
        String secondPlayer = scanner.nextLine();

        boolean player1 = true;

        boolean gameHasEnded = false;
        while(!gameHasEnded) {
            makeBoard (board);

            //displays if it is player 1 or 2's turn
            if (player1) {
                System.out.println(firstPlayer + "'s turn. (x): ");
            } else {
                System.out.println(secondPlayer + "'s turn. (o): ");
            }

            //store variable based on players turn
            char ch = '-';
            if(player1) {
                ch = 'x';
            } else {
                ch = 'o';
            }

            //row and col that represent the board
            int row = 0;
            int col = 0;

            while (true) {
                System.out.print("\nEnter a row number. (0-2): ");
                row = scanner.nextInt();
                System.out.print("\nEnter a column number. (0-2): ");
                col = scanner.nextInt();

                if (row < 0 || col < 0 || row > 2 || col > 2) {
                    System.out.println("\nThis position is out of bounds. Please try again.");
                } else if (board[row][col] != '-') {
                    System.out.println("\nSomeone has already selected this position. Please try again.");
                } else {
                    break;
                }
            }

            board[row][col] = ch;

            //Checks if there is a winner
            if (playerWins(board) == 'x') {
                System.out.println(firstPlayer + " has won!");
                gameHasEnded = true;
            } else if (playerWins(board) == 'o') {
                System.out.println(secondPlayer + " has won!");
                gameHasEnded = true;
            } else {
                if (boardFull(board)) {
                    System.out.println("\nGame has ended in a tie.");
                    gameHasEnded = true;
                } else {
                    player1 = !player1;
                }
            }
        }

        makeBoard(board);
    }

    //Function used to make board
    public static void makeBoard(char[][] board) {
        System.out.println("\nBoard: ");
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                System.out.print(board[a][b]);
            }
            System.out.println();
        }
    }

    //Function to determine if there is winner
    public static char playerWins(char [][] board) {
        //Checks rows
        for (int a = 0; a < 3; a++) {
            if (board[a][0] == board[a][1] && board[a][1] == board[a][2] && board[a][0] != '-') {
                return board[a][0];
            }
        }

        //Checks columns
        for (int b = 0; b < 3; b++) {
            if (board[0][b] == board[1][b] && board[1][b] == board[2][b] && board[0][b] != '-') {
                return board[0][b];
            }
        }

        //Checks diagonals
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return board[0][0];
        }
        if(board[2][0] == board[1][1] && board[1][1] ==  board[0][2] && board[2][0] != '-') {
            return board[2][0];
        }
        return ' ';
    }

    //Checks positions on the board
    public static boolean boardFull(char[][] board) {
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++){
                if (board[a][b] == '-') {
                    return false;
                }
            }
        } return true;
    }

    public void displayBoard() {
        System.out.print("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.print("    --+-+--");
        System.out.print("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.print("    --+-+--");
        System.out.print("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     0 1 2 ");
    }

    private static char[][] board;
    private static int turns;
    public char playerAt(int r, int c) {
        return 0;
    }
    public static boolean isCat() {
        return true;
    }
    public static int numberOfTurns() {
        return 0;
    }
    public static boolean isFull() {
        return true;
    }

    public boolean isSound(int r, int c) {
        return true;
    }
    public static void isWinner(char c) {
        if (board[r][c] == ' ')
            return;
    }
    public void playerMove(char p, int r, int c) {
        if (playerAt(r, c) == ' ') {
            this.board[r][c] = p;
            this.turns++;
        }
    }


}