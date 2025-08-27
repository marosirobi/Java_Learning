package model.contactsChallenge;

import java.util.*;

public class TreeSetMain {

    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

//        NavigableSet<Contact> sorted = new TreeSet<>(phones);
        Comparator<Contact> mySort = Comparator.comparing(Contact::getName);
        NavigableSet<Contact> sorted = new TreeSet<>(mySort);
        sorted.addAll(phones);
        sorted.forEach(System.out::println);

        System.out.println("-".repeat(30));
        NavigableSet<String> justNames = new TreeSet<>();
        phones.forEach(s -> justNames.add(s.getName()));
        System.out.println(justNames);

        System.out.println("-".repeat(30));
        NavigableSet<Contact> fullSet = new TreeSet<>(sorted);
        fullSet.addAll(emails);
        fullSet.forEach(System.out::println);

        System.out.println("-".repeat(30));
        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.sort(sorted.comparator());
        fullList.forEach(System.out::println);

        Contact min = Collections.min(fullSet, fullSet.comparator());
        Contact max = Collections.max(fullSet, fullSet.comparator());

        Contact first = fullSet.first();
        Contact last = fullSet.last();

        System.out.println("-".repeat(30));
        System.out.printf("min = %s, first = %s%n",min.getName(),first.getName());
        System.out.printf("max = %s, last  = %s%n",max.getName(),last.getName());
        System.out.println("-".repeat(30));

        NavigableSet<Contact> copiedSet = new TreeSet<>(fullSet);
        System.out.println("First element = " + copiedSet.pollFirst());
        System.out.println("Last element = " + copiedSet.pollLast());
        copiedSet.forEach(System.out::println);
        System.out.println("-".repeat(30));

        Contact daffy = new Contact("Daffy Duck");
        Contact daisy = new Contact("Daisy Duck");
        Contact snoopy = new Contact("Snoopy");
        Contact archie = new Contact("Archie");

        for(Contact c : List.of(daffy,daisy,last,snoopy)){
            System.out.printf("ceiling(%s)=%s%n",c.getName(),fullSet.ceiling(c));
            System.out.printf("higher(%s)=%s%n",c.getName(),fullSet.higher(c));
        }
        System.out.println("-".repeat(30));

        for(Contact c : List.of(daffy,daisy,last,archie)){
            System.out.printf("floor(%s)=%s%n",c.getName(),fullSet.floor(c));
            System.out.printf("lower(%s)=%s%n",c.getName(),fullSet.lower(c));
        }
        System.out.println("-".repeat(30));

        NavigableSet<Contact> descendingSet = fullSet.descendingSet();
        descendingSet.forEach(System.out::println);
        System.out.println("-".repeat(30));

        Contact lastContact = descendingSet.pollLast();
        System.out.println("Removed " + lastContact);
        descendingSet.forEach(System.out::println);
        System.out.println("-".repeat(30));

        fullSet.forEach(System.out::println);
        System.out.println("-".repeat(30));

        Contact marion = new Contact("Maid Marion");
        var headSet = fullSet.headSet(marion,true);
        headSet.forEach(System.out::println);
        System.out.println("-".repeat(30));

        var tailSet = fullSet.tailSet(marion,false);
        tailSet.forEach(System.out::println);
        System.out.println("-".repeat(30));

        Contact linus = new Contact("Linus Van Pelt");
        var subSet = fullSet.subSet(linus,false,marion,true);
        subSet.forEach(System.out::println);
        System.out.println("-".repeat(30));




    }
}
