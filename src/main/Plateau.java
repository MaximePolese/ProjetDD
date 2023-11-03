package main;

import equipementOffensif.*;
import personnage.*;

import java.util.ArrayList;

public class Plateau {
    private ArrayList<Case> initBoard;
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
        initBoard = new ArrayList<Case>();
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
        this.randomInitBoard();
        playerPos = 0;
    }

    public void randomInitBoard() {
        initBoard.add(new CaseVide());
        System.out.println(Game.ANSI_BLUE + "0 " + initBoard.get(0));
        for (int i = 1; i < 64; i++) {
            caseRemplie = false;
            while (!caseRemplie) {
                random = (int) Math.floor(Math.random() * (10 - 1 + 1) + 1);
                if (random == 1 && dragon < 4) {
                    initBoard.add(new Dragon());
                    dragon++;
                    caseRemplie = true;
                } else if (random == 2 && sorcier < 10) {
                    initBoard.add(new Sorcier());
                    sorcier++;
                    caseRemplie = true;
                } else if (random == 3 && gobelin < 10) {
                    initBoard.add(new Gobelin());
                    gobelin++;
                    caseRemplie = true;
                } else if (random == 4 && massue < 5) {
                    initBoard.add(new Massue());
                    massue++;
                    caseRemplie = true;
                } else if (random == 5 && epee < 4) {
                    initBoard.add(new Epee());
                    epee++;
                    caseRemplie = true;
                } else if (random == 6 && eclair < 5) {
                    initBoard.add(new Eclair());
                    eclair++;
                    caseRemplie = true;
                } else if (random == 7 && bouleDeFeu < 2) {
                    initBoard.add(new BouleDeFeu());
                    bouleDeFeu++;
                    caseRemplie = true;
                } else if (random == 8 && smallPotion < 6) {
                    initBoard.add(new SmallPotion());
                    smallPotion++;
                    caseRemplie = true;
                } else if (random == 9 && bigPotion < 2) {
                    initBoard.add(new BigPotion());
                    bigPotion++;
                    caseRemplie = true;
                } else if (random == 10 && caseVide < 16) {
                    initBoard.add(new CaseVide());
                    caseVide++;
                    caseRemplie = true;
                }
            }
            System.out.println(Game.ANSI_BLUE + i + " " + initBoard.get(i) + Game.ANSI_RESET);
        }
    }

    public void deleteEnemy() {
        initBoard.set(playerPos, new CaseVide());
    }

    public int getPlayerPos() {
        return playerPos;
    }

    public void setPlayerPos(int playerPos) {
        this.playerPos = playerPos;
    }

    public ArrayList<Case> getInitBoard() {
        return initBoard;
    }
}