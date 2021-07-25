public class MoveAll_x_ToEndOfString {
    public static void main(String[] args) {
        System.out.println(Move("axxbdxcefxhix"));
    }
    static String Move(String s){
        if(s.length() == 1)
            return s;
        char c = s.charAt(0);
        String temp = Move(s.substring(1));
        if(c == 'x')
            return temp+c;
        else
            return c+temp;
    }
}
