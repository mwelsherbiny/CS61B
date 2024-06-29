package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

import static java.lang.Math.pow;

public class GuitarHero {
    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        int stringN = 37;
        GuitarString[] strings = new GuitarString[stringN];
        for (int i = 0; i < stringN; i++)
        {
            double freq = 440 * pow(2, (i - 24.0) / 12.0);
            strings[i] = new GuitarString(freq);
        }

        while(true)
        {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int i = keyboard.indexOf(key);
                if (!(i >= 0 && i < stringN))
                {
                    continue;
                }
                strings[i].pluck();
            }

            double sample = 0;
            for (int j = 0; j < stringN; j++){
                sample += strings[j].sample();
            }
            StdAudio.play(sample);
            for (int j = 0; j < stringN; j++){
                strings[j].tic();
            }
        }
    }
}
