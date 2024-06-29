package deque;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    private ArrayDeque<Integer> createArrayDeque(int[] elements) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < elements.length; i++)
        {
            arrayDeque.addLast(elements[i]);
        }
        return arrayDeque;
    }

    @Test
    public void testAddFirst() {
        int[] dequeElements = new int[]{9, 8, 7, 6, 5, 4};
        ArrayDeque<Integer> arrayDeque = createArrayDeque(dequeElements);
        arrayDeque.addFirst(10);
        assertEquals(7, arrayDeque.size());
    }

    @Test
    public void testAddLast() {
        int[] dequeElements = new int[]{4, 5, 6, 7, 8, 9};
        ArrayDeque<Integer> arrayDeque = createArrayDeque(dequeElements);
        arrayDeque.addLast(10);
        assertEquals(7, arrayDeque.size());
    }

    @Test
    public void testAdd1()
    {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst(2);
        arrayDeque.addLast(3);
        arrayDeque.addLast(4);
        arrayDeque.addFirst(1);
        assertEquals(4, arrayDeque.size());
    }

    @Test
    public void testAdd2()
    {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(3);
        arrayDeque.addFirst(2);
        arrayDeque.addFirst(1);
        arrayDeque.addLast(4);
        assertEquals(4, arrayDeque.size());
    }

    @Test
    public void removeFirstTest1()
    {
        int[] dequeElements = new int[]{1, 2, 3, 4};
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        assertNull(arrayDeque.removeFirst());
        arrayDeque = createArrayDeque(dequeElements);
        assertEquals(1, (int) arrayDeque.removeFirst());
        assertEquals(3, arrayDeque.size());
    }

    @Test
    public void removeLastTest2()
    {
        int[] dequeElements = new int[]{1, 2, 3, 4};
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        assertNull(arrayDeque.removeLast());
        arrayDeque = createArrayDeque(dequeElements);
        assertEquals(4, (int) arrayDeque.removeLast());
        assertEquals(3, arrayDeque.size());
    }

    @Test
    public void getTest()
    {
        int[] dequeElements = new int[]{1, 2, 3, 4};
        ArrayDeque<Integer> arrayDeque = createArrayDeque(dequeElements);
        assertEquals(3, (int) arrayDeque.get(2));
    }

    @Test
    public void equalsTest()
    {
        int[] dequeElements = new int[]{1, 2, 3, 4};
        ArrayDeque<Integer> arrayDeque1 = createArrayDeque(dequeElements);
        LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<>();
        linkedListDeque.addLast(1);
        linkedListDeque.addLast(2);
        linkedListDeque.addLast(3);
        linkedListDeque.addLast(4);
        ArrayDeque<Integer> arrayDeque2 = createArrayDeque(dequeElements);
        assertTrue(arrayDeque1.equals(arrayDeque2));
        assertTrue(arrayDeque1.equals(arrayDeque1));
        assertTrue(arrayDeque1.equals(linkedListDeque));
        dequeElements[0] = 2;
        ArrayDeque<Integer> arrayDeque3 = createArrayDeque(dequeElements);
        assertFalse(arrayDeque1.equals(arrayDeque3));
        assertFalse(arrayDeque1.equals(dequeElements));
    }

    @Test
    public void testIterator()
    {
        ArrayDeque<Integer> deq1 = new ArrayDeque<>();
        deq1.addFirst(2);
        deq1.addFirst(1);
        deq1.addLast(3);

        int y = 1;
        for (int i : deq1)
        {
            assertEquals(y, i);
            y++;
        }
    }

    @Test
    public void generalTest()
    {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst(0);
        arrayDeque.addLast(1);
        arrayDeque.addLast(2);
        arrayDeque.addLast(3);
        arrayDeque.removeLast();
        arrayDeque.addLast(5);
        arrayDeque.removeFirst();
        arrayDeque.removeFirst();
        arrayDeque.removeFirst();
        arrayDeque.removeFirst();
        arrayDeque.addLast(10);
        arrayDeque.removeFirst();
    }

    @Test
    public void randomTest()
    {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int n = 5000;
        for (int i = 0; i < n; i++)
        {
            int val = StdRandom.uniform(0, 5);
            if (val == 0)
            {
                arrayDeque.addLast(val);
            }
            else if (val == 1)
            {
                arrayDeque.addFirst(val);
            }
            else if (val == 2)
            {
                arrayDeque.removeLast();
            }
            else if (val == 3)
            {
                arrayDeque.removeFirst();
            }
            else
            {
                arrayDeque.get(StdRandom.uniform(0, 5001));
            }
        }
    }

    @Test
    public void speedTest()
    {
        // from N = 1000 to N = 64000
        int ops = 10000;
        int testN = 8;
        for (int k = 0; k < 4; k++)
        {
            int N = 1000;
            String[][] table = new String[8][];
            for (int i = 0; i < testN; i++)
            {
                Stopwatch sw = new Stopwatch();
                ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
                fillDeque(k, ops, arrayDeque);
                timeMethod(k, ops, arrayDeque);
                double time = sw.elapsedTime();
                String NString = Integer.toString(N);
                String timeString = Double.toString(time);
                table[i] = new String[]{NString, timeString};
                N *= 2;
            }
            printTable(k, table);
        }

    }

    private void printTable(int k, String[][] table)
    {
        System.out.println("<--" + methodTested(k) + "-->");
        System.out.println("N\t    time" );
        for (String[] row : table)
        {
            for (String item : row)
            {
                System.out.print(item + "\t");
            }
            System.out.println();
        }
    }

    private void fillDeque(int k, int ops, ArrayDeque<Integer> arrayDeque)
    {
        if (k == 2 || k ==3)
        {
            for (int i = 0; i < ops; i++)
            {
                arrayDeque.addLast(i);
            }
        }
    }

    private String methodTested(int k) {
        if (k == 0) {
            return "addFirst()";
        } else if (k == 1) {
            return "addLast()";
        } else if (k == 2) {
            return "removeFirst()";
        } else if (k == 3) {
            return "removeLast()";
        }
        return "";
    }
    private void timeMethod(int k, int ops, ArrayDeque<Integer> arrayDeque)
    {
        if (k == 0)
        {
            for (int i = 0; i < ops; i++)
            {
                arrayDeque.addFirst(i);
            }
        }
        else if (k == 1)
        {
            for (int i = 0; i < ops; i++)
            {
                arrayDeque.addLast(i);
            }
        }
        else if (k == 2)
        {
            for (int i = 0; i < ops; i++)
            {
                arrayDeque.removeFirst();
            }
        }
        else if (k == 3)
        {
            for (int i = 0; i < ops; i++)
            {
                arrayDeque.removeLast();
            }
        }
    }
}