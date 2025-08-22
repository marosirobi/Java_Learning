package model.chall2;

import model.chall1.Card;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static void main(String[] args) {

        List<Card> deck = BlackJack.createDeck();
        List<Card> yourHand = new ArrayList<>(), dealerHand = new ArrayList<>();

        BlackJack.shuffleDeck(deck);
        Card.printDeck(deck, "Shuffled", 4);


        BlackJack.dealYourHand(deck,yourHand);
        BlackJack.dealYourHand(deck,yourHand);
        BlackJack.dealDealerHand(deck,dealerHand);
        BlackJack.dealDealerHand(deck,dealerHand);
        BlackJack.printHands(yourHand,dealerHand);

    }
}
