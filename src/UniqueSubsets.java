import java.util.*;

public class UniqueSubsets {
    public static void main(String[] args) {
        Map<String, Boolean> m = new HashMap<>();
        List<String> l = new ArrayList<>();
        List<String> list = new ArrayList<>();
        generate("AAB", "",l);
        for(int i = 0; i < l.size(); i++){
            if(m.get(l.get(i)) == null){
                m.put(l.get(i),true);
                list.add(l.get(i));
            }
        }
        for (String s : list){
            System.out.println(s);
        }
    }
    public static void generate(String s, String ans,List<String> out) {
        if(s.length() == 0){
            out.add(ans);
            return ;
        }
        char c = s.charAt(0);
        String ans1 = ans;
        String ans2 = ans+c;
        s = s.substring(1);
        generate(s,ans1,out);
        generate(s,ans2,out);
    }
}
