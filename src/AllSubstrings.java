public class AllSubstrings {
    public static void main(String[] args) {
        generate("ABC","");
    }
    static void generate(String s, String ans){
        if(s.length() == 0){
            System.out.println(ans);
            return ;
        }
        char c = s.charAt(0);
       String ans1 = ans;
       String ans2 = ans+c;
       s = s.substring(1);
       generate(s,ans1);
       generate(s,ans2);
    }
}
