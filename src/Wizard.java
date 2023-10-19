public class Wizard extends Personnage {
    public Wizard(String type,String name) {
        this.setName(name);
        this.setType(type);
        this.setPlayerPos(1);
        this.setLife(6);
        this.setStrength(15);
        this.setOffensiveItem(new Spell("sort"));
        this.setDefensiveItem(new Potion("philtre"));
    }
}
