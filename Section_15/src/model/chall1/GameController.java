package model.chall1;

import model.chall1.Poker.PokerGame;

public class GameController {
    public static void main(String[] args) {

        PokerGame fiveCardDraw = new PokerGame(4,5);
        fiveCardDraw.starPlay();
    }
}
