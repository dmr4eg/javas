package cz.cvut.fel.pjv;

import java.io.Serializable;

public class Contact implements Comparable<Contact>, Serializable {
    private String firstName;
    private String lastName;
    private int birthYear;

    public Contact(String firstName, String lastName, int birthYear) throws IncorrectNameException, IncorrectBirthYearException {
        if (!firstName.matches("[\\p{L}]+")){
            throw new IncorrectNameException("first name is not valid: " + firstName);
        }
        if (!lastName.matches("[\\p{L}]+")){
            throw new IncorrectNameException("last name is not valid: " + lastName);
        }
        this.firstName = firstName;
        this.lastName = lastName;
        if (birthYear < 1900 || birthYear > 2020){
            throw new IncorrectBirthYearException();
        }
        this.birthYear = birthYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }

    @Override
    public int compareTo(Contact o) {
        if (this.birthYear > o.birthYear){
            return 1;
        } else if (this.birthYear < o.birthYear){
            return -1;
        } else {
            return 0;
        }
    }
}
