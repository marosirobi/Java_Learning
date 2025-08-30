package model.GameChallenge;

public class LocationMain {
    public static void main(String[] args) {

        LocationData.addPlaces("""
                lake,at the edge of Lake Tim,E:ocean,W:forest,S:well house,N:cave
                ocean,on Tim's beach before an angry sea,W:lake
                cave,at the mouth of Tim's bat cave,E:ocean,W:forest,S:lake
                """);
        GameControl game = new GameControl("cave");
        game.startGame();
    }
}
