import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by lxuser on 6/25/17.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] values;
    private int n;

    private void testEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    public RandomizedQueue() {
        values = (Item[]) new Object[2];

    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private void resize(int capacity) {
        assert capacity >= n;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = values[i];
        }
        values = temp;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (n == values.length) {
            resize(2 * values.length);
        }
        values[n++] = item;
    }


    public Item dequeue() {
        testEmpty();
        int index = StdRandom.uniform(0, n);
        Item item = values[index];
        values[index] = values[n - 1];
        values[n - 1] = null;
        n--;
        if (n > 0 && n == values.length / 4) {
            resize(values.length / 2);
        }
        return item;
    }

    public Item sample() {
        testEmpty();
        return values[StdRandom.uniform(0, n)];
    }

    public Iterator<Item> iterator() {
        return new RandomArray();
    }

    private class RandomArray implements Iterator<Item> {
        private Item[] r;
        private int i;
        private void copyQueue() {
            r = (Item[]) new Object[n];
            for (int i = 0; i < n; i++) {
                r[i] = values[i];
            }
        }

        public RandomArray() {
            copyQueue();
            StdRandom.shuffle(r);
        }

        public boolean hasNext() {
            return i < n;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return r[i++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    public static void main(String[] args) {

    }
}
