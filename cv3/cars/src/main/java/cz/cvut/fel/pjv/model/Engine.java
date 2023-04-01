package cz.cvut.fel.pjv.model;

import java.util.Objects;

public class Engine {
    private final String type;

    public Engine(String type) {
        this.type = type;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return Objects.equals(type, engine.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return type;
    }
}
