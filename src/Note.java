import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Note {

    private final int octave;
    private final String value;

    public Note(String name) {
        Pattern digit = Pattern.compile("\\d+");
        Matcher digitMatcher = digit.matcher(name);

        digitMatcher.find();
        octave = Integer.parseInt(digitMatcher.group());

        Pattern nonDigit = Pattern.compile("\\D+");
        Matcher nonDigitMatcher = nonDigit.matcher(name);

        nonDigitMatcher.find();
        value = nonDigitMatcher.group();
    }

    public int getOctave() {
        return octave;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Note{" +
                "octave=" + octave +
                ", value='" + value + '\'' +
                '}';
    }
}
