import java.util.*;

public class PlagiarismDetectionSystem {
    static HashMap<String, Set<String>> map = new HashMap<>();

    static List<String> ngrams(String text) {
        String[] words = text.split(" ");
        List<String> res = new ArrayList<>();
        for (int i = 0; i + 2 < words.length; i++)
            res.add(words[i] + " " + words[i+1] + " " + words[i+2]);
        return res;
    }

    static void addDoc(String id, String text) {
        for (String g : ngrams(text)) {
            map.putIfAbsent(g, new HashSet<>());
            map.get(g).add(id);
        }
    }

    public static void main(String[] args) {
        addDoc("doc1", "this is a test document");
        addDoc("doc2", "this is a test sample");
        System.out.println(map);
    }
}