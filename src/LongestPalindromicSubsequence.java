public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("b"));
    }

    public static String longestPalindrome(String s) {
        String curr = "";
        maxString m = new maxString();
        m.max = "";
        helper(curr, m, 0, s);
        return m.max;
    }

    public static void helper(String curr, maxString m, int ind, String s) {
        if (curr.length() >= m.max.length() && isPalindrome(curr)) {
            m.max = curr;
        }
        if (ind >= s.length())
            return;
        helper(curr, m, ind + 1, s);
        helper((curr + s.substring(ind, ind + 1)), m, ind + 1, s);
    }

    static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }
    static class maxString{
        String max;
    }
}
