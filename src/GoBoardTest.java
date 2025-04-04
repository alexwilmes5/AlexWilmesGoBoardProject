import java.util.Scanner;

public class GoBoardTest {

    // Method to check if a move is valid
    public static boolean IsMoveValid(String[][] goBoard, int moveX, int moveY) {
        if (moveX >= 9) {
            System.out.println("X coordinate out of bounds. Try again.");
            return false;
        } else if (moveX < 0) {
            System.out.println("X coordinate out of bounds. Try again.");
            return false;
        } else if (moveY >= 9) {
            System.out.println("Y coordinate out of bounds. Try again.");
            return false;
        } else if (moveY < 0) {
            System.out.println("Y coordinate out of bounds. Try again.");
            return false;
        } else if (goBoard[moveY][moveX] != null) {
            System.out.println("That space is occupied. Try placing a piece at a different space.");
            return false;
        }
        return true; // Move is valid
    }

    public static void turnDisplay(boolean player1) {
        if (player1) {
            System.out.println("Black's turn:");
        } else {
            System.out.println("White's turn:");
        }
    }

    public static void displayBoard(String[][] goBoard, boolean player1) {
        turnDisplay(player1);
        System.out.println("  1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < goBoard[0].length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < goBoard.length; j++) {
                if (goBoard[i][j] == null) {
                    if (j == 0) {
                        System.out.print("|");
                    } else {
                        System.out.print("-|");
                    }
                } else {
                    System.out.print(goBoard[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void placePiece(String[][] goBoard, boolean player1, int moveX, int moveY) {
        if(moveX != 0) {
            goBoard[moveY][moveX] = (player1) ? "-b" : "-w";
        }
        else {
            goBoard[moveY][moveX] = (player1) ? "b" : "w";
        }

    }

    public static void acceptMove(String[][] goBoard, boolean player1, boolean validmove, int moveX, int moveY, Scanner myScn) {
        while (!validmove) {
            System.out.println("Enter an X coordinate:");
            moveX = myScn.nextInt() - 1;
            System.out.println("Enter a Y coordinate:");
            moveY = myScn.nextInt() - 1;

            // Call the IsMoveValid method to validate the move
            if (IsMoveValid(goBoard, moveX, moveY)) {
                validmove = true; // Move is valid
            }
        }
    }

    public static void checkCapture(String[][] goBoard, int moveX, int moveY) {

        if(moveY - 1 >= 0 && goBoard[moveY - 1][moveX] != null){
            System.out.println("Above capture works");
        }
        else if(moveY + 1 < goBoard.length && [moveY + 1][moveX] != null) {
            System.out.println("Below capture works");
        }
        else if(moveX - 1 >= 0 && goBoard[moveY][moveX - 1] != null) {
            System.out.println("Left capture works");
        }
        else if(moveX + 1 < goBoard[0].length && goBoard[moveY][moveX + 1] != null) {
            System.out.println("Right capture works");
        }
        else{
            System.out.println("No capture detected");
        }

    }

    public static void main(String[] args) {
        // Initializes array to represent the Go Board
        String[][] goBoard = new String[9][9];
        goBoard[4][7] = "-b";
        goBoard[7][1] = "-w";
        goBoard[2][5] = "-b";
        goBoard[8][3] = "-w";

        // Initializes variables and scanner
        Scanner myScn = new Scanner(System.in);
        Boolean player1 = true;
        Boolean play = true;

        // While loop for game to function, outputs which player's turn it is
        while (play) {

            // Prints out the board
            displayBoard(goBoard, player1);

            // Initializes variables for coordinates and ensures valid moves
            int moveX = -1;
            int moveY = -1;
            boolean validmove = false; // Reset validmove for the current turn

            acceptMove(goBoard, player1, validmove, moveX, moveY, myScn);

            // Places piece on the board
            placePiece(goBoard, player1, moveX, moveY); 

            // Switches between players
            player1 = !player1;

            checkCapture(goBoard, moveX, moveY);
        }

        // Closes scanner
        myScn.close();
    }
}