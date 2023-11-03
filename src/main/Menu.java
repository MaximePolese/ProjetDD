package main;

import personnage.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    private Scanner clavier;
    private BDD_CRUD mydb;
    private int menuChoice;
    private String startGame;
    private String exitGame;
    private Personnage p1;
    private Personnage savePlayer;
    private Game newGame;

    public Menu() {
        clavier = new Scanner(System.in);
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
                    this.modifyPlayer();
                }
            } else if (this.menuChoice == 3) {
                this.startNewGame();
            } else if (this.menuChoice == 4) {
                this.exitGame();
            }
        }
    }

    public void mainMenu() {
        while (menuChoice < 1 || menuChoice > 4) {
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
            System.out.println("4 - Exit game");
            System.out.print("Enter your choice : ");
            menuChoice = clavier.nextInt();
            clavier.nextLine();
            if (menuChoice < 1 || menuChoice > 4) {
                System.out.println("Select a right number ...");
            }
        }
    }

    public void createNewPlayer() throws SQLException {
        System.out.print("Enter type (guerrier/magicien) : ");
        String type = clavier.nextLine();
        System.out.print("Enter name : ");
        String name = clavier.nextLine();
        newPlayer(type, name);
        System.out.println(Game.ANSI_GREEN + p1 + Game.ANSI_RESET);
        System.out.println("Your player is created ! back to menu ......");
        menuChoice = 0;
    }

    public void newPlayer(String type, String name) throws SQLException {
        if (type.equals("guerrier")) {
            p1 = new Warrior(type, name);
        } else if (type.equals("magicien")) {
            p1 = new Wizard(type, name);
        }
    }

    public void modifyPlayer() throws SQLException {
        System.out.print("Modify type (guerrier/magicien) : ");
        String type = clavier.nextLine();
        System.out.print("Modify name : ");
        String name = clavier.nextLine();
        newPlayer(type, name);
        System.out.println(Game.ANSI_GREEN + p1 + Game.ANSI_RESET);
        System.out.println("Your player is modified! back to menu ......");
        menuChoice = 0;
    }

    public void resetPlayer(Personnage player) throws SQLException {
        if (player instanceof Warrior guerrier) {
            savePlayer = new Warrior(guerrier.getType(), guerrier.getName());
        } else if (player instanceof Wizard magicien) {
            savePlayer = new Wizard(magicien.getType(), magicien.getName());
        }
        mydb.createHero(savePlayer);
    }

    public void startNewGame() throws SQLException {
        System.out.print("Start new game ? y/n ");
        startGame = clavier.nextLine();
        if (this.startGame.equals("y")) {
            if (this.p1 == null) {
                p1 = new Warrior("guerrier", "player 1");
            }
            resetPlayer(p1);
            System.out.println(Game.ANSI_GREEN + savePlayer + Game.ANSI_RESET);
            newGame = new Game(mydb);
            System.out.println(Game.ANSI_RED + "Write pause anytime to access pause menu" + Game.ANSI_RESET);
            try {
                newGame.setResult(newGame.playGame(savePlayer));
            } catch (PersonnageHorsPlateauException | SQLException e1) {
                System.out.println(e1.getMessage());
            }
            if (newGame.getResult() == GameState.exit) {
                menuChoice = 0;
            }
        } else if (this.startGame.equals("n")) {
            menuChoice = 0;
        }
    }

    public void exitGame() {
        System.out.print("Exit game ? y/n ");
        exitGame = clavier.nextLine();
        if (this.exitGame.equals("n")) {
            menuChoice = 0;
        }
    }
}

