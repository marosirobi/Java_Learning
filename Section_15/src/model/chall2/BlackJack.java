package model.chall2;

import model.chall1.Card;

import java.util.Collections;
import java.util.List;
import java.util.Random;


public class BlackJack {

    private static int yourPoints = 0;
    private static int dealerPoints = 0;
    private static int bound = 51;
    private static final int rand = new Random().nextInt(bound);

    public static List<Card> createDeck(){
        return Card.getStandardDeck();
    }

    public static void shuffleDeck(List<Card> list){
        Collections.shuffle(list);
    }

    public static void dealYourHand(List<Card> list,List<Card> yourHand){

        if(Collections.disjoint(list,yourHand)) {
            Card card = list.get(rand);

            yourHand.add(card);
            yourPoints += card.rank()+2;
            list.remove(card);
            bound--;
        }
        else{
            dealYourHand(list,yourHand);
        }
    }

    public static void dealDealerHand(List<Card> list,List<Card> dealerHand){
        if(Collections.disjoint(list,dealerHand)) {
            Card card = list.get(rand);
            dealerHand.add(card);
            dealerPoints += card.rank()+2;
            list.remove(card);
            bound--;
        }
        else{
            dealYourHand(list,dealerHand);
        }
    }



    public static void printHands(List<Card> yourHand,List<Card> dealerHand){
        System.out.println("-".repeat(30));
        System.out.println(yourHand +": " + yourPoints);
        System.out.println(dealerHand +": " + dealerPoints);
        whoWon();

    }

    public static void whoWon(){
        if(yourPoints > dealerPoints){
            System.out.println("you won");
            return;
        }else if(yourPoints == dealerPoints){
            System.out.println("equal");
            return;
        }
        System.out.println("dealer won");
    }




}
