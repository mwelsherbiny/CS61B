package deque;

public class LinkedListDeque<T> {
    public class Node {
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

    public LinkedListDeque(T item)
    {
        Node first = new Node(item, null, null);
        front = new Node(null, first, null);
        back = new Node(null, null, first);
        first.next = back;
        first.prev = front;
        size++;
    }

    public LinkedListDeque()
    {
        front = new Node(null, null, null);
        back = new Node(null, null, front);
        front.next = back;
    }

    public void addFirst(T item)
    {
        front.next = new Node(item, front.next, front);
        front.next.next.prev = front.next;
        if (size == 0)
        {
            back.prev = front.next;
        }
        size++;
    }

    public void addLast(T item)
    {
        back.prev.next = new Node(item, back, back.prev);
        back.prev = back.prev.next;
        size++;
    }

    public boolean isEmpty()
    {
        return (size == 0);
    }

    public int size()
    {
        return size;
    }

    public void printDeque() {
        Node deq = this.front.next;
        while (deq.next != null)
        {
            System.out.print(deq.item + " ");
            deq = deq.next;
        }
        System.out.println();
    }

    public T removeFirst()
    {
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

    public T removeLast()
    {
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

    public T get(int index)
    {
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

    public T getRecursive(int index)
    {
        return getItem(front.next, index);
    }

    private T getItem(Node n, int index)
    {
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

//    public Iterator<T> iterator()
//    {
//        // TODO
//    }

    public boolean equals(Object o)
    {
        if (o instanceof LinkedListDeque)
        {
            return compareDeque(this, (LinkedListDeque<T>) o);
        }
        return false;
    }

    private boolean compareDeque(LinkedListDeque<T> deq1, LinkedListDeque<T> deq2)
    {
        if (deq1.size() != deq2.size())
        {
            return false;
        }
        Node n1 = deq1.front.next;
        Node n2 = deq2.front.next;
        while (n1.next != null)
        {
            if (n1.item != n2.item)
            {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }
}