package personnage;

import equipementDefensif.EquipementDefensif;
import equipementOffensif.EquipementOffensif;

public abstract class Personnage {
    private String type;
    private String name;
    private int life;
    private int strength;
    private EquipementOffensif offensiveItem;
    private EquipementDefensif defensiveItem;
//    private int playerPos;

    protected Personnage(String type, String name) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", life=" + life +
                ", strength=" + strength +
                ", offensiveItem=" + offensiveItem +
                ", defensiveItem=" + defensiveItem +
//                ", playerPos=" + playerPos +
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

//    public int getPlayerPos() {
//        return playerPos;
//    }
//
//    public void setPlayerPos(int playerPos) {
//        this.playerPos = playerPos;
//    }
}

