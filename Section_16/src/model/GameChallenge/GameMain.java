package model.GameChallenge;

import model.GameChallenge.pirate.Pirate;
import model.GameChallenge.pirate.PirateGame;
import model.GameChallenge.pirate.Town;
import model.GameChallenge.pirate.Weapon;

public class GameMain {

    public static void main(String[] args) {
//        var console = new GameConsole<>(new ShooterGame("The Shootout Game"));
//
//        int playerIndex = console.addPlayer();
//        console.playGame(playerIndex);

        var w = Weapon.getWeaponsByLevel(1);
        System.out.println(w);

        Pirate tim = new Pirate("Tim");
        System.out.println(tim);

//        Town bridgeTown = new Town("BridgeTown", "Barbados",0);
//        System.out.println(bridgeTown);
//        System.out.println(bridgeTown.information());

        var console = new GameConsole<>(new PirateGame("The Pirate Game"));
        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);

    }


}
