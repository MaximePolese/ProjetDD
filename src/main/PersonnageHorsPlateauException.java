package main;

import personnage.Personnage;

public class PersonnageHorsPlateauException extends Exception{
    public PersonnageHorsPlateauException(Personnage player){
        super(player.getName() + " Win !!!");
    }
}
