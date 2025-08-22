package model.chall1;
import java.sql.Array;
import java.util.*;


public class DeckMain {

    public static void main(String[] args) {
        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Suit.HEART,'A');
        Arrays.fill(cardArray, aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray),"Aces of Hearts",1);

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards,aceOfHearts);
        System.out.println("cards.size() = " + cards.size());

        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(acesOfHearts,"Aces of Hearts", 1);

        Card kingOfClubs = Card.getFaceCard(Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs,"Aces of Hearts", 1);

        Collections.addAll(cards,cardArray);
        Card.printDeck(cards,"Card Collection with Aces added", 1);
        Collections.addAll(cards,cardArray);
        Card.printDeck(cards,"Card Collection with Aces added", 2);

        Collections.copy(cards, kingsOfClubs);
        Card.printDeck(cards,"Card Collection with Kings copied", 2);

        cards = List.copyOf(kingsOfClubs);
        Card.printDeck(cards, "List Copy of Kings",1);

        List<Card> deckShuffle = Card.getStandardDeck();
        Collections.shuffle(deckShuffle);
        Card.printDeck(deckShuffle);

        Collections.reverse(deckShuffle);
        Card.printDeck(deckShuffle);

        var sortingAlgoritm = Comparator.comparing(Card::rank)
                        .thenComparing(Card::suit);
        Collections.sort(deckShuffle,sortingAlgoritm);
        Card.printDeck(deckShuffle,"Standard deck",13);
        Collections.reverse(deckShuffle);
        Card.printDeck(deckShuffle,"Standard deck",13);

        List<Card> kings = new ArrayList<>(deckShuffle.subList(4,8));
        Card.printDeck(kings);
        List<Card> tens = new ArrayList<>(deckShuffle.subList(16,20));
        Card.printDeck(tens);

        int subListIndex = Collections.indexOfSubList(deckShuffle, tens);
        System.out.println("Sublist index for tens = " + subListIndex);
        System.out.println("contains = " + deckShuffle.containsAll(tens));

        boolean disjoint = Collections.disjoint(deckShuffle,tens);
        System.out.println("disjoint = " + disjoint);

        boolean disjoint2 = Collections.disjoint(kings,tens);
        System.out.println("disjoint = " + disjoint2);

        Card tenOfHearts = Card.getNumericCard(Suit.HEART,10);
        deckShuffle.sort(sortingAlgoritm);
        int foundIndex = Collections.binarySearch(deckShuffle, tenOfHearts, sortingAlgoritm);
        System.out.println("foundIndex = " + foundIndex);
        System.out.println("foundIndex = " + deck.indexOf(tenOfHearts));
        System.out.println(deckShuffle.get(foundIndex));

        Card tenOfClubs = Card.getNumericCard(Suit.CLUB, 10);
        Collections.replaceAll(deckShuffle,tenOfHearts,tenOfClubs);
        Card.printDeck(deckShuffle.subList(32,36),"Replaced",1);

        Collections.replaceAll(deckShuffle,tenOfClubs,tenOfHearts);
        Card.printDeck(deckShuffle.subList(32,36),"Replaced",1);

        if(Collections.replaceAll(deckShuffle,tenOfHearts,tenOfClubs)){
            System.out.println("Tens of hearts are replaced with tens of clubs");
        }else{
            System.out.println("no tens of hearts found in the list");
        }

        System.out.println("ten of clubs cards = " +
                Collections.frequency(deckShuffle,tenOfClubs));

        System.out.println("Best Card = " + Collections.max(deckShuffle, sortingAlgoritm));
        System.out.println("Worst Card = " + Collections.min(deckShuffle, sortingAlgoritm));

        var sortBySuit = Comparator.comparing(Card::suit)
                .thenComparing(Card::rank);

        deck.sort(sortBySuit);
        Card.printDeck(deck,"Sorted by suit", 4);

        List<Card> copied = new ArrayList<>(deck.subList(0,13));
        Collections.rotate(copied,2);
        System.out.println("Unrotated: " + deck.subList(0,13));
        System.out.println("rotated 2: " + copied);

        copied = new ArrayList<>(deck.subList(0,13));
        Collections.rotate(copied,-2);
        System.out.println("Unrotated: " + deck.subList(0,13));
        System.out.println("rotated -2: " + copied);

        copied = new ArrayList<>(deck.subList(0,13));
        for(int i = 0; i < copied.size()/2; i++){
            Collections.swap(copied, i, copied.size()-1-i);
        }
        System.out.println("Manual reverse: " + copied);

        copied = new ArrayList<>(deck.subList(0,13));
        Collections.reverse(copied);
        System.out.println("Using reverse method: " + copied);
    }
}
