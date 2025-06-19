package model.challenge2;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.util.*;

public class Chall2 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Town sydney = new Town("Sydney",0);
        LinkedList<Town> places = new LinkedList<>(List.of(new Town("Budapset",43),new Town("Vienna",55)));
        places.addFirst(new Town("Sydney",0));
        boolean flag = true;
        ListIterator<Town> iterator = places.listIterator(0);
        while (flag){
            printActions();
            String action = sc.nextLine();

            switch (action){
                case "F" -> iterateForward(iterator);
                case "B" -> iterateBackward(iterator);
                case "L" -> listPlaces(places,iterator);
                case "M" -> printTowns(places);
                case "Q" -> flag = false;
                default -> System.out.println("Wrong input");
            }

        }

    }

    private static void printTowns(LinkedList<Town> list){

        for (Town t : list){
            System.out.println(t.toString());
        }
    }

    private static void printActions(){
        String textBox = """
                Available actions (select word or letter):
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit""";
        System.out.println(textBox);
    }
    private static void iterateForward(ListIterator<Town> iterator){
        if(iterator.hasNext() ){
            Town t = iterator.next();
            System.out.println(t.getTown() + " --> " + t.getDistance() + " km");
            return;
        }
        System.out.println("This is the end of the list.");
    }
    private static void iterateBackward(ListIterator<Town> iterator){
        if(iterator.hasPrevious()){
            Town t = iterator.previous();
            System.out.println(t.getTown() + " --> " + t.getDistance() + " km");
            return;
        }
        System.out.println("This is the start of the list.");
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
