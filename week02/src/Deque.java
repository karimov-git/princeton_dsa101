import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by lxuser on 6/25/17.
 */
public class Deque<Item> implements Iterable<Item> {
    private int size;
    private Node first, last;

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    private void isNull(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
    }

    private void testEmpty() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            Item value = current.item;
            current = current.next;
            return value;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Deque() {
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        isNull(item);
        Node oldFirst = first;
        first = new Node();
        first.next = oldFirst;
        first.item = item;
        if (size > 0) {
            oldFirst.prev = first;
        } else {
            last = first;
        }
        size++;
    }

    public void addLast(Item item) {
        isNull(item);
        Node oldLast = last;
        last = new Node();
        last.prev = oldLast;
        last.item = item;
        if (size > 0) {
            oldLast.next = last;
        } else {
            first = last;
        }
        size++;
    }

    public Item removeFirst() {
        testEmpty();
        Item item = first.item;
        if (size > 1) {
            first = first.next;
            first.prev = null;
        } else {
            first = null;
            last = null;
        }
        size--;
        return item;
    }

    public Item removeLast() {
        testEmpty();
        Item item = last.item;
        if (size > 1) {
            last = last.prev;
            last.next = null;
        } else {
            first = null;
            last = null;
        }
        size--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }
}
