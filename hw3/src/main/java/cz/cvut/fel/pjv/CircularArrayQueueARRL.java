package cz.cvut.fel.pjv;

import java.util.ArrayList;

/**
 * Implementation of the {@link Queue} backed by fixed size array.
 */
public class CircularArrayQueueARRL implements Queue {
    private final ArrayList<String> queue;
    private int counter = 0;
    private int capacity = 0;

    /**
     * Creates the queue with capacity set to the value of 5.
     */
    public CircularArrayQueueARRL() {
        this.queue = new ArrayList<>(5);
    }

    /**
     * Creates the queue with given {@code capacity}. The capacity represents maximal number of elements that the
     * queue is able to store.
     *
     * @param capacity  of the queue
     */
    public CircularArrayQueueARRL(int capacity) {
        this.capacity = capacity;
        this.queue = new ArrayList<>(capacity);
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        } else {
            return counter;
        }
    }

    @Override
    public boolean isEmpty() {
       if (queue.size() == 0 || queue == null){
           return true;
       } else {
           return false;
       }
    }

    @Override
    public boolean isFull() {
        if (queue.size() == capacity){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean enqueue(String obj) {
        if (isFull()) {
            return false;
        } else {
            if (obj == null) {
                return false;
            } else {
                queue.add(obj);
                counter++;
                return true;
            }
        }
    }

    @Override
    public String dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            String temp = queue.get(0);
            queue.remove(0);
            counter--;
            return temp;
        }
    }

    @Override
    public void printAllElements() {
        for (int i = 0; i < counter; i++){
            System.out.println(queue.get(i));
        }
    }
}
