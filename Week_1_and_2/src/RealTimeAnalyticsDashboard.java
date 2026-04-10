import java.util.*;

public class RealTimeAnalyticsDashboard {
    static HashMap<String, Integer> views = new HashMap<>();
    static HashMap<String, Set<String>> users = new HashMap<>();

    static void process(String url, String user) {
        views.put(url, views.getOrDefault(url, 0) + 1);
        users.putIfAbsent(url, new HashSet<>());
        users.get(url).add(user);
    }

    public static void main(String[] args) {
        process("/a", "u1");
        process("/a", "u2");
        process("/b", "u1");
        System.out.println(views);
        System.out.println(users);
    }
}