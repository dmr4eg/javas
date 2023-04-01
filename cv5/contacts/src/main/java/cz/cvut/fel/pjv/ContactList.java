package cz.cvut.fel.pjv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ContactList {
    private final List<Contact> contacts = new ArrayList<>();

    public void add(Contact contact){
        contacts.add(contact);
    }

    public void sortByBY(){
        Collections.sort(contacts);
    }

    public void sortByLastName(){
        Collections.sort(contacts, new NameComparator());
    }

    @Override
    public String toString() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
        return "";
    }
}
