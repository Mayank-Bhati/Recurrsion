import java.sql.Statement;

public class replace_pi_with_itsValue {
    public static void main(String[] args) {
        System.out.println(replace("pippxxppiixipi"));
    }
    static String replace(String s){
        if(s.length() <= 1)
            return s;
        if(s.charAt(0) == 'p' && s.charAt(1) == 'i'){
            return "3.14"+replace(s.substring(2));
        }
        else
            return s.substring(0,1)+replace(s.substring(1));
    }
}
