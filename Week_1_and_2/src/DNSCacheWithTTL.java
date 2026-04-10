import java.util.*;

class DNSEntry {
    String ip;
    long expiry;

    DNSEntry(String ip, long ttl) {
        this.ip = ip;
        this.expiry = System.currentTimeMillis() + ttl;
    }
}

public class DNSCacheWithTTL {
    static HashMap<String, DNSEntry> cache = new HashMap<>();

    static String resolve(String domain) {
        if (cache.containsKey(domain)) {
            DNSEntry e = cache.get(domain);
            if (System.currentTimeMillis() < e.expiry) return e.ip;
        }
        String ip = "1.1.1." + new Random().nextInt(100);
        cache.put(domain, new DNSEntry(ip, 3000));
        return ip;
    }

    public static void main(String[] args) {
        System.out.println(resolve("google.com"));
        System.out.println(resolve("google.com"));
    }
}