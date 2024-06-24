package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer> ops = new AList<>();
        AList<Double> times = new AList<>();
        fillTable(ops, times);
        printTimingTable(ops, times, ops);
    }

    private static void fillTable(AList<Integer> ops, AList<Double> times)
    {
        AList<Integer> lst = new AList<>();
        int currOps = 1000;
        int maxOps = 128000;
        Stopwatch sw = new Stopwatch();
        for (int i = 1; i <= currOps; i++)
        {
            if (i == currOps)
            {
                double time = sw.elapsedTime();
                times.addLast(time);
                ops.addLast(currOps);
                if (currOps * 2 <= maxOps)
                {
                    currOps *= 2;
                }
            }
            lst.addLast(i);
        }
    }
}
