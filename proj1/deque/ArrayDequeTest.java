package deque;

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
        assertEquals("10 9 8 7 6 5 4 \n", arrayDeque.toString());

    }

    @Test
    public void testAddLast() {
        int[] dequeElements = new int[]{4, 5, 6, 7, 8, 9};
        ArrayDeque<Integer> arrayDeque = createArrayDeque(dequeElements);
        arrayDeque.addLast(10);
        assertEquals(7, arrayDeque.size());
        assertEquals("4 5 6 7 8 9 10 \n", arrayDeque.toString());
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
        assertEquals("1 2 3 4 \n", arrayDeque.toString());
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
        assertEquals("1 2 3 4 \n", arrayDeque.toString());
    }

    @Test
    public void removeFirstTest1()
    {
        int[] dequeElements = new int[]{1, 2, 3, 4};
        ArrayDeque<Integer> arrayDeque = createArrayDeque(dequeElements);
        assertEquals(1, (int) arrayDeque.removeFirst());
        assertEquals(3, arrayDeque.size());
        assertEquals("2 3 4 \n", arrayDeque.toString());
    }

    @Test
    public void removeFirstTest2()
    {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 1; i <= 16; i++)
        {
            arrayDeque.addLast(i);
        }
        for (int i = 1; i <= 16; i++)
        {
            assertEquals(i, (int) arrayDeque.removeFirst());
        }
        assertEquals(0, arrayDeque.size());
        assertTrue(arrayDeque.isEmpty());
        assertEquals("", arrayDeque.toString());
    }

    @Test
    public void removeLastTest1()
    {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 1; i <= 16; i++)
        {
            arrayDeque.addLast(i);
        }
        for (int i = 16; i >= 1; i--)
        {
            assertEquals(i, (int) arrayDeque.removeLast());
        }
        assertEquals(0, arrayDeque.size());
        assertTrue(arrayDeque.isEmpty());
        assertEquals("", arrayDeque.toString());
    }
    @Test
    public void removeLastTest2()
    {
        int[] dequeElements = new int[]{1, 2, 3, 4};
        ArrayDeque<Integer> arrayDeque = createArrayDeque(dequeElements);
        assertEquals(4, (int) arrayDeque.removeLast());
        assertEquals(3, arrayDeque.size());
        assertEquals("1 2 3 \n", arrayDeque.toString());
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
        ArrayDeque<Integer> arrayDeque2 = createArrayDeque(dequeElements);
        assertTrue(arrayDeque1.equals(arrayDeque2));
        dequeElements[0] = 2;
        ArrayDeque<Integer> arrayDeque3 = createArrayDeque(dequeElements);
        assertFalse(arrayDeque1.equals(arrayDeque3));
        assertFalse(arrayDeque1.equals(dequeElements));
    }

}