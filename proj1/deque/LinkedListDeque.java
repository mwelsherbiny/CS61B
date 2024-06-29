package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private class Node {
        private Node next;
        private Node prev;
        private T item;

        public Node(T item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node front;
    private Node back;
    private int size;

    public LinkedListDeque() {
        front = new Node(null, null, null);
        back = new Node(null, null, front);
        front.next = back;
    }

    @Override
    public void addFirst(T item) {
        front.next = new Node(item, front.next, front);
        front.next.next.prev = front.next;
        if (size == 0)
        {
            back.prev = front.next;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        back.prev.next = new Node(item, back, back.prev);
        back.prev = back.prev.next;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node deq = this.front.next;
        while (deq.next != null)
        {
            System.out.print(deq.item + " ");
            deq = deq.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0)
        {
            return null;
        }
        T item = front.next.item;
        front.next = front.next.next;
        front.next.prev = front;
        size --;
        return item;
    }

    @Override
    public T removeLast() {
        if (size == 0)
        {
            return null;
        }
        T item = back.prev.item;
        back.prev = back.prev.prev;
        back.prev.next = back;
        size--;
        return item;
    }

    @Override
    public T get(int index) {
        Node n = front.next;
        for (int i = 0; i < index; i++)
        {
            if (n.next == null)
            {
                return null;
            }
            n = n.next;
        }
        return n.item;
    }

    public T getRecursive(int index) {
        return getItem(front.next, index);
    }

    private T getItem(Node n, int index) {
        if (n.next == null)
        {
            return null;
        }
        if (index == 0)
        {
            return n.item;
        }
        return getItem(n.next, index - 1);
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        Node currNode;
        LinkedListIterator()
        {
            currNode = front.next;
        }

        public boolean hasNext() {
            return currNode.next != null;
        }

        public T next() {
            T nextItem = currNode.item;
            currNode = currNode.next;
            return nextItem;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof LinkedListDeque)
        {
            return compareDeque(this, (Deque<T>) o);
        }
        return false;
    }

    private boolean compareDeque(LinkedListDeque<T> deq1, Deque<T> deq2) {
        if (deq1.size() != deq2.size())
        {
            return false;
        }
        for (int i = 0; i < size; i++)
        {
            if (!(deq1.get(i).equals(deq2.get(i))))
            {
                return false;
            }
        }
        return true;
    }
}
