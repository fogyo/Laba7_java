package useful_staff;
import java.util.ArrayList;
import java.util.LinkedList;

import contract.Vehicle;


public class MyHashMap {

    private class Entry {
        Integer key;
        Vehicle value;

        public Entry(Integer key, Vehicle value) {
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<LinkedList<Entry>> buckets;

    public MyHashMap(int capacity) {
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    private int getIndex(Integer key) {
        int hash = key.hashCode();
        return Math.abs(hash % buckets.size());
    }

    public void put(Integer key, Vehicle value) {
        int index = getIndex(key);
        LinkedList<Entry> bucket = buckets.get(index);
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry(key, value));
    }

    public Vehicle get(Integer key) {
        int index = getIndex(key);
        LinkedList<Entry> bucket = buckets.get(index);
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(Integer key) {
        int index = getIndex(key);
        LinkedList<Entry> bucket = buckets.get(index);
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                return;
            }
        }
    }

    public boolean containsKey(Integer key) {
        int index = getIndex(key);
        LinkedList<Entry> bucket = buckets.get(index);
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }
    
    public void clear() {
    	buckets.clear(); 
    }
}

