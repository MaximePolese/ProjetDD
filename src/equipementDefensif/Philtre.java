package equipementDefensif;

public class Philtre extends EquipementDefensif {
    public Philtre() {
        super("philtre");
        this.setShieldResistance(4);
    }

    @Override
    public String getShieldType() {
        return "philtre";
    }
}
