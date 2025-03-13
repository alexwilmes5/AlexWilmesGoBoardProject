import java.util.Scanner;

public class GoBoardProject {
    public static void main(String[] args) {
        // Initializes array to represent the Go Board
        String[][] goBoard = new String[9][9];
        goBoard[4][7] = "-b";
        goBoard[7][1] = "-w";
        goBoard[2][5] = "-b";
        goBoard[8][3] = "-w";

        //Initializes variables and scanner
        Scanner myScn = new Scanner(System.in);
        Boolean player1 = true;
        Boolean play = true;
        Boolean validmove = false;

        //While loop for game to function, outputs which players turn it is
        while (play) {
            if(player1) {
                System.out.println("Black's turn:");
            }else {
                System.out.println("White's turn:");
            }

            // Prints out board
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
            //Initializes variables of coordinates, allows player to input coordinates and ensures pieces can only go in open spaces
            int moveX = -1;
            int moveY = -1;
            while(!validmove){
                System.out.println("Enter an X coordinate:");
                moveX = myScn.nextInt() - 1;
                System.out.println("Enter a Y coordinate:");
                moveY = myScn.nextInt() - 1;

                if(goBoard[moveY][moveX] == null){
                    break;
                }else{
                    System.out.println("That space is occupied. Try placing a piece at a different space.");
                }
            }
            //Places piece on board, places a different character if player chooses X coordinate as 0.
            if(moveX != 0) {
                goBoard[moveY][moveX] = (player1) ? "-b" : "-w";
            } else if(moveX == 0) {
                goBoard[moveY][moveX] = (player1) ? "b" : "w";
            }

            //Switches between players
            player1 = !player1;

            //Closes scanner
        } myScn.close();
    }
}