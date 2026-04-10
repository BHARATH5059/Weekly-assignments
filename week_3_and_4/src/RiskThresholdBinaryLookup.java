import java.util.*;

public class RiskThresholdBinaryLookup {
    static int linear(int[] arr, int t) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == t) return i;
        return -1;
    }

    static int floor(int[] arr, int t) {
        int l = 0, r = arr.length - 1, res = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] <= t) {
                res = arr[m];
                l = m + 1;
            } else r = m - 1;
        }
        return res;
    }

    static int ceil(int[] arr, int t) {
        int l = 0, r = arr.length - 1, res = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] >= t) {
                res = arr[m];
                r = m - 1;
            } else l = m + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 25, 50, 100};

        System.out.println(linear(arr, 30));
        System.out.println(floor(arr, 30));
        System.out.println(ceil(arr, 30));
    }
}