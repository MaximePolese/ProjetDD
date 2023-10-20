package equipementDefensif;

public class Potion extends EquipementDefensif {
    public Potion(String name) {
        super(name);
        this.setShieldResistance(4);
    }

    @Override
    public String getShieldType() {
        return "philtre";
    }
}
