import java.util.*;

public class TwoSumTransactions {
    static void twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            if (map.containsKey(target - x))
                System.out.println(x + " " + (target - x));
            map.put(x, 1);
        }
    }

    public static void main(String[] args) {
        twoSum(new int[]{1,2,3,4}, 5);
    }
}