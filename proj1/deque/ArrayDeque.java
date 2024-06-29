package deque;
import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T>{
    private T[] items;
    private int size;
    private int first;
    private int last;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        first = 4;
        last = 4;
    }

    @Override
    public void addFirst(T item) {
        if (first == 0)
        {
            double capacity = items.length * 1.5;
            resize((int) Math.round(capacity));
        }
        if (items[first] != null)
        {
            first--;
        }
        items[first] = item;
        size++;
    }

    @Override
    public void addLast(T item) {
        if (last == items.length - 1)
        {
            double capacity = items.length * 1.5;
            resize((int) Math.round(capacity));
        }
        if (items[last] != null)
        {
            last++;
        }
        items[last] = item;
        size++;
    }

    private void resize(int capacity) {
        T[] arr = (T[]) new Object[capacity];
        int startIndex = (capacity - size) / 2;
        System.arraycopy(items, first, arr, startIndex, size);
        int diff = last - first;
        first = startIndex;
        last = startIndex + diff;
        items = arr;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        System.out.print(this);
    }

    private String getString() {
        if (size == 0)
        {
            return "";
        }
        String s = "";
        for (int i = first; i <= last; i++)
        {
            s += items[i] + " ";
        }
        s += "\n";
        return s;
    }

    @Override
    public T removeFirst() {
        if (size == 0)
        {
            return null;
        }
        T item = items[first];
        items[first] = null;
        if (size > 1)
        {
            first++;
        }
        size--;
        checkUsageFactor();
        return item;
    }

    @Override
    public T removeLast() {
        if (size == 0)
        {
            return null;
        }
        T item = items[last];
        items[last] = null;
        if (size > 1)
        {
            last--;
        }
        size--;
        checkUsageFactor();
        return item;
    }

    private void checkUsageFactor() {
        if (items.length >= 16 && size < items.length / 4)
        {
            int capacity = items.length / 2;
            resize(capacity);
        }
    }

    @Override
    public T get(int index) {
        return items[first + index];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T> {
        private int pos;
        ArrayListIterator()
        {
            pos = 0;
        }

        public boolean hasNext() {
            return pos < size;
        }

        public T next() {
            T nextItem = get(pos);
            pos++;
            return nextItem;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ArrayDeque)
        {
            return compareDeque(this, (ArrayDeque<T>) o);
        }
        return false;
    }

    private boolean compareDeque(ArrayDeque<T> deq1, ArrayDeque<T> deq2) {
        if (deq1.size() != deq2.size())
        {
            return false;
        }
        for (int i = first; i <= last; i++)
        {
            if (deq1.items[first] != deq2.items[first])
            {
                return false;
            }
        }
        return true;
    }
}
