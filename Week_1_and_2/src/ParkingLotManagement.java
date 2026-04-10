import java.util.*;

public class ParkingLotManagement {
    static String[] table = new String[10];

    static int hash(String s) {
        return Math.abs(s.hashCode()) % table.length;
    }

    static int park(String car) {
        int i = hash(car);
        while (table[i] != null) i = (i + 1) % table.length;
        table[i] = car;
        return i;
    }

    public static void main(String[] args) {
        System.out.println(park("A1"));
        System.out.println(park("A2"));
    }
}