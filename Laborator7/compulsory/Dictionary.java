import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private final List<String> acceptedWords = new ArrayList<>();

    public Dictionary() {
        acceptedWords.add("and");
        acceptedWords.add("car");
        acceptedWords.add("home");
        acceptedWords.add("school");
        //more words

    }

    public boolean isWord(String str) {
        return true;
    }
}
