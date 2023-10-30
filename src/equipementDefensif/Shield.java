package equipementDefensif;

public class Shield extends EquipementDefensif {
    public Shield() {
        super("shield");
        this.setShieldResistance(3);
    }

    @Override
    public String getShieldType() {
        return "bouclier";
    }
}
