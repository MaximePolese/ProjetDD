package equipementDefensif;

public abstract class EquipementDefensif {
    private String shieldName;
    private int shieldResistance;

    public EquipementDefensif(String name) {
        this.shieldName = name;
    }

    public abstract String getShieldType();

    @Override
    public String toString() {
        return "EquipementDefensif{" +
                "shieldType='" + getShieldType() + '\'' +
                ", shieldName='" + shieldName + '\'' +
                ", shieldResistance=" + shieldResistance +
                '}';
    }

    public String getShieldName() {
        return shieldName;
    }

    public void setShieldName(String shieldName) {
        this.shieldName = shieldName;
    }

    public int getShieldResistance() {
        return shieldResistance;
    }

    public void setShieldResistance(int shieldResistance) {
        this.shieldResistance = shieldResistance;
    }
}
