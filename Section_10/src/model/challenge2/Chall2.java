package model.challenge2;

import java.util.*;

public class Chall2 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Town sydney = new Town("Sydney",0);
        LinkedList<Town> places = new LinkedList<>(List.of(new Town("Budapset",43),new Town("Vienna",55),new Town("Justin",125),new Town("Piece",225),new Town("Cheese",22)));
        places.addFirst(new Town("Sydney",0));
        boolean flag = true;
        var iterator = places.listIterator(0);
        boolean forward = true;

        while (flag){
            forward = finalOrOriginating(iterator,forward);

            printActions();
            System.out.print("Enter Value: ");
            String action = sc.nextLine().toUpperCase().substring(0,1);

            switch (action){
                case "F" -> forward = iterateForward(iterator,forward);
                case "B" -> forward = iterateBackward(iterator,forward);
                case "L" -> printTowns(places);
                case "M" -> printActions();
                case "Q" -> flag = false;
                default -> System.out.println("Wrong input");
            }

        }

    }

    private static boolean finalOrOriginating(ListIterator<Town> iterator, boolean forward){
        if(!iterator.hasPrevious()){
            forward = true;
            System.out.println("Originating : " + iterator.next());
            return forward;
        }
        if(!iterator.hasNext()){
            forward = false;
            System.out.println("Final : " + iterator.previous());
            return forward;
        }
        return forward;
    }

    private static void printTowns(LinkedList<Town> list){

        for (Town t : list){
            System.out.println(t.toString());
        }
    }

    private static void printActions(){

        System.out.println("""
                Available actions (select word or letter):
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit""");
    }

    private static boolean iterateForward(ListIterator<Town> iterator,boolean forward){
        if(!forward){
            forward = true;
            if(iterator.hasNext())
                iterator.next();
            return forward;
        }
        if(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        return forward;
    }

    private static boolean iterateBackward(ListIterator<Town> iterator,boolean forward){
        if(forward){
            forward = false;
            if(iterator.hasPrevious())
                iterator.previous();
            return forward;
        }
        if(iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }
        return forward;
    }


    private static void listPlaces(LinkedList<Town> list, ListIterator<Town> iterator){
        System.out.println("input a city and the distance from Sydney(with comma)");
        String[] arr = sc.nextLine().split(",");
        var place = new Town(arr[0].trim(),Integer.parseInt(arr[1].trim()));
        for(var t : list){
            if(t.getTown().equalsIgnoreCase(place.getTown())) {
                System.out.println("duplacate catched");
                return;
            }
        }
        int index = 0;
        for (var t : list){
            if(place.getDistance() < t.getDistance()){
                list.add(index,place);
                return;
            }
            index++;
        }

    }
}
