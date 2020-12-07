import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class LibSlurGenerator {
    private static ArrayList<Note> notes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Permutation p = new Permutation();

        String slur = p.randPermutation();
        parseSlur(slur);

        //notes.clear();
        //notes = new ArrayList<Note>(Arrays.asList(new Note("E2"), new Note("G2"), new Note("Bb2"), new Note("C3")));

        DrawImage di = new DrawImage();
        di.drawNotes(notes);

        di.writePNG();
    }

    public static void parseSlur(String slur) {
        String[] arr = slur.split(" ");

        for (String note : arr) {
            notes.add(new Note(note));
        }
    }
}
