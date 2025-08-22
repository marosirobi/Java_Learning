package model.chall1.Poker;

import model.chall1.Card;

import java.util.*;

public class PokerGame {

    private final List<Card> deck = Card.getStandardDeck();

    private int playerCount;
    private int cardsInHands;
    private List<PokerHand> pokerHands;
    private List<Card> remainingCards;

    public PokerGame(int playerCount, int cardsInHands) {
        this.playerCount = playerCount;
        this.cardsInHands = cardsInHands;
        pokerHands = new ArrayList<>(cardsInHands);

    }

    public void starPlay(){
        Collections.shuffle(deck);
        Card.printDeck(deck);
        int randomMiddle = new Random().nextInt(15,35);
        Collections.rotate(deck,randomMiddle);
        Card.printDeck(deck);
        deal();
        System.out.println("-------------------");
        pokerHands.forEach(System.out::println);
    }

    private void deal(){
        Card[][] hands = new Card[playerCount][cardsInHands];
        int deckIndex = 0;
        for(int i = 0; i < cardsInHands; i++){
            for(int j = 0; j < playerCount; j++){
                hands[j][i] = deck.get(deckIndex++);
            }
        }
        int playerNo = 1;
        for(Card[] hand : hands){
            pokerHands.add(new PokerHand(playerNo++, Arrays.asList(hand)));
        }
    }

}
