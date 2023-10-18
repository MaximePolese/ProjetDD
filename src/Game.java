public class Game {
    private int[] gameBoard;

    public Game(){
        this.initBoard();
    }

    public void initBoard(){
        for (int i = 0; i < 64; i++){
            this.gameBoard[i] = i + 1;
        }
    }
}
