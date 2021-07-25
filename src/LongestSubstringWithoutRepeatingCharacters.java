import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int l = s.length();
        List<Character> list = new ArrayList<>();
        int n = 0;
        int max = 0;
        int i = 0;
        while (i < l) {
            char c = s.charAt(i);
            if (!list.contains(c)) {
                list.add(c);
                n++;
                if (n > max)
                    max = n;
                i++;
            } else {
                int ind = list.indexOf(c);
                for (int k = 0; k <= ind; k++)
                    list.remove(0);
                list.add(c);
                n = list.size();
                if (n > max)
                    max = n;
                i++;
            }
        }
        return max;
    }
}
