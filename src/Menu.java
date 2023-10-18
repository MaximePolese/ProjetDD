import java.util.Scanner;

public class Menu {
    private Scanner clavier = new Scanner(System.in);
    private int menuChoice;
    private String newPlayer;
    private String startGame;
    private String exitGame = "no";

    public void launchMenu() {
        System.out.println("Donjons & Dragons");
        this.mainMenu();
        while (!this.exitGame.equals("yes")) {
            if (this.menuChoice == 1) {
                this.addNewPlayer();
            } else if (this.menuChoice == 2) {
//                p1.modifyPlayer();
            } else if (this.menuChoice == 3) {
                this.startNewGame();
            } else if (this.menuChoice == 4) {
                this.exitGame();
            }
        }
    }

    public void mainMenu() {
        System.out.println("1 - New player");
        System.out.println("2 - Modify player");
        System.out.println("3 - Start new game");
        System.out.println("4 - Exit game");
        System.out.println("Enter your choice : ");
        menuChoice = clavier.nextInt();
    }

    public void addNewPlayer() {
        System.out.print("Create a new player ? yes/no ");
        newPlayer = clavier.nextLine();
        if (this.newPlayer.equals("yes")) {
            System.out.print("Enter type : ");
            String type = clavier.nextLine();
            System.out.print("Enter name : ");
            String name = clavier.nextLine();
            Personnage p1 = new Personnage(type, name);
            System.out.println(p1);
        } else if (this.newPlayer.equals("no")) {
            this.mainMenu();
        }
    }

    public void startNewGame() {
        System.out.print("Start new game ? yes/no ");
        startGame = clavier.nextLine();
        if (this.startGame.equals("yes")) {
            Game newGame = new Game();
        } else if (this.startGame.equals("no")) {
            this.mainMenu();
        }
    }

    public void exitGame() {
        System.out.print("Exit game ? yes/no ");
        exitGame = clavier.nextLine();
    }
}

