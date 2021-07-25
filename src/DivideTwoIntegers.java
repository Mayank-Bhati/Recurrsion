public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }

    public static int divide(int dividend, int divisor) {
        long n = dividend, d = divisor;
        if (n == 0)
            return 0;
        boolean positive = (n * d) >= 0;
        d = Math.abs(d);
        n = Math.abs(n);
        if (d == 1) {
            if (positive){
                return (int) n;
            }
            else
                return -(int) n;
        }
        if (d > n)
            return 0;
        long l = 1, r = Math.abs(n);
        while (l < r) {
            long m = l + (r - l) / 2;
            System.out.println(m);
            if ((m * d == n) || ((m * d < n) && ((m + 1) * d > n)))
                return (positive) ? (int) m : -(int) m;
            else if (m * d < n)
                l += m + 1;
            else
                r -= m - 1;
        }
        return (positive) ? (int) l : -(int) l;
    }
}
