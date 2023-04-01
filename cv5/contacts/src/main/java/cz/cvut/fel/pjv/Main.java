package cz.cvut.fel.pjv;

import static java.lang.Integer.parseInt;

public class Main {
    private static final String[] RECORDS = {
            "Josef Stefan 1963",
            "Pavlína Blaniková 1987",
            "Oldřich Burda 1988",
            "St5anislav Hons 1983",
            "Jan Kužílek 1969",
            "Monika Pražáková 1972",
            "Drahoslava Čermáková 1988",
            "Bořivoj Hrubeš 1984",
            "Adela Rjašková 1989",
            "Eliška Partinglová 1992",
            "Lucie Drábková 1964",
            "Dagmar Hašková 1965",
            "Petr Burda 1978",
            "Alena Denková 1982",
            "Jana Králová 1974",
            "Dominik Hradečný 1976",
            "Karel Bůžek 1987",
            "Kryštof Janíček 1994",
            "Jitka Kracíková 1997",
            "Vladimír Křivan 2001"
    };
    public static void main(String[] args) throws IncorrectNameException, IncorrectBirthYearException {
        ContactList cl = new ContactList();
        for (String record : RECORDS) {
            String[] items = record.split (" ");
            try {
                Contact contact = new Contact(items[0], items[1], Integer.parseInt(items[2]));
//                System.out.println(contact);
                cl.add(contact);
            } catch (IncorrectNameException e) {
                System.err.println("Incorrect name " + e.getMessage());
            } catch (IncorrectBirthYearException e) {
                System.err.println("Incorrect birth year ");
            }
        }
        System.out.println(cl);
        cl.sortByBY();
        System.out.println(cl);
        cl.sortByLastName();
        System.out.println(cl);
    }
}