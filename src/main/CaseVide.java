package main;

public class CaseVide implements Case{
    public CaseVide(){}

    @Override
    public void interaction() {
        System.out.println("départ");
    }
}
