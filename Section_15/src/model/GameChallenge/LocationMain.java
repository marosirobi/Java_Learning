package model.GameChallenge;

public class LocationMain {
    public static void main(String[] args) {

        Location loc = new Location("stream");
        GameControl game = new GameControl();
        game.startGame();
    }
}
