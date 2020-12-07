import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Permutation {
    public static final int MIN_SIZE = 3;
    public static final int MAX_SIZE = 5;
    public final Random random;

    public static final ArrayList<String> bugleSeries =
            new ArrayList<String>(Arrays.asList("C1", "G1", "C2", "E2", "G2", "Bb2", "C3"));

    public Permutation() {
        random = new Random();
    }

    public int random() {
        return random.nextInt(MAX_SIZE - MIN_SIZE + 1) + MIN_SIZE;
    }

    public String randPermutation() {
        ArrayList<String> tmp = new ArrayList<>(bugleSeries);
        return permutation("", random(), tmp);
    }

    private String permutation(String temp, int length, ArrayList<String> series) {
        if (length == 0) {
            return temp;
        }

        // choose random element
        String rand = series.remove(random.nextInt(series.size()));
        temp += rand + " ";

        return permutation(temp, --length, series);
    }
}