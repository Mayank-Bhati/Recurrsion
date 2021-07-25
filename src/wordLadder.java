import java.util.ArrayList;
import java.util.List;

public class wordLadder {
    public static void main(String[] args) {
        String bw = "hit";
        String ew = "cog";
        List<String> wl = new ArrayList<>();
        wl.add("hot");
        wl.add("dot");
        wl.add("dog");
        wl.add("lot");
        wl.add("log");
        wl.add("cog");
        List<List<String>> res = findLadders(bw,ew,wl);
        for(List<String> l : res){
            for(String s : l){
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> out = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        curr.add(beginWord);
        util(beginWord,endWord,wordList,out,curr);
        List<List<String>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(List<String> l : out){
            int s = -1, e = -1, max = 2;
            for(int i = 0; i < l.size(); i++){
                for(int j = i+1; j < l.size(); j++){
                    if(oneChange(l.get(i),l.get(j)) && l.get(j) == endWord){
                        if(j-i-1 >= max){
                            s = i;
                            e = j;
                            max = j-i-1;
                        }
                    }
                }
            }
            List<String> l2 = new ArrayList<>(l);
            while(s+1 < l2.size() && max > 0){
                l2.remove(s+1);
            }
            if(l2.size() <= min){
                res.add(l2);
                min = l2.size();
            }
        }
        for(List<String> l : res){
            if(l.size() > min)
                res.remove(l);
        }
        return res;
    }
    public static void util(String pw, String ew,List<String> wl,List<List<String>> out, List<String> currL){
        boolean done = false;
        if(wl.size() == 0)
            return ;
        for(int i = 0; i < wl.size(); i++){
            if(wl.size() == 1 && wl.get(i) == ew){
                currL.add(ew);
                out.add(currL);
                return ;
            }
            String word = wl.get(i);
            if(oneChange(pw,word)){
                List<String> wl1 = new ArrayList<>(wl);
                wl1.remove(i);
                if(!done){
                    done = true;
                    List<String> currL1 = new ArrayList<>(currL);
                    currL1.add(word);
                    util(word,ew,wl1,out,currL1);
                }
                else{
                    currL.add(word);
                    util(word,ew,wl1,out,currL);
                }
            }
        }
    }
    static boolean oneChange(String s1, String s2){
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i))
                count++;
            if(count > 1)
                return false;
        }
        return true;
    }
}
