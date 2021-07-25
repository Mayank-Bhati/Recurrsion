public class RemoveDuplicatesFromString {
    public static void main(String[] args) {
        System.out.println(remove("aaabbbeecdddd"));
    }
    static String remove(String s){
        if(s.length() == 0 || s.length() == 1)
            return s;
        char c = s.charAt(0);
        String temp = remove(s.substring(1));
        if(c == temp.charAt(0))
            return temp;
        else
            return c+temp;
    }
}
