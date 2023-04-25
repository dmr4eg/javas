package pjv.hodina10;

import java.util.ArrayList;
import java.util.List;

public class MyStack implements Stack{
    private final List<String> data = new ArrayList<>();

    @Override
    public void add(String word) {
        data.add(word);
    }

    @Override
    public String pop() throws InterruptedException {
        return data.remove(data.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
