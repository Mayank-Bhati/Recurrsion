import java.util.ArrayList;
import java.util.List;

public class WordsFromPhoneDigits {
    // 0 and 1 don't not map to any letters.
    public static void main(String[] args) {
        for(String a : letterCombinations("234567")){
            System.out.println(a);
        }
    }

    public static List<String> letterCombinations(String digits) {

        List<String> l = new ArrayList<>();
        helper(digits, "", l);
        return l;
    }


    static void helper(String s, String ans, List<String> l) {
        String[] keypadArr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(s.length() == 0)
            return ;
        if (s.length() == 1) {
            int k = (int) (s.charAt(0) - '0');
            String temp1 = keypadArr[k];
            for (int j = 0; j < temp1.length(); j++) {
                l.add(ans+(Character.toString(temp1.charAt(j))));
            }
            return;
        }
        int c = (int) (s.charAt(0) - '0');
        s = s.substring(1);
        String temp = keypadArr[c];
        for (int i = 0; i < temp.length(); i++) {
            helper(s, ans + temp.charAt(i), l);
        }
    }
}
