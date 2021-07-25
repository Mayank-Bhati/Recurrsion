import java.util.Stack;

public class SortTheStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(1);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(1);
        System.out.println("final stack is");
        while(!sort(s).isEmpty()){
            System.out.println(sort(s).pop());
        }
    }
    static Stack<Integer> sort(Stack<Integer> s){
        if(s.size() == 1)
            return s;
        int temp = s.pop();
        sort(s);
        insert(s,temp);
        return s;
    }
    static void insert(Stack<Integer> s, int key){
        if(s.size() == 0 || s.peek() >= key){
            s.push(key);
            return ;
        }
        int temp = s.pop();
        insert(s,key);
        s.push(temp);
    }
}
