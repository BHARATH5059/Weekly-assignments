import java.util.*;

class Trade {
    String id;
    int vol;

    Trade(String id, int vol) {
        this.id = id;
        this.vol = vol;
    }

    public String toString() {
        return id + ":" + vol;
    }
}

public class HistoricalTradeVolumeAnalysis {
    static void mergeSort(Trade[] arr, int l, int r) {
        if (l >= r) return;
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    static void merge(Trade[] arr, int l, int m, int r) {
        Trade[] temp = new Trade[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r)
            temp[k++] = arr[i].vol <= arr[j].vol ? arr[i++] : arr[j++];
        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];
        for (int x = 0; x < temp.length; x++) arr[l + x] = temp[x];
    }

    static void quickSort(Trade[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }

    static int partition(Trade[] arr, int l, int r) {
        int pivot = arr[r].vol;
        int i = l - 1;
        for (int j = l; j < r; j++)
            if (arr[j].vol > pivot) {
                i++;
                Trade t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        Trade t = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = t;
        return i + 1;
    }

    static int total(Trade[] arr) {
        int sum = 0;
        for (Trade t : arr) sum += t.vol;
        return sum;
    }

    public static void main(String[] args) {
        Trade[] arr = {
                new Trade("t3", 500),
                new Trade("t1", 100),
                new Trade("t2", 300)
        };

        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        System.out.println(total(arr));
    }
}