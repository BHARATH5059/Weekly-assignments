import java.util.*;

class TokenBucket {
    int tokens;
    long last;

    TokenBucket(int t) {
        tokens = t;
        last = System.currentTimeMillis();
    }
}

public class DistributedRateLimiter {
    static HashMap<String, TokenBucket> map = new HashMap<>();

    static boolean allow(String id) {
        map.putIfAbsent(id, new TokenBucket(5));
        TokenBucket b = map.get(id);
        if (b.tokens > 0) {
            b.tokens--;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(allow("A"));
        System.out.println(allow("A"));
    }
}