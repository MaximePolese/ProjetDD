package main;

import personnage.*;

import java.util.Scanner;

public class Menu {
    private Scanner clavier = new Scanner(System.in);
    private int menuChoice = 0;
    private String newPlayer;
    private String startGame;
    private String exitGame = "no";
    private Personnage p1;
    private Personnage savePlayer;

    public void launchMenu() {
        System.out.println(Game.ANSI_RED + "Donjons & Dragons" + Game.ANSI_RESET);
        this.mainMenu();
        while (!this.exitGame.equals("yes")) {
            if (this.menuChoice == 1) {
                this.addNewPlayer();
            } else if (this.menuChoice == 2) {
                if (this.p1 == null) {
                    System.out.println("First, you have to create new player ! back to menu ......");
                    this.mainMenu();
                } else {
                    modifyPlayer();
                    System.out.println("Your player is modified! back to menu ......");
                    this.mainMenu();
                }
            } else if (this.menuChoice == 3) {
                this.startNewGame();
            } else if (this.menuChoice == 4) {
                this.exitGame();
            }
        }
    }

    public void mainMenu() {
        menuChoice = 0;
        while (menuChoice < 1 || menuChoice > 4) {
            System.out.println("1 - New player");
            System.out.println("2 - Modify player");
            System.out.println("3 - Start new game");
            System.out.println("4 - Exit game");
            System.out.print("Enter your choice : ");
            menuChoice = clavier.nextInt();
            clavier.nextLine();
            if (menuChoice < 1 || menuChoice > 4){
                System.out.println("Select a right number ...");
            }
        }
    }

    public void addNewPlayer() {
        System.out.print("Create a new player ? yes/no ");
        newPlayer = clavier.nextLine();
        if (this.newPlayer.equals("yes")) {
            System.out.print("Enter type : ");
            String type = clavier.nextLine();
            System.out.print("Enter name : ");
            String name = clavier.nextLine();
            newPlayer(type, name);
            System.out.println(Game.ANSI_GREEN + p1 + Game.ANSI_RESET);
        } else if (this.newPlayer.equals("no")) {
            this.mainMenu();
        }
    }

    public void modifyPlayer() {
        System.out.print("Modify type : ");
        String type = clavier.nextLine();
        System.out.print("Modify name : ");
        String name = clavier.nextLine();
        newPlayer(type, name);
        System.out.println(Game.ANSI_GREEN + p1 + Game.ANSI_RESET);
    }

    public void newPlayer(String type, String name) {
        if (type.equals("guerrier")) {
            p1 = new Warrior(type, name);
        } else if (type.equals("magicien")) {
            p1 = new Wizard(type, name);
        }
    }

    public void resetPlayer(Personnage player) {
        if (player instanceof Warrior guerrier) {
            savePlayer = new Warrior(guerrier.getType(), guerrier.getName());
        } else if (player instanceof Wizard magicien) {
            savePlayer = new Wizard(magicien.getType(), magicien.getName());
        }
    }

    public void startNewGame() {
        System.out.print("Start new game ? yes/no ");
        startGame = clavier.nextLine();
        if (this.startGame.equals("yes")) {
            if (this.p1 == null) {
                p1 = new Warrior("guerrier", "player 1");
            }
            resetPlayer(p1);
            System.out.println(Game.ANSI_GREEN + savePlayer + Game.ANSI_RESET);
            Game newGame = new Game(savePlayer);
        } else if (this.startGame.equals("no")) {
            this.mainMenu();
        }
    }

    public void exitGame() {
        System.out.print("Exit game ? yes/no ");
        exitGame = clavier.nextLine();
        if (this.exitGame.equals("no")) {
            this.mainMenu();
        }
    }
}

