package main;

import personnage.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Game {
    private Scanner keyboard;
    private Plateau board;
    private De dice;
    private PauseMenu pauseMenu;
    private GameState result;

    public Game(BDD_CRUD db) {
        keyboard = new Scanner(System.in);
        board = new Plateau();
        dice = new De();
        pauseMenu = new PauseMenu(db);
        result = GameState.continu;
        System.out.println(ANSI_RED + "Write pause anytime to access pause menu" + ANSI_RESET);
        System.out.println("Player en position : " + (board.getPlayerPos() + 1));
    }

    public GameState playGame(Personnage player) throws PersonnageHorsPlateauException, SQLException {

        while (board.getPlayerPos() < 63 && result != GameState.gameover && result != GameState.exit) {
            System.out.print("Press enter to play (or write pause): ");
            if (keyboard.nextLine().equals("pause")) {
                return pauseMenu.launchPauseMenu(player);
            } else {
                this.movePlayer(player);
                result = board.getInitBoard().get(board.getPlayerPos()).interaction(player);
                if (result == GameState.enemyDies) {
                    board.deleteEnemy();
                }
            }
        }
        return GameState.continu;
    }

    public void movePlayer(Personnage player) throws PersonnageHorsPlateauException {
        dice.lancerDe();
        board.setPlayerPos(board.getPlayerPos() + dice.getDiceResult());
        if (board.getPlayerPos() >= 63) {
            throw new PersonnageHorsPlateauException(player);
        }
        System.out.println("Player en position : " + (board.getPlayerPos() + 1));
    }

    public void fuite() {
        dice.lancerDe();
        board.setPlayerPos(board.getPlayerPos() - dice.getDiceResult());
        if (board.getPlayerPos() < 0) {
            board.setPlayerPos(0);
        }
        System.out.println("Player en position : " + (board.getPlayerPos() + 1));
    }

    public GameState getResult() {
        return result;
    }

    public void setResult(GameState result) {
        this.result = result;
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
}
