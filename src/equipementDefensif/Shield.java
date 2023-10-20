package equipementDefensif;

public class Shield extends EquipementDefensif {
    public Shield(String name) {
        super(name);
        this.setShieldResistance(3);
    }

    @Override
    public String getShieldType() {
        return "bouclier";
    }
}
