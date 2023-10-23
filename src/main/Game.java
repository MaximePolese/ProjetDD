package main;

import personnage.*;
import equipementOffensif.*;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {
//    private int[] gameBoard;

    private ArrayList<Case> board;
    private int dice;
    private int playerPos;

    public Game(Personnage player) {
        this.initBoard();
        this.initPlayer();
        try {
            this.playGame(player);
        } catch (PersonnageHorsPlateauException e) {
            System.out.println(player.getName() + " Win !!!");
        }
    }

    public void initBoard() {
        board = new ArrayList<Case>();
        board.add(new CaseVide());
        board.add(new Gobelin());
        board.add(new Epee());
        board.add(new SmallPotion());
        System.out.print(board);
//        gameBoard = new int[64];
//        for (int i = 0; i < gameBoard.length; i++) {
//            gameBoard[i] = i + 1;
//            System.out.print(gameBoard[i] + " ");
//        }
        System.out.println(" ");
    }

    public void initPlayer() {
        playerPos = 1;
        System.out.println("Player en position : " + playerPos);
    }

    public void lancerDe() {
        Scanner enter = new Scanner(System.in);
        System.out.print("Press enter to play : ");
        if (enter.hasNextLine()) {
//            dice = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
            dice = 1;
            System.out.println("Dice result : " + dice);
        }
    }

    public void movePlayer() throws PersonnageHorsPlateauException{
        playerPos = playerPos + dice;
        if (playerPos > 4) {
            throw new PersonnageHorsPlateauException();
        }
        System.out.println("Player en position : " + playerPos);
    }

    public void playGame(Personnage player) throws PersonnageHorsPlateauException {
        while (playerPos <= 4) {
            this.lancerDe();
            try {
                this.movePlayer();
            }
            catch (PersonnageHorsPlateauException e){
                throw e;
            }
            board.get(playerPos-1).interaction();
        }
    }
}
