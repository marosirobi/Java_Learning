package model.arraylists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MoreLists {
    public static void main(String[] args) {

        String[] items = {"apples", "bananas", "milk", "egg"};

        List<String> list = List.of(items);

        System.out.println(list);

        System.out.println(list.getClass().getName());
        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("Yougirt");
        System.out.println(groceries);

        ArrayList<String> nextList = new ArrayList<>(List.of("pickles", "mustard", "cheese"));
        System.out.println(nextList);

        groceries.addAll(nextList);
        System.out.println(groceries);

        System.out.println("the third item is : " + groceries.get(2));

        if (groceries.contains("mustard")) {
            System.out.println("mustard found");
        }

        groceries.add("Yougirt");
        System.out.println("first = " + groceries.indexOf("Yougirt"));
        System.out.println("last = " + groceries.lastIndexOf("Yougirt"));

        System.out.println(groceries);
        groceries.remove(1);
        System.out.println(groceries);
        groceries.remove("Yougirt");
        System.out.println(groceries);
        groceries.removeAll(List.of("apples", "eggs"));
        System.out.println(groceries);


        groceries.retainAll(List.of("mustard", "milk", "apples"));
        System.out.println(groceries);
        groceries.clear();

        System.out.println(groceries);

        System.out.println("isEmpty : " + groceries.isEmpty());

        groceries.addAll(List.of("apples","milk","mustard","cheese"));
        System.out.println(groceries);
        groceries.addAll(Arrays.asList("eggs", "pickles", "mustard", "ham"));
        System.out.println(groceries);

        groceries.sort(Comparator.naturalOrder());
        System.out.println(groceries);
        groceries.sort(Comparator.reverseOrder());
        System.out.println(groceries);

        var groceryArray = groceries.toArray(new String[groceries.size()]);
        System.out.println(Arrays.toString(groceryArray));
    }
}
