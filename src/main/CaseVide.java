package main;

import personnage.Personnage;

public class CaseVide implements Case {
    public CaseVide() {
    }

    @Override
    public GameState interaction(Personnage player) {
        System.out.println("Case vide");
        return GameState.continu;
    }

    @Override
    public String toString() {
        return "Case vide";
    }
}
