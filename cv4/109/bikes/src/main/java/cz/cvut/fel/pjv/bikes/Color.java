package cz.cvut.fel.pjv.bikes;

public enum Color {
    RED(147, "Crimson red"),
    GREEN(558, "Emerald green"),
    BLUE(968, "Sky blue");
    private final int id;
    private final String description;

    Color(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
