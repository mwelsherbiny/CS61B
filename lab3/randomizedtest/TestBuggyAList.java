package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove()
    {
        AListNoResizing<Integer> lstNoResizing = new AListNoResizing<>();
        BuggyAList<Integer> buggyLst = new BuggyAList<>();
        for (int i = 0; i < 6; i++)
        {
            if (i < 3)
            {
                lstNoResizing.addLast(i);
                buggyLst.addLast(i);
            }
            if (i > 3)
            {
                assertEquals(lstNoResizing.size(), buggyLst.size());
                assertEquals(lstNoResizing.removeLast(), buggyLst.removeLast());
            }
        }
    }
    @Test
    public void randomizedTest()
    {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> LB = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                LB.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeLB = LB.size();
                assertEquals(size, sizeLB);
            }
            else if (operationNumber == 2)
            {
                if (L.size() > 0)
                {
                    int x = L.getLast();
                    int y = LB.getLast();
                    assertEquals(x, y);
                }
            }
            else if (operationNumber == 3)
            {
                if (L.size() > 0)
                {
                    int x = L.removeLast();
                    int y = LB.removeLast();
                    assertEquals(x, y);
                }
            }
        }
    }
}
