
//contains methods to create and manipulate the game board
public class Board {


    public static String[][] board = new String[14][13]; //creates the gameboard with rows 12 and 11. Playable area is 3-8 row and 3-9 column

    //initialize the board with empty spaces instead of "null"
    public static void initializeBoard() {

        for (int row = 3; row <= 8; row++){
            for (int column = 3; column <= 9; column++) {
                board[row][column] = "   ";
            }
        }
    }


    //print out the game board(row 3-8 and column 3-9)
    public static void printBoard(){

        System.out.println();
        System.out.println();
        System.out.println("  1   2   3   4   5   6   7"); //print column labels

        //print string array
        for(int row = 3; row<=8; row++){
            System.out.print("|"); //left divider
            for(int column = 3; column<=9; column++){
                System.out.print(board[row][column]); //print array value
                System.out.print("|"); //right divider
            }
            //At the end of each row, print a border between this row and the next
            System.out.println();
            System.out.println("-----------------------------");

        }

    }


    public static boolean checkWin(int row, int col){

        boolean win = false;

        //check vertically(DONE)
        if((board[row][col].equals(" X ") || board[row][col].equals(" O ")) && (
                (board[row][col].equals(board[row+1][col]) && board[row][col].equals(board[row+2][col]) && board[row][col].equals(board[row+3][col]) ) ||
                (board[row][col].equals(board[row+1][col]) && board[row][col].equals(board[row+2][col]) && board[row][col].equals(board[row-1][col])) ||
                (board[row][col].equals(board[row+1][col]) && board[row][col].equals(board[row-2][col]) && board[row][col].equals(board[row-1][col])) ||
                (board[row][col].equals(board[row-3][col]) && board[row][col].equals(board[row-2][col]) && board[row][col].equals(board[row-1][col])) ||

                //check horizontally(DONE)
                (board[row][col].equals(board[row][col+1]) && board[row][col].equals(board[row][col+2]) && board[row][col].equals(board[row][col+3]) ) ||
                (board[row][col].equals(board[row][col+1]) && board[row][col].equals(board[row][col+2]) && board[row][col].equals(board[row][col-1]) ) ||
                (board[row][col].equals(board[row][col+1]) && board[row][col].equals(board[row][col-2]) && board[row][col].equals(board[row][col-1]) ) ||
                (board[row][col].equals(board[row][col-3]) && board[row][col].equals(board[row][col-2]) && board[row][col].equals(board[row][col-1]) ) ||

                //check diagonally, top left to bottom right (DONE)
                (board[row][col].equals(board[row+1][col+1]) && board[row][col].equals(board[row+2][col+2]) && board[row][col].equals(board[row+3][col+3]) ) ||
                (board[row][col].equals(board[row+1][col+1]) && board[row][col].equals(board[row+2][col+2]) && board[row][col].equals(board[row-1][col-1]) ) ||
                (board[row][col].equals(board[row+1][col+1]) && board[row][col].equals(board[row-2][col-2]) && board[row][col].equals(board[row-1][col-1]) ) ||
                (board[row][col].equals(board[row-3][col-3]) && board[row][col].equals(board[row-2][col-2]) && board[row][col].equals(board[row-1][col-1]) ) ||

                //check diagonally, bottom left to top right (DONE)
                (board[row][col].equals(board[row+1][col-1]) && board[row][col].equals(board[row+2][col-2]) && board[row][col].equals(board[row+3][col-3]) ) ||
                (board[row][col].equals(board[row+1][col-1]) && board[row][col].equals(board[row+2][col-2]) && board[row][col].equals(board[row-1][col+1]) ) ||
                (board[row][col].equals(board[row+1][col-1]) && board[row][col].equals(board[row-2][col+2]) && board[row][col].equals(board[row-1][col+1]) ) ||
                (board[row][col].equals(board[row-3][col+3]) && board[row][col].equals(board[row-2][col+2]) && board[row][col].equals(board[row-1][col+1]) ))

                ){
            win = true;
        }

        return win;
    }

}
