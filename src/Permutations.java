import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {

        int[] inputArray = {2, 1, 1};
        List<int[]> out = permute(inputArray);
        for (int[] arr : out) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    public static List<int[]> permute(int[] nums) {
        List<int[]> res = new ArrayList<>();
        helper(nums, res, 0);
        return res;
    }

    public static void helper(int[] arr, List<int[]> res, int ind) {
        if (ind >= arr.length) {
            res.add(arr.clone());
        } else {
            for (int i = ind; i < arr.length; i++) {
                if (i != ind && arr[i] == arr[ind])
                    continue;
                swap(arr, ind, i);
                helper(arr, res, ind + 1);
                swap(arr, ind, i);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
