import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.print("Enter type : ");
        String type = clavier.nextLine();
        System.out.print("Enter name : ");
        String name = clavier.nextLine();
        Personnage P1 = new Personnage(type, name);
        clavier.close();
        System.out.println(P1);
    }
}
