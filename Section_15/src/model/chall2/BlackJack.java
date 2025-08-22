package model.chall2;

import model.chall1.Card;
import model.chall1.Suit;

import java.util.*;


public class BlackJack {

    private int yourPoints;
    private int dealerPoints;
    private static int bound = 51;
    private static int rand = new Random().nextInt(bound);

    private List<Card> yourHand,dealerHand;
    private List<Card> remainingCards;
    private final List<Card> deck = Card.getStandardDeck();

    public BlackJack() {
        yourPoints = 0;
        dealerPoints = 0;
        yourHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
        remainingCards = deck.subList(0,deck.size()-1);
    }

    public void startGame(){
        Collections.shuffle(deck);
        dealYourHand();
        dealYourHand();
        dealDealerHand();
        printHands();
        Scanner sc = new Scanner(System.in);

        System.out.println("Do you wanna deal?");
        if(sc.next().equals("Y")){
            dealYourHand();
        }else{
            System.out.println("who won?");
            if(sc.next().equals("Y")){
                whoWon();
            }
        }


    }


    public void dealYourHand(){

        if(Collections.disjoint(remainingCards,yourHand)) {
            Card card = remainingCards.get(rand);

            yourHand.add(card);
            yourPoints += card.rank()+2;
            remainingCards.remove(card);
            bound--;
        }
        else{
            dealYourHand();
        }

        if(yourPoints > 21){
            whoWon();
        }
    }

    public void dealDealerHand(){
        if(dealerHand.isEmpty())
            dealerHand.add(new Card(Suit.DIAMOND,"0",0));
        if(Collections.disjoint(remainingCards,dealerHand)) {
            Card card = remainingCards.get(rand);
            dealerHand.add(card);
            dealerPoints += card.rank()+2;
            remainingCards.remove(card);
            bound--;
        }
        else{
            dealYourHand();
        }
    }



    public void printHands(){
        System.out.println("-".repeat(30));
        System.out.println(yourHand +": " + yourPoints);
        System.out.println(dealerHand +": " + dealerPoints);

    }

    public void whoWon(){
        dealDealerHand();
        dealerHand.removeFirst();
        Collections.rotate(dealerHand,1);
        printHands();
        if((yourPoints > dealerPoints && yourPoints <= 21) || dealerPoints > 21 ){
            System.out.println("you won");
            return;
        }else if(yourPoints == dealerPoints){
            System.out.println("equal");
            return;
        }else
            System.out.println("dealer won");
    }

}
