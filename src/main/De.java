package main;

public class De {
    private int diceResult;

    public De() {
    }

    public void lancerDe() {
        diceResult = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
        System.out.println("Dice result : " + diceResult);
    }

    public int getDiceResult() {
        return diceResult;
    }
}
