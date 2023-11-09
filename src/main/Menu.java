package main;

import personnage.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    private Scanner keyboard;
    private BDD_CRUD mydb;
    private int menuChoice;
    private String exitGame;
    private Personnage p1;
    private Personnage tempPlayer;
    private Game newGame;

    public Menu() {
        keyboard = new Scanner(System.in);
        mydb = new BDD_CRUD();
        menuChoice = 0;
        exitGame = "n";
    }

    public void launchMenu() throws SQLException {
        while (!this.exitGame.equals("y")) {
            this.mainMenu();
            if (this.menuChoice == 1) {
                this.createNewPlayer();
            } else if (this.menuChoice == 2) {
                if (this.p1 == null) {
                    System.out.println("First, you have to create new player ! back to menu ......");
                    menuChoice = 0;
                } else {
                    this.modifyPlayer(p1);
                }
            } else if (this.menuChoice == 3) {
                this.startNewGame();
            } else if (this.menuChoice == 4) {
                this.continuGame();
            } else if (this.menuChoice == 5) {
                this.exitGame();
            }
        }
    }

    public void mainMenu() {
        while (menuChoice < 1 || menuChoice > 5) {
            System.out.println(Game.ANSI_RED +
                    "    ,---,                                                                                      ,---,                                                                    \n" +
                    "  .'  .' `\\                                                                                  .'  .' `\\                                                                  \n" +
                    ",---.'     \\    ,---.        ,---,   .--.   ,---.        ,---,                             ,---.'     \\   __  ,-.                        ,---.        ,---,             \n" +
                    "|   |  .`\\  |  '   ,'\\   ,-+-. /  |.--,`|  '   ,'\\   ,-+-. /  | .--.--.                    |   |  .`\\  |,' ,'/ /|            ,----._,.  '   ,'\\   ,-+-. /  | .--.--.    \n" +
                    ":   : |  '  | /   /   | ,--.'|'   ||  |.  /   /   | ,--.'|'   |/  /    '                   :   : |  '  |'  | |' | ,--.--.   /   /  ' / /   /   | ,--.'|'   |/  /    '   \n" +
                    "|   ' '  ;  :.   ; ,. :|   |  ,\"' |'--`_ .   ; ,. :|   |  ,\"' |  :  /`./                   |   ' '  ;  :|  |   ,'/       \\ |   :     |.   ; ,. :|   |  ,\"' |  :  /`./   \n" +
                    "'   | ;  .  |'   | |: :|   | /  | |,--,'|'   | |: :|   | /  | |  :  ;_                     '   | ;  .  |'  :  / .--.  .-. ||   | .\\  .'   | |: :|   | /  | |  :  ;_     \n" +
                    "|   | :  |  ''   | .; :|   | |  | ||  | ''   | .; :|   | |  | |\\  \\    `.                  |   | :  |  '|  | '   \\__\\/: . ..   ; ';  |'   | .; :|   | |  | |\\  \\    `.  \n" +
                    "'   : | /  ; |   :    ||   | |  |/ :  | ||   :    ||   | |  |/  `----.   \\                 '   : | /  ; ;  : |   ,\" .--.; |'   .   . ||   :    ||   | |  |/  `----.   \\ \n" +
                    "|   | '` ,/   \\   \\  / |   | |--'__|  : ' \\   \\  / |   | |--'  /  /`--'  /                 |   | '` ,/  |  , ;  /  /  ,.  | `---`-'| | \\   \\  / |   | |--'  /  /`--'  / \n" +
                    ";   :  .'      `----'  |   |/  .'__/\\_: |  `----'  |   |/     '--'.     /        &         ;   :  .'     ---'  ;  :   .'   \\.'__/\\_: |  `----'  |   |/     '--'.     /  \n" +
                    "|   ,.'                '---'   |   :    :          '---'        `--'---'                   |   ,.'             |  ,     .-./|   :    :          '---'        `--'---'   \n" +
                    "'---'                           \\   \\  /                                                   '---'                `--`---'     \\   \\  /                                   \n" +
                    "                                 `--`-'                                                                                       `--`-'                                    \n" + Game.ANSI_RESET);
            System.out.println("1 - New player");
            System.out.println("2 - Modify player");
            System.out.println("3 - Start new game");
            System.out.println("4 - Load last game");
            System.out.println("5 - Exit game");
            System.out.print("Enter your choice : ");
            menuChoice = keyboard.nextInt();
            keyboard.nextLine();
            if (menuChoice < 1 || menuChoice > 5) {
                System.out.println("Select a right number ...");
            }
        }
    }

    public void createNewPlayer() throws SQLException {
        System.out.print("Enter type (guerrier/magicien) : ");
        String type = keyboard.nextLine();
        System.out.print("Enter name : ");
        String name = keyboard.nextLine();
        if (type.equals("guerrier")) {
            p1 = new Warrior(type, name);
        } else if (type.equals("magicien")) {
            p1 = new Wizard(type, name);
        }
        mydb.createHero(p1);
        System.out.println(Game.ANSI_GREEN + p1 + Game.ANSI_RESET);
        System.out.println("Your player is created ! back to menu ......");
        menuChoice = 0;
    }

    public void modifyPlayer(Personnage player) throws SQLException {
        System.out.print("Modify type (guerrier/magicien) : ");
        String type = keyboard.nextLine();
        System.out.print("Modify name : ");
        String name = keyboard.nextLine();
        if (type.equals("guerrier")) {
            tempPlayer = new Warrior(type, name);
        } else if (type.equals("magicien")) {
            tempPlayer = new Wizard(type, name);
        }
        tempPlayer.setId(player.getId());
        mydb.updatePlayer(tempPlayer);
        p1 = tempPlayer;
        System.out.println(Game.ANSI_GREEN + p1 + Game.ANSI_RESET);
        System.out.println("Your player is modified! back to menu ......");
        menuChoice = 0;
    }

    public void resetPlayer(Personnage player) throws SQLException {
        if (player instanceof Warrior guerrier) {
            tempPlayer = new Warrior(guerrier.getType(), guerrier.getName());
        } else {
            tempPlayer = new Wizard(player.getType(), player.getName());
        }
        tempPlayer.setId(player.getId());
        mydb.updatePlayer(tempPlayer);
        p1 = tempPlayer;
    }

    public void startNewGame() {
        System.out.print("Start new game ? y/n ");
        String startGame = keyboard.nextLine();
        if (startGame.equals("y")) {
            if (this.p1 == null) {
                p1 = new Warrior("guerrier", "player 1");
                try {
                    mydb.createHero(p1);
                } catch (SQLException e) {
                    System.out.println("impossible to save hero");
                }
            }
            System.out.println(Game.ANSI_GREEN + p1 + Game.ANSI_RESET);
            newGame = new Game(mydb, p1);
            try {
                newGame.setResult(newGame.playGame(p1));
            } catch (PersonnageHorsPlateauException | SQLException e1) {
                System.out.println(e1.getMessage());
                newGame.setResult(GameState.win);
            }
            try {
                resetPlayer(p1);
            } catch (SQLException e) {
                System.out.println("impossible to reset hero");
            }
            if (newGame.getResult() == GameState.exit) {
                menuChoice = 0;
            }
        } else if (startGame.equals("n")) {
            menuChoice = 0;
        }
    }

    public void continuGame() {
        System.out.print("Load last game ? y/n ");
        String loadGame = keyboard.nextLine();
        if (loadGame.equals("y")) {
            System.out.println(Game.ANSI_GREEN + p1 + Game.ANSI_RESET);
            System.out.println("en cours de conception");
        } else if (loadGame.equals("n")) {
            menuChoice = 0;
        }
    }

    public void exitGame() {
        System.out.print("Exit game ? y/n ");
        exitGame = keyboard.nextLine();
        if (this.exitGame.equals("n")) {
            menuChoice = 0;
        }
    }
}

