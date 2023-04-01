package cz.cvut.fel.pjv;

import java.util.Comparator;

public class NameComparator implements Comparator<Contact>{


    @Override
    public int compare(Contact o1, Contact o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
