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
        this.manualInitBoard();
        this.initPlayer();
        try {
            this.playGame(player);
        } catch (PersonnageHorsPlateauException e) {
            System.out.println(player.getName() + " Win !!!");
        }
    }
    public void randomInitBoard() {
        board = new ArrayList<Case>();
        for (int i = 0; i < 64; i++) {

            System.out.println(i + " " + board.get(i));
        }
        System.out.println(" ");
    }
    public void manualInitBoard() {
        board = new ArrayList<Case>();
        for (int i = 0; i < 64; i++) {
            switch (i) {
                case 45, 52, 56, 62:
                    board.add(new Dragon());
                    break;
                case 10, 20, 25, 32, 36, 37, 40, 44, 47:
                    board.add(new Sorcier());
                    break;
                case 3, 6, 9, 12, 15, 18, 21, 24, 27, 30:
                    board.add(new Gobelin());
                    break;
                case 2, 5, 11, 22, 38:
                    board.add(new Massue());
                    break;
                case 19, 26, 42, 53:
                    board.add(new Epee());
                    break;
                case 1, 4, 8, 17, 23:
                    board.add(new Eclair());
                    break;
                case 48, 49:
                    board.add(new BouleDeFeu());
                    break;
                case 7, 13, 31, 33, 39, 43:
                    board.add(new SmallPotion());
                    break;
                case 28, 41:
                    board.add(new BigPotion());
                    break;
                default:
                    board.add(new CaseVide());
                    break;
            }
            System.out.println(i + " " + board.get(i));
        }
        System.out.println(" ");
    }

    public void initPlayer() {
        playerPos = 0;
        System.out.println("Player en position : " + (playerPos + 1));
    }

    public void lancerDe() {
        Scanner enter = new Scanner(System.in);
        System.out.print("Press enter to play : ");
        if (enter.hasNextLine()) {
            dice = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
//            dice = 1;
            System.out.println("Dice result : " + dice);
        }
    }

    public void movePlayer() throws PersonnageHorsPlateauException {
        playerPos = playerPos + dice;
        if (playerPos > 63) {
            throw new PersonnageHorsPlateauException();
        }
        System.out.println("Player en position : " + (playerPos + 1));
    }

    public void playGame(Personnage player) throws PersonnageHorsPlateauException {
        while (playerPos <= 63) {
            this.lancerDe();
            try {
                this.movePlayer();
            } catch (PersonnageHorsPlateauException e) {
                throw e;
            }
            board.get(playerPos).interaction(player);
        }
    }
}
