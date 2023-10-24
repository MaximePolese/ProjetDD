package personnage;

import equipementDefensif.EquipementDefensif;
import equipementOffensif.EquipementOffensif;
import equipementOffensif.Potion;
import main.Game;

import java.util.Scanner;

public abstract class Personnage {
    private String type;
    private String name;
    private int life;
    private int strength;
    private EquipementOffensif offensiveItem;
    private EquipementDefensif defensiveItem;
    private int maxLife;
    private int playerPos;

    protected Personnage(String type, String name) {
        this.name = name;
        this.type = type;
    }

    public void heals(Potion sousoupe) {
        this.life += sousoupe.getHealth();
        if (this.life > this.maxLife) {
            this.life = this.maxLife;
        }
        System.out.println("new player's life : " + this.life);
    }

    public void newItem(EquipementOffensif item) {
        if (item.getWeaponAttack() > this.getOffensiveItem().getWeaponAttack() && item.getWeaponType().equals(this.getOffensiveItem().getWeaponType())) {
            this.offensiveItem = item;
            System.out.println("new weapon : " + item.getWeaponName());
        } else {
            System.out.println("non-equipped weapon : " + item.getWeaponName());
        }
    }

    public void fight(Ennemi mechant) {
        String fuite;
        Scanner clavier = new Scanner(System.in);
        System.out.println("Do you want to run ? yes/no");
        fuite = clavier.nextLine();
        if (fuite.equals("no")) {
            while (mechant.getLife() > 0 && this.life > 0) {
                if (this.life > 0) {
                    System.out.println(this.name + " attacks");
                    mechant.setLife(mechant.getLife() - (this.strength + this.offensiveItem.getWeaponAttack()));
                    System.out.println("new enemy's life : " + mechant.getLife());
                }
                if (mechant.getLife() <= 0) {
                    System.out.println("Enemy dies");
//            board.setBoard(remove(mechant));
                } else {
                    System.out.println("Enemy attacks !");
                    this.life = this.life - mechant.getStrength();
                    System.out.println("new player's life : " + this.life);
                }
            }
        } else {

        }
    }

    @Override
    public String toString() {
        return "Personnage {" +
                "type = " + type +
                ", name = " + name +
                ", life = " + life +
                ", strength = " + strength +
                ", " + offensiveItem +
                ", " + defensiveItem +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public EquipementOffensif getOffensiveItem() {
        return offensiveItem;
    }

    public void setOffensiveItem(EquipementOffensif offensiveItem) {
        this.offensiveItem = offensiveItem;
    }

    public EquipementDefensif getDefensiveItem() {
        return defensiveItem;
    }

    public void setDefensiveItem(EquipementDefensif defensiveItem) {
        this.defensiveItem = defensiveItem;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getPlayerPos() {
        return playerPos;
    }

    public void setPlayerPos(int playerPos) {
        this.playerPos = playerPos;
    }
}

