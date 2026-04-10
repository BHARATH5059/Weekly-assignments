import java.util.*;

public class AutocompleteSystem {
    static HashMap<String, Integer> freq = new HashMap<>();

    static List<String> search(String prefix) {
        List<String> res = new ArrayList<>();
        for (String s : freq.keySet())
            if (s.startsWith(prefix)) res.add(s);
        res.sort((a,b) -> freq.get(b) - freq.get(a));
        return res.size() > 3 ? res.subList(0,3) : res;
    }

    public static void main(String[] args) {
        freq.put("java", 5);
        freq.put("javascript", 10);
        freq.put("javelin", 2);
        System.out.println(search("jav"));
    }
}