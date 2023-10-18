import java.util.Scanner;
//import java.util.Random;

public class Game {
    private int[] gameBoard;
    private int playerPos;
    private int de;
//    private Random destin = new Random();


    public Game() {
        this.initBoard();
        this.initPlayer();
        while (playerPos < 64) {
            this.lancerDes();
            this.movePlayer();
        }
    }

    public void initBoard() {
        gameBoard = new int[64];
        for (int i = 0; i < gameBoard.length; i++) {
            gameBoard[i] = i + 1;
            System.out.print(gameBoard[i] + " ");
        }
        System.out.println(" ");
    }

    public void initPlayer() {
        playerPos = 1;
        System.out.println("Player en position : " + playerPos);
    }

    public void lancerDes() {
        Scanner enter = new Scanner(System.in);
        System.out.print("Press enter to play : ");
        if (enter.hasNextLine()) {
//            int dice= destin.ints(1, 7).findFirst().getAsInt();
            de = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
            System.out.println("Résultat dé : " + de);
        }
    }

    public void movePlayer() {
        playerPos = playerPos + de;
        System.out.println("Player en position : " + playerPos);
    }
}
