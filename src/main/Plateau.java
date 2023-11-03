package main;

import equipementOffensif.*;
import personnage.*;

import java.util.ArrayList;

public class Plateau {
    private ArrayList<Case> board;
    int dragon;
    int sorcier;
    int gobelin;
    int massue;
    int epee;
    int eclair;
    int bouleDeFeu;
    int smallPotion;
    int bigPotion;
    int caseVide;
    int random;
    boolean caseRemplie;
    private int playerPos;

    public Plateau() {
        board = new ArrayList<Case>();
        dragon = 0;
        sorcier = 0;
        gobelin = 0;
        massue = 0;
        epee = 0;
        eclair = 0;
        bouleDeFeu = 0;
        smallPotion = 0;
        bigPotion = 0;
        caseVide = 0;
        int random;
        caseRemplie = false;

        this.randomInitBoard();
    }

    public void randomInitBoard() {
        board.add(new CaseVide());
        System.out.println(Game.ANSI_BLUE + "0 " + board.get(0));
        for (int i = 1; i < 64; i++) {
            caseRemplie = false;
            while (!caseRemplie) {
                random = (int) Math.floor(Math.random() * (10 - 1 + 1) + 1);
                if (random == 1 && dragon < 4) {
                    board.add(new Dragon());
                    dragon++;
                    caseRemplie = true;
                } else if (random == 2 && sorcier < 10) {
                    board.add(new Sorcier());
                    sorcier++;
                    caseRemplie = true;
                } else if (random == 3 && gobelin < 10) {
                    board.add(new Gobelin());
                    gobelin++;
                    caseRemplie = true;
                } else if (random == 4 && massue < 5) {
                    board.add(new Massue());
                    massue++;
                    caseRemplie = true;
                } else if (random == 5 && epee < 4) {
                    board.add(new Epee());
                    epee++;
                    caseRemplie = true;
                } else if (random == 6 && eclair < 5) {
                    board.add(new Eclair());
                    eclair++;
                    caseRemplie = true;
                } else if (random == 7 && bouleDeFeu < 2) {
                    board.add(new BouleDeFeu());
                    bouleDeFeu++;
                    caseRemplie = true;
                } else if (random == 8 && smallPotion < 6) {
                    board.add(new SmallPotion());
                    smallPotion++;
                    caseRemplie = true;
                } else if (random == 9 && bigPotion < 2) {
                    board.add(new BigPotion());
                    bigPotion++;
                    caseRemplie = true;
                } else if (random == 10 && caseVide < 16) {
                    board.add(new CaseVide());
                    caseVide++;
                    caseRemplie = true;
                }
            }
            System.out.println(Game.ANSI_BLUE + i + " " + board.get(i));
        }
    }
    public void initPlayer() {
        playerPos = 0;
        System.out.println("Player en position : " + (player.getPlayerPos() + 1));
    }
}
