package main;

import personnage.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Game {
    private Scanner keyboard;
    private BDD_CRUD mydb;
    private Plateau board;
    private De dice;
    public GameState result;
    private int pauseChoice;

    public Game(Personnage player, BDD_CRUD db) {
        keyboard = new Scanner(System.in);
        mydb = db;
        board = new Plateau();
        dice = new De();
        result = GameState.continu;
        pauseChoice = 0;
        try {
            result = this.playGame(player);
        } catch (PersonnageHorsPlateauException | SQLException e1) {
            System.out.println(e1.getMessage());
        }
    }

    public GameState playGame(Personnage player) throws PersonnageHorsPlateauException, SQLException {
        while (board.getPlayerPos() < 63 && result != GameState.gameover && result != GameState.exit) {
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
                dice.lancerDe();
                this.movePlayer(player);
                result = board.getPlayerPos().interaction(player);
                if (result == GameState.enemyDies) {
                    this.deleteEnemy();
                }
            }
        }
        return GameState.continu;
    }

    public void movePlayer(Personnage player) throws PersonnageHorsPlateauException {
        board.setPlayerPos(board.getPlayerPos() + dice.getDiceResult());
        if (board.getPlayerPos() >= 63) {
            throw new PersonnageHorsPlateauException(player);
        }
        System.out.println("Player en position : " + (board.getPlayerPos() + 1));
    }

    public void fuite(Personnage player) {
        dice.lancerDe();
        board.setPlayerPos(board.getPlayerPos() - dice.getDiceResult());
        if (board.getPlayerPos() < 0) {
            board.setPlayerPos(0);
        }
        System.out.println("Player en position : " + (board.getPlayerPos() + 1));
    }

    public void deleteEnemy() {
        board.setInitBoard(board.getPlayerPos(), new CaseVide());
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

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
}
