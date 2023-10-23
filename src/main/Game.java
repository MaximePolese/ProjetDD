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
        for (int i = 0; i < 64; i++) {
            if (i == 45 || i == 52 || i == 56 || i == 62) {
                board.add(new Dragon());
            }
            if (i == 10 || i == 20 || i == 25 || i == 32 || i == 35 || i == 36 || i == 37 || i == 40 || i == 44 || i == 47) {
                board.add(new Sorcier());
            }
            if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18 || i == 21 || i == 24 || i == 27 || i == 30) {
                board.add(new Gobelin());
            }
            if (i == 2 || i == 11 || i == 5 || i == 22 || i == 38) {
                board.add(new Massue());
            }
            if (i == 19 || i == 26 || i == 42 || i == 53) {
                board.add(new Epee());
            }
            if (i == 1 || i == 4 || i == 8 || i == 17 || i == 23) {
                board.add(new Eclair());
            }
            if (i == 48 || i == 49) {
                board.add(new BouleDeFeu());
            }
            if (i == 7 || i == 13 || i == 31 || i == 33 || i == 39 || i == 43) {
                board.add(new SmallPotion());
            }
            if (i == 28 || i == 41) {
                board.add(new BigPotion());
            } else {
                board.add(new CaseVide());
            }
        }
        System.out.print(board);
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
//            dice = 1;
            System.out.println("Dice result : " + dice);
        }
    }

    public void movePlayer() throws PersonnageHorsPlateauException {
        playerPos = playerPos + dice;
        if (playerPos > 64) {
            throw new PersonnageHorsPlateauException();
        }
        System.out.println("Player en position : " + playerPos);
    }

    public void playGame(Personnage player) throws PersonnageHorsPlateauException {
        while (playerPos <= 64) {
            this.lancerDe();
            try {
                this.movePlayer();
            } catch (PersonnageHorsPlateauException e) {
                throw e;
            }
            board.get(playerPos - 1).interaction(player);
        }
    }
}
