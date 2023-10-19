public class Warrior extends Personnage {
    public Warrior(String type,String name) {
        this.setName(name);
        this.setType(type);
        this.setPlayerPos(1);
        this.setLife(10);
        this.setStrength(10);
        this.setOffensiveItem(new Weapon("arme"));
        this.setDefensiveItem(new Shield("bouclier"));
    }
}
