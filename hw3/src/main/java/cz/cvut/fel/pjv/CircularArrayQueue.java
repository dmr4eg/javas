package cz.cvut.fel.pjv;

/**
 * Implementation of the {@link Queue} backed by fixed size array.
 */
public class CircularArrayQueue implements Queue {
    private final String[] queue;
    private int counter = 0;
    private int head;
    private int tail;
    private int capacity;

    /**
     * Creates the queue with capacity set to the value of 5.
     */
    public CircularArrayQueue() {
        this.queue = new String[5];
        this.capacity = 5;
    }

    /**
     * Creates the queue with given {@code capacity}. The capacity represents maximal number of elements that the
     * queue is able to store.
     * @param capacity of the queue
     */
    public CircularArrayQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new String[capacity];
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public boolean isEmpty() {
        if (counter == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isFull() {
        if ( counter == capacity) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean enqueue(String obj) {
        if (isFull() ) {
            return false;
        } else {
            if (obj == null) {
                return false;
            } else {
//                if (queue[head] == null) {
//                    queue[head] = obj;
//                } else {
//                    queue[tail] = obj;
//                }
//                counter++;
//                if (tail == capacity - 1){
//                    tail = 0;
//                } else {
//                    tail++;
//                }
                queue[tail] = obj;
                counter++;
                if (tail == capacity - 1){
                    tail = 0;
                } else {
                    tail++;
                }
            }
            return true;
        }
    }

    @Override
    public String dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            String temp = queue[head];
            queue[head] = null;
            if (head == capacity - 1) {
                head = 0;
            } else {
                head++;
            }
            counter--;
            return temp;
        }
    }

    @Override
    public void printAllElements() {
        int i = head;
        while (i != tail) {
            System.out.println(queue[i]);
            if (i == capacity - 1) {
                i = 0;
            } else {
                i++;
            }
        }
    }
}
