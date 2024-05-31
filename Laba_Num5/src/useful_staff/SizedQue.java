package useful_staff;

import java.util.ArrayDeque;

public class SizedQue<E> {

    private final int capacity;
    private final ArrayDeque<E> deque;

    public SizedQue(int capacity) {
        this.capacity = capacity;
        this.deque = new ArrayDeque<>(capacity);
    }

    public boolean add(E e) {
        if (deque.size() == capacity) {
            deque.pollFirst();
        }
        return deque.add(e);
    }
    public String toString() {
    	return deque.toString();
    }
}
