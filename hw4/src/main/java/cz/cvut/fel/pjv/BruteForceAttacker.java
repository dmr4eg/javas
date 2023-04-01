package cz.cvut.fel.pjv;

public class BruteForceAttacker extends Thief {
    private char[] password;

    @Override
    public void breakPassword(int sizeOfPassword) {
        password = new char[sizeOfPassword];
        opener(sizeOfPassword);
    }

    public void opener(int sizeOfPassword) {
        if (sizeOfPassword == 0) {
            tryOpen(password);
            return;
        }
        for (int i = 0; i < getCharacters().length; i++) {
            password[sizeOfPassword - 1] = getCharacters()[i];
            opener(sizeOfPassword - 1);
            System.out.println(password);
            if (isOpened()) {
                return;
            }
        }
    }
}