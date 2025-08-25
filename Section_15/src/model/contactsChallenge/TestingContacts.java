package model.contactsChallenge;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestingContacts {

    public static void main(String[] args) {

        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");

        printData("emails",emails);
        printData("phones",phones);

        Set<Contact> emailContacts = new HashSet<>(emails);
        Set<Contact> phoneContacts = new HashSet<>(phones);

        printData("email contacts", emailContacts);
        printData("phone contacts", phoneContacts);

        int index = emails.indexOf(new Contact("Robin Hood"));
        Contact robinHood = emails.get(index);
        robinHood.addEmail("Netflix");
        robinHood.addEmail("Netflix");
        robinHood.replaceEmailIfExists("RHood@netflix.com","RHood@yoga.com");
        printData("emails",emailContacts);
    }

    public static void printData(String header, Collection<Contact> contacts){
        System.out.println("-".repeat(30));
        System.out.println(header);
        System.out.println("-".repeat(30));
        contacts.forEach(System.out::println);
    }
}
