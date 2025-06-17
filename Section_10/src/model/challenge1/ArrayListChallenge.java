package model.challenge1;

import java.util.*;

public class ArrayListChallenge {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> groceries = new ArrayList<>();
        boolean run = true;
        while(run){
            printActions();
            String choice = sc.nextLine();
            switch (choice.trim()){
                case "0" -> run = false;
                case "1"-> addToList(groceries);
                case "2"-> deleteFromList(groceries);
                default -> System.out.println("Wrong input");
            }
            groceries.sort(Comparator.naturalOrder());
            System.out.println(groceries);

        }

    }
    private static void printActions(){
        String textBlock = """
                     Available Actions:
                    0 - to shutdown
                    1 - to add item(s) to list (comma delimited list)
                    2- to remove any items (comma delimited list)
                    Enter a number for which action you want to do: """;
        System.out.print(textBlock);
    }

    private static void addToList(ArrayList<String> list){
        String[] items = sc.nextLine().split(",");
        for (String item : items){
            if(!list.contains(item.trim()))
                list.add(item.trim());
            else{
                System.out.println(item + " is already added");
            }
        }
    }

    private static void deleteFromList(ArrayList<String> list){
        if(list.isEmpty()){
            System.out.println("you cant remove items from the list because its empty");
            return;
        }
        String[] items = sc.nextLine().split(",");
        for (String item : items){
            list.remove(item.trim());
        }
    }

}
