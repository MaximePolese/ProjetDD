package main;

import personnage.Personnage;

public class CaseVide implements Case {
    public CaseVide() {
    }

    @Override
    public void interaction(Personnage player) {
        System.out.println("Case vide");
    }

    @Override
    public String toString() {
        return "Case vide";
    }
}
