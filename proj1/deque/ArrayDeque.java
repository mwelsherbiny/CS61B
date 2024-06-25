package deque;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int first;
    private int last;

    public ArrayDeque()
    {
        items = (T[]) new Object[8];
        first = 4;
        last = 4;
    }

    public void addFirst(T item)
    {
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

    public void addLast(T item)
    {
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

    private void resize(int capacity)
    {
        T[] arr = (T[]) new Object[capacity];
        int startIndex = (capacity - size) / 2;
        System.arraycopy(items, first, arr, startIndex, size);
        first = startIndex;
        last = startIndex + size - 1;
        items = arr;
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
        System.out.print(this);
    }

    @Override
    public String toString()
    {
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

    public T removeFirst()
    {
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

    public T removeLast()
    {
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

    private void checkUsageFactor()
    {
        if (items.length >= 16 && size < items.length / 4)
        {
            int capacity = items.length / 2;
            resize(capacity);
        }
    }

    public T get(int index)
    {
        return items[first + index];
    }

//    public Iterator<T> iterator()
//    {
//        // TODO
//    }

    public boolean equals(Object o)
    {
        if (o instanceof ArrayDeque)
        {
            return compareDeque(this, (ArrayDeque<T>) o);
        }
        return false;
    }

    private boolean compareDeque(ArrayDeque<T> deq1, ArrayDeque<T> deq2)
    {
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