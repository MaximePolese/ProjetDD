package main;

import personnage.*;
import equipementOffensif.*;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    private ArrayList<Case> board;
    private int dice;

    public Game(Personnage player) {
//        this.manualInitBoard();
        this.randomInitBoard();
        this.initPlayer(player);
        try {
            this.playGame(player);
        } catch (PersonnageHorsPlateauException e1) {
            System.out.println(e1.getMessage());
        }
    }

    public void randomInitBoard() {
        board = new ArrayList<Case>();
        int dragon = 0;
        int sorcier = 0;
        int gobelin = 0;
        int massue = 0;
        int epee = 0;
        int eclair = 0;
        int bouleDeFeu = 0;
        int smallPotion = 0;
        int bigPotion = 0;
        int caseVide = 0;
        int random;
        boolean caseRemplie;

        board.add(new CaseVide());
        System.out.println(ANSI_BLUE + "0 " + board.get(0));
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
            System.out.println(ANSI_BLUE + i + " " + board.get(i));
        }
        System.out.println(" " + ANSI_RESET);
    }

//    public void manualInitBoard() {
//        board = new ArrayList<Case>();
//        for (int i = 0; i < 64; i++) {
//            switch (i) {
//                case 45, 52, 56, 62:
//                    board.add(new Dragon());
//                    break;
//                case 10, 20, 25, 32, 36, 37, 40, 44, 47:
//                    board.add(new Sorcier());
//                    break;
//                case 3, 6, 9, 12, 15, 18, 21, 24, 27, 30:
//                    board.add(new Sorcier());
//                    break;
//                case 2, 5, 11, 22, 38:
//                    board.add(new Massue());
//                    break;
//                case 19, 26, 42, 53:
//                    board.add(new Epee());
//                    break;
//                case 1, 4, 8, 17, 23:
//                    board.add(new Eclair());
//                    break;
//                case 48, 49:
//                    board.add(new BouleDeFeu());
//                    break;
//                case 7, 13, 31, 33, 39, 43:
//                    board.add(new SmallPotion());
//                    break;
//                case 28, 41:
//                    board.add(new BigPotion());
//                    break;
//                default:
//                    board.add(new CaseVide());
//                    break;
//            }
//            System.out.println(i + " " + board.get(i));
//        }
//        System.out.println(" ");
//    }

    public void initPlayer(Personnage player) {
        player.setPlayerPos(0);
        System.out.println("Player en position : " + (player.getPlayerPos() + 1));
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

    public void movePlayer(Personnage player) throws PersonnageHorsPlateauException {
        player.setPlayerPos(player.getPlayerPos() + dice);
        if (player.getPlayerPos() > 63) {
            throw new PersonnageHorsPlateauException(player);
        }
        System.out.println("Player en position : " + (player.getPlayerPos() + 1));
    }

    public void playGame(Personnage player) throws PersonnageHorsPlateauException {
        GameState result = GameState.continu;
        while (player.getPlayerPos() <= 63 && result != GameState.gameover) {
            this.lancerDe();
            this.movePlayer(player);
            result = board.get(player.getPlayerPos()).interaction(player);
            if (result == GameState.enemyDies) {
                this.deleteEnemy(player);
            }

//            if spacebar {
//              this.showMenu();
//              this.stat();
//              this.exit();
//            }
        }
    }

    public void deleteEnemy(Personnage player) {
        board.set(player.getPlayerPos(), new CaseVide());
    }

    public ArrayList<Case> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<Case> board) {
        this.board = board;
    }

    public int getDice() {
        return dice;
    }

    public void setDice(int dice) {
        this.dice = dice;
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
}
