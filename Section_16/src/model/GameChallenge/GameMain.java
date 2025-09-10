package model.GameChallenge;

import model.GameChallenge.pirate.Pirate;
import model.GameChallenge.pirate.Weapon;
import model.GameChallenge.shooter.ShooterGame;

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
    }


}
