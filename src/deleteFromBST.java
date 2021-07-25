import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class deleteFromBST {
    static class Tree<T> {
        Tree(T x) {
            value = x;
        }

        T value;
        Tree<T> left;
        Tree<T> right;
    }

    public static void main(String[] args) {
        Tree<Integer> t = new Tree<Integer>(1);
        t.right = new Tree<>(4);
        t.left = new Tree<>(0);
        t.left.left = new Tree<>(3);
        t.left.right = new Tree<>(1);
        System.out.println(digitTreeSum(t));
    }
   static long digitTreeSum(Tree<Integer> t) {
        return helper(t, 0);
    }

    private static long helper(Tree<Integer> t, long result) {
        long total = 0;
        if (t.left == null && t.right == null) {
            total += (result * 10) + t.value;
        }
        if (t.left != null) {
            total += helper(t.left, (result * 10) + t.value);
        }
        if (t.right != null) {
            total += helper(t.right, (result * 10) + t.value);
        }
        return total;
    }
    static int[] largestValuesInTreeRows(Tree<Integer> t) {
        List<Integer> l = new ArrayList<>();
        Queue<Tree<Integer>> q = new LinkedList<>();
        if(t != null){
            q.add(t);
            q.add(null);
        }
        while(!q.isEmpty()){
            boolean change = false;
            int max = Integer.MIN_VALUE;
            while(q.peek() != null){
                Tree<Integer> temp = q.poll();
                if(temp.value > max)
                    max = temp.value;
                if(temp.left != null){
                    q.add(temp.left);
                    change = true;
                }
                if(temp.right != null){
                    q.add(temp.right);
                    change = true;
                }
            }
            l.add(max);
            q.poll();
            if(change)
                q.add(null);
        }
        int out[] = new int[l.size()];
        for(int i = 0; i < out.length; i++){
            out[i] = l.get(i);
        }
        return out;
    }

    static Tree<Integer> deleteFromBST(Tree<Integer> t, int[] queries) {
        for (int query : queries) {
            t = deleteFromTree(t, query);
        }
        return t;
    }

   static Tree<Integer> deleteFromTree(Tree<Integer> t, int target) {
        if (t == null) return t; //bottom of recursion if we can't find value

        if (target < t.value) {
            t.left = deleteFromTree(t.left, target);
            return t;
        }
        if (target > t.value) {
            t.right = deleteFromTree(t.right, target);
            return t;
        }

        //else found value, so delete from tree

        //only one child so connect parent with right subtree
        if (t.left == null) return t.right;
//    if (t.right == null) return t.left; - this is the usual if we had a normal BST delete operation, but we don't as per description

        Tree<Integer> current = t;
        t = max(current.left);
        t.left = deleteMax(current.left);
        t.right = current.right;

        return t;
    }

    static Tree<Integer> max(Tree<Integer> t) {
        if (t.right == null) return t;
        return max(t.right);
    }


   static Tree<Integer> deleteMax(Tree<Integer> t) {
        if (t.right == null) return t.left;
        t.right = deleteMax(t.right);
        return t;
    }
}
