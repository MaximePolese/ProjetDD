package main;

public class De {
    private int dice;

    public De() {

    }

    public void lancerDe() {
        dice = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
        System.out.println("Dice result : " + dice);
    }
}
