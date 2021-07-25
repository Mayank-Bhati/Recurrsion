import java.util.*;

public class combinationSum {
    public static void main(String[] args) {
        int[] arr =  {1,1,1,2,2};
        List<List<Integer>> l = combinationSum2(arr,4);
        for(int i = 0; i < l.size(); i++){
            for(int j = 0; j < l.get(i).size(); j++){
                System.out.print(l.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, target, candidates, l, s);
        Iterator<List<Integer>> it = s.iterator();
        while (it.hasNext()) {
            out.add(it.next());
        }
        return out;

    }

    static void helper(int i, int tar, int[] arr, List<Integer> l, Set<List<Integer>> out) {

        if (tar == 0) {
            out.add(l);
            return;
        }

        if (i == arr.length)
            return;

        if (arr[i] <= tar) {
            List<Integer> l2 = new ArrayList<>(l);
            l2.add(arr[i]);
            helper(i + 1, tar - arr[i], arr, l2, out);
        }

        List<Integer> l2 = new ArrayList<>(l);
        helper(i + 1, tar, arr, l2, out);
    }
}
