import java.util.*;

public class FlashSaleInventoryManager {
    static HashMap<String, Integer> stock = new HashMap<>();
    static HashMap<String, Queue<Integer>> waiting = new HashMap<>();

    static synchronized String purchase(String product, int user) {
        if (stock.getOrDefault(product, 0) > 0) {
            stock.put(product, stock.get(product) - 1);
            return "Success";
        } else {
            waiting.putIfAbsent(product, new LinkedList<>());
            waiting.get(product).add(user);
            return "Waiting #" + waiting.get(product).size();
        }
    }

    public static void main(String[] args) {
        stock.put("P1", 2);
        System.out.println(purchase("P1", 1));
        System.out.println(purchase("P1", 2));
        System.out.println(purchase("P1", 3));
    }
}