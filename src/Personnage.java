import java.util.Scanner;

public class Personnage {
    private String type;
    private String name;
    private int life;
    private int strength;
    private EquipementOffensif weapon;
    private EquipementDefensif shield;
    private int playerPos;

    public Personnage(String type, String name) {
        this.name = name;
        this.type = type;
        this.playerPos = 1;
        this.newPlayer();
    }

    public void newPlayer() {
        if (this.type.equals("guerrier")) {
            this.life = 10;
            this.strength = 10;
            this.weapon = new EquipementOffensif("arme");
            this.shield = new EquipementDefensif("bouclier");
        } else if (this.type.equals("magicien")) {
            this.life = 6;
            this.strength = 15;
            this.weapon = new EquipementOffensif("sort");
            this.shield = new EquipementDefensif("philtre");
        }
    }

    public void modifyPlayer() {
        Scanner clavier = new Scanner(System.in);
        System.out.print("Modify type : ");
        this.type = clavier.nextLine();
        System.out.print("Modify name : ");
        this.name = clavier.nextLine();
        this.newPlayer();
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", life=" + life +
                ", strength=" + strength +
                ", weapon=" + weapon +
                ", shield=" + shield +
                ", playerPos=" + playerPos +
                '}';
    }

    public int getPlayerPos() {
        return playerPos;
    }

    public void setPlayerPos(int playerPos) {
        this.playerPos = playerPos;
    }
}

