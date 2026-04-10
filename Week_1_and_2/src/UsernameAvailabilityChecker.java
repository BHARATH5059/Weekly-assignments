import java.util.*;

public class UsernameAvailabilityChecker {
    static HashMap<String, Integer> users = new HashMap<>();
    static HashMap<String, Integer> attempts = new HashMap<>();

    static boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    static List<String> suggest(String username) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= 3; i++) res.add(username + i);
        res.add(username.replace("_", "."));
        return res;
    }

    static String mostAttempted() {
        String maxUser = "";
        int max = 0;
        for (String u : attempts.keySet()) {
            if (attempts.get(u) > max) {
                max = attempts.get(u);
                maxUser = u;
            }
        }
        return maxUser;
    }

    public static void main(String[] args) {
        users.put("john_doe", 1);
        System.out.println(checkAvailability("john_doe"));
        System.out.println(checkAvailability("jane_smith"));
        System.out.println(suggest("john_doe"));
        System.out.println(mostAttempted());
    }
}