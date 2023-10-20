package main;

import personnage.Personnage;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    private int[] gameBoard;
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
//        ArrayList<Case> board = new ArrayList<Case>();
//        board.add();
//        board.add();
//        board.add();
//        board.add();
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

    public void lancerDe() {
        Scanner enter = new Scanner(System.in);
        System.out.print("Press enter to play : ");
        if (enter.hasNextLine()) {
            dice = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
            System.out.println("Dice result : " + dice);
        }
    }

    public void movePlayer() {
        playerPos = playerPos + dice;
        System.out.println("Player en position : " + playerPos);
    }

    public void playGame(Personnage player) throws PersonnageHorsPlateauException {
        while (player.getPlayerPos() < 64) {
            this.lancerDe();
            this.movePlayer();
            if (playerPos >= 64) {
                throw new PersonnageHorsPlateauException();
            }
        }
    }
}
