package equipementDefensif;

public class Philtre extends EquipementDefensif {
    public Philtre(String name) {
        super(name);
        this.setShieldResistance(4);
    }

    @Override
    public String getShieldType() {
        return "philtre";
    }
}
