package main;

import personnage.*;

import java.sql.SQLException;
import java.util.Scanner;

public class PauseMenu {
    private Scanner keyboard;
    private BDD_CRUD mydb;
    private int pauseChoice;

    public PauseMenu(BDD_CRUD db) {
        keyboard = new Scanner(System.in);
        mydb = db;
        pauseChoice = 0;
    }

    public GameState launchPauseMenu(Personnage player) throws SQLException {
        while (pauseChoice == 0) {
            this.pauseMenu();
            if (pauseChoice == 1) {
                this.playerStatus(player);
            } else if (pauseChoice == 2) {
                this.resumeGame();
            } else if (pauseChoice == 3) {
                this.saveGame(player);
            } else if (pauseChoice == 4) {
                return GameState.exit;
            }
        }
        pauseChoice = 0;
        return GameState.continu;
    }

    public void pauseMenu() {
        while (pauseChoice < 1 || pauseChoice > 4) {
            System.out.println("________ PAUSE ________");
            System.out.println("1 - Player's status");
            System.out.println("2 - Resume game");
            System.out.println("3 - Save game");
            System.out.println("4 - Exit to main menu");
            System.out.print("Enter your choice : ");
            pauseChoice = keyboard.nextInt();
            keyboard.nextLine();
            if (pauseChoice < 1 || pauseChoice > 4) {
                System.out.println("Select a right number ...");
            }
        }
    }

    public void playerStatus(Personnage player) throws SQLException {
        mydb.getHeroes();
        System.out.println(Game.ANSI_GREEN + player + Game.ANSI_RESET);
        pauseChoice = 0;
    }

    public void saveGame(Personnage player) throws SQLException {
        mydb.updatePlayer(player);
        System.out.println("Game saved ...");
        pauseChoice = 0;
    }

    public void resumeGame() {
        System.out.println("LET'S GO !");
    }
}
