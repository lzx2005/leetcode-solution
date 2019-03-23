import java.util.HashMap;

public class PowerOfThree {

    private static final HashMap<Integer, Object> map = new HashMap<>();

    static {
        map.put(1, null);
        int x = 1;
        while (x < (Integer.MAX_VALUE / 3)) {
            x = x * 3;
            map.put(x, null);
        }
    }

    public boolean isPowerOfThree(int n) {
        return map.containsKey(n);
    }

    public static void main(String[] args) {
        System.out.println(PowerOfThree.map.toString());
    }
}
