package model.GameChallenge;

import model.GameChallenge.pirate.PirateGame;

//abstract class SpecialGameConsole<T extends  Game<? extends  Player>>
//        extends GameConsole<Game<? extends Player>>{
//
//    public SpecialGameConsole(Game<? extends Player> game) {
//        super(game);
//    }
//}

public class MainFinal {

    public static void main(String[] args) {

        GameConsole<PirateGame> game = new GameConsole<PirateGame>(new PirateGame("Pirate Game"));

    }

}
