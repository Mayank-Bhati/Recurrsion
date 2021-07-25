public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverse("mayank"));
    }
    static String reverse(String s){
        if(s.length() == 1 || s.length() == 0)
            return s;
        char c = s.charAt(0);
        String temp = reverse(s.substring(1));
        return temp+c;
    }
}
