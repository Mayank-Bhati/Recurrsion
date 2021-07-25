public class sqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        if (x == 1 || x == 0)
            return x;
        long left = 1, right = x / 2;
        while (left < right) {
            long m = left + (right - left) / 2;
            if (m * m == x || (m * m < x && (m + 1) * (m + 1) > x)) {
                return (int)m;
            } else if (m * m > x) {
                right = m - 1;
            } else
                left = m + 1;
        }
        return (int)left;
    }
}
