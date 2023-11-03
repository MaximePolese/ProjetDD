package main;

import personnage.*;
import equipementOffensif.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Game {
    private Scanner keyboard = new Scanner(System.in);
    private int pauseChoice = 0;
    public GameState result = GameState.continu;
    private BDD_CRUD mydb;

    public Game(Personnage player, BDD_CRUD db) {
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
}
