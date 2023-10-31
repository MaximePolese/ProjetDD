package main;

import personnage.*;
import equipementOffensif.*;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    private ArrayList<Case> board;
    private int dice;
    private Scanner keyboard = new Scanner(System.in);
    private int pauseChoice = 0;
    public GameState result = GameState.continu;
    private BDD_CRUD mydb;

    public Game(Personnage player, BDD_CRUD db) {
//      this.manualInitBoard();
        mydb = db;
        this.randomInitBoard();
        System.out.println(ANSI_RED + "Write pause anytime to access pause menu" + ANSI_RESET);
        this.initPlayer(player);
        try {
            result = this.playGame(player);
        } catch (PersonnageHorsPlateauException | SQLException e1) {
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
    }

    public void initPlayer(Personnage player) {
        player.setPlayerPos(0);
        System.out.println("Player en position : " + (player.getPlayerPos() + 1));
    }

    public void lancerDe() {
        dice = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
        System.out.println("Dice result : " + dice);
    }

    public void movePlayer(Personnage player) throws PersonnageHorsPlateauException {
        player.setPlayerPos(player.getPlayerPos() + dice);
        if (player.getPlayerPos() >= 63) {
            throw new PersonnageHorsPlateauException(player);
        }
        System.out.println("Player en position : " + (player.getPlayerPos() + 1));
    }

    public GameState playGame(Personnage player) throws PersonnageHorsPlateauException, SQLException {
        while (player.getPlayerPos() < 63 && result != GameState.gameover && result != GameState.exit) {
            System.out.print("Press enter to play (or write pause): ");
            if (keyboard.nextLine().equals("pause")) {
                while (this.pauseChoice == 0) {
                    this.pauseMenu();
                    if (this.pauseChoice == 1) {
                        this.playerStatus(player);
                    } else if (this.pauseChoice == 2) {
                        this.resumeGame();
                    } else if (this.pauseChoice == 3) {
                        return GameState.exit;
                    }
                }
                pauseChoice = 0;
            } else {
                this.lancerDe();
                this.movePlayer(player);
                result = board.get(player.getPlayerPos()).interaction(player);
                if (result == GameState.enemyDies) {
                    this.deleteEnemy(player);
                }
            }
        }
        return GameState.continu;
    }

    public void pauseMenu() {
        while (pauseChoice < 1 || pauseChoice > 3) {
            System.out.println("________ PAUSE ________");
            System.out.println("1 - Player's status");
            System.out.println("2 - Resume game");
            System.out.println("3 - Exit to main menu");
            System.out.print("Enter your choice : ");
            pauseChoice = keyboard.nextInt();
            keyboard.nextLine();
            if (pauseChoice < 1 || pauseChoice > 3) {
                System.out.println("Select a right number ...");
            }
        }
    }

    public void playerStatus(Personnage player) throws SQLException {
        mydb.getHeroes();
        System.out.println(ANSI_GREEN + player + ANSI_RESET);
        pauseChoice = 0;
    }

    public void resumeGame() {
        System.out.println("LET'S GO !");
    }

    public void deleteEnemy(Personnage player) {
        board.set(player.getPlayerPos(), new CaseVide());
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";

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

}
