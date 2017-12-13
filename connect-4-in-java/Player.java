public class Player {


    private String symbol;
    private int currentDiskRow;
    private int currentDiskCol;

    public int getCurrentDiskRow(){
        return currentDiskRow;
    }
    public int getCurrentDiskCol(){
        return currentDiskCol;
    }


    public Player(String symbol){
        this.symbol = symbol;
    }

    //Drop a disk into the selected column and return whether it was possible
    public boolean dropDisk(int col){
        boolean diskDropped = false;
        col = col+ 2; //convert column into array index

        //in that column, move up the rows, drop disk if that array spot is empty
        for(int row = 8; row >= 3; row--){
            if(Board.board[row][col].equals("   ")){
                Board.board[row][col] = " " + this.symbol + " ";
                this.currentDiskRow = row;
                this.currentDiskCol = col;
                diskDropped = true;
                System.out.println("Dropped disk");
                break;
            }
        }

        return diskDropped;
    }

}
