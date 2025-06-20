package model.arraylists;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedLists {

    public static void main(String[] args) {

        //LinkedList<String> placesToVisit = new LinkedList<>();
        var placesToVisit = new LinkedList<String>();

        placesToVisit.add("Sydney");
        placesToVisit.add(0, "Canberra");
        System.out.println(placesToVisit);
        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);
//        removeElements(placesToVisit);
//        System.out.println(placesToVisit);
//        gettingElements(placesToVisit);

//        printItinerary(placesToVisit);
//        printItinerary2(placesToVisit);
//        printItinerary3(placesToVisit);
        testIterator(placesToVisit);
    }

    private static void addMoreElements(LinkedList<String> list){
            list.addFirst("Darwin");
            list.addLast("Hobart");

            //queue methods
            list.offer("Melbourne");
            list.offerFirst("Brisbane");
            list.offerLast("Toowomba");

            //stack methods
            list.push("Alice Spirngs");

        }

    private static void removeElements(LinkedList<String> list){
        list.remove(4);
        list.remove("Sydney");

        System.out.println(list);
        String s1 = list.remove();
        System.out.println(s1 + " was removed");

        String s2 = list.removeFirst();
        System.out.println(s2 + " was removed");

        String s3 = list.removeLast();
        System.out.println(s3 + " was removed");

        //queue/deque poll methods
        String p1 = list.poll();
        System.out.println(p1 + " was removed");

        String p2 = list.pollFirst();
        System.out.println(p2 + " was removed");

        String p3 = list.pollLast();
        System.out.println(p3 + " was removed");

        list.push("Melbourne");
        list.push("Brisbane");
        list.push("Toowomba");
        System.out.println(list);
        String p4 = list.pop();
        System.out.println(p4 + " was removed");

    }

    private static void gettingElements(LinkedList<String> list){
        System.out.println("indexed element : " + list.get(4));

        System.out.println("indexed element : " + list.getLast());
        System.out.println("indexed element : " + list.getFirst());

        System.out.println("Sydney is at : " + list.indexOf("Sydney"));
        System.out.println("Darwin is at : " + list.lastIndexOf("Darwin"));

        //queue retrieval method

        System.out.println("element from element() = " + list.element());

        //stack retrieval methods
        System.out.println("element from peek() = " + list.peek());
        System.out.println("element from peekFirst() = " + list.peekFirst());
        System.out.println("element from peekLast() = " + list.peekLast());

    }

    private static void printItinerary(LinkedList<String> list){

        System.out.println("Trip start at " + list.getFirst());

        for (int i = 1; i < list.size(); i++){
            System.out.println("--> From: " + list.get(i-1) + " to " + list.get(i));
        }

        System.out.println("Trip ends at " + list.getLast());
    }

    private static void printItinerary2(LinkedList<String> list){

        System.out.println("Trip start at " + list.getFirst());
        String previousTown = list.getFirst();
        for (String town : list){
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }

        System.out.println("Trip ends at " + list.getLast());
    }

    private static void printItinerary3(LinkedList<String> list){

        System.out.println("Trip start at " + list.getFirst());
        String previousTown = list.getFirst();
        ListIterator<String> iterator = list.listIterator(1);
        while (iterator.hasNext()){
            var town = iterator.next();
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }

        System.out.println("Trip ends at " + list.getLast());
    }

    private static void testIterator(LinkedList<String> list){
        var iterator = list.listIterator();
        while(iterator.hasNext()){
            //System.out.println(iterator.next());
            if(iterator.next().equals("Brisbane"))
                iterator.add("Lake Ivanhoe");
        }

        while(iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }
        System.out.println(list);

        var iterator2 = list.listIterator(3);
        System.out.println(iterator2.next());
    }
}
