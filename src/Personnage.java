public class Personnage {
    private String type;
    private String name;
    private int life;
    private int strength;
    private EquipementOffensif weapon;

    public Personnage(String type, String name) {
        this.name = name;
        this.type = type;
        this.initPlayer();
    }

    public Personnage(String name) {
        this("guerrier", name);
    }

    public Personnage() {
        this("guerrier", "player 1");
    }

    public void initPlayer() {
        if (this.type.equals("guerrier")) {
            this.life = 10;
            this.strength = 10;
            this.weapon = new EquipementOffensif("arme");
        } else if (this.type.equals("magicien")) {
            this.life = 6;
            this.strength = 15;
        }
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", life=" + life +
                ", strength=" + strength +
                '}';
    }
}

