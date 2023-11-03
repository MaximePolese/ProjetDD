package personnage;

import equipementDefensif.*;
import equipementOffensif.*;
import main.*;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Classe représentant un personnage
 */
public abstract class Personnage {
    private int id;
    private String type;
    private String name;
    private int life;
    private int strength;
    private EquipementOffensif offensiveItem;
    private EquipementDefensif defensiveItem;
    private int maxLife;

    /**
     * Constructeur de personnage
     *
     * @param type le type de personnage : guerrier ou magicien
     * @param name le nom du joueur
     * @param db   pour interagir avec la base de donnée
     */
    protected Personnage(String type, String name) {
        this.name = name;
        this.type = type;
    }

    /**
     * Augmente la vie du personnage avec la potion trouvée
     *
     * @param sousoupe la potion trouvée par le personnage
     * @throws SQLException exception sql car les points de vie sont mis à jour sur la BDD
     */
    public void heals(Potion sousoupe) throws SQLException {
        this.life += sousoupe.getHealth();
        if (this.life > this.maxLife) {
            this.life = this.maxLife;
        }
//        mydb.changeLifePoints(this);
        System.out.println("new player's life : " + this.life);
    }

    /**
     * Equiper le personnage avec un nouvel équipement offensif
     * Le nouvel équipement est pris que s'il est meilleur que l'équipement actuel
     *
     * @param item équipement offensif trouvé par le personnage
     */
    public void newItem(EquipementOffensif item) {
        if (item.getWeaponAttack() > this.getOffensiveItem().getWeaponAttack() && item.getWeaponType().equals(this.getOffensiveItem().getWeaponType())) {
            this.offensiveItem = item;
            System.out.println("new weapon : " + item.getWeaponName());
        } else {
            System.out.println("non-equipped weapon : " + item.getWeaponName());
        }
    }

    /**
     * Pour gérer les combats avec les ennemis
     *
     * @param mechant l'ennemi avec lequel le personnage se bat
     * @return un état de jeu pour continuer ou non la partie
     * @throws SQLException exeception sql car la vie du personnage est mis à jour par enemyAttack()
     */
    public GameState fight(Ennemi mechant) throws SQLException {
        String fuite = "";
        Scanner clavier = new Scanner(System.in);
        while (!fuite.equals("n") && !fuite.equals("y") && mechant.getLife() > 0 && this.life > 0) {
            System.out.print("Do you want to run ? y/n ");
            fuite = clavier.nextLine();
            if (fuite.equals("n")) {
                this.heroAttack(mechant);
                if (mechant.getLife() <= 0) {
                    System.out.println("Enemy dies");
                    return GameState.enemyDies;
                } else {
                    this.enemyAttack(mechant);
                    if (this.life <= 0) {
                        System.out.println(Game.ANSI_RED_BACKGROUND + "GAME OVER !" + Game.ANSI_RESET);
                        return GameState.gameover;
                    }
                }
                fuite = "";
            } else if (fuite.equals("y")) {
                this.fuite();
            }
        }
        return GameState.continu;
    }

    /**
     * Pour que le personnage attaque l'ennemi
     *
     * @param mechant l'ennemi avec lequel le personnage se bat
     */
    public void heroAttack(Ennemi mechant) {
        System.out.println(this.name + " attacks");
        mechant.setLife(mechant.getLife() - (this.strength + this.offensiveItem.getWeaponAttack()));
        System.out.println("new enemy's life : " + mechant.getLife());
    }

    /**
     * Pour que l'ennemi attaque le personnage
     *
     * @param mechant l'ennemi avec lequel le personnage se bat
     * @throws SQLException exeception sql car la vie du personnage est mis à jour sur la BDD
     */
    public void enemyAttack(Ennemi mechant) throws SQLException {
        System.out.println("Enemy attacks !");
        this.life = this.life - mechant.getStrength();
        System.out.println("new player's life : " + this.life);
//                    mydb.changeLifePoints(this);
    }

    /**
     * Le personnage s'enfuit d'un combat,
     * il recule du résultat du dé
     */
    public void fuite() {
        int dice = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
        System.out.println("Dice result : " + dice);
        this.playerPos = this.playerPos - dice;
        if (this.playerPos < 0) {
            this.playerPos = 0;
        }
        System.out.println("Player en position : " + (this.playerPos + 1));
    }

    /**
     * Pour afficher les caractéristiques du personnage
     *
     * @return un string dans la console
     */
    @Override
    public String toString() {
        return "Personnage {" +
                "id = " + id +
                ", type = " + type +
                ", name = " + name +
                ", life = " + life +
                ", strength = " + strength +
                ", " + offensiveItem +
                ", " + defensiveItem +
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

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}