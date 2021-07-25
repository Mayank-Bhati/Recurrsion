import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.List;

public class SortAnArray {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(3);
        l.add(4);
        l.add(2);
        l.add(1);
        l.add(6);
        l.add(5);
        List<Integer> l1 = sort(l);
        for(int a : l1){
            System.out.print(a+" ");
        }
    }
    static List<Integer> sort(List<Integer> list){
        if(list.size() == 1)
            return list;
        int temp = list.get(list.size()-1);
        list.remove(list.size()-1);
        insert(sort(list),temp);
        return list;
    }
    static void insert(List<Integer> l, int key){
        if(l.size() == 0 || key >= l.get(l.size()-1)){
            l.add(key);
            return ;
        }
        int temp = l.get(l.size()-1);
        l.remove(l.size()-1);
        insert(l,key);
        l.add(temp);
    }
}
