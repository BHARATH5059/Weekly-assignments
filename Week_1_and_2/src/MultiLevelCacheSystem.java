import java.util.*;

public class MultiLevelCacheSystem {
    static LinkedHashMap<String, String> L1 = new LinkedHashMap<>(5,0.75f,true){
        protected boolean removeEldestEntry(Map.Entry e){return size()>3;}
    };
    static HashMap<String, String> L2 = new HashMap<>();

    static String get(String key) {
        if (L1.containsKey(key)) return L1.get(key);
        if (L2.containsKey(key)) {
            L1.put(key, L2.get(key));
            return L2.get(key);
        }
        String val = "DB_" + key;
        L2.put(key, val);
        return val;
    }

    public static void main(String[] args) {
        System.out.println(get("v1"));
        System.out.println(get("v1"));
    }
}