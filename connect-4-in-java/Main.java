import java.util.*;


// holds and manipulates game variables, and runs and sets up the game
public class Main {


    //gamestate 0 for tie
    //gamestate 1 for player 1 wins
    //gamestate 2 for player 2 wins
    private static int gameState = 0;

    private static int diskCount = 0;

    public static void main(String[] args) {


        Board.initializeBoard();
        Board.printBoard();

        Player player1 = new Player("X");
        Player player2 = new Player("O");

        Scanner scan = new Scanner(System.in);

        //while loop within which the game occurs
        exitGame:
        while(true){


            //Player 1's turn: Enter in a column
            System.out.println("Player 1(X): Drop a disk in a column: ");
            int col;

            //loop for the user to enter in a valid value
            player1Loop:
            while(true){

                try{
                    col = Integer.parseInt(scan.nextLine());

                } catch(NumberFormatException e){

                    Board.printBoard();
                    System.out.println("Not a number! Player 1(X), try again: ");
                    continue player1Loop;
                }

                if(col>=1 && col<= 7){

                    if(!player1.dropDisk(col)){

                        diskCount++;
                        Board.printBoard();
                        System.out.println("Column full! Player 1(X), try again: ");
                        continue player1Loop;
                    }

                    else {
                        break player1Loop;
                    }
                }

                Board.printBoard();
                System.out.println("Number out of bounds! Player 1(X), try again: ");
            }

            Board.printBoard();

            //if player1 has won, exit the game and set end game state
            if(Board.checkWin(player1.getCurrentDiskRow(), player1.getCurrentDiskCol())){

                gameState = 1;
                break exitGame;
            }








            //Player 2's turn: Enter in a column
            System.out.println("Player 2(O): Drop a disk in a column: ");

            //loop for the user to enter in a valid value
            player2Loop:
            while(true){

                try{
                    col = Integer.parseInt(scan.nextLine());

                } catch(NumberFormatException e){

                    Board.printBoard();
                    System.out.println("Not a number! Player 2(O), try again: ");
                    continue player2Loop;
                }

                if(col>=1 && col<= 7){

                    if(!player2.dropDisk(col)){

                        diskCount++;
                        Board.printBoard();
                        System.out.println("Column full! Player 2(O), try again: ");
                        continue player2Loop;
                    }

                    else {
                        break player2Loop;
                    }
                }

                Board.printBoard();
                System.out.println("Number out of bounds! Player 2(O), try again: ");
            }

            Board.printBoard();

            //if player2 has won, exit the game and set end game state
            if(Board.checkWin(player2.getCurrentDiskRow(), player2.getCurrentDiskCol())){

                gameState = 2;
                break exitGame;
            }


            //if the game has been finished with no winners, leave the loop and print out a tie
            if(diskCount == 42){
                break exitGame;
            }

        }//end of while loop exitGame



        if(gameState == 0){
            System.out.println("Tie.");
        }

        else if (gameState == 1){
            System.out.println("Player 1 wins!");
        }

        else{
            System.out.println("Player 2 wins!");
        }

    }//end of main method

}//end of class Main
