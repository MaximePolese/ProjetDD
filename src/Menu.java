import java.util.Scanner;

public class Menu {
    private String newPlayer;
    private String exitGame = "no";
    private String startGame;

    public Menu() {
        System.out.println("Donjons & Dragons");
        while (!this.exitGame.equals("yes")) {
            Scanner clavier = new Scanner(System.in);
            System.out.print("Create a new player ? yes/no ");
            newPlayer = clavier.nextLine();
            if (this.newPlayer.equals("yes")) {
                System.out.print("Enter type : ");
                String type = clavier.nextLine();
                System.out.print("Enter name : ");
                String name = clavier.nextLine();
                Personnage P1 = new Personnage(type, name);
                System.out.println(P1);
            } else if (this.newPlayer.equals("no")) {
                System.out.print("Start game ? yes/no ");
                startGame = clavier.nextLine();
                if (this.startGame.equals("yes")) {
                    Game newGame = new Game();
                } else if (this.startGame.equals("no")) {
                    System.out.print("Exit game ? yes/no ");
                    exitGame = clavier.nextLine();
                }
            }
//            clavier.close();
        }
    }
}

