package timingtest;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> Ns = new AList<>();
        AList<Integer> ops = new AList<>();
        AList<Double> times = new AList<>();
        int testN = 8;
        fillTable(Ns, times, ops, testN);
        printTimingTable(Ns,times, ops);
    }

    private static void fillTable(AList<Integer> Ns, AList<Double> times, AList<Integer> ops, int testN)
    {
        int N = 1000;
        int opsN = 10000;
        for (int i = 0; i < testN; i++)
        {
            SLList<Integer> lst = new SLList<>();
            fillEmptyList(lst, N);
            double time = getLastTime(lst, opsN);
            Ns.addLast(N);
            times.addLast(time);
            ops.addLast(opsN);
            N *= 2;
        }
    }

    private static void fillEmptyList(SLList<Integer> lst, int size)
    {
        for (int i = 0; i < size; i++)
        {
            lst.addLast(i);
        }
    }

    private static double getLastTime(SLList<Integer> lst, int opsN)
    {
        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < opsN; i++)
        {
            lst.getLast();
        }
        return sw.elapsedTime();
    }
}
