import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TowerOfHanoi {
    public static void main(String[] args) {
      TOH(3,'A','C','B');
    }
    static void TOH(int n, char source, char destinatin, char helper){
        if(n == 0)
            return ;
        TOH(n-1,source,helper,destinatin);
        System.out.printf("Move From %s To %s %n",source,destinatin);
        TOH(n-1,helper, destinatin, source);
    }
}
